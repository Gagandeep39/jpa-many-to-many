/**
 * Gagandeep
 * 12:14:49 pm
 * 13-Apr-2020
 */
package com.gagan.manytomany.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Book Entity mapped with database table
 */
@Entity
@Table(name = "book_table")
public class Book {
	
	/**
	 * The isbn.
	 *
	 * @Id Primary Key
	 * @Column name isbn
	 * @GeneratedValue Statetgy used to genrate auto incerement IDs
	 */
	@Id
	@Column(name = "isbn")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int isbn;
	
	/**
	 * The title.
	 *
	 * @Column Title Stores sbook title
	 */
	@Column(name = "title")
	private String title;
	
	/**
	 * The price.
	 *
	 * @Column Price Stores book price
	 */
	@Column(name = "price")
	private double price;
	
	/**
	 * The authors.
	 *
	 * @ManyToMany 
	 * fetch: lazy Initally only Book data will be fetched, but when operation on author is performed then author will be fetched
	 * cascade: Perform All operations in casecade for Book and Author except for delete
	 * @JoinColumn 
	 * name: joiin table name where mapping iss tred 
	 * joinColumn: Mapping from this table (Book) 
	 * inversejoinCOlumn; Mapping from other entity(Author)
	 */
	@ManyToMany(fetch = FetchType.LAZY,cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(
			name = "book_author",
			joinColumns = @JoinColumn(name = "book_id"),
			inverseJoinColumns = @JoinColumn(name = "author_id")
			)
	private List<Author> authors;
	
	/**
	 * Defaul constructor.
	 */
	public Book() {
	}
	
	/**
	 * Parameterized constructor.
	 *
	 * @param title Book name
	 * @param price Book price
	 */
	public Book(String title, double price) {
		super();
		this.title = title;
		this.price = price;
	}
	
	/**
	 * Map an author with the book Adds an author in author list @param authors.
	 *
	 * @param author the author
	 */
	public void addAuthor(Author author) {
		if (authors == null) {
			authors = new ArrayList<>();
		}
		authors.add(author);
	}


	public List<Author> getAuthors() {
		return authors;
	}


	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}


	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price + "]";
	}


}
