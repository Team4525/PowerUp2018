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
import org.usfirst.frc.team4525.robot.operate.autosystems.commands.ShootVault;
import org.usfirst.frc.team4525.robot.util.DashUtil;

public class DropCubeCenterRightVault implements Controller{
	private CommandManager commands = CommandManager.getInstance();

	public void start() {
		try {
			//Drive up and shoot
			commands.queSequential(new DriveStraight(40, 0.5));
			commands.queSequential(new Rotate(45));
			commands.queSequential(new DriveStraight(85, 0.5));
			commands.queSequential(new Rotate(-45));
			commands.queSequential(new ShootCommand());
			
			// back up and grab another box
			commands.queSequential(new DriveStraight(-15, 1));
			commands.queSequential(new Rotate(-87));
			commands.queSequential(new ScrewCommandDown());
			commands.queSequential(new OpenArms());
			commands.queSequential(new DriveStraight(90, 1));
			commands.queSequential(new CloseArms());
			commands.queSequential(new IntakeCommand());
			//commands.queSequential(new DriveStraight(30,0.5));
			commands.queSequential(new Rotate(-93));
			
			// shoot box into vault
			commands.queSequential(new DriveStraight(60, 0.5)); 
			//commands.queSequential(new Rotate(-57));
			//commands.queSequential(new DriveStraight(25,0.5));
			commands.queSequential(new ShootVault());

		} catch (NullPointerException e) {
			DashUtil.getInstance().log("Error with automode, command was null :(");
		}
	}

	public void stop() {
		commands.stop();
	}

}
