package net.app.spring.restful.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;  

import org.hibernate.annotations.Proxy;
@Entity @Table(name = "BM_BOOK_DETAILS_MASTER") @Proxy(lazy=false)

public class BookDetailDto implements Serializable {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name = "bnum_book_id") public Integer bnum_book_id;
	@Column(name = "bstr_bookname") public String bstr_bookname;
	@Column(name = "bstr_author") public String bstr_author;
	@Column(name = "bstr_price") public String bstr_price;
	@Column(name = "bdt_entry_date") public Date bdt_entry_date;
	@Column(name = "bnum_isactive") public Integer bnum_isactive;
	
	public Integer getBnum_book_id() {
		return bnum_book_id;
	}
	public void setBnum_book_id(Integer bnum_book_id) {
		this.bnum_book_id = bnum_book_id;
	}
	public String getBstr_bookname() {
		return bstr_bookname;
	}
	public void setBstr_bookname(String bstr_bookname) {
		this.bstr_bookname = bstr_bookname;
	}
	public String getBstr_author() {
		return bstr_author;
	}
	public void setBstr_author(String bstr_author) {
		this.bstr_author = bstr_author;
	}
	public String getBstr_price() {
		return bstr_price;
	}
	public void setBstr_price(String bstr_price) {
		this.bstr_price = bstr_price;
	}
	public Date getBdt_entry_date() {
		return bdt_entry_date;
	}
	public void setBdt_entry_date(Date bdt_entry_date) {
		this.bdt_entry_date = bdt_entry_date;
	}
	public Integer getBnum_isactive() {
		return bnum_isactive;
	}
	public void setBnum_isactive(Integer bnum_isactive) {
		this.bnum_isactive = bnum_isactive;
	}   
}
