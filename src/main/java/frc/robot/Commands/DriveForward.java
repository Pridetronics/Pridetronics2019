/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.RobotDrive;
import com.ctre.phoenix.ParamEnum;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class DriveForward extends Command {
  private Double m_speed;
  private Double m_distance;
  boolean hardstop = false;

  public DriveForward(Double Speed, Double Distance) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    m_speed = Speed;
    m_distance = Distance;

    requires(Robot.drive);
    RobotMap.myRobot.tankDrive(0.0, 0.0);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    RobotMap.leftDriveMotorLead.set(ControlMode.PercentOutput, 0);
    RobotMap.rightDriveMotorLead.set(ControlMode.PercentOutput, 0);
    hardstop = false;

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    RobotMap.myRobot.tankDrive(m_speed, m_speed);
    // m_distance -= m_speed;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (0 >= m_distance || hardstop) {
      return true;
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
