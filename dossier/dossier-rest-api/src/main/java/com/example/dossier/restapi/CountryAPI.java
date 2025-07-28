package com.example.dossier.restapi;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.example.contracts.dossier.dto.CountryDTO;
import com.example.contracts.dossier.dto.CountryExtendedDTO;
import com.example.contracts.dossier.dto.LanguageDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Countries")
public interface CountryAPI {

    @Operation(summary = "Fetch all countries")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    ResponseEntity<List<CountryDTO>> getAllCountries();

    @Operation(summary = "Fetch all languages for a given country Id")
    @GetMapping(value = "/{countryId}/languages", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    ResponseEntity<List<LanguageDTO>> findAllLanguagesByCountryId(
            @PathVariable("countryId") long countryId
    );

    @Operation(summary = "Fetch all countries with their statistics for the year with the maximum gdp per population ratio")
    @GetMapping(value = "/statistics", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    ResponseEntity<List<CountryExtendedDTO>> findAllCountriesWithStatistics();
}
