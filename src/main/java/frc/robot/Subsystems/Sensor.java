/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Sensor extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static double ENCODER_TICKS_PER_REVOLUTION = 360;
  public static double DIAMETER = 4;
  public static double DISTANCE_PER_TICK = (DIAMETER * Math.PI) / ENCODER_TICKS_PER_REVOLUTION;
  public static double ARM_LENGTH = 12;
  public static double DISTANCE_PER_DEGREE = (ARM_LENGTH * Math.PI) / ENCODER_TICKS_PER_REVOLUTION;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
