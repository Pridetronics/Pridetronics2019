/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Commands.InitializeLift;
import frc.robot.Subsystems.Drive;
import frc.robot.Subsystems.Intake;
import frc.robot.Subsystems.Lift;
import frc.robot.Subsystems.Pneumatics;
import frc.robot.Subsystems.SparkMaxEnhanced;
import frc.robot.Subsystems.Wrist;
import frc.robot.Subsystems.WristPID;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static Drive drive;
  public static Lift lift;
  public static WristPID wristPID;
  public static OI oi;
  public static Wrist wrist;
  public static Pneumatics pneumatics;
  public static Intake intake;
  public static SparkMaxEnhanced smEnhanced;
  Command autonomousCommand;
  public static boolean dir;
  public static boolean panelDir;
  

  /*
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    dir = true;
    panelDir = true;
    //CameraServer.getInstance().startAutomaticCapture();
    //UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
    //camera.setResolution(320,240);
    RobotMap.init();
    drive = new Drive();
    lift = new Lift();
    //liftPID = new LiftPID();

    wrist = new Wrist();
    wristPID = new WristPID();
    wristPID.enable();
    pneumatics = new Pneumatics();
    intake = new Intake();
    oi = new OI();
    smEnhanced = new SparkMaxEnhanced();

    //CameraServer.getInstance().startAutomaticCapture();
    NetworkTableInstance inst = NetworkTableInstance.getDefault();

    /*
     * table = inst.getTable("Shuffleboard"); rotationFirst =
     * table.getEntry("rot1"); forwardDrive = table.getEntry("fwd"); rotationSecond
     * = table.getEntry("rot2"); rotationFirst.getDouble(0.0);
     * forwardDrive.getDouble(0.0); rotationSecond.getDouble(0.0);
     */

    
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    SmartDashboard.putNumber("Lift Encoder", RobotMap.liftEncoder.getPosition() - RobotMap.liftOffset);
    
    // boolean out = RobotMap.limitSwitchLiftDown.get();
    // SmartDashboard.putBoolean("LimitSwitch", out);
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();

    /*
     * rotationFirst.setDouble(0); forwardDrive.setDouble(0);
     * rotationSecond.setDouble(0);
     */
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabIEW Dashboard,
   * remove all of the chooser code and uncomment the getString line to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional comparisons to the
   * switch structure below with additional strings. If using the SendableChooser
   * make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    autonomousCommand = new InitializeLift();

    SmartDashboard.putString("Autonomous", "Running");
    if (autonomousCommand != null) {
      autonomousCommand.start();
    }

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopInit() {
    /*
     * if(autonomousCommand != null){ autonomousCommand.cancel(); }
     */
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    SmartDashboard.putNumber("Right Encoder", RobotMap.rightDriveMotorLead.getSelectedSensorPosition());
    SmartDashboard.putNumber("Left Encoder", RobotMap.leftDriveMotorLead.getSelectedSensorPosition());
    SmartDashboard.putNumber("Wrist Encoder", RobotMap.wristEncoder.getDistance());

     SmartDashboard.putBoolean("Lift Auto", Robot.lift.limitSwitchDownOpen());
    // SmartDashboard.putNumber("Lift Encoder Velocity",
    // RobotMap.liftEncoder.getVelocity());

  }
  /**
   * This function is called periodically during test mode.
   */
}