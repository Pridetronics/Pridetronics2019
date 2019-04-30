/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Commands.*;
import frc.robot.*;
public class StartVision extends CommandGroup {
  public StartVision() {
    Robot.autonomousCommand = new VisionAuto(); 
    Robot.autonomousCommand.start();
  }
}