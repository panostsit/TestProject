package com.example.dossier.domain.filter;

import lombok.Data;

@Data
public class RegionFilters {

    private String regionName;

    private Integer countryStatsYearFrom;

    private Integer countryStatsYearTo;

    private Integer page;

    private Integer size;
}
