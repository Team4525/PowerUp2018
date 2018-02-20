package org.usfirst.frc.team4525.robot;

import org.usfirst.frc.team4525.robot.control.Controller;
import org.usfirst.frc.team4525.robot.control.auto.DropCubeCenterRightVault;
import org.usfirst.frc.team4525.robot.control.teleop.Driver;
import org.usfirst.frc.team4525.robot.control.teleop.Mech;
import org.usfirst.frc.team4525.robot.operate.SubsystemsManager;
import org.usfirst.frc.team4525.robot.operate.autosystems.CommandManager;
import org.usfirst.frc.team4525.robot.util.AutoChooser;
import org.usfirst.frc.team4525.robot.util.DashUtil;

import edu.wpi.first.wpilibj.SampleRobot;

@SuppressWarnings("deprecation")
public class Robot extends SampleRobot {

	private Controller auto, drive, mech;
	private DashUtil du;
	private CommandManager commands;
	private AutoChooser chooser;

	public Robot() {
		// Declaring the dashutil
		du = DashUtil.getInstance();
		du.log("Loading PowerUP2018...");
		// Declaring commands pour auto
		commands = CommandManager.getInstance();
		// Declaring Drive, Mech, and Auto
		drive = new Driver();
		mech = new Mech();
		chooser = new AutoChooser();
		auto = new DropCubeCenterRightVault();
	}

	public void robotInit() {

	}

	public void autonomous() {
		// du.log("Starting autonomous mode");
		// du.log("Running " + auto.toString());
		// If auto is running, start autonomous and commands
		if (auto != null) {
			auto.start();
			commands.start();
		}
	}

	public void operatorControl() {
		// Clearing Dashutil from Auto
		DashUtil.getInstance().clear();
		DashUtil.getInstance().log("Starting operator mode.");
		// starting the operator controls
		drive.start();
		mech.start();
	}

	public void stop() {
		// stopping Operator control
		drive.stop();
		mech.stop();
		// stopping auto
		if (auto != null) {
			auto.stop();
		}
		// stopping commands
		commands.stop();

	}

	protected void disabled() {
		// Stop the DriveTrain and Compressor
		drive.stop();
		SubsystemsManager.getInstance().getCompressor().stopCompressor();
		// If the autonomous is still running, stop it
		if (auto != null)
			auto.stop();
		// Stop any running commands
		commands.stop();
		//
	}
}
