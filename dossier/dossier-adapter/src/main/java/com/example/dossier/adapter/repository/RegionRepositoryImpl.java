package com.example.dossier.adapter.repository;

import com.example.dossier.adapter.outbound.persistence.mapper.RegionMapper;
import com.example.dossier.domain.Region;
import com.example.dossier.domain.filter.RegionFilters;
import com.example.dossier.domain.pagination.Paginated;
import com.example.dossier.domain.pagination.PaginationMetadata;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
@Transactional
public class RegionRepositoryImpl implements RegionRepository {

    private final RegionMapper regionMapper;

    @Override
    public Paginated<Region> searchRegions(RegionFilters filters) {

        List<Region> regions = regionMapper.searchRegions(filters);

        Integer totalCountOfRegions = regionMapper.totalCountOfRegions(filters);

        return Paginated.<Region>builder()
                        .paginationMetadata(PaginationMetadata.builder()
                                                              .size(filters.getSize())
                                                              .page(filters.getPage())
                                                              .totalElements(totalCountOfRegions)
                                                              .totalPages((int) Math.ceil((double) totalCountOfRegions / filters.getSize()))
                                                              .build())
                        .content(regions)
                        .build();
    }
}
