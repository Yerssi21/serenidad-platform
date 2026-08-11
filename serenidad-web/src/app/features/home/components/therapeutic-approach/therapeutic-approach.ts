import { Component } from '@angular/core';

interface TherapeuticApproachItem {
  readonly number: string;
  readonly title: string;
  readonly description: string;
}

@Component({
  selector: 'app-therapeutic-approach',
  imports: [],
  templateUrl: './therapeutic-approach.html',
  styleUrl: './therapeutic-approach.scss',
})
export class TherapeuticApproach {
  protected readonly approaches: readonly TherapeuticApproachItem[] = [
    {
      number: '01',
      title: 'Terapia cognitivo-conductual',
      description:
        'Trabajamos sobre pensamientos, emociones y comportamientos para comprender los patrones que influyen en tu bienestar.',
    },
    {
      number: '02',
      title: 'Terapias de tercera generación',
      description:
        'Incorporamos estrategias que favorecen una relación más flexible y consciente con tus emociones y experiencias.',
    },
    {
      number: '03',
      title: 'Aceptación',
      description:
        'Aprender a relacionarte con aquello que no puedes controlar sin permitir que el sufrimiento dirija tus decisiones.',
    },
    {
      number: '04',
      title: 'Atención plena',
      description:
        'Desarrollamos herramientas para conectar con el presente y observar pensamientos y emociones con mayor serenidad.',
    },
    {
      number: '05',
      title: 'Valores personales',
      description:
        'Identificamos aquello que realmente es importante para ti para construir una vida más coherente con quien eres.',
    },
    {
      number: '06',
      title: 'Regulación emocional',
      description:
        'Aprendes a reconocer, comprender y gestionar tus emociones de una manera más saludable y consciente.',
    },
  ];
}