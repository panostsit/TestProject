package com.example.dossier.adapter.outbound.persistence.mapper;

import com.example.dossier.adapter.outbound.persistence.provider.RegionProvider;
import com.example.dossier.domain.Region;
import com.example.dossier.domain.filter.RegionFilters;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface RegionMapper {

    @SelectProvider(type = RegionProvider.class, method = "selectRegionsWithFilters")
    @Results({
            @Result(property = "countryStats.year", column = "year"),
            @Result(property = "countryStats.gdp", column = "gdp"),
            @Result(property = "countryStats.population", column = "population")
    })
    List<Region> searchRegions(RegionFilters filters);

    @SelectProvider(type = RegionProvider.class, method = "totalNumberOfRegionsWithFilters")
    Integer totalCountOfRegions(RegionFilters filters);
}
