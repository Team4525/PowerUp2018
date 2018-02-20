package org.usfirst.frc.team4525.robot.control.auto;

import org.usfirst.frc.team4525.robot.control.Controller;
import org.usfirst.frc.team4525.robot.operate.autosystems.CommandManager;
import org.usfirst.frc.team4525.robot.operate.autosystems.commands.Rotate;

public class TestAuto implements Controller {

	private CommandManager commands = CommandManager.getInstance();

	public void start() {
		commands.queSequential(new Rotate(90));
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

}
