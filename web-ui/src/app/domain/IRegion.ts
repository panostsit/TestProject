import {ICountryStats} from './ICountryStats';

export interface IRegion {

  regionName: string;
  continentName: string;
  countryName: string;
  countryStats: ICountryStats
}
