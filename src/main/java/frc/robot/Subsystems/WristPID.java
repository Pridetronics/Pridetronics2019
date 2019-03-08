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

import edu.wpi.first.wpilibj.smartdashboard.*;
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
    super("Wrist", .06, 0, 0);
    setAbsoluteTolerance(0.05);

    setInputRange(-1024, 1024);
    setOutputRange(-.5, .5);
    
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
    return -wristEncoder.getDistance();
  }

  public void setPoint(double set) {
    this.setSetpoint(set);
  }

  @Override
  protected void usePIDOutput(double output) {
    // if true, limit is pressed
    SmartDashboard.putNumber("Wrist Output", output);
    if (!RobotMap.wristLimitUp.get() && (output > 0)) {
      wristMotor.set(output);
    } else if (!RobotMap.wristLimitDown.get() && (output < 0)) {
      wristMotor.set(output);
    } else {
      wristMotor.set(0);
    }
  }

  public void up(double Speed) {
    this.disable();
    if (Speed > 1) {
      Speed = 1;
    }
    if (Speed < 0) {
      Speed = 0;
    }

    if (!RobotMap.wristLimitUp.get()) {
      wristMotor.set(Speed);

    } else {
      wristMotor.set(0);
    }
  }

  public void down(double Speed) {
    this.disable();
    if (Speed > 0) {
      Speed = 0;
    }
    if (Speed < -1) {
      Speed = -1;
    }

    if (!RobotMap.wristLimitDown.get()) {
      wristMotor.set(Speed);

    } else {
      wristMotor.set(0);
    }
  }

  public void zeroWristEncoder(){
    wristEncoder.reset();
  }

  public boolean limitWristUp() {
    return wristLimitUp.get();
  }

  public boolean limitWristDown() {
    return wristLimitDown.get();
  }
}
