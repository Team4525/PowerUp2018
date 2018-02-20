package org.usfirst.frc.team4525.robot.operate.autosystems.commands;

import org.usfirst.frc.team4525.robot.operate.SubsystemsManager;
import org.usfirst.frc.team4525.robot.operate.autosystems.Command;
import org.usfirst.frc.team4525.robot.operate.subsystems.Screw;

import edu.wpi.first.wpilibj.Timer;

public class ScrewCommandDown implements Command {

	private SubsystemsManager systems = SubsystemsManager.getInstance();
	private Screw screw = systems.getScrew();
	private boolean finished = false;
	private boolean started = false;

	public ScrewCommandDown() {

	}

	@Override
	public void init() {
		started = true;
	}

	public void execute() {
		screw.bottom();
		Timer.delay(2.5);
		finished = true;

	}

	@Override
	public boolean isFinished() {
		return finished;
	}

	@Override
	public void end() {
		screw.stop();
	}

	@Override
	public void stop() {
		finished = true;
	}

	@Override
	public boolean interupted() {

		return finished;
	}

	@Override
	public boolean started() {

		return started;
	}

}
