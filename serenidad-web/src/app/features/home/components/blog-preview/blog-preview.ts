import { Component, inject } from '@angular/core';
import { RouterLink } from '@angular/router';
import { toSignal } from '@angular/core/rxjs-interop';
import { catchError, map, of } from 'rxjs';

import {
  ArticleService,
} from '../../../blog/services/article';

@Component({
  selector: 'app-blog-preview',
  imports: [RouterLink],
  templateUrl: './blog-preview.html',
  styleUrl: './blog-preview.scss',
})
export class BlogPreview {

  private readonly articleService =
    inject(ArticleService);

  protected readonly articles = toSignal(
    this.articleService.findAll().pipe(

      // Home solamente muestra los primeros 3
      map((articles) => articles.slice(0, 3)),

      catchError((error) => {
        console.error(
          'Error cargando artículos:',
          error
        );

        return of([]);
      }),
    ),
    {
      initialValue: [],
    }
  );
}