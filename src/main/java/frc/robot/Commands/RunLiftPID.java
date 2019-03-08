/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.RobotMap;
import com.revrobotics.ControlType;

import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMax.*;
import com.revrobotics.CANSparkMaxLowLevel.*;
/**
 * Add your docs here.
 */
public class RunLiftPID extends InstantCommand {
  /**
   * Add your docs here.
   */
  double rotations;
  private final static CANPIDController m_pidController = RobotMap.m_pidController;
  public RunLiftPID(double r) {
    super();
    rotations = r;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    m_pidController.setReference(rotations, ControlType.kPosition);
  }

}
