/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.*;
import frc.robot.Subsystems.*;
import frc.robot.Commands.*;
import frc.robot.*;
import edu.wpi.first.wpilibj.Joystick.AxisType;

/**
 * Add your docs here.
 */
public class DriveTeleop extends Command {

  private Joystick stick;

  // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
  // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
  // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR

  public DriveTeleop() {
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTO
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    requires(Robot.drive);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    this.setInterruptible(true);
    this.setRunWhenDisabled(false);

  }
  // Called just before this Command runs the first time

  @Override

  protected void initialize() {

    stick = Robot.oi.getGamepad();
    stick.setAxisChannel(AxisType.kX, 0);
    stick.setAxisChannel(AxisType.kY, 1);

    // RobotMap.pneuCompressor.start();
  }

  // Called repeatedly when this Command is scheduled to run

  @Override

  protected void execute() {

    stick = Robot.oi.getGamepad();
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
}
