/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.*;
import com.revrobotics.CANEncoder;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.Subsystems.Sensor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
/**
 * Add your docs here.
 */
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class RobotMap {

  public static Joystick joystick;
  public static DifferentialDrive myRobot;
  public static WPI_TalonSRX leftDriveMotorLead;
  public static WPI_TalonSRX leftDriveMotorFollow;
  public static WPI_TalonSRX rightDriveMotorLead;
  public static WPI_TalonSRX rightDriveMotorFollow;
  public static DigitalInput limitSwitchLiftDown;
  public static DigitalInput limitSwitchLiftUp;
  public static Encoder ArmEncoder;
  public static DoubleSolenoid solenoidHatchRelease;
  public static DoubleSolenoid solenoidHatchRelease2;
  public static DoubleSolenoid solenoidRampRelease;

  // public static CANSparkMax m_motor;

  public static CANSparkMax liftMotor;
  public static CANEncoder liftEncoder;
  public static Spark wristMotor;

  public static Victor intakeMotorLead;
  public static Victor intakeMotorFollow;

  public static final int kTimeoutMs = 30;

  public static void init() {

    leftDriveMotorLead = new WPI_TalonSRX(0);

    leftDriveMotorLead.setInverted(true);
    leftDriveMotorLead.set(0);

    leftDriveMotorFollow = new WPI_TalonSRX(1);
    if (leftDriveMotorFollow != null) {
      leftDriveMotorFollow.follow(leftDriveMotorLead);
    }

    leftDriveMotorLead.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, kTimeoutMs);

    rightDriveMotorLead = new WPI_TalonSRX(2);
    rightDriveMotorLead.set(0);

    rightDriveMotorFollow = new WPI_TalonSRX(3);
    if (rightDriveMotorFollow != null) {
      rightDriveMotorFollow.follow(rightDriveMotorLead);
    }

    rightDriveMotorLead.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, kTimeoutMs);

    myRobot = new DifferentialDrive(leftDriveMotorLead, rightDriveMotorLead);
    // LiveWindow.addAcutator("Drive", "robotDrive", myRobot);
    myRobot.setSafetyEnabled(false);
    myRobot.setExpiration(0.1);
    myRobot.setMaxOutput(1.0);

    // lift motors
    liftMotor = new CANSparkMax(4, MotorType.kBrushless);// motor to be determined
    liftEncoder = liftMotor.getEncoder();
    // liftMotor.setInverted(false);

    // wrist motors
    wristMotor = new Spark(1);
    // wristMotor.setInverted(false);

    // limitSwitch
    limitSwitchLiftDown = new DigitalInput(4);
    limitSwitchLiftUp = new DigitalInput(5);

    // Solenoids
    solenoidHatchRelease = new DoubleSolenoid(0, 1);
    solenoidHatchRelease2 = new DoubleSolenoid(2, 3);
    solenoidRampRelease = new DoubleSolenoid(4, 5);

    // intake motors
    intakeMotorLead = new Victor(9);
    // intakeMotor1.setInverted(false);
    intakeMotorFollow = new Victor(10);
    intakeMotorLead = intakeMotorFollow;
    // intakeMotor2.setInverted(false);
  }
}