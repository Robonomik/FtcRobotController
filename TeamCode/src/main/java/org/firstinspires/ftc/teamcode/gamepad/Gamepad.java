package org.firstinspires.ftc.teamcode.gamepad;

public class Gamepad {
    com.qualcomm.robotcore.hardware.Gamepad gamepad;

    public float left_stick_x = 0f;
    public float left_stick_y = 0f;
    public float right_stick_x = 0f;
    public float right_stick_y = 0f;

    public Button dpad_up = new Button();
    public Button dpad_down = new Button();
    public Button dpad_left = new Button();
    public Button dpad_right = new Button();

    public Button a = new Button();
    public Button b = new Button();
    public Button x = new Button();
    public Button y = new Button();

    public Button left_bumper = new Button();
    public Button right_bumper = new Button();

    public Button left_stick_button = new Button();
    public Button right_stick_button = new Button();

    public float left_trigger = 0f;
    public float right_trigger = 0f;

    public Gamepad(com.qualcomm.robotcore.hardware.Gamepad gamepad) {
        this.gamepad = gamepad;
    }

    public void update() {
        left_stick_x = gamepad.left_stick_x;
        left_stick_y = gamepad.left_stick_y;
        right_stick_x = gamepad.right_stick_x;
        right_stick_y = gamepad.right_stick_y;

        dpad_up.update(gamepad.dpad_up);
        dpad_down.update(gamepad.dpad_down);
        dpad_left.update(gamepad.dpad_left);
        dpad_right.update(gamepad.dpad_right);

        a.update(gamepad.a);
        b.update(gamepad.b);
        x.update(gamepad.x);
        y.update(gamepad.y);

        left_bumper.update(gamepad.left_bumper);
        right_bumper.update(gamepad.right_bumper);

        left_stick_button.update(gamepad.left_stick_button);
        right_stick_button.update(gamepad.right_stick_button);

        left_trigger = gamepad.left_trigger;
        right_trigger = gamepad.right_trigger;
    }
}
