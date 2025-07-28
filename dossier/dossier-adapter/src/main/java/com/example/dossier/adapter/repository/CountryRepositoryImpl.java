package com.example.dossier.adapter.repository;

import com.example.dossier.adapter.outbound.persistence.mapper.CountryMapper;
import com.example.dossier.domain.Country;
import com.example.dossier.domain.CountryExtended;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
@Transactional
public class CountryRepositoryImpl implements CountryRepository {

    private final CountryMapper countryMapper;

    @Override
    public List<Country> findAllCountries() {
        return countryMapper.findAllCountries();
    }

    @Override
    public List<CountryExtended> findAllCountriesWithStatistics() {
        return countryMapper.findAllCountriesWithStatistics();
    }
}
