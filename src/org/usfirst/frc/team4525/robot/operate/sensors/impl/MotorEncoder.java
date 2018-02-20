package org.usfirst.frc.team4525.robot.operate.sensors.impl;

import org.usfirst.frc.team4525.robot.operate.sensors.Sensor;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;

public class MotorEncoder implements Sensor {

	private Encoder encoder;

	public void init() {
		encoder = new Encoder(7, 8, false, EncodingType.k4X);
		encoder.setDistancePerPulse(0.009646);

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