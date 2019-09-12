import java.util.*;

public class Lift {

    boolean flag=true;
    ArrayList<Integer> arr=new ArrayList<>();
    int stage=1;
    int inputStage = chooseStage();
    int count=0;
    int z=0;
    int k=0;
    int key=0;
    boolean c=true;

    public synchronized void up(){
        if (inputStage == -1) {
//                    main.flag=false;
            System.exit(0);
        }
        if((inputStage<10 && inputStage>0)) {
            if (count == 0 && stage <= inputStage) {
                System.out.println("Up| Stage: " + stage);
                if (stage < inputStage)
                    stage++;
                if (stage == inputStage) {
                    try {
                        Thread.sleep(500);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("Up| Stage: " + stage + " you coming!");
//                   delArr(main.num);
                    try {
                        Thread.sleep(500);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    inputStage = chooseStage();
                }
            } else {
                try {
                    count = 5;
                    notify();
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else{
            System.out.println("Такого этажа не существует, всего 9 этажей");
            inputStage = chooseStage();
        }
    }


    public synchronized void down(){
        if (inputStage == -1) {
//                    main.flag=false;
            System.exit(0);
        }
        if((inputStage>0 && inputStage<10)) {
            if (count == 5 && stage >= inputStage) {
                System.out.println("Down| Stage: " + stage);
                if (stage > inputStage)
                    stage--;
                if (stage == inputStage) {
                    try {
                        Thread.sleep(500);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("Down| Stage: " + stage + " You coming!");
//                   delArr(main.num);
                    try {
                        Thread.sleep(500);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    inputStage = chooseStage();
                }
            } else {
                try {
                    count=0;
                    notify();
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else{
            System.out.println("Такого этажа не существует, всего 9 этажей");
            inputStage = chooseStage();
        }

    }

    public int chooseStage(){
        if(arr.size()==0){
            key=0;
            Scanner scanner=new Scanner(System.in);
            System.out.println("Input you stage: ");
            String iS=scanner.nextLine();
            String[] str=iS.split(" ");
            for(String s:str) {
                arr.add(Integer.parseInt(s));
            }
            Set<Integer> set = new HashSet<>(arr);
            arr.clear();
            arr.addAll(set);
            for(int i=0;i<arr.size();i++){
                if(z==arr.get(i)){
                    System.out.println("Stage: " + z + " You coming!");
                    arr.remove(i);
                }
                if(z>=arr.get(i) && z!=0){
                    k=1;
                }
            }
            if(k==0){
                Collections.sort(arr);
                if(z!=0) {
                    ArrayList<Integer> arr2=new ArrayList<>();
                    for(int i=0;i<arr.size();i++){
                        if(arr.get(i)>z && c)
                        {
                            key=i;
                            c=false;
                        }
                    }
                    for (int j = key; j < arr.size(); j++) {
                        arr2.add(arr.get(j));
                    }
                    for (int v = 0; v < arr.size()-arr2.size(); v++) {
                        arr2.add(arr.get(v));
                    }
                    arr=new ArrayList<>(arr2);
                }
                k=1;
                c=true;
            }else {
                Collections.sort(arr);
                ArrayList<Integer> arr2=new ArrayList<>();
                for(int i=0;i<arr.size();i++){
                    if(arr.get(i)>z && c) {
                        key = i;
                        c=false;
                    }
                }
                if(c) {
                    Collections.sort(arr, Collections.reverseOrder());
                    key=0;
                }
                for (int j = key; j < arr.size(); j++) {
                    arr2.add(arr.get(j));
                }
                for (int v = 0; v < arr.size()-arr2.size(); v++) {
                    arr2.add(arr.get(v));
                }
                arr=new ArrayList<>(arr2);
                c=true;
                k=0;
            }
            z=arr.get(0);
            arr.remove(0);
        }else{
            z=arr.get(0);
            arr.remove(0);
        }
        return z;
    }


}
