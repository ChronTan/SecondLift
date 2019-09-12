public class Down implements Runnable {

    Lift lift;
    Thread t;

    Down(Lift lift){
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
                lift.down();
        }
    }
}
