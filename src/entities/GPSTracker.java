package entities;

import java.util.ArrayList;
import java.util.List;

public class GPSTracker {
	private int id;
	private String simNumber;
	private List<VehiculeGPSTracker> vGPSTrackers;
	
	public GPSTracker(String simNumber) {
		super();
		this.simNumber = simNumber;
		this.vGPSTrackers = new ArrayList<VehiculeGPSTracker>();

	}

	public GPSTracker(int id, String simNumber) {
		super();
		this.id = id;
		this.simNumber = simNumber;
		this.vGPSTrackers = new ArrayList<VehiculeGPSTracker>();

	}
	public GPSTracker(int id, String simNumber, List<VehiculeGPSTracker> vGPSTrackers) {
		super();
		this.id = id;
		this.simNumber = simNumber;
		this.vGPSTrackers =vGPSTrackers ;

	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSimNumber() {
		return simNumber;
	}

	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}

	@Override
	public String toString() {
		return "simNumber=" +simNumber +"";
	}

	public List<VehiculeGPSTracker> getvGPSTrackers() {
		return vGPSTrackers;
	}

	public void setvGPSTrackers(List<VehiculeGPSTracker> vGPSTrackers) {
		this.vGPSTrackers = vGPSTrackers;
	}
	
	
	

}
