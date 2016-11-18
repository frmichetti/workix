package br.com.codecode.workix.test.bean;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@ManagedBean
@Named
@SessionScoped
public class GeradorNumeros implements Serializable {

	private static final long serialVersionUID = -7715175787426844091L;

	private double number = Math.random();

	private double range = 1.0;

	public double getRange() {
		return (range);
	}
	public void setRange(double range) {
		this.range = range;
	}

	public double getNumber() {
		return (number);
	}
	public void randomize() {
		number = range * Math.random();
	}
}
