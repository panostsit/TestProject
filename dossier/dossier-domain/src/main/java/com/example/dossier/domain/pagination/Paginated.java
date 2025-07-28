package com.example.dossier.domain.pagination;

import java.util.Collection;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Paginated<T> {

    PaginationMetadata paginationMetadata;
    
    Collection<T> content;
}
