package org.usfirst.frc.team4525.robot.util;

import org.usfirst.frc.team4525.robot.control.Controller;
import org.usfirst.frc.team4525.robot.control.auto.CrossBaselineSide;
import org.usfirst.frc.team4525.robot.control.auto.DoNothing;
import org.usfirst.frc.team4525.robot.control.auto.DropCubeCenterLeft;
import org.usfirst.frc.team4525.robot.control.auto.DropCubeCenterRight;
import org.usfirst.frc.team4525.robot.control.auto.DropCubeLeft;
import org.usfirst.frc.team4525.robot.control.auto.DropCubeRight;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoChooser {

	private static SendableChooser autoModes;
	private static DriverStation ds = DriverStation.getInstance();

	private enum AutoMode {
		Nothing, Left, Right, Middle;
	}

	public AutoChooser() {
		// Autonomous modes:

		autoModes = new SendableChooser();
		autoModes.addDefault("Nothing", AutoMode.Nothing);
		autoModes.addObject("Left", AutoMode.Left);
		autoModes.addObject("Middle", AutoMode.Middle);
		autoModes.addObject("Right", AutoMode.Right);

		SmartDashboard.putData("Autochooser", autoModes);
	};

	public static Controller getSelectedAuto() {
		AutoMode mode = (AutoMode) autoModes.getSelected();
		DashUtil.getInstance().log("Running auto for playerstation " + DriverStation.getInstance().toString());

		// Run the selected autonomous
		if (ds.getGameSpecificMessage().equals("LRL") || ds.getGameSpecificMessage().equals("LLL")) {
			switch (mode) {
			case Left:
				return new DropCubeLeft();
			case Middle:
				return new DropCubeCenterLeft();
			case Right:
				return new CrossBaselineSide();
			default: // nothing
				return new DoNothing();
			}
		} else if (ds.getGameSpecificMessage().equals("RLR") || ds.getGameSpecificMessage().equals("RRR")) {
			switch (mode) {
			case Left:
				return new CrossBaselineSide();
			case Middle:
				return new DropCubeCenterRight();
			case Right:
				return new DropCubeRight();
			default: // nothing
				return new DoNothing();
			}
		} else {
			return null;
		}
	}
}