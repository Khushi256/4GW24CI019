interface Resizeable {
    void resizewidth(int width);
    void resizeheight(int height);
}

class Rectangle implements Resizeable{
    int width;
    int height;
    Rectangle(int w,int h){
        width = w;
        height = h;
    }
    public void display(){
        System.out.println("Width: "+ width + "Height: " + height);
    }
    public void resizewidth(int newwidth){
        width = newwidth;
    }
    public void resizeheight(int newheight){
        height = newheight;
    }
}

public class ResizeTest{
    public static void main(String args[]){
        
        Rectangle r = new Rectangle(10,20);
        
        System.out.println("Before resize:\n");
        r.display();

        r.resizewidth(30);
        r.resizeheight(40);

        System.out.println("After resize:\n");
        r.display();

    }
}