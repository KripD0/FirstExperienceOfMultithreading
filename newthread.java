public class newthread implements Runnable{
    int numRow;
    Sharedata sd;
    Thread th, threadwiwiod;
    newthread(Sharedata sd, int numRow){
        this.sd=sd;
        this.numRow=numRow;
        th=new Thread(this);
        th.start();
    }
    public void run() {
        Runnable r = () -> {
            sd.rowprintmassiv(numRow);
        };
        synchronized (this.sd)
        {
            try {
                sd.rowPrint(numRow);
                sd.rowmassiv(numRow);
                threadwiwiod = new Thread(r, "Поток вывода получившийся строки.");
                threadwiwiod.start();
                threadwiwiod.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
