package net.app.spring.restful.daoimpl;

import java.util.ArrayList;
import java.util.List;

import net.app.spring.restful.dao.IBookManagementDao;
import net.app.spring.restful.model.BookDetailDto;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;


@Repository("bookManagementDao")  
public class BookManagementDaoImpl implements IBookManagementDao {
	
	private HibernateTemplate hibernateTemplate;
		
	@Autowired  
	private SessionFactory sessionFactory; 
	    
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<BookDetailDto> getBookDetailsDto() throws Exception {
		
		List<BookDetailDto> bookList = null;		
		String query = "from BookDetailDto as bookDetailDto where bookDetailDto.bnum_isactive = 1";
		bookList = sessionFactory.getCurrentSession().find(query);
		return bookList;
	}
	
	@Override
	public List<BookDetailDto> getBookDetailsDtoFilter(String filter) throws Exception {
		
		List<BookDetailDto> bookList = null;		
		String query = "from BookDetailDto as bookDetailDto where bookDetailDto.bnum_isactive = 1";
		if(filter.equals("author")) {
			query = query+" ORDER BY bookDetailDto.bstr_author ASC";
		} else if(filter.equals("date")) {
			query = query+" ORDER BY bookDetailDto.bdt_entry_date ASC";
		} else if(filter.equals("price")) {
			query = query+" ORDER BY bookDetailDto.bstr_price ASC";
		} else if(filter.equals("name")) {
			query = query+" ORDER BY bookDetailDto.bstr_bookname ASC";
		}		
		bookList = sessionFactory.getCurrentSession().find(query);
		return bookList;
	}
	
	@Override
	public BookDetailDto findBookDetailDtoById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		BookDetailDto dto = new BookDetailDto();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from BookDetailDto as details where details.bnum_book_id = "+id+" and details.bnum_isactive = 1");
			if(query.list() != null && query.list().size()>0) {
				dto = (BookDetailDto) query.list().get(0);
			}
		} catch (RuntimeException re) {
			throw re;
		}
		return dto;
	}	
	
	@Override
	public void updateBookDetailDto(BookDetailDto bookDetailDto) throws Exception {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(bookDetailDto);
			System.out.println("Data Saved");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
