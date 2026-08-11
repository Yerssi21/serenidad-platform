import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

interface BlogArticle {
  readonly category: string;
  readonly title: string;
  readonly excerpt: string;
  readonly slug: string;
  readonly readingTime: string;
}

@Component({
  selector: 'app-blog-preview',
  imports: [RouterLink],
  templateUrl: './blog-preview.html',
  styleUrl: './blog-preview.scss',
})
export class BlogPreview {
  protected readonly articles: readonly BlogArticle[] = [
    {
      category: 'Dependencia emocional',
      title: '¿Cómo saber si estoy en una relación de dependencia emocional?',
      excerpt:
        'Algunas relaciones pueden hacernos sentir que necesitamos a la otra persona para estar bien. Reconocer estas señales es el primer paso para recuperar autonomía.',
      slug: 'dependencia-emocional-en-la-pareja',
      readingTime: '6 min',
    },
    {
      category: 'Ansiedad',
      title: 'Cuando pensar demasiado empieza a agotarte',
      excerpt:
        'La preocupación constante puede convertirse en un ciclo difícil de detener. Comprender qué ocurre puede ayudarte a relacionarte de otra manera con tus pensamientos.',
      slug: 'cuando-pensar-demasiado-agota',
      readingTime: '5 min',
    },
    {
      category: 'Autoestima',
      title: 'Aprender a hablarte con más respeto',
      excerpt:
        'La forma en la que te hablas influye en cómo te relacionas contigo y con los demás. La autoestima también se construye desde el diálogo interno.',
      slug: 'aprender-a-hablarte-con-respeto',
      readingTime: '4 min',
    },
  ];
}