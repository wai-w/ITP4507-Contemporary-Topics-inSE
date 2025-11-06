public class MyClass {
    int state;
    public MyClass() {
        state = 1;
    }

    public void doAction() {
        state++;
    }
    public int getState() {
        return state;
    }

}

class Memento {
    private int mState;
    MyClass myClass;

    public Memento(MyClass mc) {
        this.myClass = mc;//linking
        this.mState = mc.getState();//value assignment
    }

    public void restore() {
        myClass.state = mState;//restoring state
    }
}