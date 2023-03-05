package Gol;
import java.util.Scanner;

public class Param {
    public int w, h, g, s;
    public String p;
    public  Param(int w, int h, int g, int s, String p) {
    this.w = w;
    this.h =h;
    this.g =g;
    this.s =s;
    this.p = p;
    }
    public  void param() throws InterruptedException {
        if (w ==10 || w==20 ||w ==40 || w==80){
                    if (h ==10 || h==20 ||h ==40){
                        if(g>=0){
                            if(s==250 || s==1000){
                                Settings input = new Settings(w,h,g,s,p);
                                input.convert();}
                            else{error();}
                        }else{error();}
                    }else{error();}
        }else{error();}}

    public static void error() throws InterruptedException {
        System.out.println("\nYou insert a invalid value, please try again\n");
    }
}