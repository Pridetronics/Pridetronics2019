/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.networktables.NetworkTableEntry;

public class DriveForward extends Command {
  private Double m_speed;
  private NetworkTableEntry m_distance;

  public DriveForward(Double Speed, NetworkTableEntry Distance) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    m_speed = Speed;
    m_distance = Distance;

    requires(Robot.drive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    RobotMap.leftDriveMotorLead.hasResetOccurred();
    RobotMap.rightDriveMotorLead.hasResetOccurred();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (RobotMap.leftDriveMotorLead.hasResetOccurred()) {
      return true;
    }

    if (RobotMap.rightDriveMotorLead.hasResetOccurred()) {
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
