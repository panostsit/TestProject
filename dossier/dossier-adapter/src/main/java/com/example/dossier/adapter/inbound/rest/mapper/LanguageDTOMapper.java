package com.example.dossier.adapter.inbound.rest.mapper;

import com.example.contracts.dossier.dto.LanguageDTO;
import com.example.dossier.domain.Language;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface LanguageDTOMapper {

    List<LanguageDTO> toLanguageDTOList(List<Language> languageList);
}
