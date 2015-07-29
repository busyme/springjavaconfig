package com.yan.onetomany_bi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "phone_id")
	private Long id;
	private String number;

	/*@ManyToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "person_phone", joinColumns = @JoinColumn(referencedColumnName = "phone_id"), inverseJoinColumns = @JoinColumn(referencedColumnName = "person_id"))
	private Person person;*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	/*public Person getPerson() {
		return person;
	}

	public void setPerson(Person persons) {
		this.person = persons;
	}*/

	@Override
	public int hashCode() {
		return this.getId().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Phone) {
			return this.getId().equals(((Phone) obj).getId());
		} else {
			return false;
		}

	}

}
