package service;

import javax.ws.rs.core.MediaType;

import java.awt.List;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

//For JSON
import com.google.gson.*;
import com.mysql.cj.xdevapi.JsonParser;

import controller.SensorController;
import model.SensorModel;



@Path("/AlamMonitor")
public class Service {
	
	
	SensorController sensorContrl = new SensorController();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public ArrayList<SensorModel> readSensore() {
		
		return sensorContrl.ReadSesor();
		
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN) 
	public String InsertSensore(String SensoreData) {
		JsonObject SensoreOb = new com.google.gson.JsonParser().parse(SensoreData).getAsJsonObject();
		
		int SensoreId = SensoreOb.get("SENSOR_ID").getAsInt();
		String SensoreStatus = SensoreOb.get("SENSOR_STATUS").getAsString();
		String floorumber = SensoreOb.get("FLOOR_NUMBER").getAsString();
		String roomnumber = SensoreOb.get("ROOM_NUMBER").getAsString();
		int smokelevel = SensoreOb.get("SMOKE_LEVEL").getAsInt();
		int co2level = SensoreOb.get("CO2_LEVEL").getAsInt();
		
		SensorModel sensOb = new SensorModel();
		
		sensOb.setSENSOR_ID(SensoreId);
		sensOb.setSENSOR_STATUS(SensoreStatus);
		sensOb.setFLOOR_NUMBER(floorumber);
		sensOb.setROOM_NUMBER(roomnumber);
		sensOb.setSMOKE_LEVEL(smokelevel);
		sensOb.setCO2_LEVEL(co2level);
		
		String output = sensorContrl.InsertSensor(sensOb);
		
		return output;
		
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN) 
	public String UpdateSensore(String SensoreData) {
		JsonObject SensoreOb = new com.google.gson.JsonParser().parse(SensoreData).getAsJsonObject();
		
		int SensoreId = SensoreOb.get("SENSOR_ID").getAsInt();
		String SensoreStatus = SensoreOb.get("SENSOR_STATUS").getAsString();
		String floorumber = SensoreOb.get("FLOOR_NUMBER").getAsString();
		String roomnumber = SensoreOb.get("ROOM_NUMBER").getAsString();
		int smokelevel = SensoreOb.get("SMOKE_LEVEL").getAsInt();
		int co2level = SensoreOb.get("CO2_LEVEL").getAsInt();
		
		SensorModel sensOb = new SensorModel();
		
		sensOb.setSENSOR_ID(SensoreId);
		sensOb.setSENSOR_STATUS(SensoreStatus);
		sensOb.setFLOOR_NUMBER(floorumber);
		sensOb.setROOM_NUMBER(roomnumber);
		sensOb.setSMOKE_LEVEL(smokelevel);
		sensOb.setCO2_LEVEL(co2level);
		
		String output = sensorContrl.UpdateSensore(sensOb);
		
		return output;
		
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN) 
	public String DeleteSensore(String SensoreData) {
		
		JsonObject SensoreOb = new com.google.gson.JsonParser().parse(SensoreData).getAsJsonObject();
		
		int SensoreId = SensoreOb.get("SENSOR_ID").getAsInt();
		
		String Output = sensorContrl.DeleteSesore(SensoreId);
		
		return Output;
	}
	
	
	

}
