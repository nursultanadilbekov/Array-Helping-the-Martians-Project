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

            if(attempts == 5) {
                System.out.println("Your attempts exhausted. Boxes changing locations... ");
                changeLocations(cargoLocations);
                System.out.println("Cargo have changed location. Try again!");
                attempts = 0;
            }
            cargoLocations = Arrays.copyOf(storedCargoLocations, cargoLocations.length);
            attempts++;
        }

    }
    public static int[] guessNumbers(){
        Scanner scanner = new Scanner(System.in);
        int guess1 = scanner.nextInt();
        int guess2 = scanner.nextInt();
        int guess3 = scanner.nextInt();
        return new int[]{guess1, guess2, guess3};

    }
    public static void changeLocations(int[] cargoLocations){
        Random random = new Random();
        for(int i = 0; i < cargoLocations.length; i++) {
           cargoLocations[i] = random.nextInt(6)  + 1;
        }
    }
    public static int[] generateRandomLocations() {
        Random random = new Random();
        int[] locations = new int[3];
        for (int i = 0; i < locations.length; i++) {
            locations[i] = random.nextInt(6) + 1;
        }
        return locations;
    }
}