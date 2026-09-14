package model.service;

public class Option {
    private String text;
    private String nextScene;
    private int obol;
    private int love;
    private int anger;
    private int sadness;
    private int affinity;


    public Option(String text, String nextScene, int obol, int love, int anger, int sadness, int affinity) {
        this.text = text;
        this.nextScene = nextScene;
        this.obol = obol;
        this.love = love;
        this.anger = anger;
        this.sadness = sadness;
        this.affinity = affinity;
    }

    public String getText() {
        return text;
    }

    public String getNextScene() {
        return nextScene;
    }

    public int getObol() {
        return obol;
    }

    public int getLove() {
        return love;
    }

    public int getAnger() {
        return anger;
    }

    public int getSadness() {
        return sadness;
    }

    public int getAffinity() {
        return affinity;
    }
}
