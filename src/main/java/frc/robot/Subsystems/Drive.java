/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.*;
import frc.robot.Commands.*;
import frc.robot.OI;
import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.Robot;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;

/**
 * Add your docs here.
 */
public class Drive extends Subsystem {

    private final WPI_TalonSRX leftDriveMotorLead;
    private final WPI_TalonSRX leftDriveMotorFollow;

    private final WPI_TalonSRX rightDriveMotorLead;
    private final WPI_TalonSRX rightDriveMotorFollow;

    public final DifferentialDrive robotDrive;
    private Joystick stick;

    public NetworkTable table;
    public NetworkTableEntry rotationFirst;
    public NetworkTableEntry forwardDrive;
    public NetworkTableEntry rotationSecond;

    public Drive() {
        rightDriveMotorLead = RobotMap.rightDriveMotorLead;
        rightDriveMotorFollow = RobotMap.rightDriveMotorFollow;

        leftDriveMotorLead = RobotMap.leftDriveMotorLead;
        leftDriveMotorFollow = RobotMap.leftDriveMotorFollow;

        robotDrive = RobotMap.myRobot;
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DriveTeleop());
    }

    public void periodic() {
        rotationFirst = table.getEntry("rot1"); 
        forwardDrive = table.getEntry("fwd"); 
        rotationSecond = table.getEntry("rot2"); 
        
        rotationFirst.getDouble(0.0);
        forwardDrive.getDouble(0.0); 
        rotationSecond.getDouble(0.0);
    }

    public void doTeleop(Joystick stick) {
        double rightValue, leftValue;
        rightValue = stick.getRawAxis(5);
        leftValue = stick.getRawAxis(1);
        robotDrive.tankDrive(leftValue, rightValue);
    }

}