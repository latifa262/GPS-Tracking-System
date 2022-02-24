package entities;

import java.util.Date;

public class VehiculeGPSTracker {
	private int id;
	private Date dateDebut;
	private Date dateFin;
	private GPSTracker gpsTracker;
	private Vehicule vehicule;
	//private static int comp;

	public VehiculeGPSTracker(Date dateDebut, Date dateFin, GPSTracker gpsTracker, Vehicule vehicule) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.gpsTracker = gpsTracker;
		this.vehicule = vehicule;
	}
        public VehiculeGPSTracker(Date dateDebut,GPSTracker gpsTracker, Vehicule vehicule) {
		this.dateDebut = dateDebut;
		this.gpsTracker = gpsTracker;
		this.vehicule = vehicule;
	}
	public VehiculeGPSTracker(int id ,Date dateDebut, Date dateFin, GPSTracker gpsTracker, Vehicule vehicule) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.gpsTracker = gpsTracker;
		this.vehicule = vehicule;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public GPSTracker getGpsTracker() {
		return gpsTracker;
	}

	public void setGp(GPSTracker gpsTracker) {
		this.gpsTracker = gpsTracker;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	@Override
	public String toString() {
		return "VehiculeGPSTracker [dateDebut=" + dateDebut + ", dateFin=" + dateFin  + ", v=" + vehicule + ", gpsTracker=" + gpsTracker+ "]";
	}

}
