package org.firstinspires.ftc.teamcode.gamepad;

enum State {
    // Button was clicked in this cycle
    WasClicked,
    // Button is pressed
    IsPressed,
    // Button is Released
    IsReleased
}

public class Button {
    private State state = State.IsReleased;

    /**
     * Update state of a button
     */
    public void update(boolean isPressed) {
        if (isPressed) {
            switch (state) {
                // If button was released (in previous update)
                case IsReleased: {
                    // it means that press just started
                    state = State.WasClicked;
                    break;
                }
                // If button was clicked (in previous update)
                case WasClicked: {
                    // it means that press is in progress
                    state = State.IsPressed;
                    break;
                }
            }
        } else {
            state = State.IsReleased;
        }
    }

    /**
     * Button was clicked in this cycle
     */
    public boolean wasClicked(){
        return state == State.WasClicked;
    }

    /**
     * Button is pressed
     */
    public boolean isPressed(){
        return state == State.IsPressed || state == State.WasClicked;
    }
}
