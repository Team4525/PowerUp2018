package org.usfirst.frc.team4525.robot.operate.subsystems.impl;

import org.usfirst.frc.team4525.robot.operate.subsystems.Climber;

import edu.wpi.first.wpilibj.VictorSP;

public class ClimberImpl implements Climber {
	private VictorSP winch;

	public void init() {
		winch = new VictorSP(5);
	}

	public void climb() {
		winch.set(1);
	}

	public void unwind() {
		winch.set(-1);
	}

	public void stop() {
		winch.set(0);
	}
}
