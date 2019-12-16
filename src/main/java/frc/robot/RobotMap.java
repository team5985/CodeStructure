package frc.robot;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.pb.EncoderAdapter;
import frc.pb.PbEncoder;
import frc.pb.SensoredSystem;

public class RobotMap {
    /**
     * Robot Configuration
     */
    static final boolean useNeoEncoders = true;

    /**
     * CAN IDs
     */
    static final int leftDriveACanId = 1;
    static final int leftDriveBCanId = 2;
    static final int rightDriveACanId = 3;
    static final int rightDriveBCanId = 4;

    /**
     * DIO Ports
     */
    static final int leftDriveEncADioPort = 0;
    static final int leftDriveEncBDioPort = 1;

    static final int rightDriveEncADioPort = 2;
    static final int rightDriveEncBDioPort = 3;

    /**
     * Drivetrain
     */
    // Left
    static CANSparkMax leftDriveA = new CANSparkMax(leftDriveACanId, MotorType.kBrushless);
    static CANSparkMax leftDriveB = new CANSparkMax(leftDriveBCanId, MotorType.kBrushless);
    static SpeedControllerGroup leftDriveMotors = new SpeedControllerGroup(leftDriveA, leftDriveB);

    // Right
    static CANSparkMax rightDriveA = new CANSparkMax(rightDriveACanId, MotorType.kBrushless);
    static CANSparkMax rightDriveB = new CANSparkMax(rightDriveBCanId, MotorType.kBrushless);
    static SpeedControllerGroup rightDriveMotors = new SpeedControllerGroup(rightDriveA, rightDriveB);

    // Encoders
    static EncoderAdapter leftEncoder;
    static EncoderAdapter rightEncoder;

    public static SensoredSystem leftDrive;
    public static SensoredSystem rightDrive;

    /**
     * @return the leftDrive
     */
    public static SensoredSystem getLeftDrive() {
        if (useNeoEncoders) {
            leftEncoder = new EncoderAdapter(leftDriveA.getEncoder());

        } else {
            leftEncoder = new EncoderAdapter( new Encoder(leftDriveEncADioPort, leftDriveEncBDioPort) );
        }
        
        leftDrive = new SensoredSystem(leftDriveMotors, leftEncoder);
        return leftDrive;
    }

    /**
     * @return the rightDrive
     */
    public static SensoredSystem getRightDrive() {
        if (useNeoEncoders) {
            rightEncoder = new EncoderAdapter(rightDriveA.getEncoder());

        } else {
            rightEncoder = new EncoderAdapter( new Encoder(rightDriveEncADioPort, rightDriveEncBDioPort) );
        }
        
        rightDrive = new SensoredSystem(rightDriveMotors, rightEncoder);
        return rightDrive;
    }

    /**
     * Elevator
     */
    static CANSparkMax elevatorSparkMax;
    static EncoderAdapter elevatorEncoder;
    static SensoredSystem elevatorSystem = new SensoredSystem(elevatorSparkMax, elevatorEncoder);

    /**
     * 
     * @return elevator motor and sensor
     */
    public static SensoredSystem getElevator() {
        return elevatorSystem;
    }

}
