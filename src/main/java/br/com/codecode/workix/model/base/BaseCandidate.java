package br.com.codecode.workix.model.base;

import java.util.Calendar;

/**
 * Markup Interface for Candidate Implementation
 * @author felipe
 *
 */
public interface BaseCandidate extends BasePerson {

	String getCpf();

	void setCpf(String cpf);

	Calendar getBirthDate();

	void setBirthDate(Calendar birthDate);

}
