public interface Command{
    public void execute();
    public void undo();

}

public Command1 implements Command{
    private int id;
    Scanner sc = new Scanner(System.in);
}