/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

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
    public static DoubleSolenoid solenoid1;
    public static DoubleSolenoid solenoid2;

    // public static CANSparkMax m_motor;

    public static CANSparkMax liftMotor;
    public static Spark wristMotor;

    public static Spark intakeMotor1;
    public static Spark intakeMotor2;

    public static void init() {

        leftDriveMotorLead = new WPI_TalonSRX(0);
        leftDriveMotorFollow = new WPI_TalonSRX(1);
        leftDriveMotorLead.setInverted(false);
        leftDriveMotorFollow.follow(leftDriveMotorLead);
        leftDriveMotorLead.set(0);

        rightDriveMotorLead = new WPI_TalonSRX(2);
        rightDriveMotorFollow = new WPI_TalonSRX(3);
        rightDriveMotorLead.setInverted(false);
        rightDriveMotorFollow.follow(rightDriveMotorLead);
        rightDriveMotorLead.set(0);

        myRobot = new DifferentialDrive(leftDriveMotorLead, rightDriveMotorLead);
        // LiveWindow.addAcutator("Drive", "robotDrive", myRobot);
        myRobot.setSafetyEnabled(false);
        myRobot.setExpiration(0.1);
        myRobot.setMaxOutput(1.0);

        // lift motors
        liftMotor = new CANSparkMax(4, MotorType.kBrushless);// motor to be determined
        // liftMotor.setInverted(false);

        // wrist motors
        wristMotor = new Spark(8);
        // wristMotor.setInverted(false);

        // limitSwitch
        limitSwitchLiftDown = new DigitalInput(4);
        limitSwitchLiftUp = new DigitalInput(5);

        // Solenoids
        solenoid1 = new DoubleSolenoid(1, 0);
        solenoid2 = new DoubleSolenoid(2, 3);

        // intake motors
        intakeMotor1 = new Spark(9);
        // intakeMotor1.setInverted(false);
        intakeMotor2 = new Spark(10);
        // intakeMotor2.setInverted(false);
    }

}