package com.example.contracts.dossier.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CountryExtendedDTO extends CountryDTO {

    private static final long serialVersionUID = -7999926087181593392L;

    private CountryStatsDTO countryStats;
}
