/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import javax.swing.RowFilter.ComparisonType;

import com.revrobotics.*;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.*;

import frc.robot.RobotMap;
import frc.robot.Commands.RunLiftPID;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Wrapper class to make up for CanSoarkMax deficiencies
 */
public class SparkMaxEnhanced extends Subsystem {

  private final CANSparkMax liftMotor;
  private final CANEncoder liftEncoder;
  private final CANPIDController liftPID;
  private double initialTicks;

  public SparkMaxEnhanced(int canAddress, MotorType mt) {

    liftMotor = new CANSparkMax(canAddress, mt);
    liftEncoder = liftMotor.getEncoder();
    liftPID = liftMotor.getPIDController();
    initialTicks = 0.0;

    // dubious here
    // liftPID.setReference(0.0, ControlType.kPosition);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new RunLiftPID(0.0));
  }

  public void setOffset() {
    initialTicks = liftEncoder.getPosition();
  }

  public double readEncoder() {
    return liftEncoder.getPosition() - initialTicks;
  }

  /**
   * set Lift PID reference point
   */
  public void runPID(double setPoint) {
    liftPID.setReference(setPoint, ControlType.kPosition);
  }

  /**
   * plain direct motor speed set
   */
  public void set(double speed) {
    liftMotor.set(speed);
  }

  // Create a reset for the Ticks
  // Create lift encoder
  // Something that reads the encoder (needs a bit of math)
  // Two methods
  // One to initialize liftTicks
  // Get ticks to read the current encoder and subtract from liftTicks

}
