package br.com.codecode.workix.tests.date;

import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ParseCalendar {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() throws Exception {
	
	String dateToParse = "2017-02-03";
	
	Date d = new SimpleDateFormat("yyyy-MM-dd").parse(dateToParse);	
	
	Calendar c = Calendar.getInstance();
	
	c.setTime(d);
	
	assertNotNull(d);
	
	System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(c.getTime()));
    }

}
