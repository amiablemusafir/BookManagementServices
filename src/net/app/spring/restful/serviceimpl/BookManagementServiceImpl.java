package net.app.spring.restful.serviceimpl;

import java.util.List;

import net.app.spring.restful.dao.IBookManagementDao;
import net.app.spring.restful.model.BookDetailDto;
import net.app.spring.restful.service.IBookManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("bookManagementService")   
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)   
public class BookManagementServiceImpl implements IBookManagementService {

	@Autowired 
	public IBookManagementDao bookManagementDao;

	
	public List<BookDetailDto> getBookDetailsDto() throws Exception {
		return this.bookManagementDao.getBookDetailsDto();
	}
	
	public List<BookDetailDto> getBookDetailsDtoFilter(String filter) throws Exception {
		return this.bookManagementDao.getBookDetailsDtoFilter(filter);
	}
	
	public BookDetailDto findBookDetailDtoById(Integer id) throws Exception {
		return this.bookManagementDao.findBookDetailDtoById(id);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateBookDetailDto(BookDetailDto bookDetailDto) throws Exception {
		this.bookManagementDao.updateBookDetailDto(bookDetailDto);
	}
}
