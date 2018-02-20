package org.usfirst.frc.team4525.robot.control.auto;

import org.usfirst.frc.team4525.robot.control.Controller;
import org.usfirst.frc.team4525.robot.operate.autosystems.CommandManager;
import org.usfirst.frc.team4525.robot.operate.autosystems.commands.DriveStraight;
import org.usfirst.frc.team4525.robot.operate.autosystems.commands.Rotate;
import org.usfirst.frc.team4525.robot.operate.autosystems.commands.ScrewCommandDown;
import org.usfirst.frc.team4525.robot.operate.autosystems.commands.ShootCommand;
import org.usfirst.frc.team4525.robot.operate.autosystems.commands.ShootVault;
import org.usfirst.frc.team4525.robot.operate.autosystems.commands.Wait;
import org.usfirst.frc.team4525.robot.util.DashUtil;

public class CrossLineVaultLeft implements Controller {
	private CommandManager commands = CommandManager.getInstance();
	
	public void start() {
		try {
			
			commands.queSequential(new DriveStraight(132, 0.6));
			commands.queSequential(new Wait(0.5));
			commands.queSequential(new DriveStraight(-68, 0.6));
			commands.queSequential(new Rotate(92));
			commands.queSequential(new DriveStraight(60, 0.6));
			commands.queSequential(new Rotate(96));
			commands.queSequential(new DriveStraight(29, 0.6));
			commands.queSequential(new ScrewCommandDown());
			commands.queSequential(new ShootVault());
			commands.queSequential(new Rotate(180));
			
		} catch (NullPointerException e) {
			DashUtil.getInstance().log("Error with automode, command was null :(");
		}
	}

	public void stop() {
		commands.stop();
	}

}
