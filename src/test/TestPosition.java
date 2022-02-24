
package test;

import java.util.Date;

import entities.Position;
import service.PositionService;
import service.GPSTrackerService;

public class TestPosition {

	public static void main(String[] args) {
		GPSTrackerService ts = new GPSTrackerService();
		PositionService ps = new PositionService();

		ps.create(new Position(11, -6, new Date(), ts.findById(1)));
		ps.create(new Position(12, -7, new Date(), ts.findById(2)));
		ps.create(new Position(13, -8, new Date("1999/09/18"), ts.findById(1)));

		//ps.delete(ps.findById(1));

		  ps.create(new Position(180, 150, new Date(20/12/2012),ts.findById(1) ));
	      ps.create(new Position(105, 670.5, new Date(4/6/2015),ts.findById(2) ));
	      ps.create(new Position(180, 340.5, new Date(7/6/2015),ts.findById(3) ));
	      ps.create(new Position(133.5, 890.5, new Date(20/6/2015),ts.findById(4) ));
	 
	      
		for (Position p : ps.findAll()) {
			System.out.println(p);
		}
	}

}
