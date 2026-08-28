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
  Title,
  Meta,
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
  ArticleService,
} from '../../services/article';

@Component({
  selector: 'app-article-detail',
  imports: [RouterLink],
  templateUrl: './article-detail.html',
  styleUrl: './article-detail.scss',
})
export class ArticleDetail {

  private readonly route =
    inject(ActivatedRoute);

  private readonly articleService =
    inject(ArticleService);

  private readonly title =
    inject(Title);

  private readonly meta =
    inject(Meta);

  protected readonly errorMessage =
    signal<string | null>(null);

  protected readonly article = toSignal(

    this.route.paramMap.pipe(

      map((params) =>
        params.get('slug')
      ),

      switchMap((slug) => {

        this.errorMessage.set(null);

        if (!slug) {
          this.errorMessage.set(
            'No encontramos este artículo.'
          );

          return of(null);
        }

        return this.articleService
          .findBySlug(slug)
          .pipe(

            catchError(
              (error: HttpErrorResponse) => {

                if (error.status === 404) {

                  this.errorMessage.set(
                    'No encontramos el artículo que buscas.'
                  );

                } else {

                  this.errorMessage.set(
                    'No pudimos cargar el artículo. Inténtalo de nuevo.'
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

  protected readonly paragraphs =
    computed(() => {

      const content =
        this.article()?.content;

      if (!content) {
        return [];
      }

      return content
        .split(/\n\s*\n/)
        .map((paragraph) =>
          paragraph.trim()
        )
        .filter(Boolean);
    });

  constructor() {

    effect(() => {

      const article =
        this.article();

      if (article === undefined) {
        return;
      }

      if (article === null) {

        this.title.setTitle(
          'Artículo no encontrado | Serenidad'
        );

        this.meta.updateTag({
          name: 'description',
          content:
            'El artículo que buscas no está disponible.',
        });

        return;
      }

      this.title.setTitle(
        `${article.title} | Serenidad`
      );

      this.meta.updateTag({
        name: 'description',
        content: article.excerpt,
      });
    });
  }
}