/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.Commands.DriveTeleop;

/**
 * Add your docs here.
 */
public class Drive extends Subsystem {

    private final WPI_TalonSRX leftDriveMotorLead; // Creates Leading Left Drive Talon
    private final WPI_TalonSRX leftDriveMotorFollow; // Creates Following Left Drive Talon

    private final WPI_TalonSRX rightDriveMotorLead; // Creates Leading Right Drive Talon
    private final WPI_TalonSRX rightDriveMotorFollow; // Creates Following Right Drive Talon

    public final DifferentialDrive robotDrive; // Creates New Differential Drive
    private Joystick stick; // Creates New Joystick

    public NetworkTable table; // Creates New NetworkTable
    public NetworkTableEntry rotationFirst; // Creates New NetworkTableEntry
    public NetworkTableEntry forwardDrive; // Creates New NetworkTableEntry
    public NetworkTableEntry rotationSecond; // Creates New NetworkTableEntry

    public Drive() {

        // Ties Talons To RobotMap
        rightDriveMotorLead = RobotMap.rightDriveMotorLead;
        rightDriveMotorFollow = RobotMap.rightDriveMotorFollow;

        leftDriveMotorLead = RobotMap.leftDriveMotorLead;
        leftDriveMotorFollow = RobotMap.leftDriveMotorFollow;

        // Ties DifferentialDrive to RobotMap
        robotDrive = RobotMap.myRobot;
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DriveTeleop()); // Sets Drive Teleop as Default Command
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
        rightValue = stick.getRawAxis(5); // Assigns Right Value to an Axis
        leftValue = stick.getRawAxis(1); // Assigns Left Value to an Axis
        robotDrive.tankDrive(leftValue, rightValue); // Gives DifferentialDrive Values
    }

}