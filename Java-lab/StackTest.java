import java.util.Scanner;

class Stack {

    private int maxsize = 10;
    private int top ;
    private int[] stackArray;

    public Stack(){
        top = -1;
        stackArray = new int[maxsize];
    }

    //push
    public void push(int val){
        if(top == maxsize - 1){
            System.out.println("Overflow\n");
        }
        else{
            stackArray[++top] = val;
            System.out.println(val+" pushed.\n");
        }
    }

    //pop
    public int pop(){
        if(top == -1){
            System.out.println("Underflow\n");
            return -1;
        }
        else{
            int val = stackArray[top--];
            System.out.println(val+" popped.\n");
            return val;
        }
    }

    //display
    public void display(){
        if(top == -1){
            System.out.println("empty\n");
        }
        else{
            System.out.println("stack elements are :\n");
            for(int i = top; i >= 0 ; i-- ){
                System.out.println(stackArray[i]);
            }
        }
    }
}

public class StackTest{
    public static void main (String args[]){

        Stack stack = new Stack();
        Scanner sc = new Scanner(System.in);

        int choice,val;

        do{
            System.out.println("\n -----STACK OPERATION----\n");
            System.out.println("1.push\n");
            System.out.println("2.pop\n");
            System.out.println("3.display\n");
            System.out.println("4.exit\n");
            System.out.println("Enter your choice: \n");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("enter value to be pushed: \n");
                    val = sc.nextInt();
                    stack.push(val);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.display();
                    break;
                case 4:
                    System.out.println("exited from program\n");
                    break;
                default:
                     System.out.println("invalid input!\n");

            }
        }
        while(choice != 4);
        sc.close();

    }
}
