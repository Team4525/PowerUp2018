package org.usfirst.frc.team4525.robot.operate.autosystems.commands;

import org.usfirst.frc.team4525.robot.operate.SubsystemsManager;
import org.usfirst.frc.team4525.robot.operate.autosystems.Command;
import org.usfirst.frc.team4525.robot.operate.subsystems.Arms;

public class OpenArms implements Command {

	private SubsystemsManager systems = SubsystemsManager.getInstance();
	private Arms arms = systems.getArms();
	private boolean finished = false;
	private boolean started = false;

	@Override
	public void init() {
		started = true;
	}

	@Override
	public void execute() {
		arms.close();
		finished = true;
	}

	@Override
	public boolean isFinished() {

		return finished;
	}

	@Override
	public void end() {

	}

	@Override
	public void stop() {
		finished = true;
	}

	@Override
	public boolean interupted() {

		return false;
	}

	@Override
	public boolean started() {

		return started;
	}

}
