package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PIDController;
import frc.pb.SensoredSystem;

public class Elevator {
    SensoredSystem _elevatorSystem;
    double _goal;

    PIDController pid;
    double Kp = 0.01;
    
    public Elevator (SensoredSystem elevatorSystem) {
        _elevatorSystem = elevatorSystem;
        pid = new PIDController(Kp, 0.0, 0.0, _elevatorSystem, _elevatorSystem);
    }

    public void update() {
        double power = Kp * (_goal - _elevatorSystem.getCounts());
        

        
        _elevatorSystem.set(power);
    }

    public void setGoal(double goal) {
        _goal = goal;
    }

    public void getGoal() {
    }

    public double getHeight() {
        return 0.0;
    }
}
