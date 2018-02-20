package org.usfirst.frc.team4525.robot.control.auto;

import org.usfirst.frc.team4525.robot.control.Controller;
import org.usfirst.frc.team4525.robot.operate.autosystems.CommandManager;
import org.usfirst.frc.team4525.robot.operate.autosystems.commands.DriveStraight;
import org.usfirst.frc.team4525.robot.operate.autosystems.commands.Rotate;
import org.usfirst.frc.team4525.robot.operate.autosystems.commands.ShootCommand;
import org.usfirst.frc.team4525.robot.util.DashUtil;

//THIS AUTO HAS BEEN TESTED

public class DropCubeCenterRight implements Controller {
	private CommandManager commands = CommandManager.getInstance();

	public void start() {
		try {
			commands.queSequential(new DriveStraight(40, 0.5));
			commands.queSequential(new Rotate(90));
			commands.queSequential(new DriveStraight(43, 0.5));
			commands.queSequential(new Rotate(-90));
			commands.queSequential(new DriveStraight(59, 0.5));
			commands.queSequential(new ShootCommand());

		} catch (NullPointerException e) {
			DashUtil.getInstance().log("Error with automode, command was null :(");
		}
	}

	@Override
	public void stop() {
		commands.stop();
	}

}
