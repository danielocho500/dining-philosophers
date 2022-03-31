package Filosofos;

public class Principal {
    public static void main(String[] args) {
        Room room = new Room();

        Philosopher f0 = new Philosopher("Nietzsche", room, 0);
        Philosopher f1 = new Philosopher("Platón", room, 1);
        Philosopher f2 = new Philosopher("Kant", room, 2);
        Philosopher f3 = new Philosopher("Aristóteles", room, 3);
        Philosopher f4 = new Philosopher("Confucio", room, 4);

        f0.start();
        f1.start();
        f2.start();
        f3.start();
        f4.start();
    }
}
