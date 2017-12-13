package com.gs.tramas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * https://spring.io/guides/gs/accessing-data-jpa/
 *
 */
@Entity
public class Trama210 {

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getField2() {
		return field2;
	}
	public void setField2(String field2) {
		this.field2 = field2;
	}
	public String getField7() {
		return field7;
	}
	public void setField7(String field7) {
		this.field7 = field7;
	}
	public Trama210(String field2) {
		this.field2 = field2;
	}

	public Trama210() {
		// TODO Auto-generated constructor stub
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String field2;
	private String field7;
}
