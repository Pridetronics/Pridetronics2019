/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

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
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMaxLowLevel.*;
/**
 * Add your docs here.
 */
import edu.wpi.first.wpilibj.DoubleSolenoid;
public class RobotMap {

    public static Joystick joystick;
    public static DifferentialDrive myRobot;
    public static WPI_TalonSRX leftDriveMotor;
    public static WPI_TalonSRX rightDriveMotor;
    public static WPI_TalonSRX leftDriveMotor1;
    public static WPI_TalonSRX rightDriveMotor1;
    public static DigitalInput lowerLimitSwitchLift;
    public static DigitalInput upperLimitSwitchLift;
    public static Encoder ArmEncoder;
    public static DoubleSolenoid solenoid1;
    public static DoubleSolenoid solenoid2;


    public static SpeedController liftMotor;
    public static SpeedController wristMotor;

    public static SpeedController intakeMotor1;
    public static SpeedController intakeMotor2;
    public static final CANSparkMaxLowLevel.MotorType kBrushless = MotorType.kBrushless;
    public static void init() {

        leftDriveMotor = new WPI_TalonSRX(2);
        leftDriveMotor.setInverted(false);
        //leftDriveMotor.set(0);
        leftDriveMotor1 = new WPI_TalonSRX(3);
        leftDriveMotor1.follow(leftDriveMotor);

        rightDriveMotor = new WPI_TalonSRX(0);
        rightDriveMotor.setInverted(false);
        //rightDriveMotor.set(0);
        rightDriveMotor1 = new WPI_TalonSRX(1);
        rightDriveMotor1.follow(rightDriveMotor);

        myRobot = new DifferentialDrive(leftDriveMotor, rightDriveMotor);
       // LiveWindow.addAcutator("Drive", "robotDrive", myRobot);
        myRobot.setSafetyEnabled(false);
        myRobot.setExpiration(0.1);
        myRobot.setMaxOutput(1.0);

        /*
 * Encoder Parameters (Digital Source A, Digital Source B, Boolean Reverse Direction, Encoding Type) 
 */ 
    ArmEncoder = new Encoder(7, 6, true, EncodingType.k4X);
    ArmEncoder.setDistancePerPulse(Sensor.DISTANCE_PER_TICK);
    ArmEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
    //LeftArmEncoder.setReverseDirection(true);

//lift motors
    liftMotor = new CANSparkMax(2 , MotorType.kBrushless);// motor to be determined
    liftMotor.setInverted(false);
//wrist motors
    wristMotor = new WPI_TalonSRX(3);
    wristMotor.setInverted(false);
//limitSwitch
    lowerLimitSwitchLift = new DigitalInput(5);
    upperLimitSwitchLift = new DigitalInput(9);
    //Solenoids
    solenoid1 = new DoubleSolenoid(1, 0);
    solenoid2 = new DoubleSolenoid(2, 3);
//intake motors
    intakeMotor1 = new WPI_TalonSRX(4);
    intakeMotor1.setInverted(false);
    intakeMotor2 = new WPI_TalonSRX(5);
    intakeMotor2.setInverted(false);
    }
    
}