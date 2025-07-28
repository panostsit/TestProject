package com.example.dossier.adapter.repository;

import com.example.dossier.adapter.outbound.persistence.mapper.LanguageMapper;
import com.example.dossier.domain.Language;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
@Transactional
public class LanguageRepositoryImpl implements LanguageRepository {

    private final LanguageMapper languageMapper;

    @Override
    public List<Language> findAllLanguagesByCountryId(long countryId) {
        return languageMapper.findAllLanguagesByCountryId(countryId);
    }
}
