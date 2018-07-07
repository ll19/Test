package com.example.demo.domain.entity;

import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




public class users {
	

	private Long id;

	private String message;

	private Date postedTime;
	

	private Long usersId;
	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this,that,"id","time");
	}
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id","time");
	}

}
