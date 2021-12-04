// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Robot;
import frc.robot.subsystems.IntakeSubsystem.IntakeState;

public class IntakeAndOutakePanel extends CommandBase {

  /** Creates a new IntakeAndOutakePanel. */
  public IntakeAndOutakePanel() {
    // Use addRequirements() here to declare subsystem dependencies.
    new SequentialCommandGroup(
        new IntakePanel(),
        new WaitCommand(3),
        new OutputPanel());
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.intakeSubsystem.setState(IntakeState.INTAKINGANDOUTAKING);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.intakeSubsystem.setState(IntakeState.NOTHING);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
