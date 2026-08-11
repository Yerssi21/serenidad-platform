import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadComponent: () =>
      import('./layout/public-layout/public-layout').then(
        (m) => m.PublicLayout,
      ),
    children: [
      {
        path: '',
        title: 'Serenidad | Psicología y bienestar emocional',
        loadComponent: () =>
          import('./features/home/pages/home/home').then(
            (m) => m.Home,
          ),
      },

      {
        path: 'sobre-mi',
        title: 'Sobre mí | Serenidad',
        loadComponent: () =>
          import('./features/about/pages/about/about').then(
            (m) => m.About,
          ),
      },

      {
        path: 'blog',
        title: 'Blog | Serenidad',
        loadComponent: () =>
          import('./features/blog/pages/blog-list/blog-list').then(
            (m) => m.BlogList,
          ),
      },

      {
        path: 'contacto',
        title: 'Contacto | Serenidad',
        loadComponent: () =>
          import('./features/contact/pages/contact/contact').then(
            (m) => m.Contact,
          ),
      },
    ],
  },

  {
    path: '**',
    redirectTo: '',
  },
];