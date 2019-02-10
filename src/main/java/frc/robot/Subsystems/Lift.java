/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;

import com.revrobotics.CANSparkMax;

import frc.robot.RobotMap;

/**
 *  TODO need to review imports
 */
//import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.Spark;
//import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Encoder;

import com.revrobotics.CANSparkMax;

/**
 * TODO add class description
 */
public class Lift extends Subsystem {

  private final CANSparkMax liftMotor = RobotMap.liftMotor;
  private final DigitalInput limitSwitchLiftDown = RobotMap.limitSwitchLiftDown;
  private final DigitalInput limitSwitchLiftUp = RobotMap.limitSwitchLiftUp;

  @Override
  public void initDefaultCommand() {
  }

  @Override
  public void periodic() {
  }

  public void up() {
    liftMotor.set(1);
  }

  public void upSpeed(double speed) {
    liftMotor.set(speed);
  }

  public void stallAtTop() {
    liftMotor.set(0.2);
  }

  public void down() {
    liftMotor.set(-.55);
  }

  public void stop() {
    liftMotor.set(0);
  }

  public Encoder getArmEncoder() {
    return RobotMap.ArmEncoder;
  }

  // TODO there are two limit switches
  public boolean limitSwitchOpen() {
    return !limitSwitchLiftDown.get();
  }
}
