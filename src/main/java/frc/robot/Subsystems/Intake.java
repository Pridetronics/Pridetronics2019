/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * Add your docs here.
 */
public class Intake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  public void periodic() {

  }

  public void intake() {
    RobotMap.intakeMotorLeft.set(1);
    RobotMap.intakeMotorRight.set(1);
  }

  public void outtake() {
    RobotMap.intakeMotorLeft.set(-1);
    RobotMap.intakeMotorRight.set(-1);
  }
}
