/**
 * Gagandeep
 * 12:12:52 pm
 * 13-Apr-2020
 */
package com.gagan.manytomany.client;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.gagan.manytomany.entity.Author;
import com.gagan.manytomany.entity.Book;

public class Main {
	
	/**
	 * 
	 * Problem Statement 
	 * 2.1 Consider the entity relationship diagram as shown below. 
	 * Identify the correct association between the book and author and implement the same using JPA. 
	 * Create necessary entity classes and tables as required. 
	 * 
	 * Steps
	 * 1. Create Manager Factor
	 * 2. Create Manager
	 * 3. Begin Transaction
	 * .
	 * . Perform Operations
	 * .
	 * 4. Commit Transaction
	 * 5. Close Manager
	 * 
	 * 
	 * Update 2
	 * Extend the 2.1 case study to implement below listed queries.
	 * Write separate operations/method to implement each query. 
	 * 
	 * a.Query all books in database. 
	 * b.Query all books written by given author name
	 * c.List all books with given price range. e.g. between Rs. 500 to 1000
	 * d.List the author name for given book id. 
	 * 
	 */
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		/**
		 * Basic insertion is performed here for testing as only table creation was specified 
		 */
//		Book book = new Book("Warrior Within", 999);
//		Author author = new Author("Gagan");
//		Author author2 = new Author("Monster");
//		book.addAuthor(author);
//		book.addAuthor(author2);
//		manager.persist(book);
//		book = new Book("testing", 11212);
//		manager.persist(book);
		
		
		/*
		 * **********LAb 2.2**********
		 */
		
		/**
		 * Query All books in database
		 */
		List<Book> books = manager.createQuery("Select b from Book b").getResultList();
		System.out.println("------1. Showing All books in database------");
		for (Book book : books) {
			System.out.println(book);
		}
		/**
		 * Query all books written by a given author
		 */
		Author author = manager.find(Author.class, 8);
		System.out.println("------2. Showing books by the Author with ID 8------");
		System.out.println(author.getBooks());
		
		/**
		 * List all books with given price range. e.g. between Rs. 500 to 1000
		 */
		List<Book> books2 = manager.createQuery("Select b from Book b WHERE b.price between 500 and 1000").getResultList();
		System.out.println("------3. Books in Price Range 500 and 100------");
		System.out.println(books2);
		
		/**
		 * List the author name for given book id. 
		 */
		Book book = manager.find(Book.class, 7);
		System.out.println("------4. Authors for book with ID 7------");
		book.getAuthors().forEach(auth->System.out.println("Author name: " + auth.getName()));
		

		manager.getTransaction().commit();
		factory.close();
	}

}
