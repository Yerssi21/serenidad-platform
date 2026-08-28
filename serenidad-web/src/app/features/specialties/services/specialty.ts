import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { environment } from '../../../../environments/environment';

export interface SpecialtySummary {
  id: number;
  title: string;
  slug: string;
  summary: string;
  image: string | null;
}

export interface SpecialtySection {
  title: string | null;
  content: string;
  displayOrder: number;
}

export interface SpecialtyDetail {
  id: number;
  title: string;
  slug: string;
  summary: string;
  image: string | null;
  sections: SpecialtySection[];
}

@Injectable({
  providedIn: 'root',
})
export class SpecialtyService {

  private readonly http = inject(HttpClient);

  private readonly apiUrl =
    `${environment.apiUrl}/api/specialties`;

  findAll(): Observable<SpecialtySummary[]> {
    return this.http.get<SpecialtySummary[]>(
      this.apiUrl
    );
  }

  findBySlug(
    slug: string
  ): Observable<SpecialtyDetail> {

    return this.http.get<SpecialtyDetail>(
      `${this.apiUrl}/${encodeURIComponent(slug)}`
    );
  }
}