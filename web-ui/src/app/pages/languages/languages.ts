import {Component, OnInit, signal} from '@angular/core';
import {MatButton} from '@angular/material/button';
import {ActivatedRoute, Router, RouterLink} from '@angular/router';
import {DossierService} from '../../service/dossier.service';
import {ILanguage} from '../../domain/ILanguage';
import {MatList, MatListItem, MatListSubheaderCssMatStyler} from '@angular/material/list';

@Component({
  selector: 'app-languages',
  imports: [
    MatButton,
    RouterLink,
    MatListItem,
    MatList,
    MatListSubheaderCssMatStyler
  ],
  templateUrl: './languages.html',
  styleUrl: './languages.css'
})
export class Languages implements OnInit {
  languages: ILanguage[] = [];
  errorMessage = signal<string | null>(null);


  constructor(private dossierService: DossierService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {

    let state = this.router.getCurrentNavigation()?.extras.state

    if (state) {
      localStorage.setItem('countryName', state['countryName']);
    }
  }



  ngOnInit() {
    this.loadItems();
  }

  loadItems() {
    this.dossierService.getLanguagesByCountryId(this.activatedRoute.snapshot.paramMap.get('countryId')).subscribe({
      next: (data) => this.languages = data,
      error: (err) => this.errorMessage.set('Could not load items: ' + err.message)
    });
  }

  protected readonly localStorage = localStorage;
}
