package com.example.dossier.adapter.inbound.rest;

import com.example.contracts.dossier.dto.CountryDTO;
import com.example.contracts.dossier.dto.CountryExtendedDTO;
import com.example.contracts.dossier.dto.LanguageDTO;
import com.example.dossier.adapter.inbound.rest.mapper.CountryDTOMapper;
import com.example.dossier.adapter.inbound.rest.mapper.CountryExtendedDTOMapper;
import com.example.dossier.adapter.inbound.rest.mapper.LanguageDTOMapper;
import com.example.dossier.adapter.service.DossierDataService;
import com.example.dossier.restapi.CountryAPI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
@RequiredArgsConstructor
public class CountryController implements CountryAPI {

    private final DossierDataService dossierDataService;

    private final CountryDTOMapper countryDTOMapper;

    private final CountryExtendedDTOMapper countryExtendedDTOMapper;

    private final LanguageDTOMapper languageDTOMapper;

    @Override
    public ResponseEntity<List<CountryDTO>> getAllCountries() {
        return ResponseEntity.ok(countryDTOMapper.toCountryDTOList(dossierDataService.getAllCountries()));
    }

    @Override
    public ResponseEntity<List<LanguageDTO>> findAllLanguagesByCountryId(long countryId) {
        return ResponseEntity.ok(languageDTOMapper.toLanguageDTOList(dossierDataService.findAllLanguagesByCountryId(countryId)));
    }

    @Override
    public ResponseEntity<List<CountryExtendedDTO>> findAllCountriesWithStatistics() {
        return ResponseEntity.ok(countryExtendedDTOMapper.toCountryExtendedDTOList(dossierDataService.findAllCountriesWithStatistics()));
    }
}
