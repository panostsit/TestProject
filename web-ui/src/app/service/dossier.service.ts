import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ICountry} from '../domain/ICountry';
import {ILanguage} from '../domain/ILanguage';
import {ICountryExtended} from '../domain/ICountryExtended';
import {IRegion} from '../domain/IRegion';
import {IRegionFilter} from '../domain/filter/IRegionFilter';
import {IPaginated} from '../domain/pagination/IPaginated';
import {ConfigService} from '../../../public/config.service';

@Injectable({
  providedIn: 'root',
})

export class DossierService {
  private readonly apiUrl;

  constructor(private http: HttpClient, private configService: ConfigService) {
   this.apiUrl = `${configService.apiUrl}/dossier`;
  }

  getAllCountries(): Observable<ICountry[]> {
    return this.http.get<ICountry[]>(`${this.apiUrl}/countries`);
  }

  getLanguagesByCountryId(countryId: string | null): Observable<ILanguage[]> {
    return this.http.get<ILanguage[]>(`${this.apiUrl}/countries/${countryId}/languages`);
  }

  getAllCountriesWithStatistics(): Observable<ICountryExtended[]> {
    return this.http.get<ICountryExtended[]>(`${this.apiUrl}/countries/statistics`);
  }

  searchRegions(filters: IRegionFilter): Observable<IPaginated<IRegion>> {
    return this.http.post<IPaginated<IRegion>>(`${this.apiUrl}/regions`, filters);
  }

}
