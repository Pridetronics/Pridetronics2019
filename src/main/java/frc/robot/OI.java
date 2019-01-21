/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.Commands.*;
/**
 * Add your docs here.
 */
public class OI {

    public Joystick joystick;
    public JoystickButton button11;
    public JoystickButton button9;
    public JoystickButton button7;
    public JoystickButton button3;
    public OI(){

        joystick = new Joystick(0); 
//Top level on Rocket
        button7 = new JoystickButton(joystick, 7);
        button7.whenPressed(new RocketBall(83.5));//change when rocketlv3 is made
//Middle level on Rocket
        button9 = new JoystickButton(joystick, 9);
        button9.whenPressed(new RocketBall(55.5));//change when rocketlv2 is made
//Bottom level on Rocket
        button11 = new JoystickButton(joystick, 11);
        button11.whenPressed(new RocketBall(27.5));//keep its gud
//Run lift while held
    button3 = new JoystickButton(joystick, 3);
    button3.whileHeld(new RunLiftUp());
    
    }
    public Joystick getJoystick(){
        return joystick;
    }
}
