import {Component, signal} from '@angular/core';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatMenuModule} from '@angular/material/menu';
import {MatButtonModule} from '@angular/material/button';
import {Router, RouterLink, RouterOutlet} from '@angular/router';
import {MatIcon} from '@angular/material/icon';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    MatExpansionModule,
    MatMenuModule,
    MatButtonModule,
    RouterLink,
    RouterOutlet,
    MatIcon
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})

export class App {
  protected readonly title = signal('web-ui');

  constructor(public router: Router) {}
}
