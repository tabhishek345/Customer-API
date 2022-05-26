package com.capg.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

import com.capg.DTO.AddressDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
	@Column(name = "pin")
	private Integer pin;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	
	public Address(AddressDTO addressdto) {
		this.pin = addressdto.getPin();
		this.city = addressdto.getCity();
		this.state = addressdto.getState();
	}
	

}
