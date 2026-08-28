import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { environment } from '../../../../environments/environment';

export interface Article {
  id: number;
  title: string;
  slug: string;
  category: string;
  excerpt: string;
  content: string;
  image: string | null;
  readingTime: string | null;
  createdAt: string;
}

@Injectable({
  providedIn: 'root',
})
export class ArticleService {

  private readonly http = inject(HttpClient);

  private readonly apiUrl =
    `${environment.apiUrl}/api/articles`;

  findAll(): Observable<Article[]> {
    return this.http.get<Article[]>(this.apiUrl);
  }

  findBySlug(slug: string): Observable<Article> {
    return this.http.get<Article>(
      `${this.apiUrl}/${slug}`
    );
  }
}