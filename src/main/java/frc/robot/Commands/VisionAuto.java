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
import frc.robot.OI;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.*;

public class VisionAuto extends CommandGroup {
  public VisionAuto() {
    addSequential(new TurnEncoder(false, Robot.rotationFirst.getDouble(0.0)));
    addSequential(new DriveForward(0.6, Robot.forwardDrive.getDouble(0.0)));
    addSequential(new TurnEncoder(false, Robot.rotationSecond.getDouble(0.0)));
    addSequential(new DriveTeleop());
  }
}