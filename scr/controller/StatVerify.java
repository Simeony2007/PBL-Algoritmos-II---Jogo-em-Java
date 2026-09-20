package scr.controller;

import java.util.ArrayList;

import scr.model.service.Scene;
import scr.model.service.Npc;
import scr.model.service.Orfeu;

public class StatVerify {

    public static String selectScene(Orfeu orfeu, ArrayList<Npc> npcs, Scene scene){
        int type = scene.getreqType();
        String npcName = scene.getReqNpcName();
        String sceneId = scene.getReqSceneId();
        int affinity = scene.getReqAffinity();
        int love = scene.getReqLove();
        int sad = scene.getReqSadness();
        int angry = scene.getReqAngry();

        if (npcName != null){
            Npc npc = null;
            for (Npc i : npcs){
            if(i.getName().equals(npcName)){
                npc = i;
            }
		}
				if (npc.getAffinity() >= affinity) {
					return sceneId;
				}
				else{
					return null;
				}
        }

        else{
            Boolean trueVerification = false;
			switch (type) {
				case 1:
					if (orfeu.getLove() >= love) {
						trueVerification = true;
					} else {
						return null;
					}
					break;

				case 2:
					if (orfeu.getSadness() >= sad) {
						trueVerification = true;
					} else {
						return null;
					}
					break;

				case 3:
					if (orfeu.getAngry() >= angry) {
						trueVerification = true;
					} else {
						return null;
					}
					break;

				default:
					trueVerification = false;
					return null;
		}

		if (trueVerification) {
			return sceneId;
		}else{
			return null;
		}
        }
    }
}
