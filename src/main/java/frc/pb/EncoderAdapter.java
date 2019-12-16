package frc.pb;

import com.revrobotics.CANEncoder;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.PIDSourceType;

public class EncoderAdapter implements PbEncoder {
    

    public EncoderAdapter(CounterBase dioEncoder) {
        
    }

    public EncoderAdapter(CANEncoder canEncoder) {

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