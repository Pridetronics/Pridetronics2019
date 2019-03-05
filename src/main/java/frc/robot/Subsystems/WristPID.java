/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Subsystems.*;
import frc.robot.Commands.*;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMSpeedController;

/**
 * Add your docs here.
 */
public class WristPID extends PIDSubsystem {
  /**
   * Add your docs here.
   */

   private final Encoder wristEncoder = RobotMap.wristEncoder;
   private final PWMSpeedController wristMotor = RobotMap.wristMotor;
   private final DigitalInput wristLimitUp = RobotMap.wristLimitUp;
   private final DigitalInput wristLimitDown = RobotMap.wristLimitDown;

  public WristPID() {
    // Intert a subsystem name and PID values here
    super("Wrist", .2, 0.0, 0.0);
    setAbsoluteTolerance(0.2);

    setInputRange(0, 1024);
    setOutputRange(-1, 1);
    
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
    return -wristEncoder.get();
  }

  public void setPoint(double set) {
    this.setSetpoint(set);
  }

  @Override
  protected void usePIDOutput(double output) {

    wristMotor.set(output);
  }

  public boolean limitWristUp(){
    return wristLimitUp.get();
  }

  public boolean limitWristDown(){
    return wristLimitDown.get();
  }
}
