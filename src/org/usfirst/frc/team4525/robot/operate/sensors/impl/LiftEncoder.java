package org.usfirst.frc.team4525.robot.operate.sensors.impl;

import org.usfirst.frc.team4525.robot.operate.sensors.Sensor;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;

public class LiftEncoder implements Sensor{

	private Encoder encoder;

	public void init() {
		encoder = new Encoder(2, 3, false, EncodingType.k4X);
		encoder.setDistancePerPulse(0.0008681);

	}

	public double get() {
		return encoder.getDistance();
	}

	public void calibrate() {
		// from the interface
	}

	public void reset() {
		encoder.reset();
	}

}