import {Component, OnInit, signal} from '@angular/core';
import {DossierService} from '../../service/dossier.service';
import {ICountry} from '../../domain/ICountry';
import {MatCell, MatColumnDef, MatHeaderCell, MatHeaderRow, MatRow, MatTableModule,} from '@angular/material/table';
import {MatCard, MatCardTitle} from '@angular/material/card';
import {MatButton} from '@angular/material/button';
import {ActivatedRoute, RouterLink} from '@angular/router';

@Component({
  selector: 'app-countries',
  imports: [
    MatTableModule,
    MatColumnDef,
    MatHeaderCell,
    MatCell,
    MatHeaderRow,
    MatRow,
    MatCard,
    MatCardTitle,
    MatButton,
    RouterLink
  ],
  templateUrl: './countries.html',
  styleUrl: './countries.css'
})
export class Countries implements OnInit {
  displayedColumns: string[] = ['name', 'area', 'countryCode2'];

  countries: ICountry[] = [];
  errorMessage = signal<string | null>(null);

  constructor(private dossierService: DossierService,
              public activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.loadItems();
  }

  loadItems() {
    this.dossierService.getAllCountries().subscribe({
      next: (data) => this.countries = data,
      error: (err) => this.errorMessage.set('Could not load items: ' + err.message)
    });
  }
}
