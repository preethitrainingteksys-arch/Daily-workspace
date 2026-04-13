package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
@Entity
public class Note {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
//	@NotNull(message="id is mandatory")
	private long id;
	@NotBlank (message="title should not be blank")
	String title;
	@NotBlank(message="content should not be blank")
	String content;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
//	public String 

}
enum STATUS{
	CLOSED,CREATED;
}


