import { Component, signal } from '@angular/core';
import {
  FormBuilder,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';

@Component({
  selector: 'app-contact',
  imports: [ReactiveFormsModule],
  templateUrl: './contact.html',
  styleUrl: './contact.scss',
})
export class Contact {
  protected readonly submitted = signal(false);

  protected readonly contactForm;

  constructor(private readonly formBuilder: FormBuilder) {
    this.contactForm = this.formBuilder.nonNullable.group({
      name: ['', [Validators.required, Validators.minLength(2)]],

      email: ['', [Validators.required, Validators.email]],

      phone: [''],

      modality: ['', Validators.required],

      message: ['', Validators.maxLength(500)],

      privacyAccepted: [false, Validators.requiredTrue],
    });
  }

  protected submit(): void {
    this.submitted.set(false);

    if (this.contactForm.invalid) {
      this.contactForm.markAllAsTouched();
      return;
    }

    console.log(this.contactForm.getRawValue());

    this.submitted.set(true);
  }
}