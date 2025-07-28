package com.example.contracts.dossier.dto.filter;

import lombok.Data;

@Data
public class RegionFiltersDTO {

    private String regionName;

    private Integer countryStatsYearFrom;

    private Integer countryStatsYearTo;

    private Integer page;

    private Integer size;
}
