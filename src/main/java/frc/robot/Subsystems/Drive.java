/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Commands.*;
import frc.robot.OI;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Drive extends Subsystem {

  private final WPI_TalonSRX leftDriveMotorLead;
  private final WPI_TalonSRX leftDriveMotorFollow;

  private final WPI_TalonSRX rightDriveMotorLead;
  private final WPI_TalonSRX rightDriveMotorFollow;

  public final DifferentialDrive robotDrive;
  private Joystick leftJoystick; // Left Joystick is zero!
  private Joystick gamepad; // Gamepad is one!
  private Joystick rightJoystick; // Right Joystick is two!

  private int currentMode;

  public Drive() {
    rightDriveMotorLead = RobotMap.rightDriveMotorLead; //
    rightDriveMotorFollow = RobotMap.rightDriveMotorFollow;

    leftDriveMotorLead = RobotMap.leftDriveMotorLead;
    leftDriveMotorFollow = RobotMap.leftDriveMotorFollow;

    robotDrive = RobotMap.myRobot;
    currentMode = 0; // Beginning of match it sets drive mode to zero-- tank
    SmartDashboard.putString("Drive Mode", "Tank");
  }

  public void setJoystick(Joystick newLeftJoystick, Joystick newRightJoystick, Joystick newGamepad) {
    leftJoystick = newLeftJoystick;
    rightJoystick = newRightJoystick;
    gamepad = newGamepad;
  }

  public void setDrive() {
    // This command is referenced in the command "SwitchDriveMode.java"-- Title is
    // self explanatory
    if (currentMode == 0) {
      currentMode = 1;
      SmartDashboard.putString("Drive Mode", "Arcade"); // This checks if it is in tank. And if it is, it will change to
                                                        // arcade
    } else if (currentMode == 1) {
      currentMode = 2;
      SmartDashboard.putString("Drive Mode", "Tank"); // If the drive mode is Arcade, it will be made to Tank (done with
                                                      // two joysticks)
    } else {
      currentMode = 0;
      SmartDashboard.putString("Drive Mode", "Tank w/ 2 Joysticks"); // If the drive mode is Tank w/ 2 Joysticks change
                                                                     // back to tank
    }
  }

  public void initDefaultCommand() {
    setDefaultCommand(new DriveTeleop());
  }

  public void periodic() {

  }

  public void doTeleop(Joystick stick) {
    if (currentMode == 0) {
      double rightValue, leftValue;
      rightValue = gamepad.getRawAxis(5);
      leftValue = gamepad.getRawAxis(1);
      robotDrive.tankDrive(leftValue, rightValue);
    } else if (currentMode == 1) {
      robotDrive.arcadeDrive(Robot.oi.leftJoystick.getY(), Robot.oi.leftJoystick.getX());
    } else {
      robotDrive.tankDrive(rightJoystick.getY(), rightJoystick.getX()); // I want to test different values for the
                                                                        // joysticks to make this work
    }
  }

}