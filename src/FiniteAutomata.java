public class FiniteAutomata {

    public static void main(String[] args) {

        int[][] machineConfig = new int[6][3];
        int[] acceptingStates = {3,5};
        machineConfig[0][0] = 2;
        machineConfig[0][1] = 4;
        machineConfig[0][2] = 6;

        machineConfig[1][0] = 3;
        machineConfig[1][1] = 4;
        machineConfig[1][2] = 2;

        machineConfig[2][0] = 4;
        machineConfig[2][1] = 2;
        machineConfig[2][2] = 2;

        machineConfig[3][0] = 3;
        machineConfig[3][1] = 1;
        machineConfig[3][2] = 5;

        machineConfig[4][0] = 1;
        machineConfig[4][1] = 4;
        machineConfig[4][2] = 6;

        machineConfig[5][0] = 1;
        machineConfig[5][1] = 5;
        machineConfig[5][2] = 4;


        if (RunProgram(machineConfig, "cabcabbc", 4, acceptingStates)) {
            System.out.println("The program ended in an accepting state!");
        } else {
            System.out.println("The program did not end in an accepting state!");
        }

    }

    public static Boolean RunProgram(int[][] stateTable, String inputWord, int initialState, int[] acceptingStates) {
        int currentState = initialState;
        Boolean validEntry = false;


        for (char inputChar:inputWord.toCharArray()) {
            int symbol = (int)inputChar - (int)'a'; //Convert character to int by subtracting a's ASCII value from the characters value. a = 0, b = 1, c = 2, ...
            currentState = stateTable[currentState - 1][symbol];
        }

        for (int i:acceptingStates) {
            if (currentState == i) {
                validEntry = true;
            }
        }
        return validEntry;
    }

}
