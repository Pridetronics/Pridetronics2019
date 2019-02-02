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

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.Subsystems.Sensor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.DigitalInput;

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
    public static DigitalInput limitSwitchLift;
    public static Encoder ArmEncoder;
    public static DoubleSolenoid solenoid1;
    public static DoubleSolenoid solenoid2;

    // public static CANSparkMax m_motor;

    public static SpeedController liftMotor;
    public static SpeedController wristMotor;

    public static SpeedController intakeMotor1;
    public static SpeedController intakeMotor2;

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

        /*
         * Encoder Parameters (Digital Source A, Digital Source B, Boolean Reverse
         * Direction, Encoding Type)
         */
        ArmEncoder = new Encoder(7, 6, true, EncodingType.k4X);
        ArmEncoder.setDistancePerPulse(Sensor.DISTANCE_PER_TICK);
        ArmEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
        // LeftArmEncoder.setReverseDirection(true);

        // lift motors
        liftMotor = new CANSparkMax(0, MotorType.kBrushless);// motor to be determined
        liftMotor.setInverted(false);
        // wrist motors
        wristMotor = new WPI_TalonSRX(3);
        wristMotor.setInverted(false);
        // limitSwitch
        limitSwitchLift = new DigitalInput(5);
        // Solenoids
        solenoid1 = new DoubleSolenoid(1, 0);
        solenoid2 = new DoubleSolenoid(2, 3);
        // intake motors
        intakeMotor1 = new WPI_TalonSRX(4);
        intakeMotor1.setInverted(false);
        intakeMotor2 = new WPI_TalonSRX(5);
        intakeMotor2.setInverted(false);
    }

}