import { Component } from '@angular/core';

import { Hero } from '../../components/hero/hero';
import { ServiceInfo } from '../../components/service-info/service-info';
import { Specialties } from '../../components/specialties/specialties';
import { AboutPreview } from '../../components/about-preview/about-preview';
import { TherapeuticApproach } from '../../components/therapeutic-approach/therapeutic-approach';
import { BlogPreview } from '../../components/blog-preview/blog-preview';
import { FinalCta } from '../../components/final-cta/final-cta';


@Component({
  selector: 'app-home',
  imports: [
    Hero,
    ServiceInfo,
    Specialties,
    AboutPreview,
    TherapeuticApproach,
    BlogPreview,
    FinalCta,
  ],
  templateUrl: './home.html',
  styleUrl: './home.scss',
})
export class Home {}