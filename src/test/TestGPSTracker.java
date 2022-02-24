package test;

import entities.GPSTracker;
import service.GPSTrackerService;

public class TestGPSTracker {

	public static void main(String[] args) {
		GPSTrackerService gs = new GPSTrackerService();
		gs.create(new GPSTracker("145"));
		gs.create(new GPSTracker("185"));
//		gs.create(new GPSTracker("189"));
//		gs.create(new GPSTracker("123"));
		
	//	gs.delete(gs.findById(2));
		
		GPSTracker tracker = gs.findById(1);
		tracker.setSimNumber("777");
		gs.update(tracker);
		
		for(GPSTracker gpsTracker : gs.findAll()) {
			System.out.println(gpsTracker);
		}

	}

}
