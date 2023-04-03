//Abhisekh Bajracharya
import java.util.*;
public class equation
{
    public static void main(String args[]) 
    {
        // ask user to enter an equation
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a string: "); // Please put parenthesis from begining and end, otherwise my code will not work properly.
        String EQ = in.nextLine();
        System.out.println("Solved: " +  SolveEquation(EQ));
        
    }
    static int SolveEquation(String EQ)
    {
        Stack<Integer> Value = new Stack<Integer>();
        Stack<Character> Operator = new Stack<Character>();
        for (int i=0;i<EQ.length(); i++)
        {
            if (Character.isDigit(EQ.charAt(i)))
            Value.push(Character.getNumericValue(EQ.charAt(i)));
            // If token is taken, push to operator stack (Finished up - / and *)
            else if (EQ.charAt(i) =='+'|| EQ.charAt(i) =='-'|| EQ.charAt(i) =='*'|| EQ.charAt(i) =='/'|| EQ.charAt(i) == '(')
            
            Operator.push(EQ.charAt(i));
            else if (EQ.charAt(i) == ')')
            {
                char Op = Operator.pop();
                int Val1 = Value.pop();
                int Val2 = Value.pop();
                //addition
                if (Op == '+')
                Value.push(Val1 + Val2);
                //subtraction
                if (Op == '-')
                Value.push(Val1 - Val2);
                // Multiplications
                if (Op == '*')
                Value.push(Val1 * Val2);
                //Division
                if (Op == '/')
                Value.push(Val1 / Val2);
                Operator.pop();
                
            }
            
        }
        while( (!Operator.isEmpty()))
        {
            // 1. I popped the operator from the operator stack
            char Op = Operator.pop();
            //2. I popped the value stack twice
            int Val1 = Value.pop();
            int Val2 = Value.pop();
            //3. and 4. apply operator to opperands and push the results
            //addition
            if (Op == '+')
            Value.push(Val1 + Val2);
            //subtraction
            if (Op == '-')
            Value.push(Val1 - Val2);
            // Multiplications
            if (Op == '*')
            Value.push(Val1 * Val2);
            //Division
            if (Op == '/')
            Value.push(Val1 / Val2);
            // I did not Pop the opening 
            }
            return Value.pop();
        
    }
    
}