package com.uni.entity;

import javax.persistence.*;

import lombok.*;


@Entity
@Table(name="student_details")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Student {
	
	@Id
	@Column(name = "id")
private int sId;
	@Column(name ="name")
private String sName;
	@Column(name="city")
private String sCity;
}
