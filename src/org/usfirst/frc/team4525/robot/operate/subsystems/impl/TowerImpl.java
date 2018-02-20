package org.usfirst.frc.team4525.robot.operate.subsystems.impl;

import org.usfirst.frc.team4525.robot.operate.subsystems.Tower;

import edu.wpi.first.wpilibj.VictorSP;

public class TowerImpl implements Tower {

	private VictorSP tower;

	public void init() {
		tower = new VictorSP(6);
	}

	public void extend() {
		tower.set(1);
	}

	public void retract() {
		tower.set(-0.2);
	}

	public void stop() {
		tower.set(0);
	}
}
