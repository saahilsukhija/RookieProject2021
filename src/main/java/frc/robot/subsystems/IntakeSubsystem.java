// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  private TalonSRX intakeMotor;
  public AnalogInput ultrasonic;

  public enum IntakeState {
    INTAKING, OUTTAKING, NOTHING
  }

  public IntakeState state;

  public IntakeSubsystem() {
    intakeMotor = new TalonSRX(Constants.motorIndex);
    ultrasonic = new AnalogInput(Constants.ultrasonicMotorPortNum);
    intakeMotor.configFactoryDefault();
    intakeMotor.setInverted(false);
  }

  public void setState(IntakeState newState) {
    state = newState;
  }

  public IntakeState getState() {
    return state;
  }

  public void setSpeed(double speed) {
    intakeMotor.set(ControlMode.PercentOutput, speed);
  }

  public void stopMotor() {
    setSpeed(0);
  }

  public double getDistance() {
    return ultrasonic.getValue() * Constants.kValueToInches;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
