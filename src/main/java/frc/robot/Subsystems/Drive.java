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
  private Joystick stick;

  private int currentMode;

  public Drive() {
    rightDriveMotorLead = RobotMap.rightDriveMotorLead;
    rightDriveMotorFollow = RobotMap.rightDriveMotorFollow;

    leftDriveMotorLead = RobotMap.leftDriveMotorLead;
    leftDriveMotorFollow = RobotMap.leftDriveMotorFollow;

    robotDrive = RobotMap.myRobot;
    currentMode = 0;
    SmartDashboard.putString("Drive Mode", "Tank");
  }

  public void switchDrive() {

    if (currentMode == 0) {
      currentMode = 1;
      SmartDashboard.putString("Drive Mode", "Arcade");
    } else {
      currentMode = 0;
      SmartDashboard.putString("Drive Mode", "Tank");
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
      rightValue = stick.getRawAxis(5);
      leftValue = stick.getRawAxis(1);
      robotDrive.tankDrive(leftValue, rightValue);
    } else {
      robotDrive.arcadeDrive(Robot.oi.joystick.getX(), Robot.oi.joystick.getY());
    }
  }

}