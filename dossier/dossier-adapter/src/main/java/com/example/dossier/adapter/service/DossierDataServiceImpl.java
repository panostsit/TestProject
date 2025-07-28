package com.example.dossier.adapter.service;

import com.example.dossier.adapter.repository.CountryRepository;
import com.example.dossier.adapter.repository.LanguageRepository;
import com.example.dossier.adapter.repository.RegionRepository;
import com.example.dossier.domain.Country;
import com.example.dossier.domain.CountryExtended;
import com.example.dossier.domain.Language;
import com.example.dossier.domain.Region;
import com.example.dossier.domain.filter.RegionFilters;
import com.example.dossier.domain.pagination.Paginated;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DossierDataServiceImpl implements DossierDataService {

    private final CountryRepository countryRepository;

    private final LanguageRepository languageRepository;

    private final RegionRepository regionRepository;

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAllCountries();
    }

    @Override
    public List<Language> findAllLanguagesByCountryId(long countryId) {
        return languageRepository.findAllLanguagesByCountryId(countryId);
    }

    @Override
    public List<CountryExtended> findAllCountriesWithStatistics() {
        return countryRepository.findAllCountriesWithStatistics();
    }

    @Override
    public Paginated<Region> searchRegions(RegionFilters filters) {
        return regionRepository.searchRegions(filters);
    }
}
