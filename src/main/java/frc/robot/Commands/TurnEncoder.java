/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import frc.robot.*;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.*;

public class TurnEncoder extends Command {
  private boolean left;

  private double leftDistance;
  private double rightDistance;

  /*
   * private NetworkTableEntry leftdist; private NetworkTableEntry rightdist;
   */
  public TurnEncoder(boolean left, NetworkTableEntry dist) {

    this.left = left;

    /*
     * this.leftdist = dist; this.rightdist = dist;
     */
    requires(Robot.drive);

  }

  protected void initialize() {
    RobotMap.leftDriveMotorLead.hasResetOccurred();
    RobotMap.rightDriveMotorLead.hasResetOccurred();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (left) {
      RobotMap.myRobot.tankDrive(-.5, .5);
    } else {
      RobotMap.myRobot.tankDrive(.5, -.5);
    }
    System.out.println(RobotMap.leftDriveMotorLead.get());

  }

  // Make this return true when this Command no longer needs to run execute(7)
  @Override
  protected boolean isFinished() {
    // true is left and false is right
    leftDistance = RobotMap.rightDriveMotorLead.get();
    rightDistance = RobotMap.leftDriveMotorLead.get();
    // SmartDashboard.putNumber("leftDistance", leftDistance);
    // SmartDashboard.putNumber("rightDistance", rightDistance);
    /*
     * if (Math.abs(leftDistance) >= leftdist && Math.abs(rightDistance) >=
     * rightdist) { return true; }
     */
    // TODO get the test correct return false;
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    RobotMap.myRobot.stopMotor();

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}