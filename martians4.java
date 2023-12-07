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

            //This loop for check your guesses with the real locations of cargo.
            for(int i = 0; i < cargoLocations.length; i++) {
                for(int j = 0; j < numbers.length; j++){
                    if(cargoLocations[i] == numbers[j]){
                        isNumberSame = true;
                        cargoLocations[i] = 0;
                        rightGuess++;
                    }
                }
            }
            if( rightGuess == cargoLocations.length){
                System.out.println("You guessed " + rightGuess + " kilometer marks. \nYou have found the cargo.");
                break;
            }
            else{
                System.out.println("You guessed " + rightGuess + " kilometers marks");
                rightGuess = 0;
            }
