package frc.pb.sim.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import frc.pb.SensoredSystem;
import frc.pb.sim.*;
import frc.pb.sim.physics.ForceCalcs;
import frc.pb.sim.physics.MotorModel;
import frc.robot.subsystems.Elevator;

public class ElevatorTest {
    @Test
    public void Test() {
        double drumRadius = 0.03; // metres
        double gearRatio = 10.0; // n : 1
        double transmissionEfficiency = 0.8;
        double mass = 15.0; // kg

        MotorModel neoModel = new MotorModel(3.36, 166, 5880, 12);
        MockEsc motor = new MockEsc(neoModel);
        MockEncoder encoder = new MockEncoder(2048, gearRatio);
        SensoredSystem elevatorSystem = new SensoredSystem(motor, encoder);
        Elevator elevator = new Elevator(elevatorSystem);

        double pos = 0.0;
        double speed = 0.0; // m/s
        double voltage = 12.0;

        double dt = 0.02; // s
        double goal = 1000.0; // encoder counts
        double maxTime = 10.0; // s

        elevator.setGoal(goal);
        neoModel.setCurrentLimit(40);

        boolean running = true;
        double time;
        // Physics simulation loop
        for (time = 0.0; time < maxTime && running; time += dt) {
            elevator.update();

            double motorSpeed = gearRatio * speed / drumRadius;

            // Positive is up, negative down
            double force = transmissionEfficiency * neoModel.getTorque(voltage * motor.get(), motorSpeed) * gearRatio / drumRadius;
            force -= ForceCalcs.addGravity(mass);
            force += 100; // newtons, e.g. a constant force spring

            double acceleration = force / mass;
            speed += acceleration * dt;
            pos += speed * dt;

            encoder.update(dt, speed / drumRadius); // Assuming encoder is placed on drum, not motor

            System.out.println("Motor Command: " + motor.get() + "    Motor Speed: " + motorSpeed + "    Speed: " + speed + "    Force: " + force + "    Pos: " + pos + 
            "    Enc: " + encoder.getCounts() + "    Time: " + time);
        }

        assertEquals(goal, encoder.getCounts(), 10);
    }
}
