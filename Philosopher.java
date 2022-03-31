package Filosofos;

public class Philosopher extends Thread{
    
    private String name;
    private Room room;
    private int id;

    public Philosopher(String name, Room room, int id){
        this.name = name;
        this.room = room;
        this.id = id;
    }

    @Override
    public void run(){

        while(true){
            try {
                //thinks
                System.out.println(this.name+" is thinking ");
                sleep((int) (Math.random() * 9));

                //waits to eat
                System.out.println(this.name+" is hungry ");
                
                room.left(this.id, this.name);
                room.right(this.id, this.name);

                //eat
                System.out.println(this.name+ " Is eating");
                sleep((int) (Math.random() * 9));

                room.endEats(this.id, this.name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
