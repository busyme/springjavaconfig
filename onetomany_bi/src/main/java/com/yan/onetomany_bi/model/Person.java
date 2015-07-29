package com.yan.onetomany_bi.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="person_id")
	private Long id;
	private String name;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="person_phone",joinColumns=@JoinColumn(referencedColumnName="person_id"),inverseJoinColumns=@JoinColumn(referencedColumnName="phone_id"))
	private Collection<Phone> phones;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Phone phone) {
		if(phones==null){
			phones = new ArrayList<Phone>();
		}
		
		phones.add(phone);
	}

	@Override
	public int hashCode() {
		return this.getId().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			return this.getId().equals(((Person) obj).getId());
		} else {
			return true;
		}
	}

}
