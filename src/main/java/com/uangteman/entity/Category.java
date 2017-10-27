package com.uangteman.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tcategory")  //(optional) mengubah nama tabel agar tidak 'Category'
public class Category implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //(optional) membuat column menjadi Auto Increment
	private long Id;
	
	@Column(length=100, unique=true, nullable=false)  //(optional) melakukan setting structure dari Column
	private String name;
	
	public Category() {}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
	
