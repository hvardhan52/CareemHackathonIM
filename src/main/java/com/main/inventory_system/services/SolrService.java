package com.main.inventory_system.services;

import java.io.IOException;
import java.util.Date;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import com.main.inventory_system.context.SolrCarLocationContext;
import com.main.inventory_system.models.CarLocation;
import com.main.inventory_system.utilities.Constants;


/**
 * 
 * @author harshvardhan
 * 
 */
public class SolrService {
	
	static HttpSolrClient server = SolrCarLocationContext.getInstance().getSolrServer();
	
	/**
	 * Test Method
	 * @param key
	 * @param value
	 * @throws SolrServerException
	 * @throws IOException
	 */
	public static  void setDataInSolr(CarLocation carLocation) throws SolrServerException, IOException{
		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("carId",carLocation.getCarId());
		//doc.addField("aloc", "82.919702,77.642569");
		doc.addField("aloc", carLocation.getLocation().getlatitude().toString()+","+carLocation.getLocation().getlongitude().toString());
		doc.addField("timestamp",new Date());
		System.out.println("Value is "+carLocation.getLocation().getlatitude().toString()+","+carLocation.getLocation().getlongitude().toString());
		server.add(doc);
		server.commit();
	}
	
	/**
	 * Test Method
	 * @param carLocation
	 * @param value
	 * @throws SolrServerException
	 * @throws IOException
	 */
	public static void getDataInSolr(String carId) throws SolrServerException, IOException{
		SolrQuery query = new SolrQuery();
		//query.setQuery("*");
		//query.setFields("carId",carId);
		query.setQuery("*");
		query.addFilterQuery("{!geofilt sfield=aloc}");
		
		query.add(Constants.CENTRE, "82.919702,77.642569");
		query.add(Constants.DISTANCE, "2");
		query.addFilterQuery("timestamp:[2012-09-24T00:00:00Z TO 2019-09-24T00:00:00Z]");
		//query.addFilterQuery("{!geofilt sfield=aloc}");
		System.out.println("Ammmiiiigo  query is "+query.toQueryString());
		QueryResponse response = server.query(query);
	    SolrDocumentList results = response.getResults();
	    for (int i = 0; i < results.size(); ++i) {
	    	System.out.println("hala!");
	      System.out.println(results.get(i));
	    }
	}
//	
//	/**
//	 * Auto Complete Suggestions
//	 * @param searchedString
//	 * @return
//	 * @throws IOException 
//	 * @throws SolrServerException 
//	 */
//	public SolrDocumentList getAutoCompleteSuggestion(String searchedString) throws SolrServerException, IOException{
//		SolrQuery query = new SolrQuery();
//		query.setQuery(searchedString);
//		query.setFields(SolrConstants.PRODUCT_ID, SolrConstants.PRODUCT_NAME, SolrConstants.CATGEORY_ID);
//		QueryResponse response = server.query(query);
//	    SolrDocumentList results = response.getResults();
//		return results;
//	}
//
//	public SolrDocumentList findShopNearBy(FindShopNearByRequest findShopNearByRequest) throws SolrServerException, IOException {
//		SolrQuery query = new SolrQuery();
//		
//		//String lat = findShopNearByRequest.getLocConsumer().getlatitude().toString();
//		//String lon = findShopNearByRequest.getLocConsumer().getlongitude().toString();
//		query.setQuery("*");
//		query.addFilterQuery("{!geofilt sfield=aloc}");
//		query.add(SolrConstants.CENTRE, "12.919702,77.642569");
//		query.add(SolrConstants.DISTANCE, ConfigContext.getInstance().getConfig().getSolrDistance());
//		QueryResponse response = shopServer.query(query);
//	    SolrDocumentList results = response.getResults();
//	    for (int i = 0; i < results.size(); ++i) {
//		      System.out.println(results.get(i));
//		    }
//		return results;
//	}
}
