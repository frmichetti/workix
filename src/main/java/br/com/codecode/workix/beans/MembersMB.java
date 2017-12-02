package br.com.codecode.workix.beans;

import br.com.codecode.workix.cdi.dao.Crud;
import br.com.codecode.workix.cdi.qualifiers.Generic;
import br.com.codecode.workix.core.exceptions.NotImplementedYetException;
import br.com.codecode.workix.jpa.models.Member;
import br.com.codecode.workix.jsf.util.helper.SocialLinkHelper;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

/**
 * This ManagedBean controls Members Fragment on AboutPage
 * 
 * @author felipe
 * @since 1.0
 * @version 1.1
 * @see BaseMB
 */
@Model
public class MembersMB extends BaseMB {

    @Inject
    @Generic
    private Crud<Member> memberDao;

    @Inject
    private SocialLinkHelper linkHelper;

    private DataModel<Member> list;

    @PostConstruct
    @Override
    protected void init() {

        list = new ListDataModel<>(memberDao.listAll(0, Integer.MAX_VALUE));

    }


    /**
     * @return the list
     */
    public DataModel<Member> getList() {
	return list;
    }

    /**
     * @return discover Social Media Link
     * @param url Enter the Url for Discover Social Media
     */
    public String whatSocialLink(String url){
	return linkHelper.returnMedia(url);
    }



}
