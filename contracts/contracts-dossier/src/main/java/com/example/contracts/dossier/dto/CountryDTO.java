package com.example.contracts.dossier.dto;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

@Data
public class CountryDTO implements Serializable {

    private static final long serialVersionUID = 5156912081109383539L;

    private long countryId;

    private String name;

    private long area;

    private LocalDate nationalDay;

    private String countryCode2;

    private String countryCode3;
}
