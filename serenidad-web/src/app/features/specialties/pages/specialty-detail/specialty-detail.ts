import {
  Component,
  computed,
  effect,
  inject,
  signal,
} from '@angular/core';

import {
  ActivatedRoute,
  RouterLink,
} from '@angular/router';

import {
  HttpErrorResponse,
} from '@angular/common/http';

import {
  Meta,
  Title,
} from '@angular/platform-browser';

import {
  toSignal,
} from '@angular/core/rxjs-interop';

import {
  catchError,
  map,
  of,
  switchMap,
} from 'rxjs';

import {
  SpecialtyService,
} from '../../services/specialty';

@Component({
  selector: 'app-specialty-detail',
  imports: [RouterLink],
  templateUrl: './specialty-detail.html',
  styleUrl: './specialty-detail.scss',
})
export class SpecialtyDetail {

  private readonly route =
    inject(ActivatedRoute);

  private readonly specialtyService =
    inject(SpecialtyService);

  private readonly title =
    inject(Title);

  private readonly meta =
    inject(Meta);

  protected readonly errorMessage =
    signal<string | null>(null);

  protected readonly specialty = toSignal(
    this.route.paramMap.pipe(

      map((params) =>
        params.get('slug')
      ),

      switchMap((slug) => {

        this.errorMessage.set(null);

        if (!slug) {
          this.errorMessage.set(
            'No encontramos esta especialidad.'
          );

          return of(null);
        }

        return this.specialtyService
          .findBySlug(slug)
          .pipe(

            catchError(
              (error: HttpErrorResponse) => {

                if (error.status === 404) {
                  this.errorMessage.set(
                    'No encontramos la especialidad que buscas.'
                  );
                } else {
                  this.errorMessage.set(
                    'No pudimos cargar esta información.'
                  );
                }

                return of(null);
              }
            )
          );
      })
    ),
    {
      initialValue: undefined,
    }
  );

  protected readonly sections =
    computed(() => {

      const specialty =
        this.specialty();

      if (!specialty) {
        return [];
      }

      return specialty.sections.map(
        (section) => ({
          ...section,

          paragraphs: section.content
            .split(/\n\s*\n/)
            .map((paragraph) =>
              paragraph.trim()
            )
            .filter(Boolean),
        })
      );
    });

  constructor() {

    effect(() => {

      const specialty =
        this.specialty();

      if (specialty === undefined) {
        return;
      }

      if (specialty === null) {

        this.title.setTitle(
          'Especialidad no encontrada | Serenidad'
        );

        return;
      }

      this.title.setTitle(
        `${specialty.title} | Serenidad`
      );

      this.meta.updateTag({
        name: 'description',
        content: specialty.summary,
      });
    });
  }
}