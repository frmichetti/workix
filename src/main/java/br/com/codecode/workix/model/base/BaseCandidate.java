package br.com.codecode.workix.model.base;

import java.util.Calendar;

/**
 * Markup Interface for Candidate Implementation
 * @author felipe
 *
 */
public interface BaseCandidate extends BasePerson {

	long getCpf();

	void setCpf(long cpf);

	Calendar getBirthDate();

	void setBirthDate(Calendar birthDate);

}
