package com.apoolla.crud.mapper;

public interface Mapper<I, O> {

	public O mapToDTO(I i);
	
	public I mapToEntity(O o);
}
