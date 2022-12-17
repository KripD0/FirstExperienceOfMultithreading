import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N;
        String path = "data.txt";
        System.out.println("Введите размерность матрицы.");
        N = input.nextInt(); input.nextLine();
        System.out.println("Введите путь к файлу.");
        path = input.nextLine();

        Sharedata sd = new Sharedata(path, N);
        newthread trpArr[]=new newthread[N];
        System.out.println("Исходная матрица:");
        try {
            for(int i=0;i<N;i++){
                if(i>0) trpArr[i-1].th.join();
                trpArr[i]=new newthread(sd,i);
            }
            trpArr[N-1].th.join();
        }
        catch (InterruptedException ex){
            System.out.println(ex);
        }
        System.out.println("\nОбработка завершена");
        System.out.print("Получившийся массив: ");
        for(int i = 0; i< Sharedata.massiv.size(); i ++){
            System.out.print(Sharedata.massiv.get(i) + " ");
        }
    }
}
