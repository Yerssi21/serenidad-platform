import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { environment } from '../../../../environments/environment';

export interface ChatRequest {
  message: string;
}

export interface ChatResponse {
  message: string;
}

@Injectable({
  providedIn: 'root',
})
export class ChatService {

  private readonly http = inject(HttpClient);

  private readonly apiUrl =
    `${environment.apiUrl}/api/chat`;

  send(request: ChatRequest): Observable<ChatResponse> {
    return this.http.post<ChatResponse>(
      this.apiUrl,
      request
    );
  }
}