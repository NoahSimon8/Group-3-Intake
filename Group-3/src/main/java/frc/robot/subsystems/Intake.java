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
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Intake extends SubsystemBase {
  /** Creates a new Intake Subsystem. */

  // The compressor for the pneumatics 
  private Compressor pcmCompressor = new Compressor(Constants.Intake.compressor_id, PneumaticsModuleType.CTREPCM);

  // the two solidoids that manage the movement of the arm
  private DoubleSolenoid leftDoubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.Intake.left_solenoid_forward_channel, Constants.Intake.left_solenoid_reverse_channel);
  private DoubleSolenoid rightDoubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.Intake.right_solenoid_forward_channel, Constants.Intake.right_solenoid_reverse_channel);
  // the motor used to spin the motor on the arm
  private CANSparkMax motor = new CANSparkMax(Constants.Intake.motor_id, MotorType.kBrushless);


  public Intake() {
      pcmCompressor.enableDigital();
  }

// moves the pistons forward
  public void pistonsForward(){
    leftDoubleSolenoid.set(Value.kForward);
    rightDoubleSolenoid.set(Value.kForward);


  }
// moves the pistons back
  public void pistonsReverse(){
    leftDoubleSolenoid.set(Value.kReverse);
    rightDoubleSolenoid.set(Value.kReverse);

  }
// change the motor speed
  public void setMotorSpeed(double speed){
    motor.set(speed);
  }

// not used
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
// not used
  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
