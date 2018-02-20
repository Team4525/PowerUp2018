package org.usfirst.frc.team4525.robot.operate.autosystems.commands;

import org.usfirst.frc.team4525.robot.operate.SubsystemsManager;
import org.usfirst.frc.team4525.robot.operate.autosystems.Command;
import org.usfirst.frc.team4525.robot.operate.subsystems.Intake;

import edu.wpi.first.wpilibj.Timer;

public class ShootCommand implements Command {

	private SubsystemsManager systems = SubsystemsManager.getInstance();

	private Intake intake = systems.getIntake();

	private boolean finished = false;
	private boolean started = false;
	//

	public ShootCommand() {

	}

	public void init() {
		started = true;
	}

	public void execute() {
		intake.eject(0.5);
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
		return finished;
	}

	public boolean started() {
		return started;
	}
}
