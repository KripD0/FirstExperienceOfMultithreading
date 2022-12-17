import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sharedata {
    final int N = 5;
    static ArrayList<Integer> massiv = new ArrayList<Integer>();
    private int a[][];

    public int min = Integer.MAX_VALUE;
    public Sharedata(String path, int N){
        try(Scanner scan=new Scanner(new File(path)))
        {
            a=new int[N][N];
            for(int i=0;i<N;i++)
                for (int j=0;j<N;j++) {
                    a[i][j] = scan.nextInt();
                    if (a[i][j] < min) {
                        min = a[i][j];
                    }
                }
        }
        catch (IOException ex){
            System.out.println(ex);
        }
    }
    void rowmassiv(int numRow){
        boolean daornet = false;
        for(int j=0;j<N;j++)
            if(a[numRow][j] == min){
                daornet = true;
            }
        if (daornet){
            massiv.add(1);
        }
        else massiv.add(-1);
    }
    void rowPrint(int numRow){
        for(int j=0;j<N;j++)
            System.out.print(a[numRow][j]+" ");
    }
    void rowprintmassiv(int numRow){
            System.out.print("Получившийся элемент масисва: " + massiv.get(numRow) + "\n");
    }
}

