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

/**
 * Add your docs here.
 */
public class Drive extends Subsystem {

    // public final DifferentialDrive robotDrive;
    private Joystick stick;

    DifferentialDrive robotDrive = RobotMap.myRobot;

    // public Drive() {
    // robotDrive = RobotMap.myRobot;
    // }

    public void initDefaultCommand() {
        setDefaultCommand(new DriveTeleop());
    }

    public void periodic() {

    }

    public void doTeleop(Joystick stick) {
        double rightValue, leftValue;
        rightValue = stick.getRawAxis(5);
        leftValue = stick.getRawAxis(1);
        robotDrive.tankDrive(leftValue, rightValue);
    }

}