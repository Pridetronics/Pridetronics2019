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
    public Joystick gamepad;
    public JoystickButton button1;//OuttakeBall
    public JoystickButton button2;//IntakeBall
    public JoystickButton button3; //CargoBall
    public JoystickButton button4; //WristUp
    public JoystickButton button5; //Hatch Panel in/out
    public JoystickButton button6; //WristDown
    public JoystickButton button7;  //Rocket Ball 3
    public JoystickButton button8;  //Rocket Hatch 3
    public JoystickButton button9;  //Rocket Ball 2
    public JoystickButton button10; //Rocket Hatch 2
    public JoystickButton button11; //Rocket Ball 1
    public JoystickButton button12; //Rocket Hatch 1
   
    
    //InstanceVariables for Ball
    public static final double RocketBallLv1 = 27.5;
    public static final double RocketBallLv2 = 55.5;
    public static final double RocketBallLv3 = 83.5;
    //InstanceVariables for Hatch
    public static final double RocketHatch1 = 19;
    public static final double RocketHatch2 = 47;
    public static final double RocketHatch3 = 75;
    //InstanceVariable for CargoBall
    public static final double CargoBall = 48;
    public OI(){

        joystick = new Joystick(0); 
        gamepad= new Joystick(1);
//Intake and Outtake
        button1 = new JoystickButton(joystick, 2);
        button1.whileHeld(new intakeBall());
        button2 = new JoystickButton(joystick, 1);
        button2.whileHeld(new outtakeBall());
/*
//Cargo ball whenPressed
        button3 = new JoystickButton(joystick, 3);
        button3.whenPressed(new RocketCargo(CargoBall));
//Top level on Rocket
        button7 = new JoystickButton(joystick, 7);
        button7.whenPressed(new RocketCargo(RocketBallLv3));//change when rocketlv3 is made
//Middle level on Rocket
        button9 = new JoystickButton(joystick, 9);
        button9.whenPressed(new RocketCargo(RocketBallLv2));//change when rocketlv2 is made
//Bottom level on Rocket
        button11 = new JoystickButton(joystick, 11);
        button11.whenPressed(new RocketCargo(RocketBallLv1));//keep its gud
//Wrist up whileheld
        button4 = new JoystickButton(joystick, 4);
        button4.whileHeld(new WristUp());
//Wrist down whileheld
        button6 = new JoystickButton(joystick, 6);
        button6.whileHeld(new WristDown());
//Hatch Panel in/out
        button5 = new JoystickButton(joystick, 5);
        button5.whenPressed(new PanelPush());
        button5.whenReleased(new PanelPull());
//Top Hatch on Rocket
        button8 = new JoystickButton(joystick, 8);
        button8.whenPressed(new RocketCargo(RocketHatch3));
//Middle Hatch on Rocket
        button10 = new JoystickButton(joystick, 10);
        button10.whenPressed(new RocketCargo(RocketHatch2));
//Bottom Hatch on Rocket
        button12 = new JoystickButton(joystick, 12);
        button12.whenPressed(new RocketCargo(RocketHatch1));
*/
    }
    public Joystick getJoystick(){
        return joystick;
    }
    public Joystick getGamepad(){
            return gamepad;
    }
}