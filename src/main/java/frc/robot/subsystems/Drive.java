package frc.robot.subsystems;

import frc.pb.SensoredSystem;

public class Drive extends Subsystem {

    public Drive (SensoredSystem leftDrive, SensoredSystem rightDrive) {

    }

    @Override
    public double getPosition() {
        return 0;
    }

    @Override
    public boolean zeroPosition() {
        return false;
    }

    @Override
    void configActuators() {
        
    }

    @Override
    void configSensors() {

    }

}