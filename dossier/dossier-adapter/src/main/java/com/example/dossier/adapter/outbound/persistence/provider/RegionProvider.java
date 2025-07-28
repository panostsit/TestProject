package com.example.dossier.adapter.outbound.persistence.provider;

import com.example.dossier.domain.filter.RegionFilters;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

public class RegionProvider {
    public String selectRegionsWithFilters(RegionFilters filters) {
        StringBuilder sqlQuery = new StringBuilder("SELECT c2.name AS continent_name, r.name AS region_name, c.name AS country_name, cs.year, cs.population, cs.gdp\n");

        constructMainQuery(sqlQuery, filters);

        sqlQuery.append(" ORDER BY r.name LIMIT #{size} OFFSET ");
        sqlQuery.append(filters.getPage() * filters.getSize());

        return sqlQuery.toString();
    }

    public String totalNumberOfRegionsWithFilters(RegionFilters filters) {
        StringBuilder sqlQuery = new StringBuilder("SELECT COUNT(*)\n");

        constructMainQuery(sqlQuery, filters);

        return sqlQuery.toString();
    }

    private void constructMainQuery(StringBuilder sqlQuery, RegionFilters filters) {
        sqlQuery.append("FROM countries c\n"
                + "JOIN country_stats cs ON cs.country_id = c.country_id\n"
                + "JOIN regions r ON r.region_id = c.region_id\n"
                + "JOIN continents c2 ON c2.continent_id = r.continent_id");

        if (StringUtils.isNotEmpty(filters.getRegionName())) {
            sqlQuery.append(" AND r.name = #{regionName}");
        }

        if (Objects.nonNull(filters.getCountryStatsYearFrom())) {
            sqlQuery.append(" AND cs.year >= #{countryStatsYearFrom}");
        }

        if (Objects.nonNull(filters.getCountryStatsYearTo())) {
            sqlQuery.append(" AND cs.year <= #{countryStatsYearTo}");
        }
    }
}
