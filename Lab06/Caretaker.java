import java.util.Stack;

public class Caretaker{


    private Stack<Memento> undoList = new Stack<Memento>();
    private Stack<Memento> redoList = new Stack<Memento>();


    public void saveMyClass(MyClass mc) {
        Memento memento = new Memento(mc);//new Memento = backup
        undoList.push(memento);//save it into undo Stack  different with command pattern
        redoList.clear();
    }

    public void undo() {
        if (!undoList.isEmpty()) {
            System.out.println("Perform undo.");
            Memento m = undoList.pop();
            Memento redoMemento = new Memento(m.myClass);
            m.restore();
            redoList.push(redoMemento);

        } else {
            System.out.println("Nothing to undo.");
        }   
    }
    public void redo() {
        if (!redoList.isEmpty()) {
            System.out.println("Perform redo.");
            Memento m = redoList.pop();
            Memento undoMemento = new Memento(m.myClass);
            m.restore();
            undoList.push(undoMemento);
        } else {
            System.out.println("Nothing to redo.");
        }   
    }
}