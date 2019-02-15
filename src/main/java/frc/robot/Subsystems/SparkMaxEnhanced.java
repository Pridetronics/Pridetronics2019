/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import com.revrobotics.*;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class SparkMaxEnhanced extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private final CANEncoder liftEncoder = RobotMap.liftEncoder;
  private double initialTicks;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

  }

  public void setOffset() {

    initialTicks = liftEncoder.getPosition();

  }

  public double readEncoder() {
    return liftEncoder.getPosition() - initialTicks;
  }

  // Create a reset for the Ticks
  // Create lift encoder
  // Something that reads the encoder (needs a bit of math)
  // Two methods
  // One to initialize liftTicks
  // Get ticks to read the current encoder and subtract from liftTicks

}
