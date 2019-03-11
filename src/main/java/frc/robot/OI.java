/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.GamepadBase;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Commands.*;

/**
 * Add your docs here.
 */
public class OI {

  public Joystick joystick;
  public Joystick gamepad;
  public JoystickButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15;
  public JoystickButton gamepadButton8;
  public JoystickButton TestButton; // Lift down


  // InstanceVariables for Ball
  public static final double RocketBallLv1 = 27.5;
  public static final double RocketBallLv2 = 55.5;
  public static final double RocketBallLv3 = 83.5;
  // InstanceVariables for Hatch
  public static final double RocketHatch1 = 0;
  public static final double RocketHatch2 = 37.5;
  public static final double RocketHatch3 = 65.5;
  // InstanceVariable for CargoBall
  public static final double CargoBall = 48;
  //InstanceVariables for Wrist
  //public static final double Wrist = Math.PI/2;

  public static final double HatchPosition = 0;
  public static final double ShootPosition = -55;
  public static final double IntakePosition = -90;

  private double value;
  private Joystick Stick;

  public OI() {

    joystick = new Joystick(0);
    gamepad = new Joystick(1);

    // Intake and Outtake
    
    Triggers right = new Triggers(gamepad, 2);
    right.whileActive(new IntakeBall());
    right.close();
    Triggers left = new Triggers(gamepad, 3);
    left.whileActive(new EjectBall());
    left.close();

    /*
    button13 = new JoystickButton(joystick, 1);
    button13.whileHeld(new RunLiftUp());
    button14 = new JoystickButton(joystick, 2);
    button14.whileHeld(new RunLiftDown());
    */

    // Cargo ball whenPressed
    button1 = new JoystickButton(joystick, 1);
    button1.whileHeld(new RunLiftUp());

    button2 = new JoystickButton(joystick, 2);
    button2.whileHeld(new RunLiftDown());


    button10 = new JoystickButton(joystick, 7);
    button10.whenPressed(new RunLiftPID(RocketBallLv3));

    button11 = new JoystickButton(joystick, 8);
    button11.whenPressed(new RunLiftPID(RocketHatch3));

    button12 = new JoystickButton(joystick, 9);
    button12.whenPressed(new RunLiftPID(RocketBallLv2));

    button13 = new JoystickButton(joystick, 10);
    button13.whenPressed(new RunLiftPID(RocketHatch2));

    button14 = new JoystickButton(joystick, 11);
    button14.whenPressed(new RunLiftPID(RocketBallLv1));

    button15 = new JoystickButton(joystick, 12);
    button15.whenPressed(new RunLiftPID(RocketHatch1));

    
    // Wrist up whileheld
    button4 = new JoystickButton(gamepad, 2);
    button4.whenPressed(new WristTo(HatchPosition));
    
    button6 = new JoystickButton(gamepad, 1);
    button6.whenPressed(new WristTo(IntakePosition));
    
    button6 = new JoystickButton(gamepad, 4);
    button6.whenPressed(new WristTo(ShootPosition));
    
    // Hatch Panel in/out
    button5 = new JoystickButton(joystick, 5);
    button5.whenPressed(new PushPanel());
    
    // Top Hatch on Rocket
    gamepadButton8 = new JoystickButton(gamepad, 8);
    //gamepadButton8.whenPressed(new SwitchDriveMode());

    button5 = new JoystickButton(gamepad, 5);
    button5.whenPressed(new RampRelease());

    TestButton = new JoystickButton(gamepad, 9);
    TestButton.whenPressed(new TestZeroWristEncoder());
  }

  public Joystick getJoystick() {
    return joystick;
  }

  public Joystick getGamepad() {
    return gamepad;
  }
}