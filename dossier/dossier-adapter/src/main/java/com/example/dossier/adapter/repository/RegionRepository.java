package com.example.dossier.adapter.repository;

import com.example.dossier.domain.Region;
import com.example.dossier.domain.filter.RegionFilters;
import com.example.dossier.domain.pagination.Paginated;

public interface RegionRepository {

    Paginated<Region> searchRegions(RegionFilters filters);
}
