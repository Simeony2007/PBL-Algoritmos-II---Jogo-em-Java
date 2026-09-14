package pbl.model.service;
import java.util.ArrayList;

public class Chapter {
	private String title;
	private ArrayList<Scene> arrayScenes = new ArrayList<>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void addScene(Scene scene){
		arrayScenes.add(scene);
	}

	public Scene getScene(String id) {
		for (Scene scene : arrayScenes) {
            if (scene.getId().equalsIgnoreCase(id)) {
                return scene;
            }
        }
        return null;
	}

	@Override
    public String toString() {
        return String.format(title);
	}

}