package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int terminalWidth =  120;   //Нет способа понять, какого размера окно запущено, считаю что стандарт
        int terminalHeight = 29;

        Scanner in = new Scanner(System.in);
        System.out.println("ГРАФОПОСТРОИТЕЛЬ SIN");
        //String matheq = in.nextLine();
        System.out.println("Начало счёта аргумента (Если 0, то -1)");
        double xStart = -Math.abs(in.nextInt());

        if (xStart == 0) {
            xStart = -1;
        }

        double xEnd = -xStart;
        System.out.println("Шаг (Если 0, то 0.001)");
        double deltaQuant = in.nextInt();

        if (deltaQuant == 0) {
            deltaQuant = 0.001;
        }

        //double[] result = (double[]) Parser (matheq,xEnd,xStart,deltaQuant);
        double[] result = new double[(int)((xEnd-xStart)/deltaQuant)];
        int counter = 0;

        for (double i=xStart; i<xEnd-deltaQuant; i=i+deltaQuant){
            result[counter] = Math.sin(i);
            counter++;
        }
        OutputMethod(result,xEnd,xStart,deltaQuant,terminalWidth,terminalHeight,counter);
    }

    public static void OutputMethod(double[] result, double xEnd, double xStart, double deltaQuant, int terminalWidth, int terminalHeight, int counter){
        //Высчитываем границы графопостроения
        double prevMax = result[0];

        for (int f=0; f<counter-1; f++){ //Поиск максимума функции
            if (prevMax<Math.abs(result[f])){
                prevMax = Math.abs(result[f]);
            }
        }

        double heightStep = Math.abs((prevMax*2)/terminalHeight); //Шаг по вертикали
        double horisStep = Math.abs((Math.abs(xEnd)+Math.abs(xStart))/terminalWidth); //Шаг по горизонтали
        //Форматирование исходных данных под терминал
        double currSum = 0;
        double[] resultAdapted = new double[terminalWidth];
        int amount = (int) (horisStep/deltaQuant);

        for (int otr=0; otr<terminalWidth; otr++) { //Сжимание исходного шага под шаг терминала
            currSum=0;
            for (int f = 0; f < amount; f++) { //Проход текущему по отрезку
                currSum = currSum + result[otr*amount + f];
            }

            resultAdapted[otr] = currSum/(amount); //Среднее для каждого знака
            System.out.println(resultAdapted[otr]);
        }

        System.out.println();
        System.out.println(prevMax + " НАЙДЕННЫЙ ВЕРХНИЙ ПРЕДЕЛ");
        System.out.println(heightStep+ "= ШАГ ГРАФОПОСТРОИТЕЛЯ ПО ВЕРТИКАЛИ");
        System.out.println(horisStep + "= ШАГ ГРАФОПОСТРОИТЕЛЯ ПО ГОРИЗОНТАЛИ");
        for (int w=0; w<terminalWidth; w++){//Заполнить строку
            System.out.print("0");
        }
        System.out.println();
        for (int h=terminalHeight; h>-1; h--){ //Заполнить столбец
            for (int w=0; w<terminalWidth; w++){ //Заполнить строку

                     if (resultAdapted[w] > (-prevMax + heightStep*h) && resultAdapted[w] < (-prevMax + heightStep*(h+1)) ){
                           System.out.print("0");
                      }
                      else {
                           System.out.print(" ");
                      }

            }
            System.out.println(); //Перенос каретки (Строка заполнена)
    }
        for (int w=0; w<terminalWidth; w++){//Заполнить строку
            System.out.print("0");
        }
    }


    public static Object Parser(String matheq, double xEnd, double xStart, double deltaQuant) {
        //Цикл для высчитывания глубины математического уравнения
        int closureAm=0; int openningAm=0;

        for (int currChar = 0; currChar < matheq.length(); currChar++){
            //if (matheq[currChar] == '('){openningAm++;}
            // if (matheq[currChar] == ')'){closureAm++; }
        }

        if (closureAm != openningAm){
            System.out.println("ОШИБКА ЗАПИСИ МАТ. УРАВНЕНИЯ - ПОПРОБУЙТЕ СНОВА");
        }
        double[] result = new double[0];
        return result;

    }

}