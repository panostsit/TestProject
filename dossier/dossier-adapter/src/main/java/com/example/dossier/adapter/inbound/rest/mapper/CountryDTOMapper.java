package com.example.dossier.adapter.inbound.rest.mapper;

import com.example.contracts.dossier.dto.CountryDTO;
import com.example.dossier.domain.Country;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface CountryDTOMapper {

    List<CountryDTO> toCountryDTOList(List<Country> countryList);
}
