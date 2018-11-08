package by.mmf.metelskaya.employersandjobs;

import java.util.InputMismatchException;
import java.util.Scanner;

class Menu {
    static void getMenu() {
        int n = 0;
        int[][] speed = new int[n][n];
        int[][] priority = new int[n][n];
        boolean flag = true;
        while (flag) {
            System.out.println("\nSelect: " +
                    "\n1)Fill matrix" +
                    "\n2)Fill matrix by new values" +
                    "\n3)Print matrices" +
                    "\n4)Calculate" +
                    "\n5)Exit");
            int num = getNumber();
            switch (num) {
                case 1: {
                    speed = getSpeedMatrix();
                    priority = getPriorityMatrix();
                    break;
                }

                case 2: {
                    System.out.println("Enter number of employees and jobs: ");
                    n = getNumber();
                    speed = new int[n][n];
                    System.out.println("enter speed: ");
                    enterMatrix(speed);
                    priority = new int[n][n];
                    System.out.println("enter priority: ");
                    enterMatrix(priority);
                    break;
                }
                case 3: {
                    System.out.println("Speed: ");
                    printMatrices(speed);
                    System.out.println("Priority: ");
                    printMatrices(priority);
                    break;
                }
                case 4: {
                    DistributeWork work = new DistributeWork(speed, priority);
                    work.calculateMatches();
                    break;
                }
                case 5: {
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("choose 1-5");
                    break;
                }
            }
        }
    }

    private static void enterMatrix(int[][] matrix) {
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                System.out.print("\tenter " + (i + 1) + " " + (j + 1));
                matrix[i][j] = getNumber();
                System.out.println();
            }
        }
    }

    private static void printMatrices(int[][] matrix) {
        for (int j = 0; j < matrix.length; j++) {
            for (int[] aMatrix : matrix) {
                System.out.print(aMatrix[j] + " ");
            }
            System.out.println();
        }
    }

    private static int getNumber() {
        Scanner in = new Scanner(System.in);
        int n = 0;
        while (true) {
            try {
                n = in.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("not a number");
                break;
            }
        }
        return n;
    }

    static int[][] getSpeedMatrix() {
        return new int[][]{
                {5, 2, 3, 4, 1},
                {2, 5, 1, 3, 4},
                {4, 3, 2, 1, 5},
                {1, 2, 3, 4, 5},
                {5, 2, 3, 4, 1}
        };
    }

    static int[][] getPriorityMatrix() {
        return new int[][]{
                {5, 3, 4, 1, 2},
                {1, 2, 3, 5, 4},
                {4, 5, 3, 2, 1},
                {5, 2, 1, 4, 3},
                {2, 1, 4, 3, 5}
        };
    }
}
