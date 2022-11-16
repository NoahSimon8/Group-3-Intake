// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;


public class DriveTrain extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  private WPI_TalonFX rightFrontMotor = new WPI_TalonFX(Constants.DriveTrain.right_front);
  private WPI_TalonFX leftFrontMotor = new WPI_TalonFX(Constants.DriveTrain.left_front);
  private WPI_TalonFX rightBackMotor = new WPI_TalonFX(Constants.DriveTrain.right_back);
  private WPI_TalonFX leftBackMotor = new WPI_TalonFX(Constants.DriveTrain.left_back);

  private MotorControllerGroup leftMotors = new MotorControllerGroup(leftFrontMotor, leftBackMotor);
  private MotorControllerGroup rightMotors = new MotorControllerGroup(rightFrontMotor, rightBackMotor);
  
// Creates a differential drive object
  private DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);


  public DriveTrain() {
    // All motors coast, right motors are inverted
    rightMotors.setInverted(true);
    leftFrontMotor.setNeutralMode(NeutralMode.Coast);
    rightFrontMotor.setNeutralMode(NeutralMode.Coast);
    leftBackMotor.setNeutralMode(NeutralMode.Coast);
    rightBackMotor.setNeutralMode(NeutralMode.Coast);


  }

  public void tankDrive(double left_speed, double right_speed){
    // left and right motors move indepentdantly
      leftMotors.set(left_speed);
      rightMotors.set(right_speed);

  }


  public void arcadeDrive(double speed, double rotation){
    // left and right motors are controlled with the differential drive class
    drive.arcadeDrive(speed, rotation * Constants.DriveTrain.rotation_speed); // why was it negative ration in the btab code? 

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
