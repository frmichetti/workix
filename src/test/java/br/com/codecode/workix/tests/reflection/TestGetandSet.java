package br.com.codecode.workix.tests.reflection;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;


public class TestGetandSet {
    
    private NovaClasse n;

    @BeforeClass
    public static void setUpBeforeClass() {
    }

    @SuppressWarnings("static-access")
    @Before
    public void setUp() {
	
	n = n.builder().cpf(123456789).nome("felipe").idade(28).build();
	
    }

    @Test
    public void test() {
	assertNotNull(n);
	
    }

}
