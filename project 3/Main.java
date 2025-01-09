public class Main {
    public static void main(String[] args) {
        InfixToPostfix ITP = new InfixToPostfix();
        EvaluatePostfix EPF = new EvaluatePostfix();

        String[] testCases = {
            "2+3*4",
            "100*2+12",
            "100*(2+12)",
            "100*2/50",
            "2^3^2",
            "2-3+4",
            "2*3-4/2",
            "20/(5-3)",
            "3*(2+3)-6/(1+2)",
            "2^3*2",
            "10/0" // Test case for dividng by zero
        };

        for (String testCase : testCases) {
            String postfix = ITP.infixToPostfix(testCase);
            System.out.println("Infix Expression: " + testCase);
            System.out.println("Postfix Expression: " + postfix);
            System.out.println("Evaluation: " + EPF.evaluatePostfix(postfix));
            System.out.println();
        }
    }
}
