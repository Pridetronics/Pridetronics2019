/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * Add your docs here.
 */
public class PushPanel extends InstantCommand {
  /**
   * Add your docs here.
   */
  public PushPanel() {
    super();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    Robot.panelDir = !Robot.panelDir;
    
    if (Robot.panelDir) {
      Robot.pneumatics.releaseHatch();
    } else {
      Robot.pneumatics.retractHatch();
    }
  }

}
