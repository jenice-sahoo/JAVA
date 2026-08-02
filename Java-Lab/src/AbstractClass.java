abstract class Operations {
    abstract void add();
    abstract void sub();
    abstract void mul();
    abstract void div();
}

class calculator extends Operations {
    void add(){
        System.out.println("add");
    }
    void sub(){
        System.out.println("sub");
    }
    void mul(){
        System.out.println("mul");
    }
    void div(){
        System.out.println("div");
    }
}
public class AbstractClass {
    public static void main(String[] args) {
        
    }
}