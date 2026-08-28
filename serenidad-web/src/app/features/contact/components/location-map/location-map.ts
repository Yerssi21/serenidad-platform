import {
  Component,
  computed,
} from '@angular/core';

import {
  DomSanitizer,
  SafeResourceUrl,
} from '@angular/platform-browser';

import { inject } from '@angular/core';

import {
  environment,
} from '../../../../../environments/environment';

@Component({
  selector: 'app-location-map',
  imports: [],
  templateUrl: './location-map.html',
  styleUrl: './location-map.scss',
})
export class LocationMap {

  private readonly sanitizer =
    inject(DomSanitizer);

  /*
   * Sustituiremos esta dirección
   * por la dirección definitiva.
   */
  private readonly address =
    'Av. Maisonnave 28 bis, Alicante, España';

  protected readonly mapUrl =
    computed<SafeResourceUrl>(() => {

      const query =
        encodeURIComponent(this.address);

      const url =
        'https://www.google.com/maps/embed/v1/place'
        + `?key=${environment.googleMapsApiKey}`
        + `&q=${query}`;

      return this.sanitizer
        .bypassSecurityTrustResourceUrl(url);
    });

  protected readonly directionsUrl =
    `https://www.google.com/maps/search/?api=1&query=${
      encodeURIComponent(this.address)
    }`;
}