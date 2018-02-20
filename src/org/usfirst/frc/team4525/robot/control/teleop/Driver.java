package org.usfirst.frc.team4525.robot.control.teleop;

import org.usfirst.frc.team4525.robot.control.Controller;
import org.usfirst.frc.team4525.robot.operate.SubsystemsManager;
import org.usfirst.frc.team4525.robot.operate.sensors.SensorManager;
import org.usfirst.frc.team4525.robot.operate.subsystems.Climber;
import org.usfirst.frc.team4525.robot.operate.subsystems.Drive;
import org.usfirst.frc.team4525.robot.operate.subsystems.Tower;
import org.usfirst.frc.team4525.robot.util.DashUtil;
import org.usfirst.frc.team4525.robot.util.XboxController;
import org.usfirst.frc.team4525.robot.util.XboxController.Axis;
import org.usfirst.frc.team4525.robot.util.XboxController.Button;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Driver implements Controller {

	private boolean active = false;

	private XboxController xbox = new XboxController(0);

	SubsystemsManager systems = SubsystemsManager.getInstance();
	Drive drive_train = systems.getDriveTrain();
	Tower tower = systems.getTower();
	Climber climber = systems.getClimber();

	public void start() {
		active = true;

		new Thread(new Runnable() {

			public void run() {

				DashUtil.getInstance().log("Starting Driver Mode.");

				drive_train.setDeadZone(0.15);
				drive_train.setDriveStrait(true);

				int driveInvert = 1;

				// set buttons
				boolean invertPressed = false;

				while (active) {

					SmartDashboard.putNumber("Hey", SensorManager.getInstance().getDriveEncoder().get());
					// to be sure the screw and buttons wont fail
					if (xbox.getAxis(Axis.RightX) < 0.2) {
						if (xbox.getButton(Button.BumperR) && !invertPressed) {
							driveInvert = driveInvert * -1;
							invertPressed = true;
						} else if (!xbox.getButton(Button.BumperR)) {
							invertPressed = false;
						}
					}
					drive_train.drive(xbox.getAxis(Axis.LeftY) * driveInvert, xbox.getAxis(Axis.RightX),xbox.getAxis(Axis.TriggerR)>0.1);

					if (xbox.getPOV() == 0) {
						tower.extend();
					} else if (xbox.getPOV() != 0) {
						tower.stop();
					}

					if (xbox.getAxis(Axis.TriggerR) > 0.1) {
						climber.unwind();
					} else if (xbox.getAxis(Axis.TriggerR) < 0.1) {
						climber.stop();
					}

					if (xbox.getPOV() == 180) {
						tower.retract();
						climber.climb();
					} else if (xbox.getPOV() != 180) {
						tower.stop();
						climber.stop();
					}
				}
				DashUtil.getInstance().log("Driver mode stopped.");
			}
		}).start();
	}

	public void stop() {
		active = false;
	}
}
