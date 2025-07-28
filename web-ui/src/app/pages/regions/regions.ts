import {ChangeDetectorRef, Component, ViewChild} from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import {MatTableDataSource} from '@angular/material/table';
import {IRegion} from '../../domain/IRegion';
import {PageEvent} from '@angular/material/paginator';
import {RegionsSearch} from './regions-search/regions-search';
import {RegionsTable} from './regions-table/regions-table';
import {IRegionFilter} from '../../domain/filter/IRegionFilter';
import {IPaginated} from '../../domain/pagination/IPaginated';
import {MatButton} from '@angular/material/button';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-regions',
  imports: [
    ReactiveFormsModule,
    RegionsSearch,
    RegionsTable,
    MatButton,
    RouterLink
  ],
  templateUrl: './regions.html',
  styleUrl: './regions.css'
})
export class Regions {
  constructor(private cdr: ChangeDetectorRef) {}

  @ViewChild(RegionsSearch) regionsSearch!: RegionsSearch;
  @ViewChild(RegionsTable) regionsTable!: RegionsTable;

  dataSource: MatTableDataSource<IRegion> = new MatTableDataSource<IRegion>([]);
  formData: IRegionFilter = {};
  pageSize: number = 10;

  onSearchResults(data: {results: IPaginated<IRegion>, formData: IRegionFilter}) {
    this.formData = data.formData;
    this.dataSource.data = data.results.content;
    this.regionsTable.paginator.length = data.results.paginationMetadata.totalElements;
    this.regionsTable.paginator.pageIndex = data.results.paginationMetadata.page;
    this.regionsTable.paginator.pageSize = data.results.paginationMetadata.size;
  }

  onPageChange(event: {pageEvent: PageEvent, formData: IRegionFilter}) {
    this.pageSize = event.pageEvent.pageSize;

    const filters = {
      ...event.formData,
      size: event.pageEvent.pageSize,
      page: event.pageEvent.pageIndex
    };

    this.regionsSearch.loadItems(filters);
  }
}
