package com.example.demo.domain.entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class message {
	

	private Long stu;
	

	@Size(min=1,max=30,message="{firstName.size}")
	private String firstName;
	

	@Size(min=5,max=16,message="{userName.size}")
	private String userName;
	
	
	@Size(min=4,max=25,message="{password.size}")
	private String password;
	

	@Size(min=1,max=30,message="{lastName.size}")
	private String lastName;
	

	@NotEmpty(message="TEL must not be empty")
	@Email(message="{TEL.valid}")
	private String email;
	

	@Override
	public boolean equals(Object that) {
		// TODO Auto-generated method stub
		return EqualsBuilder.reflectionEquals(this, that, "firstName","lastName","userName","password","email");
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return HashCodeBuilder.reflectionHashCode(this, "firstName","lastName","userName","password","emial");
	}
}
