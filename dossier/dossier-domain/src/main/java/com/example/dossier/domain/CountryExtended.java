package com.example.dossier.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CountryExtended extends Country {

    private CountryStats countryStats;
}
