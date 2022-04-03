package com.bookstore.book.repository;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bookstore.book.model.Book;

/**
 * This interface dedicatedly handles, book collection operation
 * 
 * @author Muthukumar Chellappa
 *
 */

@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {

	@Query(value = "select t.price from Book t where t.id = :id")
	public BigDecimal retrieveBookPriceById(Long id);
	
	@Query(value = "select t from Book t where t.id = :id")
	public Book retrieveBookById(Long id);
	
	@Modifying
	@Query(value = "update Book t set t.price = :price where t.id = :id")
	public void updateBookPrice(BigDecimal price, Long id);
	
	@Modifying
	@Query(value = "delete from Book t where t.id = :id")
	public void deleteBookById(Long id);

}