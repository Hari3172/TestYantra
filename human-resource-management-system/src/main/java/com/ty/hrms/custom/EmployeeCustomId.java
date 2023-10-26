package com.ty.hrms.custom;

import java.io.Serializable;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class EmployeeCustomId implements IdentifierGenerator {

	private final String PRIFIX_VALUE = "TY%03d";
	private static Integer SUFFIX_VALUE = 1;

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) {
		return (Serializable)String.format(PRIFIX_VALUE, SUFFIX_VALUE++);
	}

}
