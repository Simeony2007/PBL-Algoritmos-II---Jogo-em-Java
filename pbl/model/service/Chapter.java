package pbl.model.service;
import java.util.ArrayList;

public class Chapter {
	// Atributos
	private String title;
	private ArrayList<Scene> arrayScenes = new ArrayList<>();

	public Chapter(String title){
		this.title = title;
	}

	public void addScene(Scene scene){
		arrayScenes.add(scene);
	}

	@Override
    public String toString() {
        return String.format(title);
	}

}