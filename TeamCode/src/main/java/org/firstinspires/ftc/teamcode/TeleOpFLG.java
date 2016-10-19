package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.RMHardwarePushbot;

@TeleOp(name="PushBot: RMTeleOpMode", group="Pushbot")  // @Autonomous(...) is the other common choice
public class TeleOpFLG extends LinearOpMode {

    /* Declare OpMode members. */
    private ElapsedTime runtime = new ElapsedTime();
    DcMotor leftMotor = null;
    RMHardwarePushbot robot = new RMHardwarePushbot();
    DcMotor rightMotor = null;

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "RMTeleOp Initialized");
        telemetry.update();

        robot.init(hardwareMap);
        /* eg: Initialize the hardware variables. Note that the strings used here as parameters
         * to 'get' must correspond to the names assigned during the robot configuration
         * step (using the FTC Robot Controller app on the phone).
         */
        leftMotor = robot.leftMotor;
        rightMotor = robot.rightMotor;

        // eg: Set the drive motor directions:
        // "Reverse" the motor that runs backwards when connected directly to the battery
        leftMotor.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightMotor.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        /*
         */
        while (opModeIsActive()) {
            //idle the end of the match (driver presses STOP)
            telemetry.addData("Status", "(RM) Run Time: " + runtime.toString());
            telemetry.update();

            // eg: Run wheels in tank mode (note: The joystick goes negative when pushed forwards)
            leftMotor.setPower(-gamepad1.left_stick_y);
            rightMotor.setPower(-gamepad1.right_stick_y);
            // Always call idle() at the bottom of your while(opModeIsActive()) loop
            idle();
        }
    }
}