package test;

import entities.Position;
import entities.Vehicule;
import service.GPSTrackerService;
import service.VehiculeService;
import entities.Vehicule;

public class TestVehicule {
	public static void main(String[] args) {
		GPSTrackerService ts = new GPSTrackerService();
		VehiculeService vs = new VehiculeService();

		vs.create(new Vehicule("1004-A-29", "Ford", "Camion1"));
		vs.create(new Vehicule("1005-B-30", "RR", "Car1"));
		vs.create(new Vehicule("1006-C-31", "M", "Car2"));
		vs.create(new Vehicule("1007-D-32","Ford3","Camion2"));
		vs.create(new Vehicule("1008-E-33","Ford4","Camion3"));
		
		// vs.delete(vs.findById(3));
		
		for (Vehicule v : vs.findAll()) {
			System.out.println(v);
		}
	}
}
