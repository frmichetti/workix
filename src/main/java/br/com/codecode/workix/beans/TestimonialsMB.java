package br.com.codecode.workix.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.jpa.models.Testimonial;

/**
 * This ManagedBean controls Testimonials Fragment on HomePage and AboutPage
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see BaseMB
 */
@Model
public class TestimonialsMB extends BaseMB {
    
    @Inject
    @Generic
    private Crud<Testimonial> testDao;
    
    private DataModel<Testimonial> list;

    @PostConstruct
    @Override
    protected void init() {
	try {
	    
	    list = new ListDataModel<Testimonial>(testDao.listAll(0, Integer.MAX_VALUE));
	    
	} catch (NotImplementedYetException e) {	    
	    e.printStackTrace();
	}	

    }

    
    /**
     * @return the list
     */
    public DataModel<Testimonial> getList() {
        return list;
    }
    
    

}
