/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.Subsystems.Drive;
import frc.robot.OI;
import frc.robot.Robot;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class VisionAuto extends CommandGroup {
  public VisionAuto() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);

    requires(Robot.drive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //addSequential(new TurnEncoder(false, Robot.rotationFirst.getDouble(0.0)));
    //addSequential(new DriveForward(0.6, Robot.forwardDrive.getDouble(0.0)));
    //addSequential(new TurnEncoder(false, Robot.rotationSecond.getDouble(0.0)));

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    // Drive.tankDrive(leftValue, rightValue);
    // Drive.tankDrive(leftValue, rightValue);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
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
