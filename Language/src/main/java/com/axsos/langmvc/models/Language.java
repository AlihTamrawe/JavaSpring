package com.axsos.langmvc.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Language")
public class Language {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 	
	
	@NotNull
    @Size(min = 2, max = 200, message="expense must be at least 2 characters.")
    private String name;
	
	@NotNull
    @Size(min = 3, max = 200, message="expense must be at least 3 characters.")
    private String creator;
	
	@NotNull
 	@Min(value=0, message="Must be value.")
    private String version;
	
	 @Column(updatable=false)
     @DateTimeFormat(pattern="yyyy-MM-dd")
     private Date createdAt;
     @DateTimeFormat(pattern="yyyy-MM-dd")
     private Date updatedAt;
     public Language( String name, String creator,String version) {
		this.name = name;
		this.creator = creator;
		this.version = version;
	}

		public Language(){
	    	 
	     }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Long getId() {
		return id;
	}
	 @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }


}
