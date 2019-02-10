/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import com.ctre.phoenix.motorcontrol.FeedbackDevice;

//  TODO review imports
import edu.wpi.first.wpilibj.TimedRobot;
//import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Scheduler;
//import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.*;
//import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.networktables.NetworkTable;
//import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
//import edu.wpi.first.wpilibj.TimedRobot;
//import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Commands.DriveForward;
import frc.robot.Subsystems.Drive;
import frc.robot.Subsystems.Intake;
import frc.robot.Subsystems.Lift;
import frc.robot.Subsystems.Pnuematics;
import frc.robot.Subsystems.Wrist;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  public static Drive drive; // Creates New Drive
  public static Lift lift; // Creates New Lift
  public static OI oi; // Creates New OI
  public static Wrist wrist; // Creates New Wrist
  public static Pnuematics pnuematics; // Creates New Pnuematics
  public static Intake intake; // Creates New Intake

  public NetworkTable table; // Creates New Network Table

  public static DriveForward driveForward;

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {

    RobotMap.init();
    drive = new Drive();
    lift = new Lift();
    wrist = new Wrist();
    pnuematics = new Pnuematics();
    intake = new Intake();
    oi = new OI();

    // TODO is chooser needed
    /*
     * m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
     * m_chooser.addOption("My Auto", kCustomAuto);
     * SmartDashboard.putData("Auto choices", m_chooser);
     * SmartDashboard.putString("RobotID", "Master 190208b");
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

    NetworkTableInstance inst = NetworkTableInstance.getDefault(); // Creates new NetworkTableInstance Object

    table = inst.getTable("Shuffleboard");

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
   * TODO autonomous needed? This autonomous (along with the chooser code above)
   * shows how to select between different autonomous modes using the dashboard.
   * The sendable chooser code works with the Java SmartDashboard. If you prefer
   * the LabIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional comparisons to the
   * switch structure below with additional strings. If using the SendableChooser
   * make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {

  }

  /**
   * TODO autonomous needed This function is called periodically during
   * autonomous.
   */
  @Override
  public void autonomousPeriodic() {

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopInit() {
  }

  /**
   * TODO need Vyom's logger
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();

    // Pushes Values of Encoders into SmartDashboard
    SmartDashboard.putNumber("Right Encoder", RobotMap.rightDriveMotorLead.getSelectedSensorPosition());
    SmartDashboard.putNumber("Left Encoder", RobotMap.leftDriveMotorLead.getSelectedSensorPosition());
    SmartDashboard.putNumber("Lift Encoder Position", RobotMap.liftEncoder.getPosition());
    SmartDashboard.putNumber("Lift Encoder Velocity", RobotMap.liftEncoder.getVelocity());
  }
}
