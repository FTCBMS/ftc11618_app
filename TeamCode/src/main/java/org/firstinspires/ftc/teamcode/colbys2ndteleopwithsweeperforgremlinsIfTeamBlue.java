/*
Copyright (c) 2016 Robert Atkinson

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Robert Atkinson nor the names of his contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="colbys2nd teleop sweeper for gremlins", group="Pushbot")
public class colbys2ndteleopwithsweeperforgremlinsIfTeamBlue extends OpMode {

    /* Declare OpMode members. */
    colbyPushBot robot = new colbyPushBot(); // use the class created to define a Pushbot's hardware
    static final double INCREMENT = 0.1;     // amount to slew servo each CYCLE_MS cycle
    static final int CYCLE_MS = 50;     // period of each cycle
    static final double MAX_POS = 1.0;     // Maximum rotational position
    static final double MIN_POS = 0.0;     // Minimum rotational position

    static final double max = 0.5;
    static final double START = 0.25;

    // Define class members

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "there once was a boy named timmy he was really small so people called him little timmy little timmy didnt like that name thou. One day timmy was at school and and his math teacher asked him whe 5+5 was but timmy didnt know so timmy guessed 12? all the other kids laughed but it wasnt timmys fault he didnt know his brain was just so small he couldnt rememberhe barley rememberd the first seven numbers in the alphabe he even mixed up numbers with letters. later that day at recces a bully named bob the builder came up to him and said dum LITTLE Timmy your so smal a ant could squash you he hah little timmy was so mad he kicked the bully ing the shin the bully just laughed and punche Timmy in the face timmy died of sadness later that day. thats why you shouldnt bully. ");

        robot.servo2.setDirection(Servo.Direction.REVERSE);
        robot.servo.scaleRange(START, max);
        robot.servo2.scaleRange(START, max);
        robot.servo.setPosition(0);
        robot.servo2.setPosition(0);
    }


    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
    }

    /*
     * Code to run REPEATEDLY after
    @Overridethe driver hits PLAY but before they hit STOP
     */


    public void loop() {

        //tank mode drive
        double left = -gamepad1.left_stick_y;
        double right = -gamepad1.right_stick_y;
        robot.leftMotor.setPower(left+right);
        robot.rightMotor.setPower(right+left);


        //sweepermoter powed by left_bumper
        //double sweeper = gamepad1.left_trigger;

        if (gamepad1.left_bumper) {
            robot.sweeperMoter.setPower(-1);
        } else {
            robot.sweeperMoter.setPower(0);
        }

        if (gamepad1.right_bumper) {
            robot.sweeperMoter.setPower(1);
        } else {
            robot.sweeperMoter.setPower(0);
        }

        /*
        position += .001;
        position %= 1;
        robot.servo.setPosition(position);
        */
        //lifter going on one servo
        if (gamepad1.a) {
            robot.servo.setPosition(0);

        } else if (gamepad1.y) {
            robot.servo.setPosition(1);
            //robot.servo2.setPosition(1);
        }

        //shooter

        double shoot1 = gamepad1.right_trigger;
        robot.shooterMotor1.setPower(-shoot1);
        robot.shooterMotor2.setPower(shoot1);

        /*
        shooter
        double shoot2 = (gamepad1.right_bumper ? 1 : 0);
        robot.shooterMotor1.setPower(shoot1);
        robot.shooterMotor2.setPower(-shoot1);

        */

    }

}
