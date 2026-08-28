import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

import { Header } from '../header/header';
import { Footer } from '../footer/footer';
import { ChatWidget } from '../../features/chat/components/chat-widget/chat-widget';

@Component({
  selector: 'app-public-layout',
  imports: [RouterOutlet, Header, Footer, ChatWidget],
  templateUrl: './public-layout.html',
  styleUrl: './public-layout.scss',
})
export class PublicLayout {}