package com.example.contracts.dossier.dto.pagination;

import java.io.Serializable;
import java.util.Collection;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginatedDTO<T> implements Serializable {

    private static final long serialVersionUID = 2738122987706522305L;

    PaginationMetadataDTO paginationMetadata;
    
    Collection<T> content;
}
