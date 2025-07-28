package com.example.dossier.domain;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class CountryStats {

    private int year;

    private long population;

    private BigDecimal gdp;
}
