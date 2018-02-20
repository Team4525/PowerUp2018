package org.usfirst.frc.team4525.robot.operate;

import org.usfirst.frc.team4525.robot.operate.subsystems.Arms;
import org.usfirst.frc.team4525.robot.operate.subsystems.Climber;
import org.usfirst.frc.team4525.robot.operate.subsystems.Drive;
import org.usfirst.frc.team4525.robot.operate.subsystems.Intake;
import org.usfirst.frc.team4525.robot.operate.subsystems.Pneumatics;
import org.usfirst.frc.team4525.robot.operate.subsystems.Puncher;
import org.usfirst.frc.team4525.robot.operate.subsystems.Screw;
import org.usfirst.frc.team4525.robot.operate.subsystems.Tower;
import org.usfirst.frc.team4525.robot.operate.subsystems.impl.ArmsImpl;
import org.usfirst.frc.team4525.robot.operate.subsystems.impl.ClimberImpl;
import org.usfirst.frc.team4525.robot.operate.subsystems.impl.DriveImpl;
import org.usfirst.frc.team4525.robot.operate.subsystems.impl.IntakeImpl;
import org.usfirst.frc.team4525.robot.operate.subsystems.impl.PneumaticsImpl;
import org.usfirst.frc.team4525.robot.operate.subsystems.impl.PuncherImpl;
import org.usfirst.frc.team4525.robot.operate.subsystems.impl.ScrewImpl;
import org.usfirst.frc.team4525.robot.operate.subsystems.impl.TowerImpl;
import org.usfirst.frc.team4525.robot.util.DashUtil;

public class SubsystemsManager {

	private static SubsystemsManager instance = new SubsystemsManager();

	public static SubsystemsManager getInstance() {
		return instance;
	}

	// Declare the subsystems
	private SubSystem drive_train = new DriveImpl();
	private SubSystem screw = new ScrewImpl();
	private SubSystem compressor = new PneumaticsImpl();
	private SubSystem puncher = new PuncherImpl();
	private SubSystem arms = new ArmsImpl();
	private SubSystem intake = new IntakeImpl();
	private SubSystem climber = new ClimberImpl();
	private SubSystem tower = new TowerImpl();

	// Declare methods for subsystems
	public Drive getDriveTrain() {
		return (Drive) drive_train;
	}

	public Screw getScrew() {
		return (Screw) screw;
	}

	public Pneumatics getCompressor() {
		return (Pneumatics) compressor;
	}

	public Puncher getPuncher() {
		return (Puncher) puncher;
	}

	public Arms getArms() {
		return (Arms) arms;
	}

	public Intake getIntake() {
		return (Intake) intake;
	}

	public Climber getClimber() {
		return (Climber) climber;
	}

	public Tower getTower() {
		return (Tower) tower;
	}

	private SubsystemsManager() {
		DashUtil.getInstance().log("Initiating Subsystems.");

		// Initialize subsystems
		drive_train.init();
		screw.init();
		compressor.init();
		puncher.init();
		arms.init();
		intake.init();
		climber.init();
		tower.init();
		//
		DashUtil.getInstance().log("Subsystems Ready!");
	}

}
