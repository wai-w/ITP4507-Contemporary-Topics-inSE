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

