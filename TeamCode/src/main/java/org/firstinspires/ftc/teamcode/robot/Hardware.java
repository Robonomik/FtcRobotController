package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

class Motors {
    DcMotor mainDriveLeft;
    DcMotor mainDriveRight;

    DcMotor lift;
    DcMotor ballHarvester;

    Motors(HardwareMap hardwareMap) {
        mainDriveLeft = hardwareMap.get(DcMotor.class, "MainDrive-L");
        mainDriveRight = hardwareMap.get(DcMotor.class, "MainDrive-R");

        lift = hardwareMap.get(DcMotor.class, "Lift");
        ballHarvester = hardwareMap.get(DcMotor.class, "BallHarvester");
    }
}

class Servos {
    Servo leftHatch;
    Servo rightHatch;

    Servo sorter;

    Servos(HardwareMap hardwareMap) {
        leftHatch = hardwareMap.get(Servo.class, "Hatch-L");
        rightHatch = hardwareMap.get(Servo.class, "Hatch-R");

        sorter = hardwareMap.get(Servo.class, "Sorter");
    }
}

public class Hardware {
    public Motors motors;
    public Servos servos;

    ColorSensor colorSensor;

    public Hardware(HardwareMap hardwareMap) {
        motors = new Motors(hardwareMap);
        servos = new Servos(hardwareMap);
        colorSensor = hardwareMap.get(ColorSensor.class, "ColorSensor");
    }
}
