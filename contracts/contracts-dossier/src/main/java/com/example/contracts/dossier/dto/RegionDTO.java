package com.example.contracts.dossier.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class RegionDTO implements Serializable {

    private static final long serialVersionUID = 349392818579141465L;

    private String regionName;
    
    private String continentName;
    
    private String countryName;
    
    private CountryStatsDTO countryStats;
}
