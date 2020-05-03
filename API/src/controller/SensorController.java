package controller;

import com.mysql.cj.xdevapi.DbDoc;

import dbcon.DBConnection;
import model.SensorModel;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class SensorController {

	Connection con = null;
	ArrayList<SensorModel> SensorList = new ArrayList<SensorModel>();

	public SensorController() {

		con = DBConnection.connection();

	}

	public String InsertSensor(SensorModel sensorOb) {
		String output = "";

		try {
			if (con == null) {
				return "Erro while Connecting to the databse for insering Please check your Database Connection";

			}
			String query = "INSERT INTO sensor (SENSOR_ID,SENSOR_STATUS,FLOOR_NUMBER,ROOM_NUMBER,SMOKE_LEVEL,CO2_LEVEL)VALUES(?,?,?,?,?,?)";

			PreparedStatement statment = con.prepareStatement(query);

			statment.setInt(1, sensorOb.getSENSOR_ID());
			statment.setString(2, sensorOb.getSENSOR_STATUS());
			statment.setString(3, sensorOb.getFLOOR_NUMBER());
			statment.setString(4, sensorOb.getROOM_NUMBER());
			statment.setInt(5, sensorOb.getSMOKE_LEVEL());
			statment.setInt(6, sensorOb.getCO2_LEVEL());

			statment.execute();
			con.close();

			output = "Insert Suceses";

		} catch (Exception e) {

			output = "Erro while Inserting to Databse";
			System.err.println(e.getMessage());

		}
		return output;
	}

	public ArrayList<SensorModel> ReadSesor() {

		try {

			if (con == null) {
				System.err.println(
						"Erro while Connecting to the databse for insering Please check your Database Connection");
			}

			String query = "SELECT SENSOR_ID,SENSOR_STATUS,FLOOR_NUMBER,ROOM_NUMBER,SMOKE_LEVEL,CO2_LEVEL FROM sensor";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				SensorModel sensor = new SensorModel();

				sensor.setSENSOR_ID(rs.getInt("SENSOR_ID"));
				sensor.setSENSOR_STATUS(rs.getString("SENSOR_STATUS"));
				sensor.setFLOOR_NUMBER(rs.getString("FLOOR_NUMBER"));
				sensor.setROOM_NUMBER(rs.getString("ROOM_NUMBER"));
				sensor.setSMOKE_LEVEL(rs.getInt("SMOKE_LEVEL"));
				sensor.setCO2_LEVEL(rs.getInt("CO2_LEVEL"));

				SensorList.add(sensor);

			}

			con.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		System.out.println("View All Sensores Sucess");
		return SensorList;
	}
	
	public String UpdateSensore(SensorModel sensore) {
		
		String Output = "";
		try {
			
			if (con == null) {
				
				return "Erro while Connecting to the databse for insering Please check your Database Connection";
			}
			
			String query = "UPDATE sensor SET  SENSOR_STATUS = ?, FLOOR_NUMBER = ?, ROOM_NUMBER = ?, SMOKE_LEVEL = ?, CO2_LEVEL =? WHERE SENSOR_ID = ?";
			
			PreparedStatement statment = con.prepareStatement(query);
			
			statment.setString(1, sensore.getSENSOR_STATUS());
			statment.setString(2, sensore.getFLOOR_NUMBER());
			statment.setString(3, sensore.getROOM_NUMBER());
			statment.setInt(4, sensore.getSMOKE_LEVEL());
			statment.setInt(5, sensore.getCO2_LEVEL());
			statment.setInt(6, sensore.getSENSOR_ID());
			
			statment.execute();
			con.close();
			Output = "Update Sucesss";
			
		}catch (Exception e) {
			Output = "Error while updating Sensore.";
			System.err.println(e.getMessage());
			
		}
		
		return Output;		
		
	}	
	
	
	
	public String DeleteSesore(int SesoreId) {
		
		String output="";
		
		try {
			
			if (con == null) {
				return "Erro while Connecting to the databse for Deleting Please check your Database Connection";
			}
			
			String query = "DELETE FROM sensor WHERE SENSOR_ID = ? ";
			
			PreparedStatement statement = con.prepareStatement(query);
			
			statement.setInt(1, SesoreId);
			
			statement.execute();
			con.close();
			
			output = "Delete Sucess";
			
		}catch (Exception e) {
			
			output = "Error while deleting the item.";
			System.err.println(e.getMessage());
			
		}		
		
		return output;
		
	}
	
	
}
