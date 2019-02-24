/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.smartdashboard.*;

import frc.robot.Robot;
import frc.robot.Robot.*;

/**
 * Zero the lift encoder by reading encoder and saving as the offset
 */
public class ZeroEncoder extends InstantCommand {

  public ZeroEncoder() {
    super();
  }

  @Override
  protected void initialize() {
    SmartDashboard.putString("Autonomous", "Zeroing Encoder");
    Robot.lift.setOffset();
  }

}
