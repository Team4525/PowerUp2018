package org.usfirst.frc.team4525.robot.control.auto;

import org.usfirst.frc.team4525.robot.control.Controller;
import org.usfirst.frc.team4525.robot.operate.autosystems.CommandManager;
import org.usfirst.frc.team4525.robot.operate.autosystems.commands.DriveStraight;
import org.usfirst.frc.team4525.robot.util.DashUtil;

//THIS AUTO HAS BEEN TESTED

public class CrossBaselineSide implements Controller {
	
	private CommandManager commands = CommandManager.getInstance();
	
	public void start() {
		try {
			
			commands.queSequential(new DriveStraight(132, 1));
			
		} catch (NullPointerException e) {
			DashUtil.getInstance().log("Error with automode, command was null :(");
		}
	}

	@Override
	public void stop() {
		commands.stop();
	}

}
