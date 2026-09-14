package model.service;

import java.util.ArrayList;

public class Scene {
    private String id;
    private ArrayList<Dialogue> dialogueArray = new ArrayList<>();
    private ArrayList<Option> optionArray = new ArrayList<>();
    private Npc activeNpc; // Can be null if no NPC is present

    // Constructor WITH an active NPC
    public Scene(String id, Npc activeNpc) {
        this.id = id;
        this.activeNpc = activeNpc;
    }

    // Constructor WITHOUT an NPC (sets activeNpc to null)
    public Scene(String id) {
        this(id, null);
    }

    public String getId() {
        return id;
    }

    public ArrayList<Dialogue> getDialogueArray() {
        return dialogueArray;
    }

    public ArrayList<Option> getOptionArray() {
        return optionArray;
    }

    public void addOption(Option option) {
        optionArray.add(option);
    }

    public void addDialogue(Dialogue dialogue) {
        dialogueArray.add(dialogue);
    }

    public void setActiveNpc(Npc npc) {
        this.activeNpc = npc;
    }

    public Npc getActiveNpc() {
        return activeNpc;
    }

    // Helper method to safely check if the scene has an NPC
    public boolean hasActiveNpc() {
        return this.activeNpc != null;
    }
}