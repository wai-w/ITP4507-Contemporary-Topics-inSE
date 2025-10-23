public interface Command{
    public void execute();
    public void undo();

}

public class Command1 implements Command{
    private int id;
    private static final Scanner sc = new Scanner(System.in);

    public Command1(Scanner sc){
        this.sc = sc;
    }
    public void execute(){
        System.out.println("Input ID for Command 1:");
        id = sc.nextInt();  
        System.out.println(id + "Command 1 : execute()");
    }
    public void undo(){
        System.out.println(id + "Command 1 : undo()");
    }
}



public class Command2 implements Command{
    private int id;
    private static final Scanner sc = new Scanner(System.in);

    public Command2(Scanner sc){
        this.sc = sc;
    }
    public void execute(){
        System.out.println("Input ID for Command 2:");
        id = sc.nextInt();  
        System.out.println(id + "Command 2 : execute()");
    }
    public void undo(){
        System.out.println(id + "Command 2 : undo()");
    }
}


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