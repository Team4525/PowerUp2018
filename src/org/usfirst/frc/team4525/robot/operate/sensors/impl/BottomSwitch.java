package org.usfirst.frc.team4525.robot.operate.sensors.impl;

import org.usfirst.frc.team4525.robot.operate.sensors.Sensor;

import edu.wpi.first.wpilibj.DigitalInput;

public class BottomSwitch implements Sensor {

	private DigitalInput button;

	public void init() {
		button = new DigitalInput(6);
	}

	public double get() {
		if (button.get()) {
			return 1;
		} else {
			return 0;
		}
	}

	public void calibrate() {
		// nothing to calibrate
	}

	public void reset() {
		// nuttin to reset
	}
}
