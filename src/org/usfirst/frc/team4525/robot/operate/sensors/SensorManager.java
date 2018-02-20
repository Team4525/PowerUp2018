package org.usfirst.frc.team4525.robot.operate.sensors;

import org.usfirst.frc.team4525.robot.operate.sensors.impl.BottomSwitch;
import org.usfirst.frc.team4525.robot.operate.sensors.impl.DriveEncoders;
import org.usfirst.frc.team4525.robot.operate.sensors.impl.FrontSwitch;
import org.usfirst.frc.team4525.robot.operate.sensors.impl.Gyro;
import org.usfirst.frc.team4525.robot.operate.sensors.impl.LiftEncoder;
import org.usfirst.frc.team4525.robot.operate.sensors.impl.MotorEncoder;
import org.usfirst.frc.team4525.robot.operate.sensors.impl.TopSwitch;
import org.usfirst.frc.team4525.robot.util.DashUtil;

public class SensorManager {

	private static SensorManager instance = new SensorManager();

	public static SensorManager getInstance() {
		return instance;
	}

	// Sensors:
	private Sensor gyro;
	private Sensor driveEncoder;
	private Sensor liftEncoder;
	private Sensor frontSwitch;
	private Sensor topSwitch;
	private Sensor bottomSwitch;
	private Sensor motorencoder;

	// Getters
	public Sensor getGyro() {
		return gyro;
	}

	public Sensor getDriveEncoder() {
		return driveEncoder;
	}

	public Sensor getLiftEncoder() {
		return liftEncoder;
	}

	public Sensor getFrontSwitch() {
		return frontSwitch;
	}

	public Sensor getTopSwitch() {
		return topSwitch;
	}

	public Sensor getBottomSwitch() {
		return bottomSwitch;
	}

	public Sensor getMotorEncoder() {
		return motorencoder;
	}

	private SensorManager() {
		DashUtil.getInstance().log("Initiating Sensors");
		gyro = new Gyro();
		driveEncoder = new DriveEncoders();
		liftEncoder = new LiftEncoder();
		frontSwitch = new FrontSwitch();
		topSwitch = new TopSwitch();
		bottomSwitch = new BottomSwitch();
		motorencoder = new MotorEncoder();
		//
		gyro.init();
		driveEncoder.init();
		liftEncoder.init();
		frontSwitch.init();
		topSwitch.init();
		bottomSwitch.init();
		motorencoder.init();
		//
		DashUtil.getInstance().log("Sensors online.");
		//
	}

}
