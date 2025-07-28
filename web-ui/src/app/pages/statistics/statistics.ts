import {Component, OnInit, signal} from '@angular/core';
import {MatButton} from "@angular/material/button";
import {MatCard, MatCardTitle} from "@angular/material/card";
import {MatCell, MatColumnDef, MatHeaderCell, MatHeaderRow, MatRow, MatTableModule} from "@angular/material/table";
import {DossierService} from '../../service/dossier.service';
import {RouterLink} from '@angular/router';
import {ICountryExtended} from '../../domain/ICountryExtended';

@Component({
  selector: 'app-statistics',
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
  templateUrl: './statistics.html',
  styleUrl: './statistics.css'
})
export class Statistics implements OnInit {
  displayedColumns: string[] = ['name', 'countryCode3', 'year', 'gdp', 'population'];

  countriesExtended: ICountryExtended[] = [];
  errorMessage = signal<string | null>(null);

  constructor(private dossierService: DossierService) {}

  ngOnInit() {
    this.loadItems();
  }

  loadItems() {
    this.dossierService.getAllCountriesWithStatistics().subscribe({
      next: (data) => this.countriesExtended = data,
      error: (err) => this.errorMessage.set('Could not load items: ' + err.message)
    });
  }
}
