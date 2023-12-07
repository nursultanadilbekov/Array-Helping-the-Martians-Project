import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] cargoWeights = {150, 250, 313}; //weights of cargo

        int attempts = 1;
        boolean isNumberSame = false;
        boolean isAllIncorrect = true;

        int rightGuess = 0;
        int[] cargoLocations = generateRandomLocations(); //locations of cargo
        int[] storedCargoLocations = Arrays.copyOf(cargoLocations, cargoLocations.length); // returns cargoLocation values back

        while(isAllIncorrect){
            System.out.println("Attemps: " + attempts + " \nEnter the kilometer marks to check cargo location: ");
            int[] numbers = guessNumbers();

            