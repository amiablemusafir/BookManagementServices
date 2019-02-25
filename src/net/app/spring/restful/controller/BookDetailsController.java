package net.app.spring.restful.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.app.spring.restful.constant.EmpRestURIConstants;
import net.app.spring.restful.model.BookDetailDto;
import net.app.spring.restful.model.ResponseCode;
import net.app.spring.restful.service.IBookManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookDetailsController {
	
	@Autowired  
	private IBookManagementService bookManagementService; 
	
    @RequestMapping(value = EmpRestURIConstants.GET_ALL_BOOKDETAILS, method = RequestMethod.GET)
    public @ResponseBody List<BookDetailDto> getProductMethod1(@RequestParam(value="itemcode", defaultValue="1") String itemcode) {
    	
    	List<BookDetailDto> bookDetailDtoList = new ArrayList<BookDetailDto>();
    	try {
			bookDetailDtoList = this.bookManagementService.getBookDetailsDto();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  bookDetailDtoList;
    }
    
    
    @RequestMapping(value = EmpRestURIConstants.GET_BOOK, method = RequestMethod.GET)
    public @ResponseBody BookDetailDto getBookDetailsById(@PathVariable(value="bookcode")  String bookcode) {
    	BookDetailDto bookDetailDto = new BookDetailDto();
    	try {
			bookDetailDto = this.bookManagementService.findBookDetailDtoById(Integer.parseInt(bookcode));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}    	
    	return bookDetailDto;
    }
  
    @RequestMapping(value = EmpRestURIConstants.CREATE_BOOK, method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> createEmployee(@RequestBody BookDetailDto bookDetils) {
    	bookDetils.setBdt_entry_date(new Date());
    	bookDetils.setBnum_isactive(1);
		try {
			this.bookManagementService.updateBookDetailDto(bookDetils);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
    
    @RequestMapping(value = EmpRestURIConstants.DELETE_BOOK, method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<?> deleteBookDetailsById(@PathVariable(value="bookcode")  String bookcode) {
    	BookDetailDto bookDetailDto = new BookDetailDto();
    	try {
			bookDetailDto = this.bookManagementService.findBookDetailDtoById(Integer.parseInt(bookcode));
			if(bookDetailDto != null && bookDetailDto.getBnum_book_id() != null) {
				bookDetailDto.setBnum_isactive(0);
				this.bookManagementService.updateBookDetailDto(bookDetailDto);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}    	
    	return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
  
    
}