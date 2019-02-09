/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // Ties Motors to RobotMap
  private final CANSparkMax liftMotor = RobotMap.liftMotor;
  private final DigitalInput limitSwitchLiftDown = RobotMap.limitSwitchLiftDown;
  private final DigitalInput limitSwitchLiftUp = RobotMap.limitSwitchLiftUp;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  public void periodic() {
    // Put code here to be run every loop

  }

  public void up() {
    liftMotor.set(1); // Sets liftMotor to up
  }

  public void upSpeed(double speed) {
    liftMotor.set(speed); // Sets liftMotor Speed
  }

  public void stallAtTop() {
    liftMotor.set(0.2); // Sets liftMotor to slow down at the top
  }

  public void down() {
    liftMotor.set(-.55); // Sets liftMotor to down
  }

  public void stop() {
    liftMotor.set(0); // Sets liftMotor to stop
  }

  public Encoder getArmEncoder() {
    return RobotMap.ArmEncoder;
  }

  public boolean limitSwitchOpen() {
    return !limitSwitchLiftDown.get();
  }

  public boolean limitSwitchClose() {
    return !limitSwitchLiftUp.get();
  }
}
