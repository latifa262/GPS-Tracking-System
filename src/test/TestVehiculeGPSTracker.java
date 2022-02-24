package test;

import java.util.Date;

import entities.VehiculeGPSTracker;
import service.GPSTrackerService;
import service.VehiculeGPSTrackerService;
import service.VehiculeService;

public class TestVehiculeGPSTracker {
	public static void main(String[] args) {
		VehiculeGPSTrackerService vgs =new VehiculeGPSTrackerService();
		VehiculeService vs =new VehiculeService();
        GPSTrackerService ts = new GPSTrackerService();
		
        vgs.create(
				new VehiculeGPSTracker(new Date("2020/01/01"), new Date("2020/04/30"), ts.findById(1), vs.findById(1)));
		vgs.create(
				new VehiculeGPSTracker(new Date("2020/01/01"), new Date("2020/04/30"), ts.findById(2), vs.findById(2)));
		vgs.create(
				new VehiculeGPSTracker(new Date("2020/01/01"), new Date("2020/04/30"), ts.findById(3), vs.findById(3)));
		vgs.create(
				new VehiculeGPSTracker(new Date("2020/04/04"), new Date("2020/07/3"), ts.findById(4), vs.findById(4)));
		// Qst d
		vgs.create(
				new VehiculeGPSTracker(new Date("2020/05/05"), new Date("2020/10/01"), ts.findById(1), vs.findById(5)));
		vgs.create(
				new VehiculeGPSTracker(new Date("2020/06/06"), new Date("2020/11/01"), ts.findById(2), vs.findById(6)));
		
		vgs.delete(vgs.findById(4));

		for(VehiculeGPSTracker vgp : vgs.findAll()) {
			System.out.println(vgp);
		}
	}
}
