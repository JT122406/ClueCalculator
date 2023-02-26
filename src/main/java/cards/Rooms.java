package cards;

/**
 * @author Christian DaSilva
 */

public enum Rooms {
    KITCHEN("Kitchen", 1),
    BALLROOM("Ballroom", 2),
    CONSERVATORY("Conservatory",3),
    BILLIARD_ROOM("Billiard room", 4),
    LIBRARY("Library", 5),
    STUDY("Study", 6),
    HALL("Hall", 7),
    LOUNGE("Lounge", 8),
    DINING_ROOM("Dining Room", 9);

    public final String name;
    public final int room;
    Rooms(String name, int room){
        this.name = name;
        this.room = room;
    }

    public static Rooms getRoom(int num){
        for(Rooms s: Rooms.values())
            if(s.room == num) return s;
        return null;
    }
}
