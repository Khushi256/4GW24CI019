class Outer {
    void display(){
        System.out.println("This is an outer class\n");
    }
    class Inner {
        void display(){
            System.out.println("This is an inner class\n");
    }
}
}
public class OuterInnerTest{
    public static void main(String args[]){

        Outer o = new Outer();
        o.display();

        Outer.Inner i = o.new Inner();
        i.display();
    }
}

