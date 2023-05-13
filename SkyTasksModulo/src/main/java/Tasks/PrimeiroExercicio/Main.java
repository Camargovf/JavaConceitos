package Tasks.PrimeiroExercicio;

import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final String INPUT_MESSAGE = "Digite um número inteiro:";
    private static final String INVALID_INPUT_MESSAGE = "Entrada inválida. O valor deve ser um número inteiro.";
    private static final String NO_REPETITIONS_MESSAGE = "Não foram encontradas repetições de três algarismos consecutivos.";

    public static void main(String[] args) {
        try {
            String input = getInput(INPUT_MESSAGE);
            if (isValidInput(input)) {
                long number = convertToLong(input);
                String result = findRepetitions(number);
                showMessage(result);
                logResult(result);
            } else {
                showMessage(INVALID_INPUT_MESSAGE);
                LOGGER.log(Level.WARNING, INVALID_INPUT_MESSAGE);
            }
        } catch (NumberFormatException e) {
            showMessage(INVALID_INPUT_MESSAGE);
            LOGGER.log(Level.WARNING, INVALID_INPUT_MESSAGE);
        }
    }

    private static String getInput(String message) {
        return JOptionPane.showInputDialog(message);
    }

    private static boolean isValidInput(String input) {
        return input.matches("\\d+");
    }

    private static long convertToLong(String input) {
        return Long.parseLong(input);
    }


    private static String findRepetitions(long number) {
        String digits = String.valueOf(number);
        StringBuilder output = new StringBuilder();
        int index = 2;

        for (char digit : digits.substring(2).toCharArray()) {
            if (digit == digits.charAt(index - 1) && digit == digits.charAt(index - 2)) {
                output.append("Há uma sequência de algarismos ")
                        .append(digit)
                        .append(" repetidos três vezes consecutivas com início na posição ")
                        .append(index)
                        .append(".\n");
            }
            index++;
        }

        return output.length() == 0 ? NO_REPETITIONS_MESSAGE : output.toString();

    }

    private static void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private static void logResult(String result) {
        LOGGER.log(Level.INFO, result);
    }
}
