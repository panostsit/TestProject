package com.example.dossier.adapter.inbound.rest.mapper;

import com.example.contracts.dossier.dto.pagination.PaginatedDTO;
import com.example.contracts.dossier.dto.pagination.PaginationMetadataDTO;
import com.example.dossier.domain.pagination.Paginated;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;

@Mapper
public interface PaginatedDTOMapper<T1, T2> {

    default PaginatedDTO<T2> toPaginatedDTOList(Paginated<T1> paginated, Function<T1, T2> mappingFunction) {

        Collection<T2> collectionDTO = paginated.getContent()
                                                .stream()
                                                .map(mappingFunction)
                                                .collect(Collectors.toList());

        return PaginatedDTO.<T2>builder()
                           .paginationMetadata(PaginationMetadataDTO.builder()
                                                                    .page(paginated.getPaginationMetadata().getPage())
                                                                    .size(paginated.getPaginationMetadata().getSize())
                                                                    .totalElements(paginated.getPaginationMetadata().getTotalElements())
                                                                    .totalPages(paginated.getPaginationMetadata().getTotalPages())
                                                                    .build())
                           .content(collectionDTO)
                           .build();
    }
}
