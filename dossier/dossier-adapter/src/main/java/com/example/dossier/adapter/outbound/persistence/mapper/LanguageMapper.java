package com.example.dossier.adapter.outbound.persistence.mapper;

import com.example.dossier.domain.Language;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LanguageMapper {

    @Select("SELECT * FROM languages WHERE language_id IN (SELECT language_id FROM country_languages WHERE country_id = #{countryId})")
    @Results({
            @Result(property = "id", column = "language_id"),
            @Result(property = "name", column = "language")
    })
    List<Language> findAllLanguagesByCountryId(long countryId);
}
