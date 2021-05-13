package org.firstinspires.ftc.teamcode.robot.components;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Ball Harvester
 */
public class Harvester {
    DcMotor motor;
    boolean isOn = false;

    public Harvester(DcMotor motor){
        this.motor = motor;
    }

    public void on(){
        motor.setPower(1.0);
        isOn = true;
    }

    public void off(){
        motor.setPower(0.0);
        isOn = false;
    }

    public void toggle(){
        if(isOn){
            off();
        }else{
            on();
        }
    }
}
