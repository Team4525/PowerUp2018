package org.usfirst.frc.team4525.robot.operate.subsystems;

import org.usfirst.frc.team4525.robot.operate.SubSystem;

public interface Intake extends SubSystem {
	public void intake();

	public void eject(double power);

	public void stop();
}
