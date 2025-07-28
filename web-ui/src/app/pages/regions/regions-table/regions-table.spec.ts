import {ComponentFixture, TestBed} from '@angular/core/testing';

import {RegionsTable} from './regions-table';

describe('RegionsTable', () => {
  let component: RegionsTable;
  let fixture: ComponentFixture<RegionsTable>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegionsTable]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegionsTable);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
