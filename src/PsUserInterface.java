import java.util.Scanner;
import psmodel.PsLogic;
import cardutils.Card;
import cardutils.Pile;

public class PsUserInterface {

    private final Scanner scan;
    private final PsLogic logic;

    public PsUserInterface() {
        this.scan = new Scanner(System.in);
        this.logic = new PsLogic();
    }

    public void run() {
        System.out.println("❤️♦️♠️♣️ Welcome to Poker Squares! ❤️♦️♠️♣️");
        char choice;
        do {
            printMenu();

            String answer = scan.nextLine().trim().toUpperCase();
            if(answer.isEmpty()){
                choice = '\0';
            }
            else{
                choice = answer.charAt(0);
            }

            switch (choice) {
                case 'N':
                    logic.initNewGame();
                    System.out.println("New game started!\n");
                    break;
                case 'P':
                    playGame();
                    break;
                case 'E':
                    System.out.println("Thanks for playing! Goodbye!");
                    break;
                default:
                    System.out.println("Unknown command!");
                    break;
            }
        } while (choice != 'E');
    }

    private void printMenu() {
        System.out.println("N - New Game");
        System.out.println("P - Play the Game");
        System.out.println("E - Exit");
        System.out.println("---------------------");
        System.out.print("Choice: ");
    }

    private void playGame() {
        if (logic.isGameOver()) {
            System.out.println("Game over already. Final score: " + logic.getPoints() + "\n");
            return;
        }
        while (!logic.isGameOver()) {
            Card c;
            try{
                c = logic.pickNextCard();
            }catch(IllegalStateException  e){
                System.out.println("Cannot draw a new card: " + e.getMessage());
                break;
            }
            System.out.println("You drew: " + c);

            boolean placed = false;
            while(!placed){
                printPiles();
                System.out.print("Choose pile [0-4]: ");
                int pileIndex;
                try{
                    pileIndex = Integer.parseInt(scan.nextLine().trim());
                }catch (NumberFormatException e){
                    System.out.println("Please enter a valid number (0-4)!");
                    continue;
                }

                if (pileIndex < 0 || pileIndex >= 5) {
                    System.out.println("Invalid pile number! Must be between 0 and 4.");
                    continue;
                }

                try{
                    logic.addCardToPile(pileIndex);
                    placed = true;
                }catch(IllegalStateException e){
                    System.out.println("Cannot place card: " + e.getMessage());
                }

            }
            System.out.println();
        }
        System.out.println("All cards placed!");
        System.out.println("Final score: " + logic.getPoints() + "\n");
        System.out.println();
    }

    private void printPiles() {
        int i = 0;
        for (Pile p : logic.getPiles()) {
            System.out.println("Pile " + i + ": " + p);
            i++;
        }
    }
}