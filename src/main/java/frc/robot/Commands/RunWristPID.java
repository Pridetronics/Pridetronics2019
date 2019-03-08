/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.RobotMap;
import com.revrobotics.ControlType;
/**
 * Add your docs here.
 */
public class RunWristPID extends InstantCommand {
  /**
   * Add your docs here.
   */
  private double setpoint;
  public RunWristPID(double s) {
    super();
    s = setpoint;
    // Use requires() here to declare subsystem dependencies
    requires(Robot.wrist);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
  }

}