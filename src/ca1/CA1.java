package ca1;

import java.io.BufferedReader;
import java.util.Collections;
import java.io.FileReader;
import java.util.ArrayList;

public class CA1 {

    //Enum that will store the team names. Each team will have a number attributed to it so later on in the code we can attribute the people to the groups.
    public enum TeamNames {

        SLYTHERIN(1), MUGGLES(2), HUFFLEPUFF(3), GRYFFINDOR(4), RAVENCLAW(5), THE_LOCOS(6), MANIACS(7), STORM_TROOPERS(8), LOST_IN_TRANSLATION(9),
        GHOSTS(10), DARK_TOADS(11), BAT_GIRLS(12), THE_REPUBLIC(13), GUARDIANS_OF_THE_GALAXY(14), LOSERS(15), SLOW_RUNNERS(16), DEEP_SLEEPERS(17), SOBER_CHILDS(18),
        THE_NERDS(19), FALLEN_WINNERS(20);

        //It defines an integer field to associate a team number with each enum value.
        private final int teamNumber;

        //Constructor for the TeamNames enum that takes an int parameter to initialize teamNumber.
        TeamNames(int teamNumber) {
            this.teamNumber = teamNumber;
        }

        //Getter method to retrieve the associated team number for each enum value.
        public int getTeamNumber() {
            return teamNumber;
        }

    }

    public static void main(String[] args) {

        //It initializes a variable that will store each line of the file.
        String line = "";

        //It creates an arraylist that will be used to store the first names.
        ArrayList<String> firstNames = new ArrayList<>();

        //Try/Catch to keep the code from crashing in case of any errors with the file etc.
        try {
            
            //It initializes the BufferedReader and loads the CSV file. 
            BufferedReader reader = new BufferedReader(new FileReader("MOCK_DATA.csv"));

            //This loop makes sure the program will keep reading line by line until there's none left.
            while ((line = reader.readLine()) != null) {
                //It creates an array and implements a method that splits each line using a comma as the delimiter, it works because it's a csv file.
                String[] row = line.split(",");
                //It checks if the row has at least 2 elements (index 1 corresponds to the first name).
                if (row.length >= 2) {
                    //It extracts the first element of the row, in this case the first name.
                    String firstName = row[1];
                    //It adds the first name to the arraylist.
                    firstNames.add(firstName);
                }
            }
            //It displays the first names extracted from the file.
            System.out.println("First names extracted from the file:");
            //An enhanced loop to display the first names saved in the arraylist.
            for (String name : firstNames) {
                //It displays the name.
                System.out.println(name);
            }

            //Collections' method to shuffled a list, in this case the list with the first names extracted from the file.
            Collections.shuffle(firstNames);

            System.out.println("*******************************************************************");
            System.out.println("*******************************************************************");
            System.out.println("*******************************************************************");

            System.out.println("First names extracted from the list after being shuffled:");
            //An enhanced loop to display the first names saved in the arraylist after being shuffled.
            for (String shuffledName : firstNames) {
                System.out.println(shuffledName);
            }

            System.out.println("*******************************************************************");
            System.out.println("*******************************************************************");
            System.out.println("*******************************************************************");

            //A variable that sets the size of the teams.
            int teamSize = 5;
            //It keeps track of the current team to which a name is being assigned. 
            int currentTeam = 0;
            //It's an ArrayList that temporarily holds the names for the current team.
            ArrayList<String> currentMembers = new ArrayList<>();

            //An inhanced loop that iterates through the shuffled names.
            for (String name : firstNames) {
                //It adds the current name to the current team.
                currentMembers.add(name); 

                //A condition to check if the current team has reached its size limit (teamSize).
                if (currentMembers.size() == teamSize) {
                    //It displays the name of the team and the names that have been added to the team.
                    System.out.println("Team: " + TeamNames.values()[currentTeam] + ", Members: " + currentMembers);
                    //It then clears the array so the process can be repeated.
                    currentMembers.clear();
                    //It makes sure to move to the next team after reaching its limit of 5. 
                    currentTeam = (currentTeam + 1) % TeamNames.values().length;
                }
            }

            //It handles any remaining members who haven't been assigned to teams.
            if (!currentMembers.isEmpty()) {
                //It displays the teams and the members.
                System.out.println("Team: " + TeamNames.values()[currentTeam] + ", Members: " + currentMembers);
            }
            //Catch to avoid the code from running in case of errors.
        } catch (Exception e) {
            System.out.println("It seems something went wrong!");
        }
    }

}
