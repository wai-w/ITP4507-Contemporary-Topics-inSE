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

public class Memento {
    private int mState;
    private MyClass myClass;

    public Memento(MyClass mc) {
        this.myClass = mc;
        this.mState = mc.getState();
    }

    public int getState() {
        return mState;
    }
}