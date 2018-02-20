package org.usfirst.frc.team4525.robot.operate.autosystems.commands;

import org.usfirst.frc.team4525.robot.operate.SubsystemsManager;
import org.usfirst.frc.team4525.robot.operate.autosystems.Command;
import org.usfirst.frc.team4525.robot.operate.subsystems.Intake;

import edu.wpi.first.wpilibj.Timer;

public class IntakeCommand implements Command {

	private SubsystemsManager systems = SubsystemsManager.getInstance();

	private Intake intake = systems.getIntake();

	private boolean finished = false;
	private boolean start = false;

	public IntakeCommand() {

	}

	public void init() {
		start = true;
	}

	public void execute() {
		intake.intake();
		Timer.delay(0.75);
		intake.stop();
		finished = true;
	}

	public boolean isFinished() {
		return finished;
	}

	public void end() {
		intake.stop();
	}

	public void stop() {
		finished = true;
	}

	public boolean interupted() {
		return false;
	}

	public boolean started() {
		return start;
	}
}
