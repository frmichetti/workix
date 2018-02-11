package br.com.codecode.workix.beans;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.jpa.models.Testimonial;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

/**
 * This ManagedBean controls Testimonials Fragment on HomePage and AboutPage
 *
 * @author felipe
 * @version 1.1
 * @see BaseMB
 * @since 1.0
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
        list = new ListDataModel<>(testDao.listAll(0, Integer.MAX_VALUE));
    }


    /**
     * @return the list
     */
    public DataModel<Testimonial> getList() {
        return list;
    }


}
