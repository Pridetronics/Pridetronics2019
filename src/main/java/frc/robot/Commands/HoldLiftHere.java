/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.RobotMap;
import com.revrobotics.CANPIDController;
import com.revrobotics.ControlType;

/**
 * Add your docs here.
 */
public class HoldLiftHere extends InstantCommand {
  /**
   * Add your docs here.
   */

   double here;
   private final static CANPIDController m_pidController = RobotMap.m_pidController;


  public HoldLiftHere() {
    super();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {

    here = RobotMap.liftEncoder.getPosition();
    m_pidController.setReference(here, ControlType.kPosition);


  }

}
