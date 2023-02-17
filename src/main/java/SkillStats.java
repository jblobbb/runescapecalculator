public class SkillStats {
    private int experienceGiven;

    private int levelRequired;


//get and set
    public void setLevelRequired(int levelRequired) {
        this.levelRequired = levelRequired;
    }

    public void setExperienceGiven(int experienceGiven) {
        this.experienceGiven = experienceGiven;
    }

    public int getLevelRequired() {
        return levelRequired;
    }

    public int getExperienceGiven(){
        return experienceGiven;
    }
//constructor
    public SkillStats(int experienceGiven, int levelRequired) {
        this.experienceGiven = experienceGiven;
        this.levelRequired = levelRequired;
    }
}
