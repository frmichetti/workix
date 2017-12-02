package br.com.codecode.workix.tests.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

abstract class MagicGetAndSet {

    public void set(String attr, Object valor) throws ClassNotFoundException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
	Class<?> clazz = Class.forName(getClass().getName());
	
	Field field = clazz.getDeclaredField(attr);
	
	field.setAccessible(true);
	
	field.set(this, valor);
    }

    public Object get(String attr) throws ClassNotFoundException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
	
	Class<?> clazz = Class.forName(getClass().getName());
	
	Field field = clazz.getDeclaredField(attr);
	
	field.setAccessible(true); 
	
	return field.get(this);
    }
    
    public Object with(String attr, Object valor) throws ClassNotFoundException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
	
	Class<?> clazz = Class.forName(getClass().getName());
	
	Field field = clazz.getDeclaredField(attr);
	
	field.setAccessible(true);
	
	field.set(this, valor);
	
	return this;
    }
    
    public String[] methods(){
	
	Method[] methods = this.getClass().getMethods();
	
	String[] methodsNames = new String[methods.length]; 
	
	for (int x=0 ; x < methods.length;x++) {
	    methodsNames[x] = methods[x].getName();
	}
	
	return methodsNames;
    }
    
    public String[] fields(Class<?> clazz){
	
	Field[] fields = clazz.getFields();
	
	String[] methodsNames = new String[fields.length]; 
	
	for (int x=0 ; x < fields.length;x++) {
	    methodsNames[x] = fields[x].getName();
	}
	
	return methodsNames;
    }

    

}

