package br.com.codecode.workix.tests.builder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.codecode.workix.interfaces.Buildable;
import br.com.codecode.workix.jpa.models.User;

public class BuilderScan {

    private Buildable<?> builder;

    private Class<?> clazz;

    public void setUp() {

	builder = new User.Builder("teste");

	clazz = builder.getClass();
    }

    @Test
    public void test() {

	setUp();

	List<Class<?>> classes = new ArrayList<>();

	while (!clazz.getSuperclass().getSimpleName().equalsIgnoreCase("object")) {

	    System.out.println("[Class]");

	    System.out.println(clazz.getSuperclass());

	    classes.add(clazz.getSuperclass());

	    System.out.println("---Fields---");

	    Field[] fields = clazz.getDeclaredFields();

	    for (int x = 0; x < fields.length; x++) {

		System.out.println(fields[x].getName());

	    }

	    System.out.println("---Annotations---");

	    Annotation[] annotations = clazz.getAnnotations();

	    for (int x = 0; x < annotations.length; x++) {

		System.out.println(annotations[x].toString());

	    }

	    clazz = clazz.getSuperclass();
	}
	
	System.out.println("End");
	
	for (Class<?> c : classes) {
	    System.out.println(c.getCanonicalName()
		    .substring(c.getCanonicalName().lastIndexOf(".") + 1));
	}

	Assert.assertNotEquals(0, classes.size());

    }

}
