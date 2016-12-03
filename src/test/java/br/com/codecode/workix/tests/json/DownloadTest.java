package br.com.codecode.workix.tests.json;

import java.io.Serializable;
import java.util.List;

import com.google.gson.reflect.TypeToken;

import br.com.codecode.workix.tests.util.HttpTest;
import br.com.codecode.workix.tests.util.gson.GsonProvider;

/**
 * Markup Interface for Download Test Unit
 * 
 * @author felipe
 * @version 1.1
 * @since 1.1
 * @see Serializable
 * @see GsonProvider
 */
public interface DownloadTest<T extends Serializable> {    

    /**
     * Download Items to a String
     * @param url Download Url
     */
    default String downloadItens(String url) {	

	return HttpTest.sendGet(url);
    }

    /**
     * Parse Items to Entity
     * @param rawJson Raw Json String
     * @param type Expected Type
     * @return List of Parsed Object
     */
    default List<T> parseItens(String rawJson,TypeToken<?> type) {	
	
	return GsonProvider.getInstance().buildGson()
		.fromJson(rawJson, type.getType());	
	
    }

}
