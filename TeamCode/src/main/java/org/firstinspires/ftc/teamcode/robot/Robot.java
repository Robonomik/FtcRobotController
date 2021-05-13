package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.robot.components.Harvester;
import org.firstinspires.ftc.teamcode.robot.components.Hatch;
import org.firstinspires.ftc.teamcode.robot.components.Lift;
import org.firstinspires.ftc.teamcode.robot.components.MainDrive;
import org.firstinspires.ftc.teamcode.robot.components.Sorter;

public class Robot {
    public Hardware hardware;

    public MainDrive mainDrive;

    public Lift lift;

    public Hatch leftChamberHatch;
    public Hatch rightChamberHatch;

    public Sorter sorter;
    public Harvester harvester;

    public Robot(HardwareMap hardwareMap) {
        // Get robot hardware from the hardwareMap
        hardware = new Hardware(hardwareMap);

        // Main drive train
        mainDrive = new MainDrive(hardware.motors.mainDriveLeft, hardware.motors.mainDriveRight);

        // Cube lifter
        lift = new Lift(hardware.motors.lift);

        // Chamber hatches
        leftChamberHatch = new Hatch(hardware.servos.leftHatch);
        rightChamberHatch = new Hatch(hardware.servos.rightHatch);

        // Ball sorter
        sorter = new Sorter(hardware.servos.sorter, hardware.colorSensor);
        // Ball harvester
        harvester = new Harvester(hardware.motors.ballHarvester);
    }

    /**
     * Open all ball chambers
     */
    public void openChambers() {
        leftChamberHatch.close();
        rightChamberHatch.close();
    }

    /**
     * Close all ball chambers
     */
    public void closeChambers() {
        leftChamberHatch.close();
        rightChamberHatch.close();
    }

    /**
     * Stop all DC motors.
     */
    public void stopMotors() {
        hardware.motors.mainDriveRight.setPower(0.0);
        hardware.motors.mainDriveLeft.setPower(0.0);
        hardware.motors.lift.setPower(0.0);
    }
}
