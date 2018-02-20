package org.usfirst.frc.team4525.robot.control.auto;

import org.usfirst.frc.team4525.robot.control.Controller;
import org.usfirst.frc.team4525.robot.operate.autosystems.CommandManager;
import org.usfirst.frc.team4525.robot.operate.autosystems.commands.CloseArms;
import org.usfirst.frc.team4525.robot.operate.autosystems.commands.DriveStraight;
import org.usfirst.frc.team4525.robot.operate.autosystems.commands.IntakeCommand;
import org.usfirst.frc.team4525.robot.operate.autosystems.commands.OpenArms;
import org.usfirst.frc.team4525.robot.operate.autosystems.commands.Rotate;
import org.usfirst.frc.team4525.robot.operate.autosystems.commands.ScrewCommandDown;
import org.usfirst.frc.team4525.robot.operate.autosystems.commands.ShootCommand;
import org.usfirst.frc.team4525.robot.operate.autosystems.commands.Wait;
import org.usfirst.frc.team4525.robot.util.DashUtil;

public class DropCubeCenterLeftVault implements Controller {
	private CommandManager commands = CommandManager.getInstance();

	public void start() {
		try {
			commands.queSequential(new DriveStraight(20, 0.9));
			commands.queSequential(new Wait(0.2));
			commands.queSequential(new Rotate(-45));
			commands.queSequential(new DriveStraight(90, 0.9));
			commands.queSequential(new Wait(0.2));
			commands.queSequential(new Rotate(20));
			commands.queSequential(new DriveStraight(10, 0.9));
			commands.queSequential(new ShootCommand());
			commands.queSequential(new DriveStraight(-10, 1));
			commands.queSequential(new Rotate(90));
			commands.queSequential(new ScrewCommandDown());
			commands.queSequential(new OpenArms());
			commands.queSequential(new DriveStraight(25, 1));
			commands.queSequential(new CloseArms());
			commands.queSequential(new IntakeCommand());
			commands.queSequential(new DriveStraight(-30, 1));
			commands.queSequential(new Rotate(90));
			commands.queSequential(new DriveStraight(65, 1));
			commands.queSequential(new ShootCommand());

		} catch (NullPointerException e) {
			DashUtil.getInstance().log("Error with automode, command was null :(");
		}
	}

	public void stop() {
		commands.stop();
	}
}
