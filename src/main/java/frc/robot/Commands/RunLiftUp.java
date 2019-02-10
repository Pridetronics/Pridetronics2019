/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DigitalInput;

import frc.robot.RobotMap;
import frc.robot.Robot;
//  TODO  needed? import frc.robot.Subsystems.Lift;

/**
 * TODO add class description here
 */
public class RunLiftUp extends Command {

  // TODO is bottom limit switch needed
  public final DigitalInput limitSwitchLiftDown = RobotMap.limitSwitchLiftDown;
  public final DigitalInput limitSwitchLiftUp = RobotMap.limitSwitchLiftUp;

  public RunLiftUp() {

    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.lift);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.lift.up();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false; // TODO when does this stop?
  }

  // Called once after isFinished returns true
  @Override
  protected void end() { // TODO Needs to stop
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() { // TODO Needs to stop
  }
} // end class RunLiftUp
