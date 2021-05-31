package org.firstinspires.ftc.teamcode.robot.components;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;

public class Sorter {
    Servo servo;
    ColorSensor colorSensor;

    public enum Chamber {
        Left,
        Right
    }

    public Sorter(Servo servo, ColorSensor colorSensor) {
        this.servo = servo;
        this.colorSensor = colorSensor;

        colorSensor.enableLed(false);
    }

    /**
     * Set destination chamber based on sampled color
     */
    public ColorSensor update() {
        return colorSensor;
//        if (colorSensor.red() > colorSensor.blue()) {
//            setDestinationChamber(Chamber.Left);
//        } else if (colorSensor.blue() > colorSensor.red()) {
//            setDestinationChamber(Chamber.Right);
//        }
    }

    /**
     * Set which chamber should be a destination of balls
     */
    public void setDestinationChamber(Chamber chamber) {
        switch (chamber) {
            case Left: {
                servo.setPosition(0.0);
                break;
            }
            case Right: {
                servo.setPosition(0.3);
                break;
            }
        }
    }
}
