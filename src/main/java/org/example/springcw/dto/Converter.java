package org.example.springcw.dto;

public interface Converter<E, D> {
    D convertToDto(E entity);
}