import { Component, inject, signal } from '@angular/core';
import {
  NonNullableFormBuilder,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { finalize } from 'rxjs';

import { ContactService } from '../../services/contact';
import { LocationMap } from '../../components/location-map/location-map';

@Component({
  selector: 'app-contact',
  imports: [ReactiveFormsModule, LocationMap],
  templateUrl: './contact.html',
  styleUrl: './contact.scss',
})
export class Contact {

  private readonly fb = inject(NonNullableFormBuilder);
  private readonly contactService = inject(ContactService);

  protected readonly loading = signal(false);
  protected readonly successMessage = signal<string | null>(null);
  protected readonly errorMessage = signal<string | null>(null);

  protected readonly contactForm = this.fb.group({
    name: [
      '',
      [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(120),
      ],
    ],

    email: [
      '',
      [
        Validators.required,
        Validators.email,
        Validators.maxLength(180),
      ],
    ],

    phone: [
      '',
      Validators.maxLength(30),
    ],

    modality: [
      '',
      [
        Validators.required,
        Validators.maxLength(50),
      ],
    ],

    message: [
      '',
      Validators.maxLength(500),
    ],

    privacyAccepted: [
      false,
      Validators.requiredTrue,
    ],
  });

  protected submit(): void {

    if (this.contactForm.invalid) {
      this.contactForm.markAllAsTouched();
      return;
    }

    this.loading.set(true);
    this.successMessage.set(null);
    this.errorMessage.set(null);

    const request = this.contactForm.getRawValue();

    this.contactService
      .create(request)
      .pipe(
        finalize(() => this.loading.set(false))
      )
      .subscribe({
        next: (response) => {
          this.successMessage.set(response.message);
          this.contactForm.reset();
        },

        error: (error) => {
          console.error(
            'Error enviando formulario:',
            error
          );

          this.errorMessage.set(
            'No pudimos enviar tu solicitud. Inténtalo nuevamente.'
          );
        },
      });
  }
}