package org.usfirst.frc.team4525.robot.operate.subsystems.impl;

import org.usfirst.frc.team4525.robot.operate.subsystems.Arms;
import org.usfirst.frc.team4525.robot.util.Piston;

public class ArmsImpl implements Arms {

	private Piston arms;

	public void init() {
		arms = new Piston(0, 1, false);
	}

	@Override
	public void open() {
		arms.retract();

	}

	@Override
	public void close() {
		arms.extend();

	}

}
