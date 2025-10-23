import java.util.Scanner;

public class Lab05Q1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Command cmd1 = new Command1(sc);
        Command cmd2 = new Command2(sc);

        System.out.println("Enter command: 0 = exit, 1 = undo, 2 = Command1, 3 = Command2");

        int command = sc.nextInt();
        switch (command) {
            case 0:
                System.out.println("Exiting...");
                break;
            case 1:
                cmd1.undo();
                cmd2.undo();
                break;
            case 2:
                cmd1.execute();
                break;
            case 3:
                cmd2.execute();
                break;
            default:
                System.out.println("Invalid command.");
        }

        sc.close();
    }
}