/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;

import frc.robot.RobotMap;

/**
 * TODO add class description
 */
public class Intake extends Subsystem {

  private final Spark intakeMotorLeft = RobotMap.intakeMotorLeft;
  private final Spark intakeMotorRight = RobotMap.intakeMotorRight;

  @Override
  public void initDefaultCommand() {
  }

  @Override
  public void periodic() {

  }

  public void intake() {
    intakeMotorLeft.set(1);
    intakeMotorRight.set(1);
  }

  public void outtake() {
    intakeMotorLeft.set(-1);
    intakeMotorRight.set(-1);
  }
} // end Intake
