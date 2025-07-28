import {ICountry} from './ICountry';
import {ICountryStats} from './ICountryStats';

export interface ICountryExtended extends ICountry {
  countryStats: ICountryStats;
}
