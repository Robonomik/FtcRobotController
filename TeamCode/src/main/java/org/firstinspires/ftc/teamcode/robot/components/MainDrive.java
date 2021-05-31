package org.firstinspires.ftc.teamcode.robot.components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Drive train of the robot.
 *
 * <p>Responsible for movement of a robot</p>
 */
public class MainDrive {
    private DcMotor leftMotor, rightMotor;

    public MainDrive(DcMotor leftMotor, DcMotor rightMotor) {
        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        this.leftMotor = leftMotor;
        this.rightMotor = rightMotor;
    }

    /**
     * Set the power level of the motors
     *
     * @param left  power of left motor [-1.0, 1.0]
     * @param right power of right motor [-1.0, 1.0]
     */
    public void setPower(double left, double right) {
        leftMotor.setPower(left);
        rightMotor.setPower(right);
    }

    /**
     * Run the main drive.
     * <p>Power of motors will be calculated internally.</p>
     *
     * @param power     backward/forward [-1.0, 1.0]
     * @param direction left/right [-1.0, 1.0]
     */
    public void run(double power, double direction) {
        // Calculate power of left motor
        double lPower = Range.clip(power + direction, -1.0, 1.0);
        // Calculate power of right motor
        double rPower = Range.clip(power - direction, -1.0, 1.0);

        setPower(lPower, -rPower);
    }
}
