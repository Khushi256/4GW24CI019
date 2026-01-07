class DivisonByZeroException extends Exception{
    
    DivisonByZeroException(String message){
        super(message);
    }
}

public class DivisionTest{
    public static void main(String args[]){

        int num = 10;
        int den = 0;

        try{
            if(den == 0){
                throw new DivisonByZeroException("Division by zero is not allowed!");
            }
            int result = num/den;
            System.out.println("Result: " + result);
        }
        catch(DivisonByZeroException e){
            System.out.println("Exception caught: " + e.getMessage());
        }
        finally{
            System.out.println("This is the final block");
        }
    }
}
