import {Component, EventEmitter, Input, Output, signal} from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {MatCard, MatCardTitle} from '@angular/material/card';
import {MatGridList, MatGridTile} from '@angular/material/grid-list';
import {RegionEnum} from '../../../domain/enum/RegionEnum';
import {MatError, MatFormField, MatInput, MatLabel} from '@angular/material/input';
import {MatButton} from '@angular/material/button';
import {MatOption, MatSelect} from '@angular/material/select';
import {IRegionFilter} from '../../../domain/filter/IRegionFilter';
import {DossierService} from '../../../service/dossier.service';

@Component({
  selector: 'app-regions-search',
  imports: [
    ReactiveFormsModule,
    MatCard,
    MatCardTitle,
    MatGridTile,
    MatGridList,
    MatFormField,
    MatInput,
    MatLabel,
    MatError,
    MatButton,
    MatFormField,
    MatOption,
    MatSelect
  ],
  templateUrl: './regions-search.html',
  styleUrl: './regions-search.css'
})
export class RegionsSearch {
  constructor(private dossierService: DossierService) {}

  @Input() pageSize = 10;

  @Output() searchResults = new EventEmitter<any>();

  errorMessage = signal<string | null>(null);
  yearMinimumValue = 0;

  regionForm = new FormGroup({
    regionName: new FormControl(''),
    countryStatsYearFrom: new FormControl(undefined, [Validators.min(this.yearMinimumValue), Validators.pattern('\\d*')]),
    countryStatsYearTo: new FormControl(undefined, [Validators.min(this.yearMinimumValue), Validators.pattern('\\d*')]),
  });


  onSubmit() {
    const filters = {
      ...this.regionForm.value,
      size: this.pageSize,
      page: 0
    };

    this.loadItems(filters)
  }

  loadItems(filters: IRegionFilter) {
    this.dossierService.searchRegions(filters).subscribe({
      next: (results) => this.searchResults.emit({results, formData: {regionName: filters.regionName, countryStatsYearFrom: filters.countryStatsYearFrom, countryStatsYearTo: filters.countryStatsYearTo}}),
      error: (err) => this.errorMessage.set('Could not load items: ' + err.message)
    });
  }

  protected readonly Object = Object;
  protected readonly RegionEnum = RegionEnum;
}
