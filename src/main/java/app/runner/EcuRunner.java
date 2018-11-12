package app.runner;

import app.core.BinarySensor;
import app.core.DoorSensor;
import app.core.EcuStateModule;
import app.core.IgnitionAdvanceSensor;
import app.core.RpmSensor;
import app.core.SeatBeltSensor;
import app.core.TireSensor;

public class EcuRunner {
	
	public static void main (String[] args) {
		EcuStateModule ecuState = new EcuStateModule();
		IgnitionAdvanceSensor ignitionAdvanceSensor = new IgnitionAdvanceSensor();
		RpmSensor rpmSensor = new RpmSensor();
		TireSensor tireSensor = new TireSensor();
		DoorSensor doorSensor = new DoorSensor();
		BinarySensor seatBeltSensor = new SeatBeltSensor();
		
		ecuState.setIgnition(true);
		ignitionAdvanceSensor.setAngle(40);
		ecuState.setCurrentTirePressure(25.0f);
		rpmSensor.setCurrentRpm(700);
		ecuState.setDoors(4);
		ecuState.setSeatbelts(5);
		
		System.out.println(ecuState.getStateMessage());
		System.out.println("===============");
		System.out.println("Engine RPM: " + rpmSensor.getCurrentRpm());
		System.out.println("Optimal tire pressure level: " + tireSensor.getOptimalPressure());
		
		tireSensor.setCurrentPressure(ecuState.getCurrentTirePressure());
		tireSensor.checkState(4).forEach(t -> System.out.println(t));
		doorSensor.checkDoors(ecuState.getDoors()).forEach(t -> System.out.println(t));
		seatBeltSensor.checkState(ecuState.getSeatbelts()).forEach(t -> System.out.println(t));
	}

}
