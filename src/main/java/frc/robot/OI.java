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
import frc.robot.Subsystems.Wrist;

/**
 * Add your docs here.
 */
public class OI {

  public Joystick leftJoystick;
  public Joystick rightJoystick;
  public Joystick gamepad;
  public JoystickButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button10,
      button11, button12, button13, button14, button15, button16;
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
  // public static final double CargoHatch = 27.55;
  public static final double CargoBallCargo = 48.25;
  // InstanceVariables for Wrist
  // public static final double Wrist = Math.PI/2;

  public static final double HatchPosition = 0;
  public static final double ShootPosition = -55;
  public static final double IntakePosition = -100;

  private double value;
  private Joystick Stick;

  public OI() {

    leftJoystick = new Joystick(0); // Left Joystick
    rightJoystick = new Joystick(2); // Right Joystick
    gamepad = new Joystick(1); // Gamepad

    // Joystick
    button1 = new JoystickButton(leftJoystick, 1);
    button1.whileHeld(new RunLiftUp());

    button2 = new JoystickButton(leftJoystick, 2);
    button2.whileHeld(new RunLiftDown());

    button3 = new JoystickButton(leftJoystick, 3);
    button3.whenPressed(new RunLiftPID(CargoBallCargo));

    button4 = new JoystickButton(leftJoystick, 4);
    button4.whileHeld(new WristDown());

    // Ramp Button
    button5 = new JoystickButton(leftJoystick, 5);
    button5.whenPressed(new RampRelease());

    button6 = new JoystickButton(leftJoystick, 6);
    button6.whileHeld(new WristUp());

    button7 = new JoystickButton(leftJoystick, 7);
    button7.whenPressed(new RunLiftPID(RocketBallLv3));

    button8 = new JoystickButton(leftJoystick, 8);
    button8.whenPressed(new RunLiftPID(RocketHatch3));

    button9 = new JoystickButton(leftJoystick, 9);
    button9.whenPressed(new RunLiftPID(RocketBallLv2));

    button10 = new JoystickButton(leftJoystick, 10);
    button10.whenPressed(new RunLiftPID(RocketHatch2));

    button11 = new JoystickButton(leftJoystick, 11);
    button11.whenPressed(new RunLiftPID(RocketBallLv1));

    // Rocket Hatch position 1 and Cargo Ship Position 1 are on the same button
    button12 = new JoystickButton(leftJoystick, 12);
    button12.whenPressed(new RunLiftPID(RocketHatch1));

    // Gamepad

    button13 = new JoystickButton(gamepad, 1);
    button13.whenPressed(new WristTo(IntakePosition));

    button14 = new JoystickButton(gamepad, 2);
    button14.whenPressed(new WristTo(HatchPosition));

    button14 = new JoystickButton(gamepad, 4);
    button14.whenPressed(new WristTo(ShootPosition));

    // Unused Button-- To be fixed
    button15 = new JoystickButton(gamepad, 5);

    // Hatch Panel in/out
    button16 = new JoystickButton(gamepad, 6);
    button16.whenPressed(new PushPanel());

    // Top Hatch on Rocket
    gamepadButton8 = new JoystickButton(gamepad, 8);
    gamepadButton8.whenPressed(new SwitchDriveMode());

    TestButton = new JoystickButton(gamepad, 9);
    TestButton.whenPressed(new TestZeroWristEncoder());

    Triggers right = new Triggers(gamepad, 2);
    right.whileActive(new EjectBall());
    right.close();
    Triggers left = new Triggers(gamepad, 3);
    left.whileActive(new IntakeBall());
    left.close();

  }

  public Joystick getLeftJoystick() {
    return leftJoystick;
  }
  public Joystick getRightJoystick(){
    return rightJoystick;
  }

  public Joystick getGamepad() {
    return gamepad;
  }
}