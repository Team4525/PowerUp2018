package org.usfirst.frc.team4525.robot.operate.subsystems;

import org.usfirst.frc.team4525.robot.operate.SubSystem;

public interface Tower extends SubSystem {

	public void extend();

	public void retract();

	public void stop();
}
