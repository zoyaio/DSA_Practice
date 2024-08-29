package bigO;

/**
 * Program to find the runtime in miliseconds for functions.
 */
public class ExecutionTimer {
    public static void main(String[] args) {
        final int NUMBER_OF_INSTRUCTIONS = 100; //Sets the number of instructions
        Analysis test = new Analysis();

        final long startTime = System.currentTimeMillis();
        //test.fun1(NUMBER_OF_INSTRUCTIONS);
        //test.fun2(NUMBER_OF_INSTRUCTIONS);
        //test.fun3(NUMBER_OF_INSTRUCTIONS);
        //test.fun4(NUMBER_OF_INSTRUCTIONS);
        //test.fun5(NUMBER_OF_INSTRUCTIONS);
        //test.fun6(NUMBER_OF_INSTRUCTIONS);
        //test.fun7(NUMBER_OF_INSTRUCTIONS);
        //test.fun8(NUMBER_OF_INSTRUCTIONS);
        //test.fun9(NUMBER_OF_INSTRUCTIONS);
        //test.fun10(NUMBER_OF_INSTRUCTIONS);
        //test.fun11(NUMBER_OF_INSTRUCTIONS);
        //test.fun12(NUMBER_OF_INSTRUCTIONS);
        //test.fun13(NUMBER_OF_INSTRUCTIONS);

        final long endTime = System.currentTimeMillis();

        System.out.println("Total execution time: " + (endTime - startTime));

    }
}
