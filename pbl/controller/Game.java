package pbl.controller;
import java.util.ArrayList;

import pbl.model.service*;
import pbl.view.GameInterface;

public class Game{
	private Orfeu protagonista;
	private ArrayList<Npc> npcs = new ArrayList<>();
	private ArrayList<Chapter> capitulos = new ArrayList<>();
	private int capituloAtual = 0;


	public Game(int obol, int love, int anger, int sadness){
		protagonista = new Orfeu(obol, love, anger, sadness);
	}

	public Orfeu getProtagonista(){
		return protagonista;
	}

	public ArrayList<Npc> getNpcs(){
		return npcs;
	}

	public void addNpc(Npc npc){
		npcs.add(npc);
	}

	public void addChapter(Chapter chapter){
		capitulos.add(chapter);
	}

	public Chapter nextChapter(){
		return capitulos.get(capituloAtual++);
	}

	public void createGameChapters(){
		
		for(int i = 0; i < 2; i++){ // DOIS CAPÍTULOS SÓ PRA INÍCIO!
			Chapter j = new Chapter();
			addChapter(j);
		}

		Chapter capituloRodandoAgora = nextChapter();
		capituloRodandoAgora.addScene();

	}

}