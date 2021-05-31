package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Hardware {
    public class Motors {
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

    public class Servos {
        public Servo leftHatch;
        public Servo rightHatch;

        public Servo grip;

        Servo sorter;

        Servos(HardwareMap hardwareMap) {
            leftHatch = hardwareMap.get(Servo.class, "Hatch-L");
            rightHatch = hardwareMap.get(Servo.class, "Hatch-R");

            grip = hardwareMap.get(Servo.class, "Grip");

            sorter = hardwareMap.get(Servo.class, "Sorter");
        }
    }
    public Motors motors;
    public Servos servos;

    ColorSensor colorSensor;

    public Hardware(HardwareMap hardwareMap) {
        motors = new Motors(hardwareMap);
        servos = new Servos(hardwareMap);
        colorSensor = hardwareMap.get(ColorSensor.class, "ColorSensor");
    }
}
