import cards.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

/**
 * @author Joseph T. McQuigg
 */

public class CluePlayer {

    private String name;
    private int playerNumber;
    private ArrayList<Weapons> weapons;
    private ArrayList<Rooms> rooms;
    private ArrayList<Suspects> suspects;
    private boolean isUser;

    public CluePlayer(@NotNull String name, int playerNumber, ArrayList<Weapons> weapons, ArrayList<Rooms> rooms, ArrayList<Suspects> suspects, boolean isUser) {
        this.name = name;
        this.playerNumber = playerNumber;
        this.weapons = weapons;
        this.rooms = rooms;
        this.suspects = suspects;
        this.isUser = isUser;
    }

    public String getName() {
        return name;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }


    public String toString() {
        return "Player " + playerNumber + " is " + name;
    }

    public ArrayList<Suspects> getSuspects() {
        return suspects;
    }

    public ArrayList<Weapons> getWeapons() {
        return weapons;
    }

    public ArrayList<Rooms> getRooms() {
        return rooms;
    }

}
