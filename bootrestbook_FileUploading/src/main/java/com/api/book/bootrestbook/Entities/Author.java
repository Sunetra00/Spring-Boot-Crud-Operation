package com.api.book.bootrestbook.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Author {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int authorId; //primary key
	    private String fName;
	    private String lName;
	    private String language;
	    
	    @OneToOne(mappedBy = "author")
	    @JsonBackReference
	    private Book book;
	    
		public int getAuthorId() {
			return authorId;
		}
		public void setAuthorId(int authorId) {
			this.authorId = authorId;
		}
		public String getfName() {
			return fName;
		}
		public void setfName(String fName) {
			this.fName = fName;
		}
		public String getlName() {
			return lName;
		}
		public void setlName(String lName) {
			this.lName = lName;
		}
		public String getLanguage() {
			return language;
		}
		public void setLanguage(String language) {
			this.language = language;
		}
	    

}
