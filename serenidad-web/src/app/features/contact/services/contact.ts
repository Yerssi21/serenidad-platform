import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment.development';

export interface ContactRequest {
  name: string;
  email: string;
  phone: string;
  modality: string;
  message: string;
  privacyAccepted: boolean;
}

export interface ContactResponse {
  id: number;
  message: string;
  createdAt: string;
}

@Injectable({
  providedIn: 'root',
})
export class ContactService {

  private readonly http = inject(HttpClient);

  private readonly apiUrl =
  `${environment.apiUrl}/api/contact`;

  create(request: ContactRequest): Observable<ContactResponse> {
    return this.http.post<ContactResponse>(this.apiUrl, request);
  }
}