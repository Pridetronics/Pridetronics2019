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
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * Main class that ties robot to the code
 */
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
  public static DoubleSolenoid solenoidRampRelease;


  public static Victor wristMotor; // Creates new Victor motor for Wrist
  public static Victor intakeMotorLead; // Creates new Victor for Intake
  // public static Victor intakeMotorFollow;

  public static CANSparkMax liftMotor; // Creates new CanSparkMAX motor for Lift

  public static CANEncoder liftEncoder; // Creates new CANEncoder for Lift

  public static final int kTimeoutMs = 30;

  public static void init() {

    leftDriveMotorLead = new WPI_TalonSRX(0); // Assigns Leading Left Drive Motor to Talon #0
    leftDriveMotorLead.setInverted(true); // Inverts Leading Left Drive Motor
    leftDriveMotorLead.set(0); // Sets speed to 0 (anywhere between -1 and 1)

    leftDriveMotorFollow = new WPI_TalonSRX(1); // Assigns Following Left Drive Motor to Talon #1
    leftDriveMotorFollow.setInverted(true); // Inverts Following Left Drive Motor
    
    // Makes the Following Left Drive Motor to follow the Leading left Drive Motor
    leftDriveMotorFollow.follow(leftDriveMotorLead);
    // Converts Leading left Drive Motor to an Encoder
    leftDriveMotorLead.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, kTimeoutMs);

    rightDriveMotorLead = new WPI_TalonSRX(2); // Assigns Leading Right Drive Motor to Talon #2
    rightDriveMotorLead.setInverted(true); // Inverts Leading Right Drive Motor
    rightDriveMotorLead.set(0); // Sets speed to 0 (anywhere between -1 and 1)

    rightDriveMotorFollow = new WPI_TalonSRX(3); // Assigns Following Right Drive Motor to Talon #3
    rightDriveMotorFollow.setInverted(true); // Inverts Following Left Drive Motor

    // Makes the Following Right Drive Motor to follow the Leading Right Drive Motor
    rightDriveMotorFollow.follow(rightDriveMotorLead);
    // Converts Leading Right Drive Motor to an Encoder
    rightDriveMotorLead.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, kTimeoutMs);

    // Assigns myRobot To a new Differential Drive Object that uses The Leading
    // Motors
    myRobot = new DifferentialDrive(leftDriveMotorLead, rightDriveMotorLead);
    // LiveWindow.addAcutator("Drive", "robotDrive", myRobot);
    myRobot.setSafetyEnabled(false);
    myRobot.setExpiration(0.1);
    myRobot.setMaxOutput(1.0);

    // lift motors
    liftMotor = new CANSparkMax(4, MotorType.kBrushless);// motor to be
    // determined
    liftEncoder = liftMotor.getEncoder();

    // Lift Motor to a new CANSparkMAX object
    liftMotor = new CANSparkMax(4, MotorType.kBrushless);
    liftEncoder = liftMotor.getEncoder();
    // liftMotor.setInverted(false);

    // wrist motors

    // Wrist Motor to a new Victor Object
    wristMotor = new Victor(0);
    // wristMotor.setInverted(false);

    // limitSwitch

    // Limit Switch to new Digital input objects
    limitSwitchLiftDown = new DigitalInput(4);
    limitSwitchLiftUp = new DigitalInput(5);

    // Solenoids

    // Solenoids Hatch and Ramp to new Double Solenoid objects
    solenoidHatchRelease = new DoubleSolenoid(0, 1);
    // solenoidHatchRelease2 = new DoubleSolenoid(2, 3);
    solenoidRampRelease = new DoubleSolenoid(4, 5);

    // intake motors

    // Intake Motor to a new Victor Object
    intakeMotorLead = new Victor(1);
    // intakeMotor1.setInverted(false);
    // intakeMotorFollow = new Victor(1);
    // intakeMotor2.setInverted(false);
  }
}