// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** A command that uses the intake subsystem. It extends the arms and runs the motor to pick balls up */
public class IntakeCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Intake intake;

  /**
   * Creates a new Intake Command.
   *
   * @param intake The subsystem used by this command.
   */
  public IntakeCommand(Intake intake) {
    this.intake = intake;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intake);
  }





  // Called when the command is initially scheduled.
  // moves the pistons forward and starts the motor
  @Override
  public void initialize() {
    intake.pistonsForward();
    intake.setMotorSpeed(0.7);
  }

  // This is not used for this command
  @Override
  public void execute() {}

  // When the button is released this will be called. It retracts the pistons and setst the motor speed to 0
  @Override
  public void end(boolean interrupted) {
    intake.pistonsReverse();
    intake.setMotorSpeed(0);
  }

  // not used for this command
  @Override
  public boolean isFinished() {
    return false;
  }
}
