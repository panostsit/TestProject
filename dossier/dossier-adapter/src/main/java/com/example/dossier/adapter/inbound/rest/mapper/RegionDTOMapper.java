package com.example.dossier.adapter.inbound.rest.mapper;

import com.example.contracts.dossier.dto.RegionDTO;
import com.example.dossier.domain.Region;
import org.mapstruct.Mapper;

@Mapper
public interface RegionDTOMapper {

    RegionDTO toRegionDTO(Region region);
}
