package com.example.dossier.domain;

import lombok.Data;

@Data
public class Region {

    private String regionName;

    private String continentName;

    private String countryName;

    private CountryStats countryStats;
}
