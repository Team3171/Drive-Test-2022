// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or
 * the package after creating this project, you must also update the
 * build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  private TalonSRX leftFront, rightFront, leftRear, rightRear;
  private Joystick leftStick, rightStick;

  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    leftFront = new TalonSRX(3);
    rightFront = new TalonSRX(1);
    leftRear = new TalonSRX(2);
    rightRear = new TalonSRX(4);

    leftFront.setInverted(true);
    rightFront.setInverted(false);
    leftRear.setInverted(true);
    rightRear.setInverted(false);

    leftStick = new Joystick(0);
    rightStick = new Joystick(1);
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    final double leftY = leftStick.getY(), rightX = rightStick.getX();

    leftFront.set(ControlMode.PercentOutput, leftY - rightX);
    rightFront.set(ControlMode.PercentOutput, leftY + rightX);
    leftRear.set(ControlMode.PercentOutput, leftY - rightX);
    rightRear.set(ControlMode.PercentOutput, leftY + rightX);
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {
  }

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {
    leftFront.set(ControlMode.Disabled, 0);
    rightFront.set(ControlMode.Disabled, 0);
    leftRear.set(ControlMode.Disabled, 0);
    rightRear.set(ControlMode.Disabled, 0);
  }

}
