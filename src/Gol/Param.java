package Gol;
import java.util.Scanner;

public class Param {
    public static void param() throws InterruptedException {
       int w,h,g,s;
       String p;
       Scanner read = new Scanner(System.in);
        System.out.print("Insert the value to Grid Width size: (10),(20),(40) or (80): ");
        w = read.nextInt();


        if (w ==10 || w==20 ||w ==40 || w==80){
            System.out.print("Insert the value to Grid height size: (10),(20) or (40): ");
            h = read.nextInt();

                    if (h ==10 || h==20 ||h ==40){
                        System.out.print("Insert the value to max generations: (0 = infinite): ");
                        g = read.nextInt();

                        if(g>0){
                            System.out.print("Insert the speed of the generations will be parameterizable: (250) or (1000): ");
                            s = read.nextInt();

                            if(s==250 || s==1000){
                                System.out.print("Insert The initial population will be parameterizable:(0 = dead), (1 = alive) (# = next line)  ");
                                p = read.next();
                                Settings input = new Settings(w,h,g,s,p);
                                input.convert();}
                            else{error();}

                        }else if (g==0){
                            System.out.print("Insert the speed of the generations will be parameterizable: (250) or (1000): ");
                            s = read.nextInt();

                            if(s==250 || s==1000){
                                System.out.print("Insert The initial population will be parameterizable:(0 = dead), (1 = alive) (# = next line) (rnd = ramdom): ");
                                p = read.next();
                                Settings input = new Settings(w,h,g,s,p);
                                input.convert();}
                            else{error();}

                        }else{error();}

                    }else{error();}

        }else{error();}}

    public static void error() throws InterruptedException {
        System.out.println("\nYou insert a invalid value, please try again\n");
        param();
    }
}