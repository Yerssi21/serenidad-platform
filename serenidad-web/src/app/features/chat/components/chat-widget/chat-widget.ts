import { Component, ElementRef, ViewChild, effect, inject, signal } from '@angular/core';

import { FormControl, ReactiveFormsModule, Validators } from '@angular/forms';

import { finalize } from 'rxjs';

import { ChatService } from '../../services/chat';

type ChatRole = 'user' | 'assistant';

interface ChatMessage {
  id: number;
  role: ChatRole;
  text: string;
}

@Component({
  selector: 'app-chat-widget',
  imports: [ReactiveFormsModule],
  templateUrl: './chat-widget.html',
  styleUrl: './chat-widget.scss',
})
export class ChatWidget {
  private readonly chatService = inject(ChatService);

  private nextId = 2;

  @ViewChild('messagesContainer')
  private messagesContainer?: ElementRef<HTMLDivElement>;

  protected readonly isOpen = signal(false);

  protected readonly loading = signal(false);

  protected readonly messages = signal<ChatMessage[]>([
    {
      id: 1,
      role: 'assistant',
      text:
        'Hola 💛 Soy el asistente virtual de Serenidad. ' +
        'Puedo orientarte sobre bienestar emocional ' +
        'y ayudarte a conocer nuestros servicios.',
    },
  ]);

  protected readonly messageControl = new FormControl('', {
    nonNullable: true,
    validators: [Validators.required, Validators.maxLength(1200)],
  });

  constructor() {
    effect(() => {
      this.messages();
      this.loading();

      queueMicrotask(() => {
        this.scrollToBottom();
      });
    });
  }

  protected toggle(): void {
    this.isOpen.update((open) => !open);
  }

  protected close(): void {
    this.isOpen.set(false);
  }

  protected send(): void {
    const text = this.messageControl.value.trim();

    if (!text || this.messageControl.invalid || this.loading()) {
      return;
    }

    this.addMessage('user', text);

    this.messageControl.setValue('');

    this.loading.set(true);

    this.chatService
      .send({
        message: text,
      })
      .pipe(finalize(() => this.loading.set(false)))
      .subscribe({
        next: (response) => {
          this.addMessage('assistant', response.message);
        },

        error: (error) => {
          console.error('Error en el chat:', error);

          this.addMessage(
            'assistant',
            'En este momento no puedo responder. ' +
              'Puedes intentarlo nuevamente o utilizar ' +
              'la sección Contacto.',
          );
        },
      });
  }

  protected sendQuickMessage(message: string): void {
    if (this.loading()) {
      return;
    }

    this.messageControl.setValue(message);

    this.send();
  }

  protected onEnter(event: Event): void {
    const keyboardEvent = event as KeyboardEvent;

    if (keyboardEvent.shiftKey) {
      return;
    }

    keyboardEvent.preventDefault();

    this.send();
  }

  protected clearChat(): void {
    this.messages.set([
      {
        id: this.nextId++,
        role: 'assistant',
        text: 'Hola 💛 Soy el asistente virtual de Serenidad. ' + '¿En qué puedo ayudarte?',
      },
    ]);
  }

  private addMessage(role: ChatRole, text: string): void {
    this.messages.update((messages) => [
      ...messages,
      {
        id: this.nextId++,
        role,
        text,
      },
    ]);
  }

  private scrollToBottom(): void {
    const element = this.messagesContainer?.nativeElement;

    if (!element) {
      return;
    }

    element.scrollTop = element.scrollHeight;
  }
}
