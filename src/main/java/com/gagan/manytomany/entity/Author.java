/**
 * Gagandeep
 * 12:24:01 pm
 * 13-Apr-2020
 */
package com.gagan.manytomany.entity;

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
 * The Class Author.
 */
@Entity
@Table(name = "author_table")
public class Author {
	
	/**
	 * The isbn.
	 *
	 * @Id Primary Key
	 * @Column name id
	 * @GeneratedValue Statetgy used to genrate auto incerement IDs
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/**
	 * The title.
	 *
	 * @Column Author Stores sbook authhor
	 */
	@Column(name = "name")
	private String name;
	
	
	/**
	 * The books.
	 *
	 * @see Book
	 * @ManyToMany 
	 * fetch: lazy Initially only Book data will be fetched, but when
	 *             operation on author is performed then author will be fetched
	 * cascade: Perform All operations in casecade for Author and Book
	 *             except for delete
	 * @JoinColumn 
	 * name: join table name where mapping iss tred joinColumn: Mapping from this table (Author) 
	 * inversejoinCOlumn: Mapping from other entity(Book) basically opposite of Book mapping
	 */
	@ManyToMany(fetch = FetchType.LAZY,cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(
			name = "book_author",
			joinColumns = @JoinColumn(name = "author_id"),
			inverseJoinColumns = @JoinColumn(name = "book_id")
			)
	private List<Book> books;
	
	/**
	 * Instantiates a new author.
	 */
	public Author() {
	}
	
	/**
	 * Map an author with the book Adds an book in books list @param books.
	 * @return the books
	 */
	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}



	public Author(String name) {
		super();
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}


}
