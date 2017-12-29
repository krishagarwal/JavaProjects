import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Electoral {
    private ArrayList<State> states = new ArrayList<State>();

    public Electoral(String fName) {
        loadFile(fName);
    }

    public Electoral() {
        this("Data.txt");
    }

    public static void main(String[] args) {
        Electoral run = new Electoral("Data");
        run.menu();
    }

    public void menu() {
        char choice;
        do {
            choice = getUserInput();
            switch (choice) {
                case '1':
                    mergeSortName(states, 0, states.size() - 1);
                    displayStates();
                    break;
                case '2':
                    insertionSortElectoralVotes(states);
                    displayStates();
                    break;
                case '3':
                    selectionSortClintonPercentage(states);
                    displayStates();
                    break;
                case '4':
                    bubbleSortTrumpPercentage(states);
                    displayStates();
                    break;
                case '5':
                    printResults(states);
                    break;
            }
        }
        while (choice >= '1' && choice <= '5');
        goodBye();
    }

    public char getUserInput() {
        char choice = '1';
        System.out.println("\n\n1: Display States sorted by name");
        System.out.println("2: Display States sorted by Electoral Votes");
        System.out.println("3: Display States sorted by Percentage for Clinton");
        System.out.println("4: Display States sorted by Percentage for Trump");
        System.out.println("5: Display Electoral Totals for the Candidates");
        System.out.println("6: Exit");

        do {
            choice = Prompt.getChar("\nPlease Enter 1 through 6, indicating your choice from the menu above: ");
        }
        while (choice < '1' || choice > '6');
        return choice;
    }

    private void loadFile(String inFileName) {
        String name;
        int numOfElectoral;
        int numOfTrump;
        int numOfClinton;
        int numOfOther;

        try {
            Scanner inFile = new Scanner(new File(inFileName));
            while (inFile.hasNext()) {
                name = inFile.next();
                numOfElectoral = inFile.nextInt();
                numOfTrump = inFile.nextInt();
                numOfClinton = inFile.nextInt();
                numOfOther = inFile.nextInt();

                states.add(new State(name, numOfElectoral, numOfTrump, numOfClinton, numOfOther));
            }
        } catch (IOException i) {
            System.out.println("Error: " + i.getMessage());
        }
    }

    public void displayStates() {
        System.out.println("\n\n\n+------------------+");
        System.out.println("| List of States   |");
        System.out.println("+---------------------------------------------------------+");
        System.out.println("|                                                         |");
        System.out.println("|  State    Electoral   Trump   Clinton   Other  Winner   |");
        for (int i = 0; i < states.size(); i++) {
            if (i % 5 == 0) {
                System.out.println("|                                                         |");
            }
            System.out.println("|  " + states.get(i) + "  |");
        }
        System.out.println("|                                                         |");
        System.out.println("+---------------------------------------------------------+");
    }

    public void merge(ArrayList<State> list, int startA, int endA, int startB, int endB){

        ArrayList<State> mergedList = new ArrayList<>();

        int indexA = startA;
        int indexB = startB;

        while(indexA <= endA && indexB <= endB){
            if(list.get(indexA).compareTo(list.get(indexB)) > 0){
                mergedList.add(list.get(indexB));
                indexB++;
            }
            else{
                mergedList.add(list.get(indexA));
                indexA++;
            }
        }

        if (indexA <= endA){
            for(int i = indexA; i<=endA; i++){
                mergedList.add(list.get(i));
            }
        } else {
            for(int i = indexB; i<=endB; i++){
                mergedList.add(list.get(i));
            }
        }

        int counter = 0;
        for(int i = startA; i<= endB; i++){
            list.set(i, mergedList.get(counter));
            counter++;
        }
    }

    public void mergeSortName(ArrayList<State> list, int first, int last) {

        if(last - first == 0){
            return;
        }

        mergeSortName(list, first, (last + first) / 2);
        mergeSortName(list, (last + first) / 2 + 1, last);
        merge(list, first, (last + first) / 2, (last + first) / 2 + 1, last);
    }


    private void swap(ArrayList<State> list, int i, int j) {
        State temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private int findMinClintonPercentageIndex(ArrayList<State> m, int endIndex){
        int minIndex = 0;

        for(int i = 1; i <= endIndex; i++){
            if(m.get(minIndex).compareToClintonPercentage(m.get(i)) > 0){
                minIndex = i;
            }
        }

        return minIndex;
    }

    public void insertionSortElectoralVotes(ArrayList<State> list) {

        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < i; j++){
                if(list.get(i).compareToElectoralVotes(list.get(j)) < 0){
                    State temp = list.get(i);
                    list.remove(i);
                    list.add(j, temp);
                }
            }
        }

    }

    public void selectionSortClintonPercentage(ArrayList<State> list) {

        for(int i = list.size() - 1; i > 0; i--){
            int maxIndex = findMinClintonPercentageIndex(list, i);
            swap(list, maxIndex, i);
        }

    }


    public void bubbleSortTrumpPercentage(ArrayList<State> list) {

        boolean isDone = false;

        while(!isDone){
            isDone = true;
            for(int i = 0; i < list.size() - 1; i++){
                if(list.get(i).compareToTrumpPercentage(list.get(i + 1)) < 0){
                    swap(list, i, i+1);
                    isDone = false;
                }
            }
        }

    }

    public void printResults(ArrayList<State> list) {
        int trumpTotal = 0, clintonTotal = 0, trumpPopular = 0, clintonPopular = 0;

        System.out.println("\n\n\nELECTORAL TOTALS\n");
        System.out.println("Clinton: " + clintonTotal);
        System.out.println("Trump  : " + trumpTotal + "\n\n");
        System.out.println("POPULAR VOTE TOTALS\n");
        System.out.println("Clinton: " + clintonPopular);
        System.out.println("Trump  : " + trumpPopular + "\n\n");
    }

    public void goodBye() {
        System.out.println("\n\nThanks for reviewing the Electoral College results!\n\n\n");
    }
}