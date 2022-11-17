// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  Compressor pcmCompressor = new Compressor(Constants.Intake.compressor_id, PneumaticsModuleType.CTREPCM);

//   DoubleSolenoid exampleDoublePCM = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2);
  DoubleSolenoid doubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.Intake.solenoid_forward_channel, Constants.Intake.solenoid_reverse_channel);
  

  public Intake() {
      pcmCompressor.enableDigital();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
