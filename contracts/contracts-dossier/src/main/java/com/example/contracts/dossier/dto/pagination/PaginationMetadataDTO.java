package com.example.contracts.dossier.dto.pagination;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginationMetadataDTO {

    private long page;

    private long size;

    private long totalPages;

    private long totalElements;
}
