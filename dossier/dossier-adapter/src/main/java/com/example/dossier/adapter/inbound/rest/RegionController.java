package com.example.dossier.adapter.inbound.rest;

import com.example.contracts.dossier.dto.RegionDTO;
import com.example.contracts.dossier.dto.filter.RegionFiltersDTO;
import com.example.contracts.dossier.dto.pagination.PaginatedDTO;
import com.example.dossier.adapter.inbound.rest.mapper.PaginatedDTOMapper;
import com.example.dossier.adapter.inbound.rest.mapper.RegionDTOMapper;
import com.example.dossier.adapter.inbound.rest.mapper.RegionFiltersDTOMapper;
import com.example.dossier.adapter.service.DossierDataService;
import com.example.dossier.domain.Region;
import com.example.dossier.restapi.RegionAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/regions")
@RequiredArgsConstructor
public class RegionController implements RegionAPI {

    private final DossierDataService dossierDataService;

    private final PaginatedDTOMapper<Region, RegionDTO> paginatedDTOMapper;

    private final RegionFiltersDTOMapper regionFiltersDTOMapper;

    private final RegionDTOMapper regionDTOMapper;

    @Override
    public ResponseEntity<PaginatedDTO<RegionDTO>> searchRegions(RegionFiltersDTO filtersDTO) {
        return ResponseEntity.ok(paginatedDTOMapper.toPaginatedDTOList(
                dossierDataService.searchRegions(regionFiltersDTOMapper.toDomain(filtersDTO)), regionDTOMapper::toRegionDTO));
    }
}
