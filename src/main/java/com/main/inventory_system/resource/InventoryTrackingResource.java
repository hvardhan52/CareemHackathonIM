package com.main.inventory_system.resource;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.solr.client.solrj.SolrServerException;

import com.main.inventory_system.models.CarLocation;
import com.main.inventory_system.models.CarLocationWithIndex;
import com.main.inventory_system.models.Location;
import com.main.inventory_system.models.Operator;
import com.main.inventory_system.services.KafkaProducerService;
import com.main.inventory_system.services.SolrService;

/**
 * APIs related to Tracking 
 * @author harshvardhan
 *
 */
		
@Path("/inventory/tracking")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InventoryTrackingResource {
	
	@POST
	@Path("/updateCabLocation")
	public void updateCabLocation(CarLocationWithIndex carLocation) {
		try {
			SolrService.setDataInSolr(carLocation);
		} catch (SolrServerException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	@GET
	@Path("/deleteCabLocation")
	public void deleteCabLocation(@QueryParam(value = "carId") String carId) {
		try {
			SolrService.deleteDataInSolr(carId);
		} catch (SolrServerException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	@POST
	@Path("/postCarLocation")
	public void postCarLocation(CarLocation carLocation) {
		
	 new KafkaProducerService().postCabLocationToKafka(carLocation);
	
	}
	
	@POST
	@Path("/findCabs")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSolrCheck(CarLocation carLocation) {
		String cabListString = "No Rides found";
		SolrService ss = new SolrService();
		try {
			 cabListString = SolrService.getDataInSolr(carLocation);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return Response.status(Response.Status.OK).entity(cabListString).build();
	}
	
	@GET
	@Path("/get-rides")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSolrCheck(@QueryParam("lat") Double lat,@QueryParam("long") Double lon, @QueryParam("status") Boolean status) {
		String cabListString = "No Rides found";
		CarLocation carLocation = new CarLocation();
		Location loc = new Location();
		loc.setLatitude(lat);
		loc.setLongitude(lon);
		carLocation.setLocation(loc);
		carLocation.setStatus(status);
		try {
			 cabListString = SolrService.getDataInSolr(carLocation);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return Response.status(Response.Status.OK).entity(cabListString).build();
	}

}
