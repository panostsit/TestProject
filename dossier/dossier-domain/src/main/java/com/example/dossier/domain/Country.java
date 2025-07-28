package com.example.dossier.domain;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Country {

    private long countryId;

    private String name;

    private long area;

    private LocalDate nationalDay;

    private String countryCode2;

    private String countryCode3;
}
