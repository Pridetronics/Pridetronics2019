/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Subsystems.Lift;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.Subsystems.*;

/*
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
*/


public class RocketCargo extends Command {

    private double distance;
    
    
  public double scale = 1.0;

  public RocketCargo(double d) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.distance = d * scale;
    
    // SmartDashboard.putNumber("d", d);

    requires(Robot.lift);

  }

  // Make a method to make the lift go up and down
  // How to figure out the distance traveled in the speed

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    SmartDashboard.putString("Autonomous", "Rocket Cargo");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    SmartDashboard.putNumber("distance", this.distance);

    

    //Robot.liftPID.enable();
    //Robot.liftPID.setPoint(distance);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    /*SmartDashboard.putNumber("current ticks", Robot.liftEncoder.readEncoder());
    if (Robot.liftEncoder.readEncoder() > this.distance) {
      Robot.lift.stop();
      return true;
    }*/
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.lift.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}