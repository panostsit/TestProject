package com.example.dossier.adapter.service;

import com.example.dossier.domain.Country;
import com.example.dossier.domain.CountryExtended;
import com.example.dossier.domain.Language;
import com.example.dossier.domain.Region;
import com.example.dossier.domain.filter.RegionFilters;
import com.example.dossier.domain.pagination.Paginated;
import java.util.List;

public interface DossierDataService {

    List<Country> getAllCountries();

    List<Language> findAllLanguagesByCountryId(long countryId);

    List<CountryExtended> findAllCountriesWithStatistics();

    Paginated<Region> searchRegions(RegionFilters filters);
}
