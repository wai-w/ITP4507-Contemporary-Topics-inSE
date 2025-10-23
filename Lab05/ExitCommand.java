public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public void undo() {
        // Exit command cannot be undone
    }
}