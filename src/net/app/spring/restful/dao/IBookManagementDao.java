package net.app.spring.restful.dao;

import java.util.List;

import net.app.spring.restful.model.BookDetailDto;

public interface IBookManagementDao {

	public List<BookDetailDto> getBookDetailsDto() throws Exception;
	public BookDetailDto findBookDetailDtoById(Integer id) throws Exception;
	
	public void updateBookDetailDto(BookDetailDto bookDetailDto) throws Exception;
}
