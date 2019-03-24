package br.com.codecode.workix.jsf.util.helper;

import javax.enterprise.context.RequestScoped;

/**
 * Social Link Helper
 *
 * @author felipe
 * @version 1.0
 * @since 1.0
 */
@RequestScoped
public class SocialLinkHelper {

    public String returnMedia(String url) {

        String resp = "";

        if (url.trim().toLowerCase().contains("github")) {
            resp = "fa fa-github-square fa-2x";

        } else if (url.trim().toLowerCase().contains("twitter")) {
            resp = "fa fa-twitter-square fa-2x";

        } else if (url.trim().toLowerCase().contains("facebook")) {
            resp = "fa fa-facebook-square fa-2x";

        } else if (url.trim().toLowerCase().contains("linkedin")) {
            resp = "fa fa-linkedin-square fa-2x";

        } else if (url.trim().toLowerCase().contains("google")) {
            resp = "fa fa-google-plus-square fa-2x";

        } else {
            resp = "fa fa-link fa-2x";

        }

        return resp;
    }

}
