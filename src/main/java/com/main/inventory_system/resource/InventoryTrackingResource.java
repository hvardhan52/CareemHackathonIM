package com.main.inventory_system.resource;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.solr.client.solrj.SolrServerException;

import com.main.inventory_system.models.CarLocation;
import com.main.inventory_system.models.Operator;
import com.main.inventory_system.services.KafkaProducerService;
import com.main.inventory_system.services.SolrService;

@Path("/inventory/tracking")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InventoryTrackingResource {
	
	@POST
	@Path("/postCarLocation")
	public void createOpertaor(CarLocation carLocation) {
		
	 new KafkaProducerService().postCabLocationToKafka(carLocation);
	
	}
	
	@GET
	@Path("/test_solr")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSolrCheck(@QueryParam(value = "param")String param) {
		SolrService ss = new SolrService();
		try {
			SolrService.getDataInSolr(param);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return Response.status(Response.Status.OK).entity("{\"success\":\"Solr is alive\"}").build();
	}

}
