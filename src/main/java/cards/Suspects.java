package cards;

/**
 * @author Christian DaSilva
 */

public enum Suspects {

        MISS_SCARLETT("Miss Scarlett", 1),
        MRS_WHITE("Mrs White", 2),
        MR_GREEN("Mr Green", 3),
        PROFESSOR_PLUM("Professor Plum", 4),
        COLONEL_MUSTARD("Colonel Mustard", 5),
        MRS_PEACOCK("Mrs Peacock",6);

        public final String name;
        public final int Character;

        Suspects(String name, int Character){
                this.name = name;
                this.Character = Character;
        }

        public static Suspects getCharacter(int num){
                for(Suspects s : Suspects.values())
                        if(s.Character == num) return s;
                return null;
        }

        public static String getName(int num){
                for(Suspects s : Suspects.values())
                        if(s.Character == num) return s.name;
                return null;
        }

}


