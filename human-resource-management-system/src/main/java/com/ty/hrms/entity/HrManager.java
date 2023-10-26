
package com.ty.hrms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class HrManager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hrManagerId;
	private String hrManagerName;
}
