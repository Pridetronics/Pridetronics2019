/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.*;
/**
 * Add your docs here.
 */
public class LeftTrigger extends Trigger {
  
  private Joystick stick = new Joystick(1);
  @Override
  public boolean get() {
    if(stick.getRawAxis(3)>0){
      SmartDashboard.putBoolean("Left Trigger Pressed", true);
      return true;
    } else {
      return false;
    }
  }
}
