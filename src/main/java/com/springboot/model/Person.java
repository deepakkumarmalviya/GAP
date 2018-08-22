package com.springboot.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {

	String id;
	String Name;
	public Person() {
		super();
	}
	
	public Person(String id, String name) {
		this.id = id;
		this.Name = name;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
}
