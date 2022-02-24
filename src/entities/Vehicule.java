package entities;

import java.util.ArrayList;
import java.util.List;

public class Vehicule {
	private int id;
	private String matricule;
	private String marque;
	private String type;
	private List<VehiculeGPSTracker> vGPSTrackers;

	//private static int comp;

	public Vehicule(String matricule, String marque, String type) {
		super();
		this.matricule = matricule;
		this.marque = marque;
		this.type = type;
		// this.vGPSTrackers = new ArrayList<VehiculeGPSTracker>();
	}

	public Vehicule(int id, String matricule, String marque, String type) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.marque = marque;
		this.type = type;
		this.vGPSTrackers = vGPSTrackers;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
        
        

	@Override
	public String toString() {
		return "matricule=" + matricule + ", marque=" + marque + ", type=" + type +  "";
	}

	
	public List<VehiculeGPSTracker> getvGPSTrackers() { return vGPSTrackers; }
	 
	public void setvGPSTrackers(List<VehiculeGPSTracker> vGPSTrackers) {
	  this.vGPSTrackers = vGPSTrackers; }
	 

}
