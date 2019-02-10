/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import frc.robot.Subsystems.*;
import frc.robot.*;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.Joystick.AxisType;

/**
 * TODO add class descriprion
 * 
 * here.
 */
public class DriveTeleop extends Command {

  private Joystick stick;

  public DriveTeleop() {

    requires(Robot.drive);

    this.setInterruptible(true);
    this.setRunWhenDisabled(false);

  }
  // Called just before this Command runs the first time

  @Override
  protected void initialize() {

    stick = Robot.oi.getGamepad(); // TODO change control style here
    stick.setAxisChannel(AxisType.kX, 0);
    stick.setAxisChannel(AxisType.kY, 1);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    stick = Robot.oi.getGamepad(); // TODO change control style here
    Robot.drive.doTeleop(stick);
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

    end();

  }
} // end DriveTeleop
