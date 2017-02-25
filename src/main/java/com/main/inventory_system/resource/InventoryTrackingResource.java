package com.main.inventory_system.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.main.inventory_system.models.CarLocation;
import com.main.inventory_system.models.Operator;
import com.main.inventory_system.services.KafkaProducerService;

@Path("/inventory/tracking")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InventoryTrackingResource {
	
	@POST
	@Path("/postCarLocation")
	public void createOpertaor(CarLocation carLocation) {
		
	 new KafkaProducerService().postCabLocationToKafka(carLocation);
	
	}

}
