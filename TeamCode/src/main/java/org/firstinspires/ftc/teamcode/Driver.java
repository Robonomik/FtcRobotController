package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.gamepad.Gamepad;
import org.firstinspires.ftc.teamcode.robot.Robot;

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

            // Let's sleep for a little bit
            sleep(40);
            idle();
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
        if (gamepad.left_stick_button.wasClicked()) {
            robot.harvester.toggle();
        }

        // Update sorter state, using color sensor
        robot.sorter.update();
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
        if (gamepad.dpad_up.isPressed()) {
            robot.lift.run(1.0);
        } else if (gamepad.dpad_down.isPressed()) {
            robot.lift.run(-1.0);
        } else {
            robot.lift.run(0.0);
        }
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
