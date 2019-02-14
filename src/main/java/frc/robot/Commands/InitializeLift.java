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
import edu.wpi.first.wpilibj.smartdashboard.*;

public class InitializeLift extends CommandGroup {
  /**
   * Add your docs here.
   */
  public InitializeLift() {
    SmartDashboard.putString("Autonomous", "1");
    addSequential(new RunLiftDown());
    SmartDashboard.putString("Autonomous", "2");
    addSequential(new TimedCommand(0.5));
    SmartDashboard.putString("Autonomous", "3");
    addSequential(new ZeroEncoder());
    SmartDashboard.putString("Autonomous", "4");
    addSequential(new RocketCargo(OI.RocketHatch1));
    SmartDashboard.putString("Autonomous", "5");
    addSequential(new DriveTeleop());
    SmartDashboard.putString("Autonomous", "6");
  }
}
