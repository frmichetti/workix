package br.com.codecode.workix.model.pojo;

import java.util.Calendar;

import br.com.codecode.workix.model.base.BaseCandidate;

/**
 * Draft Candidate Class
 * @author felipe
 * 
 *
 */
class Candidate extends Person implements BaseCandidate{

	@Override
	public long getCpf() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setCpf(long cpf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Calendar getBirthDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBirthDate(Calendar birthDate) {
		// TODO Auto-generated method stub
		
	}

}
