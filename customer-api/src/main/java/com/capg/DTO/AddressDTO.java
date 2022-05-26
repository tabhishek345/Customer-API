package com.capg.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.capg.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
	
	private Integer pin;
	@NotBlank(message="City Can't Be Blank or Null!!")
	@Size(min = 3,max = 100)
	private String city;
	@NotBlank(message="State Can't Be Blank or Null!!")
	@Size(min = 3,max = 100)
	private String state;
	
	public AddressDTO(Address address) {
		this.pin = address.getPin();
		this.city = address.getCity();
		this.state = address.getState();
	}

}
