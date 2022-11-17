// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
public class Intake extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  private Compressor pcmCompressor = new Compressor(Constants.Intake.compressor_id, PneumaticsModuleType.CTREPCM);

  private DoubleSolenoid leftDoubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.Intake.left_solenoid_forward_channel, Constants.Intake.left_solenoid_reverse_channel);
  DoubleSolenoid rightDoubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.Intake.right_solenoid_forward_channel, Constants.Intake.right_solenoid_reverse_channel);
 
private WPI_TalonFX motor = new WPI_TalonFX(Constants.Intake.motor_id);

  // private WPI_TalonFX motor = new WPI_TalonFX(0);

  public Intake() {
      pcmCompressor.enableDigital();
    //         doubleSolenoid.set(Value.kForward);

  }


  public void pistonsForward(){
    leftDoubleSolenoid.set(Value.kForward);
    rightDoubleSolenoid.set(Value.kForward);


  }

  public void pistonsReverse(){
    leftDoubleSolenoid.set(Value.kReverse);
    rightDoubleSolenoid.set(Value.kReverse);

  }

  public void setMotorSpeed(double speed){
    motor.set(speed);
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
