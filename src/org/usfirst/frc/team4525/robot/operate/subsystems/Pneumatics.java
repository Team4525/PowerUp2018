package org.usfirst.frc.team4525.robot.operate.subsystems;

import org.usfirst.frc.team4525.robot.operate.SubSystem;

public interface Pneumatics extends SubSystem {
	public void startCompresser();

	public void stopCompressor();

	public boolean getCompressorRunning();
}
