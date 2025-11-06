public class Lab06Q1B {
    public static void main(String[] args) {
        Caretaker ct = new Caretaker();
        MyClass mc = new MyClass();
    System.out.println("Create a MyClass object with state 1");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int command = -1;
        while (command != 0) {
            System.out.println( "Enter command: 0 = exit, 1 = undo, 2 = redo, 3 = doAction");
            command = scanner.nextInt();
            switch (command) {
                case 1:
                    ct.undo();
                    break;
                case 2:
                    ct.redo();
                    break;
                case 3:
                    // save current state before performing action so undo will restore previous state
                    ct.saveMyClass(mc);
                    mc.doAction();
                    break;
                default:
                    break;
            }
            System.out.println("Current state : " + mc.getState());
        }
    }
}
