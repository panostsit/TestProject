import {Routes} from '@angular/router';
import {Countries} from './pages/countries/countries';
import {Languages} from './pages/languages/languages';
import {Statistics} from './pages/statistics/statistics';
import {Regions} from './pages/regions/regions';

export const routes: Routes = [
  { path: 'countries', component: Countries},
  { path: 'countries/:countryId/languages', component: Languages},
  { path: 'statistics', component: Statistics},
  { path: 'regions', component: Regions},
];
