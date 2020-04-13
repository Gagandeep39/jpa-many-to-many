/**
 * Gagandeep
 * 12:12:52 pm
 * 13-Apr-2020
 */
package com.gagan.manytomany.client;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.gagan.manytomany.entity.Author;
import com.gagan.manytomany.entity.Book;

public class Main {
	
	/**
	 * 1. Create Manager Factor
	 * 2. Create Manager
	 * 3. Begin Transaction
	 * .
	 * . Perform Operations
	 * .
	 * 4. Commit Transaction
	 * 5. Close Manager
	 */
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		Book book = new Book("Warrior Within", 999);
		Author author = new Author("Gagan");
		Author author2 = new Author("Monster");
		book.addAuthor(author);
		book.addAuthor(author2);
		manager.persist(book);
		book = new Book("testing", 11212);
		manager.persist(book);
		
		manager.getTransaction().commit();
		factory.close();
	}

}
