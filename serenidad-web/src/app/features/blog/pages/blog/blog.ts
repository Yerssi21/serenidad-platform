import { Component, inject } from '@angular/core';
import { RouterLink } from '@angular/router';
import { toSignal } from '@angular/core/rxjs-interop';
import { catchError, of } from 'rxjs';

import {
  ArticleService,
} from '../../services/article';

@Component({
  selector: 'app-blog',
  imports: [RouterLink],
  templateUrl: './blog.html',
  styleUrl: './blog.scss',
})
export class Blog {

  private readonly articleService =
    inject(ArticleService);

  protected readonly articles = toSignal(
    this.articleService.findAll().pipe(
      catchError((error) => {
        console.error(
          'Error cargando artículos:',
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