package com.example.dossier.adapter.inbound.rest.mapper;

import com.example.contracts.dossier.dto.filter.RegionFiltersDTO;
import com.example.dossier.domain.filter.RegionFilters;
import java.util.Objects;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper
public interface RegionFiltersDTOMapper {

    @Mapping(target = "size", source = "size", qualifiedByName = "checkSize")
    @Mapping(target = "page", source = "page", qualifiedByName = "checkPage")
    RegionFilters toDomain(RegionFiltersDTO regionFiltersDTO);

    @Named("checkSize")
    default int checkSize(Integer size) {
        if (Objects.isNull(size) || size < 1) {
            return 5;
        }

        return size;
    }

    @Named("checkPage")
    default int checkPage(Integer page) {
        if (Objects.isNull(page) || page < 0) {
            return 0;
        }

        return page;
    }
}
