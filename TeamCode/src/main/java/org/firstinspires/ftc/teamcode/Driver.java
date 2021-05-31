package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.gamepad.Gamepad;
import org.firstinspires.ftc.teamcode.robot.Robot;
import org.firstinspires.ftc.teamcode.robot.components.Lift;
import org.firstinspires.ftc.teamcode.robot.components.Sorter;

@TeleOp(name = "Driver", group = "Main")
public class Driver extends LinearOpMode {
    Gamepad gamepad;
    Robot robot;

    @Override
    public void runOpMode() {
        // Initialize a gamepad
        gamepad = new Gamepad(gamepad1);
        // Initialize robot hardware
        robot = new Robot(hardwareMap);

        telemetry.addData(">", "♦Program Ready♦");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            update();
        }

        // Stop all motors
        // FtcRobotController does this internally too, but let's do it here too, just to be 100% sure
        robot.stopMotors();
        telemetry.addData(">", "All motors stopped");

        telemetry.addData(">", "►Program Closed◄");
        telemetry.update();
    }

    void update() {
        // Update input data
        gamepad.update();

        // Main Drive Train
        updateDriveTrain();

        // Cube lift
        updateLift();

        // Chamber Hatches
        updateHatches();


        // Start/Stop ball harvester
        robot.harvester.setPower(gamepad.left_stick_y);

        // Sorter Chamber
        if(gamepad.dpad_left.wasClicked()) {
            robot.sorter.setDestinationChamber(Sorter.Chamber.Left);
        } else if(gamepad.dpad_right.wasClicked()) {
            robot.sorter.setDestinationChamber(Sorter.Chamber.Right);
        }

        if(gamepad.y.isPressed()) {
            robot.hardware.servos.grip.setPosition(1.0);
        }
        else if(gamepad.a.isPressed()) {
            robot.hardware.servos.grip.setPosition(0.0);
        }


        // Update sorter state, using color sensor
        ColorSensor cs = robot.sorter.update();

        telemetry.addData("red:",cs.red());
        telemetry.addData("green:",cs.green());
        telemetry.addData("blue:",cs.blue());
        telemetry.update();
    }

    void updateDriveTrain() {
        // Left trigger runs forward
        // 1.0 - 0.0 = 1.0
        // Right trigger runs backward
        // 0.0 - 1.0 = -1.0
        float power = gamepad.left_trigger - gamepad.right_trigger;

        // Turn direction
        float direction = -gamepad.right_stick_x;
        robot.mainDrive.run(power, direction);
    }

    void updateLift() {
        // Move lift based on dpad input
        if (gamepad.dpad_up.wasClicked()) {
            robot.lift.runToPosition(Lift.Position.Top);
        } else if (gamepad.dpad_down.wasClicked()) {
            robot.lift.runToPosition(Lift.Position.Bottom);
        }

        telemetry.addData("Pos:", robot.lift.get());
    }

    void updateHatches(){
        // Open/Close ball chamber hatches
        if (gamepad.x.wasClicked()) {
            robot.leftChamberHatch.toggle();
        }
        if (gamepad.b.wasClicked()) {
            robot.rightChamberHatch.toggle();
        }
    }
}
