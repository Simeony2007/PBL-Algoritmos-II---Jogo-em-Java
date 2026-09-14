package model.service;
import java.util.ArrayList;

public class Chapter {
	private String title;
	private ArrayList<Scene> scenes = new ArrayList<>();

	public Chapter(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public ArrayList<Scene> getScenes(){
		return scenes;
	}

	public void addScene(Scene scene){
		scenes.add(scene);
	}
}