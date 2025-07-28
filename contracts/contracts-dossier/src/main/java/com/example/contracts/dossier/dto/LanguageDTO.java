package com.example.contracts.dossier.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class LanguageDTO implements Serializable {

    private static final long serialVersionUID = -9040461855847418921L;

    private long id;

    private String name;
}
