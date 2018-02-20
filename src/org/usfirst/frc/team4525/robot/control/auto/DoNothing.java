package org.usfirst.frc.team4525.robot.control.auto;

import org.usfirst.frc.team4525.robot.control.Controller;
import org.usfirst.frc.team4525.robot.util.DashUtil;

//THIS AUTO HAS BEEN TESTED

public class DoNothing implements Controller {// Does nothing

	public void start() {
		DashUtil.getInstance().log("Doing Nothing For some Reason");
	}

	@Override
	public void stop() {

	}

}