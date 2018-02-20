package org.usfirst.frc.team4525.robot.operate.subsystems;

import org.usfirst.frc.team4525.robot.operate.SubSystem;

public interface Climber extends SubSystem {

	public void climb();

	public void unwind();

	public void stop();
}
