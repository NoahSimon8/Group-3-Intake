// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

/** An example command that uses an example subsystem. */
public class ArcadeDrive extends CommandBase {

  
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})


  private final DriveTrain drivetrain;
  
  private DoubleSupplier forward;
  private DoubleSupplier side;

  /**
   * Creates a new ExampleCommand.
   *
   * @param drivetrain The subsystem used by this command.
   */


  public ArcadeDrive(DriveTrain drivetrain, DoubleSupplier forward, DoubleSupplier side) {
    // instantiate the instance variables
    this.drivetrain = drivetrain;
    this.forward = forward;
    this.side = side;


    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // start values at 0
    drivetrain.arcadeDrive(0,0);

  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // use getter lambda's to retrieve speeds
    drivetrain.arcadeDrive(forward.getAsDouble(),side.getAsDouble());

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // set ending values to 0
    drivetrain.arcadeDrive(0,0);

  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
