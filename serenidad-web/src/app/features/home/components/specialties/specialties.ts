import {
  Component,
  inject,
} from '@angular/core';

import {
  RouterLink,
} from '@angular/router';

import {
  toSignal,
} from '@angular/core/rxjs-interop';

import {
  catchError,
  of,
} from 'rxjs';

import {
  SpecialtyService,
} from '../../../specialties/services/specialty';

@Component({
  selector: 'app-specialties',
  imports: [
    RouterLink,
  ],
  templateUrl: './specialties.html',
  styleUrl: './specialties.scss',
})
export class Specialties {

  private readonly specialtyService =
    inject(SpecialtyService);

  protected readonly specialties = toSignal(
    this.specialtyService.findAll().pipe(

      catchError((error) => {

        console.error(
          'Error cargando especialidades:',
          error
        );

        return of([]);
      })

    ),
    {
      initialValue: [],
    }
  );
}