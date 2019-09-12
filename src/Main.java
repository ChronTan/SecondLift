public class Main {

    public static void main(String[] args) {
        System.out.println("вы вошли в лифт,в доме 9 этажей");
        Lift lift=new Lift();
        Up up=new Up(lift);
        Down down=new Down(lift);
    }
}
