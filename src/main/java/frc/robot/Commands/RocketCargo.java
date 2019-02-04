/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Subsystems.Lift;
import edu.wpi.first.wpilibj.Encoder;


public class RocketCargo extends Command {
  private Encoder ArmEncoder;
  private double distance;
  public RocketCargo(double distance) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.distance = distance;
    requires(Robot.lift);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    ArmEncoder = Robot.lift.getArmEncoder();
    ArmEncoder.reset();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.lift.up();
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(ArmEncoder.getDistance() == distance){
      return true;
    } else{
      return false;
    }
    
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
*/