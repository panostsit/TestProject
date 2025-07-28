package com.example.dossier.domain.pagination;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginationMetadata {

    private long page;

    private long size;

    private long totalPages;

    private long totalElements;
}
