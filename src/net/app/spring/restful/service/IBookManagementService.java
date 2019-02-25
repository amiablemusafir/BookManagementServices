package net.app.spring.restful.service;

import java.util.List;

import net.app.spring.restful.model.BookDetailDto;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface IBookManagementService {

	public List<BookDetailDto> getBookDetailsDto() throws Exception;
	public BookDetailDto findBookDetailDtoById(Integer id) throws Exception;
	public void updateBookDetailDto(BookDetailDto bookDetailDto) throws Exception;
}
