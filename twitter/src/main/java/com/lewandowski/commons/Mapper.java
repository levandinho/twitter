package com.lewandowski.commons;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface Mapper<E, D> {

    public E mapDtoToEntity(D dto);

    public D mapEntityToDto(E entity);

    default public List<E> mapDtoToEntity(Collection<D> dtos) {
        return dtos.stream().map(d -> mapDtoToEntity(d)).collect(Collectors.toList());
    }

    default public List<D> mapEntityToDto(Collection<E> entities) {
        return entities.stream().map(e -> mapEntityToDto(e)).collect(Collectors.toList());
    }
}
