package frc.pb;

import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedController;

public class PbSparkMax implements SpeedController, PbEncoder {
    

    @Override
    public void pidWrite(double output) {
        this.set(output);
    }

    @Override
    public void set(double speed) {
        
    }

    @Override
    public double get() {
        return 0;
    }

    @Override
    public void setInverted(boolean isInverted) {

    }

    @Override
    public boolean getInverted() {
        return false;
    }

    @Override
    public void disable() {

    }

    @Override
    public void stopMotor() {

    }

    @Override
    public int getCounts() {
        return 0;
    }

    @Override
    public void setPIDSourceType(PIDSourceType pidSource) {

    }

    @Override
    public PIDSourceType getPIDSourceType() {
        return null;
    }

    @Override
    public double pidGet() {
        return 0;
    }

}