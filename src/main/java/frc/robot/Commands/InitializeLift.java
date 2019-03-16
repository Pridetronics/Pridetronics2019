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

public class InitializeLift extends CommandGroup {
  /**
   * Add your docs here.
   */
  public InitializeLift() {
    // addSequential(new DisableWristPID());
    addSequential(new LiftUpUntilZeroed());
    addSequential(new ZeroEncoder());
    addSequential(new ZeroWristEncoder2());
    //addSequential(new RunLiftPID(OI.RocketHatch1));
    addSequential(new DriveTeleop());
  }
}
