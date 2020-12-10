package com.company;
import java.util.Scanner;
import static java.lang.Float.NaN;

public class Main {
    public static void main(String[] args) {
        int terminalWidth =  118;   //Without other libraries I have no way to know what size window is - this is standard for win
        int terminalHeight = 28;

        Scanner in = new Scanner(System.in);
        System.out.println("PSEUDOGRAPHIC FUNCTION PLOTTER 0.0.4b");
        System.out.println("1 - SIN");
        System.out.println("2 - COS");
        System.out.println("3 - TAN");
        System.out.println("4 - ACOS");
        System.out.println("5 - ASIN");
        System.out.println("6 - EXP");
        System.out.println("7 - SINH");
        System.out.println("8 - COSH");
        System.out.println("9 - TANH");
        System.out.println("10 - LOG");
        int type = in.nextInt();
        System.out.println("Starting point of x");
        double xStart = in.nextDouble();
        System.out.println("Ending point of x");
        double xEnd = in.nextDouble();
        if (xEnd < xStart) { //If you mishapped xStart & xEnd this will fix it for you
            System.out.println("It seems you mishapped start and end of argument.. Fixing");
            double buffer;
            buffer = xEnd;
            xEnd = xStart;
            xStart = buffer;
        }

        System.out.println("Step (if 0 is chosen, = 0.001)");
        double deltaQuant = in.nextInt();
        if (deltaQuant == 0) {
            deltaQuant = 0.001;
        }

        if ((xEnd - xStart)/deltaQuant < 1) {
            System.out.println("Step is too big, shrinking it!");
            deltaQuant = (xEnd - xStart)/10000;
            System.out.println("Now, step is -" + deltaQuant);
        }

        //double[] result = (double[]) Parser (matheq,xEnd,xStart,deltaQuant);
        double[] result = new double[(int)Math.ceil(Math.abs(xEnd-xStart)/deltaQuant) +2];
        int counter = 0;
        for (double i=xStart; i<xEnd-deltaQuant; i=i+deltaQuant){
            switch (type) {
                case 2: result[counter] = Math.cos(i); break;
                case 3: result[counter] = Math.tan(i); break;
                case 4: result[counter] = Math.acos(i); break;
                case 5: result[counter] = Math.asin(i); break;
                case 6: result[counter] = Math.exp(i); break;
                case 7: result[counter] = Math.sinh(i); break;
                case 8: result[counter] = Math.cosh(i); break;
                case 9: result[counter] = Math.tanh(i); break;
                case 10: result[counter] = Math.log(i); break;
                default: result[counter] = Math.sin(i); break;
            }
            System.out.println("Y = " + result[counter] + " WITH X = " + i);
            counter++;
        }
        OutputMethod(result,xEnd,xStart,deltaQuant,terminalWidth,terminalHeight,counter);
    }

    public static void OutputMethod(double[] result, double xEnd, double xStart, double deltaQuant, int terminalWidth, int terminalHeight, int counter){
        //Search for argument & func borders in terminal
        double prevMax = 0;
        for (int f=0; f<counter-1; f++){ //Search for maximum
            if (prevMax<Math.abs(result[f])){
                if (result[f] != NaN){prevMax = Math.abs(result[f]);}
            }
        }

        double heightStep = Math.abs((prevMax*2)/terminalHeight); //Vertical terminal step
        double horisStep = Math.abs(xEnd-xStart)/terminalWidth;   //Horizontal terminal step
        //Format the data for pseudographics
        double currSum = 0;
        double[] resultAdapted = new double[terminalWidth];
        int amount = (int) Math.floor(horisStep/deltaQuant);

        for (int otr=0; otr<terminalWidth-1; otr++) { //Shrink the step to terminal step
            currSum=0;
            for (int f = 0; f < amount; f++) { //current section to shrink
                currSum += result[otr * amount + f];
            }
            resultAdapted[otr] = currSum/(amount); //Middle number for every section
        }

        System.out.println();
        System.out.println(prevMax + " Maximum found");
        System.out.println(heightStep+ "= Vertical step");
        System.out.println(horisStep + "= Horizontal step");

        //Legend
        System.out.printf("%.1f",(float)xStart);
        for (int w=0; w<terminalWidth-6; w++){//Fill the line
            System.out.print(" ");
        }
        System.out.printf("%.1f",(float)xEnd);

        System.out.println();
        for (int w=0; w<terminalWidth; w++){//Fill the line (start of graph)
            System.out.print("X");
        }
        System.out.println();
        for (int h=terminalHeight; h>-1; h--){ //Vertical pointer
            for (int w=0; w<terminalWidth; w++){ //Horizontal pointer
                     if (resultAdapted[w] > (-prevMax + heightStep*h) && resultAdapted[w] < (-prevMax + heightStep*(h+1)) && resultAdapted[w]!=NaN){
                          System.out.print("X");
                      }
                      else {
                             System.out.print(" ");
                     }
            }
            System.out.println(); //Step down (line is filled)
    }
        for (int w=0; w<terminalWidth; w++){//Fill the line (end of graph)
            System.out.print("X");
        }
    }


    public static Object Parser(String matheq, double xEnd, double xStart, double deltaQuant) {
        //Cycle for search of depth
        int closureAm=0; int openningAm=0;

        for (int currChar = 0; currChar < matheq.length(); currChar++){
            //if (matheq[currChar] == '('){openningAm++;}
            // if (matheq[currChar] == ')'){closureAm++; }
        }

        if (closureAm != openningAm){
            System.out.println("Mistake in equation -> (,) ");
        }
        double[] result = new double[0];
        return result;

    }

}