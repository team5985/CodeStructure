package frc.pb;

import edu.wpi.first.wpilibj.PIDSource;

public interface PbEncoder extends PIDSource {
    public int getCounts();
}