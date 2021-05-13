package jpabook.jpashop.controller;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberForm {

	@NotEmpty(message = "이름은 빈 값이 아니어야 합니다")
	private String name;

	private String city;

	private String street;

	private String zipCode;
}
