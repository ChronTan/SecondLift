public class Up implements  Runnable{
    Lift lift;
    Thread t;

    Up(Lift lift){
        this.lift=lift;
        t=new Thread(this);
        t.start();
    }


    public void run(){
        while(lift.flag){
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
                lift.up();
        }
    }
}
