import java.util.HashMap;
import java.util.Scanner;

public class calculator {

    public static final int[] levelArray = {0, 83, 174, 276, 388, 512, 650, 801, 969, 1154, 1358, 1584, 1833, 2107, 2411, 2746, 3115, 3523, 3973,
            4470, 5018, 5624, 6291, 7028, 7842, 8740, 9730, 10824, 12031, 13363, 14833, 16456, 18247, 20224, 22406,
            24815, 27473, 30408, 33648, 37224, 41171, 45529, 50339, 55649, 61512, 67983, 75127, 83014, 91721, 101333,
            111945, 123660, 136594, 150872, 166636, 184040, 203254, 224466, 247886, 273742, 302288, 333804, 368599,
            407015, 449428, 496254, 547953, 605032, 668051, 737627, 814445, 899257, 992895, 1096278, 1210421, 1336443,
            1475581, 1629200, 1798808, 1986068, 2192818, 2421087, 2673114, 2951373, 3258594, 3597792, 3972294, 4385776,
            4842295, 5346332, 5902831, 6517253, 7195629, 7944614, 8771558, 9684577, 10692629, 11805606, 13034431};

    public static void main(String[] args) {

        HashMap<String, SkillStats> prayer = new HashMap<>();
        prayer.put("Bones", new SkillStats(4,0));
        prayer.put("Big bones", new SkillStats(35,10));
        prayer.put("Dragon bones", new SkillStats(72,40));
        prayer.put("Dagannoth bones", new SkillStats(120,70));

        HashMap<String, SkillStats> mining = new HashMap<>();
        mining.put("Copper", new SkillStats(15, 0));
        mining.put("Iron", new SkillStats(35,15));
        mining.put("Coal", new SkillStats(70,30));
        mining.put("Rune", new SkillStats(250, 80));


    Scanner scanner = new Scanner(System.in);

        System.out.println("What is your current experience total");
        int currentLevel = scanner.nextInt();

        System.out.println("What skill are you training?");
        String currentSkill = scanner.next();

        System.out.println("Your current level is " + currentLevelTotal(currentLevel));
        System.out.println("Your experience remaining until next level is " + xpTillNextLevel(currentLevel));

        switch (currentSkill){
            case "prayer":
                System.out.println("The total number of actions required until next level is " + actionsRequired(currentLevel, prayer.get("Dragon bones").getExperienceGiven()) + " Dragon Bones");
                System.out.println("The level required to bury is " + prayer.get("Dragon bones").getLevelRequired());
                break;
            case "mining":
                System.out.println("The total number of actions required until next level is " + actionsRequired(currentLevel, mining.get("Coal").getExperienceGiven()) + " Coal");
                System.out.println("The level required to mine is " + mining.get("Coal").getLevelRequired());
                break;
        }

    }

    static int currentLevelTotal(int currentXp) {
        int total = 0;

        for (int i = 0; i < levelArray.length; i++) {
            int xp = levelArray[i];
            if (xp >= currentXp) {
                total = i;
                break;
            }
        }
        return total;
    }

    static int currentTotalLevelXP(int currentLevel){
        return levelArray[currentLevel-1];
    }

    static int xpTillNextLevel(int currentXp){
        int currentLevel = currentLevelTotal(currentXp);
        int nextLevelXp = currentTotalLevelXP(currentLevel+1);
        return (nextLevelXp - currentXp);
    }

    static double actionsRequired(int currentXp, int xpPerAction){
        double nextLevel = xpTillNextLevel(currentXp);
        return Math.ceil(nextLevel / xpPerAction);
    }
}
