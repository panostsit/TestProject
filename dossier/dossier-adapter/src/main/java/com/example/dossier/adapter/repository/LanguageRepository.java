package com.example.dossier.adapter.repository;

import com.example.dossier.domain.Language;
import java.util.List;

public interface LanguageRepository {

    List<Language> findAllLanguagesByCountryId(long countryId);
}
