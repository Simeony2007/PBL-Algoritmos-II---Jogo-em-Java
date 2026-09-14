package pbl.model.service;

public class Orfeu {
    private int obol;
    private int love;
    private int anger;
    private int sadness;

    public Orfeu(int obol, int love, int anger, int sadness) {
        this.obol = obol;
        this.love = love;
        this.anger = anger;
        this.sadness = sadness;
    }

    public int getObol() { return this.obol; }
    public int getLove() { return this.love; }
    public int getAnger() { return this.anger; }
    public int getSadness() { return this.sadness; }

    // Modify methods handling both increases (+amount) and decreases (-amount)
    public void modifyObol(int amount) {
        this.obol = Math.max(0, this.obol + amount); // Prevents negative obols
    }

    public void modifyLove(int amount) {
        this.love = Math.max(0, this.love + amount);
    }

    public void modifyAnger(int amount) {
        this.anger = Math.max(0, this.anger + amount);
    }

    public void modifySadness(int amount) {
        this.sadness = Math.max(0, this.sadness + amount);
    }

    @Override
    public String toString() {
        return String.format("Orfeu [Obols: %d, Love: %d, Anger: %d, Sadness: %d]", 
                obol, love, anger, sadness);
    }
}