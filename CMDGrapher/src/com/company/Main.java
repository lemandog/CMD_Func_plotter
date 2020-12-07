package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int terminalWidth =  120;   //Нет способа понять, какого размера окно запущено, считаю что стандарт
        int terminalHeight = 30;
        
        Scanner in = new Scanner(System.in);
        System.out.println("Функция, в виде f(x), (например cos(x))");
        String matheq = in.nextLine();
        System.out.println("Начало счёта аргумента (Если 0, то -1)");
        double xStart = in.nextInt();
        System.out.println("Конец счёта аргумента (Если 0, то +1)");
        double xEnd = in.nextInt();
        System.out.println("Шаг (Если 0, то 0.01)");
        double deltaQuant = in.nextInt();

        double[] result = (double[]) Parser (matheq,xEnd,xStart,deltaQuant);




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
