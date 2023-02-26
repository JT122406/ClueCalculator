package cards;

/**
 * @author Christian DaSilva
 */

public enum Weapons {
    CANDLESTICK("Candlestick", 1),
    KNIFE("Knife", 2),
    ROPE("Rope", 3),
    WRENCH("Wrench", 4),
    REVOLVER("Revolver", 5),
    PIPE("Lead Pipe", 6);

    public final String name;
    public final int weapon;

    Weapons(String name, int weapon){
        this.name = name;
        this.weapon = weapon;
    }
    public static Weapons getWeapon(int num){
        for(Weapons s: Weapons.values())
            if(s.weapon == num) return s;
        return null;
    }

    public static String getName(int num){
        for(Weapons s: Weapons.values())
            if(s.weapon == num) return s.name;
        return null;
    }

}
