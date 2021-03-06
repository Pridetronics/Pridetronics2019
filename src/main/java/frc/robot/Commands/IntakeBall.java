/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.*;

public class IntakeBall extends Command {

  public IntakeBall() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    SmartDashboard.putBoolean("Intake Running", false);
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    SmartDashboard.putBoolean("Intake Running", true);
    Robot.intake.intake();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    SmartDashboard.putBoolean("Intake Running", false);
    Robot.intake.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
