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
/**
 * Add your docs here.
 */
public class RobotMap {

    public static Joystick joystick;
    public static DifferentialDrive myRobot;
    public static SpeedController leftDriveMotor;
    public static SpeedController rightDriveMotor;
    public static DigitalInput limitSwitchLift;
    public static Encoder ArmEncoder;
    

    public static SpeedController manipulatorMotor;

    public static void init() {

        leftDriveMotor = new WPI_TalonSRX(1);
        leftDriveMotor.setInverted(false);
        //leftDriveMotor.set(0);

        rightDriveMotor = new WPI_TalonSRX(0);
        rightDriveMotor.setInverted(false);
        //rightDriveMotor.set(0);

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


    manipulatorMotor = new WPI_TalonSRX(2);// motor to be determined
    manipulatorMotor.setInverted(false);

    limitSwitchLift = new DigitalInput(5);
    }
    
}