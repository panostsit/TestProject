package com.example.dossier.adapter.inbound.rest.mapper;

import com.example.contracts.dossier.dto.CountryExtendedDTO;
import com.example.dossier.domain.CountryExtended;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface CountryExtendedDTOMapper {

    List<CountryExtendedDTO> toCountryExtendedDTOList(List<CountryExtended> countryExtendedList);
}
