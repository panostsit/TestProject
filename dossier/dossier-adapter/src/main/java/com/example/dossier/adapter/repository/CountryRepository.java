package com.example.dossier.adapter.repository;

import com.example.dossier.domain.Country;
import com.example.dossier.domain.CountryExtended;
import java.util.List;

public interface CountryRepository {

    List<Country> findAllCountries();

    List<CountryExtended> findAllCountriesWithStatistics();
}
