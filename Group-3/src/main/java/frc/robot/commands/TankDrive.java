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
public class TankDrive extends CommandBase {

  
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})


  private final DriveTrain drivetrain;
  
  private DoubleSupplier left;
  private DoubleSupplier right;



  /**
   * Creates a new ExampleCommand.
   *
   * @param drivetrain The subsystem used by this command.
   */




  public TankDrive(DriveTrain drivetrain, DoubleSupplier left, DoubleSupplier right) {
    this.drivetrain = drivetrain;
    this.left = left;
    this.right = right;




    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivetrain.tankDrive(0,0);

  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.tankDrive(left.getAsDouble(),right.getAsDouble());

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.tankDrive(0,0);

  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
