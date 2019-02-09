/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class RobotMap {

  public static Joystick joystick; // Creates New Joystick
  public static DifferentialDrive myRobot; // Creates New DriffentialDrive
  public static WPI_TalonSRX leftDriveMotorLead; // Creates New Talon
  public static WPI_TalonSRX leftDriveMotorFollow; // Creates New Talon
  public static WPI_TalonSRX rightDriveMotorLead; // Creates New Talon
  public static WPI_TalonSRX rightDriveMotorFollow; // Creates New Talon
  public static DigitalInput limitSwitchLiftDown;
  public static DigitalInput limitSwitchLiftUp;
  public static Encoder ArmEncoder;
  public static DoubleSolenoid solenoidHatchRelease; // Creates New Solenoid
  public static DoubleSolenoid solenoidRampRelease; // Creates New Solenoid

  // public static CANSparkMax m_motor;

  public static CANSparkMax liftMotor; // Creates New SparkMax Motor for lift
  public static CANEncoder liftEncoder; // Creates New Encoder for lift
  public static Spark wristMotor; // Creates New Spark for wrist

  public static Spark intakeMotorLeft; // Creates New Spark for intake
  public static Spark intakeMotorRight; // Creates New Spark for intake

  public static final int kTimeoutMs = 30;

  public static void init() {

    leftDriveMotorLead = new WPI_TalonSRX(0); // Assigns Leading Left Drive Motor to a Talon
    leftDriveMotorFollow = new WPI_TalonSRX(1); // Assigns Following Left Motor to a Talon
    leftDriveMotorLead.setInverted(false);

    // Tells the Following Left Motor to follow the Leading Left Motor
    leftDriveMotorFollow.follow(leftDriveMotorLead); 
    leftDriveMotorLead.set(0);

    // Turns the Leading Left Motor to an Encoder
    leftDriveMotorLead.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, kTimeoutMs);

    rightDriveMotorLead = new WPI_TalonSRX(2); // Assigns Leading Right Drive Motor to a Talon
    rightDriveMotorFollow = new WPI_TalonSRX(3); // Assigns Following Right Drive Motor to a Talon
    rightDriveMotorLead.setInverted(false);
    // Tells the Following Right Motor to follow the Leading Right Motor
    rightDriveMotorFollow.follow(rightDriveMotorLead); 
    rightDriveMotorLead.set(0);

    // Turns the Leading Left Motor to an Encoder
    rightDriveMotorLead.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, kTimeoutMs);

    // Creates a Differential Drive Object named myRobot
    myRobot = new DifferentialDrive(leftDriveMotorLead, rightDriveMotorLead);
    // LiveWindow.addAcutator("Drive", "robotDrive", myRobot);
    myRobot.setSafetyEnabled(false);
    myRobot.setExpiration(0.1);
    myRobot.setMaxOutput(1.0);

    // lift motors
    liftMotor = new CANSparkMax(4, MotorType.kBrushless); // Assigns Lift Motor to a Spark Max
    liftEncoder = liftMotor.getEncoder();
    // liftMotor.setInverted(false);

    // wrist motors
    wristMotor = new Spark(1); // Assigns Wrist Motor to Spark
    // wristMotor.setInverted(false);

    // limitSwitch
    limitSwitchLiftDown = new DigitalInput(4);
    limitSwitchLiftUp = new DigitalInput(5);

    // Solenoids
    solenoidHatchRelease = new DoubleSolenoid(0, 1);
    solenoidRampRelease = new DoubleSolenoid(2, 3);

    // intake motors
    intakeMotorLeft = new Spark(9);
    // intakeMotor1.setInverted(false);
    intakeMotorRight = new Spark(10);
    // intakeMotor2.setInverted(false);
  }

}