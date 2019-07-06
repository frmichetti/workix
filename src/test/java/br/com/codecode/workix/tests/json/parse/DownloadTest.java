package br.com.codecode.workix.tests.json.parse;

import br.com.codecode.workix.gson.util.GsonProvider;
import br.com.codecode.workix.tests.util.HttpTest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.util.List;

/**
 * Markup Interface for Download Test Unit
 * 
 * @author felipe
 * @version 1.1
 * @since 1.1
 * @see Serializable
 * @see GsonProvider
 */
interface DownloadTest<T extends Serializable> {

    /**
     * Download Items to a String
     * @param url Download Url
     */
    default String downloadItens(String url) {	

	return HttpTest.sendGet(url);
    }

    /**
     * Parse Items to Entity with Default Gson
     * @param rawJson Raw Json String
     * @param type Expected Type
     * @return List of Parsed Object
     */
    default List<T> parseItens(String rawJson,TypeToken<?> type) {	
	
	return GsonProvider.buildGson()
		.fromJson(rawJson, type.getType());	
	
    }
    
    /**
     * Parse Items to Entity with Another Gson Implementation
     * @param rawJson Raw Json String
     * @param type Expected Type
     * @return List of Parsed Object
     */
    default List<T> parseItens(Gson gson,String rawJson,TypeToken<?> type){
	return gson.fromJson(rawJson, type.getType());	
    }

}
