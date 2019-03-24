package br.com.codecode.workix.jsf.util.helper;

import br.com.codecode.workix.core.enums.JobType;

import javax.enterprise.context.RequestScoped;

/**
 * Job Type Link Helper
 *
 * @author felipe
 * @version 1.0
 * @since 1.0
 */
@RequestScoped
public class JobTypeLinkHelper {

    public String returnType(JobType jobType) {

        String resp = "";

        switch (jobType) {

            case FREELANCE:
                resp = "badge freelance";
                break;

            default:
            case FULLTIME:
                resp = "badge full-time";
                break;

            case INTERNSHIP:
                resp = "badge internship";
                break;

            case PARTTIME:
                resp = "badge part-time";
                break;

            case TEMPORARY:
                resp = "badge temporary";
                break;


        }


        return resp;
    }

}
