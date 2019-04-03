/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.*;
import frc.robot.Robot;

/**
 * Add your docs here.
 */

 public class Logger extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  public static double TimeStamp;
  public static double ModifiedTimeStamp;
  public static PowerDistributionPanel pdp = new PowerDistributionPanel();
  //PowerDistributionPanel pdp = new PowerDistributionPanel();
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public static void sendVoltage() {
    double voltage = pdp.getVoltage();
    SmartDashboard.putNumber("Voltage of the Robot", voltage);
  }

  public static void sendCurrent() {
    double current0 = pdp.getCurrent(0);
    double current1 = pdp.getCurrent(1);
    double current5 = pdp.getCurrent(5);
    double current6 = pdp.getCurrent(6);
    double current12 = pdp.getCurrent(12);
    double current13 = pdp.getCurrent(13);
    double current14 = pdp.getCurrent(14);
    double current15 = pdp.getCurrent(15);

    SmartDashboard.putNumber("Spark Max Current", current0);
    SmartDashboard.putNumber("Lift Current", current1);
    SmartDashboard.putNumber("Intake", current5);
    SmartDashboard.putNumber("Wrist", current6);
    SmartDashboard.putNumber("Left Front", current12);
    SmartDashboard.putNumber("Left Back", current13);
    SmartDashboard.putNumber("Rightt Front", current14);
    SmartDashboard.putNumber("Right Back", current15);
  }

  public static void sendTotalCurrent() {
    double totalcurrentofpdp = pdp.getTotalCurrent();
    SmartDashboard.putNumber("TotalCurrent", totalcurrentofpdp);
  }

  public static double sendFPGATimestamp() {
    TimeStamp = Timer.getFPGATimestamp();
    ModifiedTimeStamp = TimeStamp - Robot.DisabledTime;
    return ModifiedTimeStamp;
  }
}
