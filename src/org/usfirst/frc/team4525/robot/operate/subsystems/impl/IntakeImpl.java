package org.usfirst.frc.team4525.robot.operate.subsystems.impl;

import org.usfirst.frc.team4525.robot.operate.sensors.Sensor;
import org.usfirst.frc.team4525.robot.operate.sensors.SensorManager;
import org.usfirst.frc.team4525.robot.operate.subsystems.Intake;

import edu.wpi.first.wpilibj.VictorSP;

public class IntakeImpl implements Intake {

	private VictorSP left;
	private VictorSP right;
	//
	private SensorManager sensor;
	private Sensor button;

	public void init() {
		left = new VictorSP(7);
		right = new VictorSP(8);
		sensor = SensorManager.getInstance();
		button = sensor.getFrontSwitch();
	}

	public void intake() {
		if (button.get() == 1) {
			left.set(-0.80);
			right.set(0.80);
		} else {
			stop();
		}
	}

	public void eject(double power) {
		left.set(power);
		right.set(-power);
	}

	public void stop() {
		left.set(0);
		right.set(0);
	}
}
