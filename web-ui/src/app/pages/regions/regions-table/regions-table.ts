import {AfterViewInit, ChangeDetectorRef, Component, EventEmitter, Input, Output, ViewChild} from '@angular/core';
import {
  MatCell,
  MatCellDef,
  MatColumnDef,
  MatHeaderCell,
  MatHeaderCellDef,
  MatHeaderRow,
  MatHeaderRowDef,
  MatRow,
  MatRowDef,
  MatTable,
  MatTableDataSource
} from '@angular/material/table';
import {MatCard, MatCardTitle} from '@angular/material/card';
import {MatPaginator, PageEvent} from '@angular/material/paginator';
import {IRegion} from '../../../domain/IRegion';
import {IRegionFilter} from '../../../domain/filter/IRegionFilter';

@Component({
  selector: 'app-regions-table',
  imports: [
    MatTable,
    MatCardTitle,
    MatCard,
    MatHeaderRow,
    MatRow,
    MatHeaderCell,
    MatCell,
    MatPaginator,
    MatColumnDef,
    MatHeaderCellDef,
    MatCellDef,
    MatHeaderRowDef,
    MatRowDef,
  ],
  templateUrl: './regions-table.html',
  styleUrl: './regions-table.css'
})
export class RegionsTable implements AfterViewInit {
  constructor(private cdr: ChangeDetectorRef) {}

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  @Input() dataSource = new MatTableDataSource<IRegion>([]);
  @Input() formData: IRegionFilter = {};

  @Output() pageChange = new EventEmitter<{pageEvent: PageEvent, formData: IRegionFilter}>();

  displayedColumns: string[] = ['continentName', 'regionName', 'countryName', 'year', 'population', 'gdp'];
  pageSize = 10;
  totalElements: number = 0;
  currentPage = 0;

  ngAfterViewInit() {
    this.paginator.page.subscribe(() => {
      this.currentPage = this.paginator.pageIndex;
      this.pageSize = this.paginator.pageSize;

      this.pageChange.emit({
        pageEvent: {
          pageIndex: this.currentPage,
          pageSize: this.pageSize,
          length: this.totalElements
        },
        formData: this.formData
      });
    });

      this.pageChange.emit({
        pageEvent: {
          pageIndex: this.currentPage,
          pageSize: this.pageSize,
          length: this.totalElements
        },
        formData: this.formData
      });
  }

}
