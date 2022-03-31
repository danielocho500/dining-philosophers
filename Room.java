package Filosofos;

public class Room {
    private boolean[] forks;

    public Room(){
        forks = new boolean[5];

        forks[0] = false;
        forks[1] = false;
        forks[2] = false;
        forks[3] = false;
        forks[4] = false;
    }

    public synchronized void left(int id, String name){
        System.out.println(name + " wanna use the left fork");
        while(this.forks[id] == true){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        forks[id] = true;
        System.out.println(name + " uses the left fork");

        notifyAll();
    }
    
    public synchronized void right(int id, String name){
        System.out.println(name + " Wanna use the right fork");

        int position = 0;

        if(id == 0)
            position = 4;
        else
            position = id - 1;

        while(this.forks[position] == true){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        forks[position] = true;
        System.out.println(name + " uses the right fork");

        notifyAll();
    }

    public synchronized void endEats(int id, String name){
        System.out.println(name + " is not eating anymore");

        forks[id] = false;
        if(id == 0)
            forks[4] = false;
        else
            forks[id-1] = false;

        notifyAll();
    }
}
