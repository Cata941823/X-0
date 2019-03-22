package Xsizero;

import java.util.Scanner;

public class Joc {
    public static void main(String[] args) {
        int [][]Tabla = new int[3][3];
        int []Verificare = new int[8];
        Game(Tabla, Verificare);
    }

    public static void Game(int[][] Tabla, int[] Verificare)
    {
        System.out.println("USR = X, PC = 0");
        do {
            MutareUser(Tabla);
            MutarePC(Tabla);
            afisare(Tabla);
            boolean finish = CheckWinner(Tabla, Verificare);
            if(finish == true) break;
        }while(!TablaTotalParcursa(Tabla));
    }

    private static void MutareUser(int[][] Tabla)
    {
        System.out.println("Dati doua valori: ");
        Scanner x = new Scanner(System.in);
        Scanner y = new Scanner(System.in);
        int i = x.nextInt();
        int j = y.nextInt();
        if(Tabla[i][j]!=0)
        {
            do {
                System.out.println("Reintroduceti alte doua date diferite: ");
                i = x.nextInt();
                j = y.nextInt();
            }while(Tabla[i][j]!=0);
            Tabla[i][j]=-1;
        }
        else Tabla[i][j]=-1;
    }

    private static void MutarePC(int[][] Tabla)
    {
        for(int i = 0; i<3; i++)
        {
            for(int j = 0; j<3; j++)
            {
                if(Tabla[i][j] == 0)
                {
                    Tabla[i][j]=1;
                    return;
                }
            }
        }
    }

    private  static  void afisare(int[][] Tabla)
    {
        for(int i = 0; i<3; i++)
        {
            for(int j = 0; j<3; j++)
            {
                if(Tabla[i][j]==-1) System.out.print("X ");
                else if(Tabla[i][j]==1) System.out.print("O ");
                else System.out.print("_ ");
            }
            System.out.println();
        }
    }

    private static boolean CheckWinner(int[][] Tabla, int[] Verificare)
    {
        boolean finish = false;
        Verificare[0] = Tabla[0][0] + Tabla[0][1] + Tabla[0][2];
        Verificare[1] = Tabla[1][0] + Tabla[1][1] + Tabla[1][2];
        Verificare[2] = Tabla[2][0] + Tabla[2][1] + Tabla[2][2];

        Verificare[3] = Tabla[0][0] + Tabla[1][0] + Tabla[2][0];
        Verificare[4] = Tabla[0][1] + Tabla[1][1] + Tabla[2][1];
        Verificare[5] = Tabla[0][2] + Tabla[1][2] + Tabla[2][2];

        Verificare[6] = Tabla[0][0] + Tabla[1][1] + Tabla[2][2];
        Verificare[7] = Tabla[0][2] + Tabla[1][1] + Tabla[2][0];
        for(int i = 0; i<8; i++)
        {
            if(Verificare[i]==3)
            {
                System.out.println("PC-ul a castigat!");
                finish = true;
                break;
            }
            else if(Verificare[i]==-3)
            {
                System.out.println("USER-ul a castigat!");
                finish = true;
                break;
            }
            else finish = false;
        }
        return finish;
    }

    private static boolean TablaTotalParcursa(int[][] Tabla)
    {
        boolean OK = true;
        for(int i = 0; i<3; i++)
        {
            for(int j = 0; j<3; j++)
            {
                if(Tabla[i][j] == 0)
                {
                    OK = false;
                    break;
                }
            }
        }
        return  OK;
    }
}
