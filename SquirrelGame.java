package IRP.src;

import java.math.*;
import java.util.Random;
import java.util.Scanner;

public class SquirrelGame 
{

    static class chaser
    {
        double xcord(double theta)
        {
            return Math.cos(theta);
        }

        double ycord(double theta)
        {
            return Math.sin(theta);
        }

        double theta(double chy, double tay, double distance)
        {
            return Math.asin(((tay - chy) / distance));
        }
    }

    static class target
    {
        double xcord(double theta)
        {
            return Math.cos(theta);
        }

        double ycord(double theta)
        {
            return Math.sin(theta);
        }
    }


    public static void main(String[] args) throws Exception 
    {
        boolean flag = true;
        chaser chase = new chaser();
        target targ = new target();
        Scanner sc = new Scanner(System.in);

        while (flag)
        {
            double chx = 0, chy = 0, tax = 10, tay = 10, distance = 2, chtheta, disx = 0, disy = 0;
            int count = 0;
            Random rn = new Random();

            while (distance > 1)
            {
                double tatheta = rn.nextDouble(89) + 1;
                distance = Math.sqrt((Math.pow((tax - chx), 2) + Math.pow((tay - chy), 2)));
                chtheta = chase.theta(chy, tay, distance);
                chx += chase.xcord(chtheta);
                chy += chase.ycord(chtheta);
                tax += targ.xcord(tatheta);
                tay += targ.ycord(tatheta);
                disx += chase.xcord(chtheta);
                disy += chase.ycord(chtheta);
                ++count;
            }
            System.out.println("It took " + count + " moves to catch the target.\nChaser coordinates: (" + chx + ", " + chy + ")\nTarget coordinates: (" + tax + ", " + tay + ")\nDistance: " + distance + "m\nChaser travelled " + disx + "m on the x - axis\nChaser travelled " + disy + "m on the y - axis\nChaser offset is " + (chx - 0) + "m x - axis and " + (chy - 0) + "m y - axis\nTarget offset is " + (tax - 10) + "m x - axis and " + (tay - 10) + "m y - axis" + "\n\nEnter false to close or true to go again.");
            flag = sc.nextBoolean();
        }
        sc.close();
    }
}