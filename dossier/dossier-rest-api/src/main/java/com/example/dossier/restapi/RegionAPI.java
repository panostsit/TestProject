package com.example.dossier.restapi;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.example.contracts.dossier.dto.RegionDTO;
import com.example.contracts.dossier.dto.filter.RegionFiltersDTO;
import com.example.contracts.dossier.dto.pagination.PaginatedDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Regions")
public interface RegionAPI {

    @Operation(summary = "Fetch all regions based on filters")
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    ResponseEntity<PaginatedDTO<RegionDTO>> searchRegions(@RequestBody RegionFiltersDTO filtersDTO);
}
