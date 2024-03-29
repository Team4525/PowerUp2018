package org.usfirst.frc.team4525.robot.operate.autosystems.commands;

import org.usfirst.frc.team4525.robot.operate.autosystems.Command;

public class Wait implements Command {

	private boolean finished = false;
	private boolean started = false;

	private double time = 0;
	private int interval = 0;

	public Wait(double d) {
		time = d * 1000000;// Multiply the time we're waiting by by 1,000,000,
							// to convert to microseconds
	}

	public void init() {
		started = true;

	}

	@Override
	public void execute() {
		interval++;// This takes about a microsecond to process, so when we do
					// this "time" times we get the correct amount of wait time
		if (interval >= time)
			finished = true;
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return finished;
	}

	@Override
	public void end() {
		// do nothing
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		finished = true;
	}

	@Override
	public boolean interupted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean started() {
		// TODO Auto-generated method stub
		return started;
	}

}
