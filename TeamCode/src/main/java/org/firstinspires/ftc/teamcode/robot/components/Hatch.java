package org.firstinspires.ftc.teamcode.robot.components;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Hatch of a ball chamber
 */
public class Hatch {
    /**
     * Hatch servo positions
     */
    private enum Position {
        Opened(1.0),
        Closed(0.0);

        private double position;

        Position(final double position) {
            this.position = position;
        }

        public double value() {
            return position;
        }
    }

    private Servo servo;
    private Position position = Position.Closed;

    public Hatch(Servo servo) {
        this.servo = servo;
    }

    /**
     * Check if hatch is open.
     *
     * <p>Keep in mind that it does not check actual position of the servo.</p>
     */
    public boolean isOpen() {
        return this.position == Position.Opened;
    }

    /**
     * Open hatch of a chamber
     */
    public void open() {
        position = Position.Opened;
        servo.setPosition(position.value());
    }

    /**
     * Close hatch of a chamber
     */
    public void close() {
        position = Position.Closed;
        servo.setPosition(position.value());
    }

    /**
     * Toggle hatch
     */
    public void toggle() {
        if (isOpen()) {
            close();
        } else {
            open();
        }
    }
}
