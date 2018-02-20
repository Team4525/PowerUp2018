package org.usfirst.frc.team4525.robot.control.teleop;

import org.usfirst.frc.team4525.robot.control.Controller;
import org.usfirst.frc.team4525.robot.operate.SubsystemsManager;
import org.usfirst.frc.team4525.robot.operate.sensors.Sensor;
import org.usfirst.frc.team4525.robot.operate.sensors.SensorManager;
import org.usfirst.frc.team4525.robot.operate.subsystems.Arms;
import org.usfirst.frc.team4525.robot.operate.subsystems.Intake;
import org.usfirst.frc.team4525.robot.operate.subsystems.Pneumatics;
import org.usfirst.frc.team4525.robot.operate.subsystems.Puncher;
import org.usfirst.frc.team4525.robot.operate.subsystems.Screw;
import org.usfirst.frc.team4525.robot.util.DashUtil;
import org.usfirst.frc.team4525.robot.util.XboxController;
import org.usfirst.frc.team4525.robot.util.XboxController.Axis;
import org.usfirst.frc.team4525.robot.util.XboxController.Button;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Mech implements Controller {

	private boolean active = false;

	private XboxController xbox = new XboxController(1);

	SubsystemsManager systems = SubsystemsManager.getInstance();
	//
	Screw screw = systems.getScrew();
	Pneumatics compressor = systems.getCompressor();
	Arms arms = systems.getArms();
	Intake intake = systems.getIntake();
	Puncher puncher = systems.getPuncher();
	//
	SensorManager sensors = SensorManager.getInstance();
	//
	Sensor encoder = sensors.getLiftEncoder();
	Sensor tB = sensors.getTopSwitch();
	Sensor bB = sensors.getBottomSwitch();
	Sensor mEncoder = sensors.getMotorEncoder();

	public void start() {
		//
		active = true;
		//
		new Thread(new Runnable() {

			public void run() {

				DashUtil.getInstance().log("Starting Mech Mode.");

				boolean isTop = false;
				boolean isBottom = true;
				boolean isOpen = true;

				while (active) {
					SmartDashboard.putNumber("Top", tB.get());
					SmartDashboard.putNumber("Bottom", bB.get());
					SmartDashboard.putNumber("MEncoder", mEncoder.get());
					compressor.startCompresser();

					if (xbox.getPOV() == 0 && isTop == false) {
						// DriverStation.reportError("Lift", false);
						isTop = true;
						screw.top();
					} else if (isTop == true && xbox.getPOV() != 0) {
						isTop = false;
						screw.stop();
						// DriverStation.reportError("Stop Lift", false);
					}

					if (xbox.getPOV() == 180 && isBottom == false) {
						// DriverStation.reportError("Lower", false);
						isBottom = true;
						screw.bottom();
					} else if (isBottom == true && xbox.getPOV() != 180) {
						isBottom = false;
						screw.stop();
						// DriverStation.reportError("Stop Lower", false);
					}

					if (xbox.getButton(Button.X) && isOpen) {
						arms.close();
						isOpen = false;
					} else if (xbox.getButton(Button.A) && !isOpen) {
						arms.open();
						isOpen = true;
					}

					if (xbox.getAxis(Axis.TriggerR) > 0.1) {
						intake.eject(0.5);
					} else if (xbox.getAxis(Axis.TriggerL) > 0.1) {
						intake.intake();
					} else {
						intake.stop();
					}

					if (xbox.getButton(Button.Y)) {
						puncher.push();
					}
					SmartDashboard.putNumber("encoders", SensorManager.getInstance().getLiftEncoder().get());
				}

				DashUtil.getInstance().log("Mech mode stopped.");
			}
		}).start();
	}

	public void stop() {
		active = false;
	}
}
