package Filosofos;

public class FilosofoRebelde extends Thread{
    
    private String name;
    private Room sala;
    private int id;

    public FilosofoRebelde(String name, Room sala, int id){
        this.name = name;
        this.sala = sala;
        this.id = id;
    }

    @Override
    public void run(){

        while(true){
            try {
                System.out.println(this.name+" esta filosofando ");
                sleep((int) (Math.random() * 9));

                System.out.println("a "+this.name+" le dio hambre ");
                
                sala.right(this.id, this.name);
                sala.left(this.id, this.name);

                System.out.println(this.name+ "esta comiendo");
                sleep((int) (Math.random() * 9));

                sala.endEats(this.id, this.name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
