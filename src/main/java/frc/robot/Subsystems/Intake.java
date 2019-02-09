/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Intake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // Ties Intake Motors to RobotMap
  private final Spark intakeMotorLeft = RobotMap.intakeMotorLeft;
  private final Spark intakeMotorRight = RobotMap.intakeMotorRight;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  public void periodic() {

  }

  public void intake() {
    intakeMotorLeft.set(1); // Tells Left Intake Motor to intake
    intakeMotorRight.set(1); // Tells Right Intake Motor to intake
  }

  public void outtake() {
    intakeMotorLeft.set(-1); // Tells Left Intake Motor to shoot
    intakeMotorRight.set(-1); // Tells Right Intake Motor to shoot
  }
}
