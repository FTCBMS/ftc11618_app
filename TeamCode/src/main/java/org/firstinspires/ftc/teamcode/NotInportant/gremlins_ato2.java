package org.firstinspires.ftc.teamcode.NotInportant;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by grigg on 11/19/2016.
 */

@Autonomous(name="Auto drive by bot", group = "Pushbot")
@Disabled
public class gremlins_ato2 extends LinearOpMode {
    RMHardwarePushbot robot =  new RMHardwarePushbot();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        robot.leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        idle();

        robot.leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        waitForStart();
        robot.leftMotor.setPower(0.5);
        robot.rightMotor.setPower(0.5);
        sleep(5000);
        robot.leftMotor.setPower(0);
        robot.rightMotor.setPower(0);
    }
}
