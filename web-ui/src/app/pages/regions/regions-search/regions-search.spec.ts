import {ComponentFixture, TestBed} from '@angular/core/testing';

import {RegionsSearch} from './regions-search';

describe('RegionsSearch', () => {
  let component: RegionsSearch;
  let fixture: ComponentFixture<RegionsSearch>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegionsSearch]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegionsSearch);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
