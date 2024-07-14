import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class ParenSymmetry {


    private Boolean isBalanced(String s) {
        //help
        //(()())((())))
        //stack:
        //string:((")" ())((())))
        Stack<Object> paren= new Stack<>();
        for (int i = 0; i < s.length(); i++){
            int indvChar = s.charAt(i);
            if (indvChar == '('){
                paren.push(indvChar);

            } else if (indvChar == ')'){
                try{
                    paren.pop();
                } catch (Exception exception) {
                    return false;
                }

            }
        }
        if (paren.isEmpty()){
            return true;
        }

        return false;
    }

    private void checkFile(String filename)  {
        // open file named filename
        try {
            Scanner fileIn = new Scanner(new File(filename));

            // for each line in the file
            // read the line
            // print whether or not the line's parenthesis are balanced
            while (fileIn.hasNext()){
                String lineIn = fileIn.nextLine();
                System.out.println(isBalanced(lineIn));
            }
            // CLOSE the file
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }

    }

    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry();

        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);

        ps.checkFile("/Users/devi/Dev/Projects/ParenSymmetry/TestStrings0.txt");
        ps.checkFile("/Users/devi/Dev/Projects/ParenSymmetry/TestStrings1.txt");

    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
