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
  private Joystick gamepad;
  private Joystick leftJoystick;
  private Joystick rightJoystick;

  private int currentMode;

  public Drive() {
    rightDriveMotorLead = RobotMap.rightDriveMotorLead;
    rightDriveMotorFollow = RobotMap.rightDriveMotorFollow;

    leftDriveMotorLead = RobotMap.leftDriveMotorLead;
    leftDriveMotorFollow = RobotMap.leftDriveMotorFollow;

    // Sets the "follow" motors to the "lead" motors.

    robotDrive = RobotMap.myRobot;
    currentMode = 0;
    SmartDashboard.putString("Drive Mode", "Tank");
  }

  public void setJoystick(Joystick newLeftJoystick, Joystick newRightJoystick, Joystick newGamepad) {
    leftJoystick = newLeftJoystick;
    rightJoystick = newRightJoystick;
    gamepad = newGamepad;

    // Is created to be used in the methods and set it equal to the Joysticks we
    // created
  }

  public void setDrive() {
    // This code is referenced in the SwitcheDriveMode.java to switch modes.
    if (currentMode == 0) {
      currentMode = 1;
      SmartDashboard.putString("Drive Mode", "Arcade");

    } else if (currentMode == 1) {
      currentMode = 2;
      SmartDashboard.putString("Drive Mode", "Tank");
    } else {
      currentMode = 0;
      SmartDashboard.putString("Drive Mode", "Tank w/ 2 Joysticks");

    }

  }

  public void initDefaultCommand() {
    setDefaultCommand(new DriveTeleop());

  }

  public void periodic() {

    // "void" does stuff only once

  }

  public void doTeleop() {
    if (currentMode == 0) {
      double rightValue, leftValue;
      rightValue = gamepad.getRawAxis(5);
      leftValue = gamepad.getRawAxis(1);
      robotDrive.tankDrive(leftValue, rightValue);
    } else if (currentMode == 1) {
      robotDrive.arcadeDrive(leftJoystick.getY(), leftJoystick.getX());

    }  /*else  { 
      robotDrive.tankDrive(leftJoystick.getRawAxis(1), rightJoystick.getRawAxis(1), true);
      System.out.println("left and right data" + leftJoystick.getRawAxis(1) + "   " + rightJoystick.getRawAxis(1));
     }
    // Sets the axis the Joysticks should collect data from (in each mode)
    */
  }
     
  }





