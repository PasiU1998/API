package model;

public class SensorModel {
	
	private int SENSOR_ID;
	
	private String SENSOR_STATUS;
	
	private String FLOOR_NUMBER;
	
	private String ROOM_NUMBER;
	
	private int SMOKE_LEVEL;
	
	private int CO2_LEVEL;

	public SensorModel(int sENSOR_ID, String sENSOR_STATUS, String fLOOR_NUMBER, String rOOM_NUMBER, int sMOKE_LEVEL,
			int cO2_LEVEL) {
		super();
		SENSOR_ID = sENSOR_ID;
		SENSOR_STATUS = sENSOR_STATUS;
		FLOOR_NUMBER = fLOOR_NUMBER;
		ROOM_NUMBER = rOOM_NUMBER;
		SMOKE_LEVEL = sMOKE_LEVEL;
		CO2_LEVEL = cO2_LEVEL;
	}

	public SensorModel() {
		
	}

	public int getSENSOR_ID() {
		return SENSOR_ID;
	}

	public void setSENSOR_ID(int sENSOR_ID) {
		SENSOR_ID = sENSOR_ID;
	}

	public String getSENSOR_STATUS() {
		return SENSOR_STATUS;
	}

	public void setSENSOR_STATUS(String sENSOR_STATUS) {
		SENSOR_STATUS = sENSOR_STATUS;
	}

	public String getFLOOR_NUMBER() {
		return FLOOR_NUMBER;
	}

	public void setFLOOR_NUMBER(String fLOOR_NUMBER) {
		FLOOR_NUMBER = fLOOR_NUMBER;
	}

	public String getROOM_NUMBER() {
		return ROOM_NUMBER;
	}

	public void setROOM_NUMBER(String rOOM_NUMBER) {
		ROOM_NUMBER = rOOM_NUMBER;
	}

	public int getSMOKE_LEVEL() {
		return SMOKE_LEVEL;
	}

	public void setSMOKE_LEVEL(int sMOKE_LEVEL) {
		SMOKE_LEVEL = sMOKE_LEVEL;
	}

	public int getCO2_LEVEL() {
		return CO2_LEVEL;
	}

	public void setCO2_LEVEL(int cO2_LEVEL) {
		CO2_LEVEL = cO2_LEVEL;
	}
	
	
	

}
