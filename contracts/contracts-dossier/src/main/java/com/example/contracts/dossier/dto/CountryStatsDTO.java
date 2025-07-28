package com.example.contracts.dossier.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class CountryStatsDTO implements Serializable {

    private static final long serialVersionUID = -9117500761175177443L;

    private int year;

    private long population;

    private BigDecimal gdp;
}
