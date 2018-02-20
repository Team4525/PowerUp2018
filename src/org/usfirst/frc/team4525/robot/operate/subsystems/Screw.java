package org.usfirst.frc.team4525.robot.operate.subsystems;

import org.usfirst.frc.team4525.robot.operate.SubSystem;

public interface Screw extends SubSystem {

	// public void setpoint(double point);

	public void top();

	public void bottom();

	public void stop();
}
