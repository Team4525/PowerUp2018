package org.usfirst.frc.team4525.robot.operate.subsystems.impl;

import org.usfirst.frc.team4525.robot.operate.sensors.Sensor;
import org.usfirst.frc.team4525.robot.operate.sensors.SensorManager;
import org.usfirst.frc.team4525.robot.operate.subsystems.Screw;

import edu.wpi.first.wpilibj.VictorSP;

public class ScrewImpl implements Screw {
	// Motors
	private VictorSP screw;
	// Sensor Stuff
	private Sensor tB;
	private Sensor bB;
	private Sensor encoder;
	private boolean isMoving = false;

	public void init() {
		screw = new VictorSP(4);
		tB = SensorManager.getInstance().getTopSwitch();
		bB = SensorManager.getInstance().getBottomSwitch();
		encoder = SensorManager.getInstance().getMotorEncoder();
	}

	@Override
	public void top() {
		if (isMoving == false && tB.get() == 1) {
			isMoving = true;
			screw.set(1);
			new Thread(new Runnable() {
				public void run() {
					while (isMoving == true) {
						if (tB.get() == 0 || encoder.get() >= -1) {
							stop();
						}
					}
				}
			}).start();
		}
	}

	@Override
	public void bottom() {
		if (isMoving == false && bB.get() == 1) {
			isMoving = true;
			screw.set(-1);
			new Thread(new Runnable() {
				public void run() {
					while ((isMoving == true)) {
						if (bB.get() == 0 || encoder.get() <= -16) {
							stop();
						}
					}
				}
			}).start();
		}
	}

	public void stop() {
		screw.set(0);
		isMoving = false;
	}
}
