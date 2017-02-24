package br.com.codecode.workix.tests.reflection;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestGetandSet {
    
    private NovaClasse n;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @SuppressWarnings("static-access")
    @Before
    public void setUp() throws Exception {
	
	n = n.builder().cpf(123456789).nome("felipe").idade(28).build();
	
    }

    @Test
    public void test() {
	assertNotNull(n);
	
    }

}
