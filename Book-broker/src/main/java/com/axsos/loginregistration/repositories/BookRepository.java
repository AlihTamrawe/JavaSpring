package com.axsos.loginregistration.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.loginregistration.models.Book;


@Repository
public interface BookRepository  extends CrudRepository<Book,Long>{

	
	List<Book> findAll();
	
    List<Book> findBytitleContaining(String search);
    
    Optional<Book> findById(Long id);
    
    Long countBytitleContaining(String search);
    
    @Query("select b from Book b where b.borrower IS NULL")
    List<Book> findbooksnotborrow();

	
}
