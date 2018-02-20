package org.usfirst.frc.team4525.robot.operate.subsystems.impl;

import org.usfirst.frc.team4525.robot.operate.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.Compressor;

public class PneumaticsImpl implements Pneumatics {

	private Compressor comp;

	public void init() {
		comp = new Compressor(0);
	}

	public void startCompresser() {
		comp.start();
		comp.setClosedLoopControl(true);
	}

	public void stopCompressor() {
		comp.stop();
	}

	public boolean getCompressorRunning() {
		return comp.getPressureSwitchValue();
	}

}
