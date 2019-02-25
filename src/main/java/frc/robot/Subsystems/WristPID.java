/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Subsystems.*;
import frc.robot.Commands.*;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Encoder;

/**
 * Add your docs here.
 */
public class WristPID extends PIDSubsystem {
  /**
   * Add your docs here.
   */
  Encoder arm = RobotMap.ArmEncoder;
  private final Victor wristMotor = RobotMap.wristMotor;

  public WristPID() {
    // Intert a subsystem name and PID values here
    super("Wrist", .25, 0.0, 0.0);
    setAbsoluteTolerance(0.2);
    getPIDController().setContinuous(false);
    
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return arm.getDistancePerPulse();
    //return 1;//Robot.WristEncoder.readEncoder();
  }

  /*public void setPoint(double set) {
    this.setSetpoint(set);
  }*/

  @Override
  protected void usePIDOutput(double output) {
    wristMotor.set(output);
  }
}
