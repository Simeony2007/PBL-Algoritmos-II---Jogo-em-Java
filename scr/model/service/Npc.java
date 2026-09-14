package scr.model.service;

public class Npc {
    private String name;
    private int affinity;

    public Npc(String name, int affinity) {
        this.name = name;
        this.affinity = affinity;
    }

    public String getName() {
        return this.name;
    }

    public int getAffinity() {
        return this.affinity;
    }

    // Handles both increases (+amount) and decreases (-amount)
    public void modifyAffinity(int amount) {
        this.affinity += amount;
    }

    @Override
    public String toString() {
        return String.format("Npc [Name: %s, Affinity: %d]", name, affinity);
    }
}