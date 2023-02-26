import cards.Rooms;
import cards.Suspects;
import cards.Weapons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ClueCalculator {

    public static void main(String[] args) throws IOException {
        int numOfPlayers;
        //Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to Clue Calculator");
        System.out.println("How many players are there?");
        while (true) {
            try {
                numOfPlayers = Integer.parseInt(reader.readLine());
                if (numOfPlayers < 1) {
                    System.out.println("Invalid number of players");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number of players");
            }
        }
        System.out.println("There are " + numOfPlayers + " players");
        ArrayList<CluePlayer> players = new ArrayList<>(numOfPlayers);
        System.out.println("Enter your name: \n");
        String name = reader.readLine();
        System.out.println("You are " + name);
        int playerNumber;
        do {
            printCharacters();
            System.out.println("Enter your player number: ");
            playerNumber = Integer.parseInt(reader.readLine());
            System.out.println(playerNumber);
            if (!(playerNumber > Suspects.values().length || playerNumber < 1))
                break;
            System.out.println("Invalid player number");
        } while (true);
        System.out.println("You are " + Suspects.getName(playerNumber));
        ArrayList<Suspects> characters = new ArrayList<>();
        System.out.println("Press enter an extra time when done entering characters");
        printCharacters();
        System.out.println("Enter all of Character cards you have and end it by entering 0");
        while (true) {
            int num = Integer.parseInt(reader.readLine());
            if (num == 0) break;
            if (!characters.isEmpty() && characters.contains(Suspects.getCharacter(num)) || num > Suspects.values().length || num < 1)
                System.out.println("You already entered that character or Invalid character number");
            else characters.add(Suspects.getCharacter(num));
        }

        ArrayList<Weapons> weapons = new ArrayList<>();
        printWeapons();
        System.out.println("Enter any Weapon cards you have");
        while (true){
            int num = Integer.parseInt(reader.readLine());
            if (num == 0) break;
            if (!weapons.isEmpty() && weapons.contains(Weapons.getWeapon(num)) || num > Weapons.values().length || num < 1)
                System.out.println("You already entered that weapon or Invalid weapon number");
            else weapons.add(Weapons.getWeapon(num));
        }


        ArrayList<Rooms> rooms = new ArrayList<>();
        printRooms();
        System.out.println("Enter any Room cards you have");
        while (true){
            int num = Integer.parseInt(reader.readLine());
            if (num == 0) break;
            if (!rooms.isEmpty() && rooms.contains(Rooms.getRoom(num)) || num > Rooms.values().length || num < 1)
                System.out.println("You already entered that room or Invalid room number");
            else rooms.add(Rooms.getRoom(num));
        }

        CluePlayer player = new CluePlayer(name, playerNumber, weapons, rooms, characters, true);
        players.add(player);
        printBasicOdds(player);


        for (int i = 1; i < numOfPlayers; i++) {
            System.out.println("Enter player " + (i + 1) + "'s name: ");
            name = reader.readLine();
            printCharacters();
            System.out.println("Enter player " + (i + 1) + "'s character number: ");
            playerNumber = Integer.parseInt(reader.readLine());
            players.add(new CluePlayer(name, playerNumber, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), false));
        }
        startGame(players);
    }

    private static void printCharacters(){
        System.out.println("Characters: ");
        for(Suspects s : Suspects.values()) System.out.println(s.Character + ": " + s.name);
    }

    private static void printWeapons(){
        System.out.println("Weapons: ");
        for(Weapons w : Weapons.values()) System.out.println(w.weapon + ": " + w.name);
    }

    private static void printRooms(){
        System.out.println("Rooms: ");
        for(Rooms r : Rooms.values()) System.out.println(r.room + ": " + r.name);
    }

    private static void printBasicOdds(CluePlayer player){
        new Thread(() -> {
            ArrayList<Suspects> stemp = new ArrayList<>();
            ArrayList<Weapons> wtemp = new ArrayList<>();
            ArrayList<Rooms> rtemp = new ArrayList<>();
            Collections.addAll(stemp, Suspects.values());
            Collections.addAll(wtemp, Weapons.values());
            Collections.addAll(rtemp, Rooms.values());
            for (Suspects s : player.getSuspects()) stemp.remove(s);
            for (Suspects s : stemp) System.out.println("The odds of the Killer being " + s.name + " is " + (1.0 / stemp.size()) * 100 + "%" );
            for (Weapons s: player.getWeapons()) wtemp.remove(s);
            for (Weapons s : wtemp) System.out.println("The odds of the Weapon being " + s.name + " is " + (1.0 / wtemp.size()) * 100);
            for (Rooms s: player.getRooms()) rtemp.remove(s);
            for(Rooms s : rtemp) System.out.println("The odds of the Room being " + s.name + " is " + (1.0/rtemp.size()) * 100);
        }).start();
    }

    public static void startGame(ArrayList<CluePlayer> players) {

    }
}
