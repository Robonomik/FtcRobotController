package org.firstinspires.ftc.teamcode.robot.components;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Cube Lift
 */
public class Lift {
    /**
     * Lift motor positions
     */
    public enum Position {
        Top(2500),
        Middle(1250),
        Bottom(0);

        private int position;

        Position(final int position) {
            this.position = position;
        }

        public int value() {
            return position;
        }
    }

    private DcMotor motor;

    public Lift(DcMotor motor) {
        this.motor = motor;
    }

    /**
     * Get current position of cube lift
     */
    public double getCurrentPosition() {
        return motor.getCurrentPosition();
    }

    /**
     * Run the cube lift.
     *
     * @param power down/up [-1.0, 1.0]
     */
    public void run(double power) {
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setPower(power);
    }

    /**
     * Move the cube lift to supplied position.
     *
     * @param position Position of the lift
     */
    public void runToPosition(Position position) {
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition(position.value());
    }
}
