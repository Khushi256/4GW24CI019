class Shape {
    void draw(){
        System.out.print("Drawing shape\n");
    }
    void erase(){
        System.out.print("Erasing shape\n");
    }
}
class Circle extends Shape {
    void draw(){
        System.out.print("Drawing circle\n");
    }
    void erase(){
        System.out.print("Erasing circle\n");
    }
}

class triangle extends Shape {
    void draw(){
        System.out.print("Drawing triangle\n");
    }
    void erase(){
        System.out.print("Erasing triangle\n");
    }
}

class square extends Shape {
    void draw(){
        System.out.print("Drawing square\n");
    }
    void erase(){
        System.out.print("Erasing square\n");
    }
}

public class ShapeDemo {
    public static void main (String args[]){
        Shape shape;
        shape = new Circle();
        shape.draw();
        shape.erase();

        shape = new triangle();
        shape.draw();
        shape.erase();

        shape = new square();
        shape.draw();
        shape.erase();
    }
}
