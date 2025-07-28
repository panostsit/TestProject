package com.example.dossier.adapter.outbound.persistence.mapper;

import com.example.dossier.domain.Country;
import com.example.dossier.domain.CountryExtended;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CountryMapper {

    @Select("SELECT * FROM countries")
    List<Country> findAllCountries();

    @Select("SELECT c.*, cs.year, cs.population, cs.gdp  \n"
            + "FROM countries c\n"
            + "JOIN country_stats cs ON cs.country_id = c.country_id\n"
            + "JOIN (\n"
            + "    SELECT country_id, MAX(gdp / population) AS max_gdp_per_pop\n"
            + "    FROM country_stats\n"
            + "    GROUP BY country_id\n"
            + ") max_stats ON cs.country_id = max_stats.country_id \n"
            + "           AND (cs.gdp / cs.population) = max_stats.max_gdp_per_pop;")
    @Results({
            @Result(property = "countryStats.year", column = "year"),
            @Result(property = "countryStats.gdp", column = "gdp"),
            @Result(property = "countryStats.population", column = "population")
    })
    List<CountryExtended> findAllCountriesWithStatistics();
}
