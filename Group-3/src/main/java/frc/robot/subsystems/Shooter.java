
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;



public class Shooter extends SubsystemBase {

  private WPI_TalonFX leftMotor = new WPI_TalonFX(Constants.Shooter.left_shooter_motor);
  private WPI_TalonFX rightMotor = new WPI_TalonFX(Constants.Shooter.right_shooter_motor);



  private MotorControllerGroup shooterMotorGroup = new MotorControllerGroup(leftMotor, rightMotor);


  /** Creates a new ExampleSubsystem. */
  public Shooter() {
    leftMotor.setInverted(true);
    
  }

  public void setSpeed(double speed){
    shooterMotorGroup.set(speed);

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
