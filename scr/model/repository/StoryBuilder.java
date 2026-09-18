package scr.model.repository;

import scr.model.service.*;
import scr.model.service.Chapter;
import scr.model.service.Npc;
import scr.model.service.Orfeu;
import scr.model.service.Scene;

import java.util.ArrayList;

public class StoryBuilder {
    public static Object BuildGame;


    public static ArrayList<Npc> GetNpcs(){

        ArrayList<Npc> npcs = new ArrayList<>();

        Npc charon = new Npc("Charon", 0);
        Npc eurydice = new Npc("Eurydice", 0);
        Npc sisyphus = new Npc("Sisyphus", 0);

        npcs.add(charon);
        npcs.add(eurydice);
        npcs.add(sisyphus);

        return (npcs);
    }

    // public static Orfeu GetOrfeu(){
    //     Orfeu orfeu = new Orfeu(1, 3, 3, 3);
    //     return orfeu;
    // }


    // public static Chapter getChapter(int index){
    //     switch(index){
    //         case 1:
    //             return BuildChapter1(new Chapter());
    //         default:
    //             return null;
    //     }
    // }


    public static Chapter BuildChapter1(){
        Chapter chapter = new Chapter("Capítulo 1 - A Entrada do Submundo");

        Scene scene1 = new Scene("s1_introduction");
        Scene scene2 = new Scene("s2_cerberus");
        Scene scene2a = new Scene("s2a_cerberus", "s3_river_styx");
        Scene scene2b = new Scene("s2b_cerberus", "s3_river_styx");
        Scene scene2c = new Scene("s2c_cerberus", "s3_river_styx");
        Scene scene3 = new Scene("s3_river_styx");



        // Cena 1 - Introdução
        scene1.addNewDialogue("A música de Orfeu não apenas agradava aos homens; ela curvava as árvores, acalmava as feras e fazia as próprias pedras chorarem. Filho da musa Calíope, herdou a Lira de Ouro do próprio Apolo, o deus da luz e das artes. Seu nome já era lenda muito antes do luto: sua voz guiara os Argonautas ao lado de Jasão, Héracles e os maiores semideuses de toda a Grécia, superando até mesmo o canto mortal das Sereias. Orfeu era, sem contestação, o maior bardo que já pisou sobre a terra.");
        scene1.addNewDialogue("Sua sorte parecia completa ao unir-se à formosa ninfa Eurídice. No entanto, a felicidade dos mortais é um alvo fácil para a tragédia. Logo após o matrimônio, ao fugir da perseguição obstinada de Aristeu — um rival invejoso do bardo —, Eurídice pisou sobre uma serpente oculta na relva. A picada foi rápida; o veneno, fatal.");
        scene1.addNewDialogue("Nos braços de Orfeu, o feixe de luz de sua vida se apagou. Incapaz de aceitar o silêncio eterno de sua amada e recusando-se a curvar-se ao destino, o bardo toma uma decisão insana para qualquer mortal: caminhar até a garganta da terra e descer ao Submundo para arrancar Eurídice das garras de Hades.");
        scene1.addNewDialogue("À beira do abismo que leva ao reino dos mortos, a mão de Orfeu pesa sobre as cordas da lira. O som que ecoa da fenda escura não reflete apenas sua arte, mas a força exata que destrói sua alma.");
        scene1.addNewDialogue("Escolha a motivação de Orfeu:");
        scene1.addNewChoice("Jurei protegê-la até o fim dos meus dias, e nem mesmo a morte tem o direito de quebrar nosso laço.", "s2_cerberus", 0, 0, 2, 0, 0);
        scene1.addNewChoice("Ficar na terra sem Eurídice é uma sentença pior que o próprio Tártaro. Eu não tenho nada mais a perder.", "s2_cerberus", 0, 0, 0, 0, 2);
        scene1.addNewChoice("A tirania das Moiras não vai roubar minha esposa. Eu vou descer ao reino de Hades e tomar o que é meu de volta.", "s2_cerberus", 0, 5, 0, 2, 0);


        // Cena 2 - Confronto com Cérbero
        scene2.addNewDialogue("A jornada de Orfeu o leva até o Cabo Tênaro, uma ponta rochosa e esquecida pelo sol no extremo sul da Grécia, onde uma caverna úmida e escura exala o cheiro de enxofre e esquecimento. Ali fica uma das passagens diretas para o Submundo.");
        scene2.addNewDialogue("À medida que adentra a penumbra, um rugido ecoa pelas paredes de pedra, fazendo o chão tremer. Das sombras surge a silhueta colossal de Cérbero, o guardião do Submundo. Com suas três cabeças de presas afiadas e uma cauda de serpente que chacoalha em aviso, a besta rosnante bloqueia completamente o caminho, pronta para devorar qualquer ser vivo que ouse cruzar aquele limite.");
        scene2.addNewDialogue("Forçar a passagem pela força é uma sentença de morte. A única arma de Orfeu é a Lira de Apolo, e sua capacidade de transformar sentimento puro em melodia para dominar a mente e os sentidos das criaturas.");
        scene2.addNewDialogue("Qual música você toca para passar por Cérbero?");
        scene2.addNewChoice("Uma melodia suave e envolvente que evoca o repouso da natureza, abrandando a ferocidade da besta até fazê-la adormecer.", "s2a_cerberus", 0, 0, 1, 0, 0);
        scene2.addNewChoice("Um canto lúgubre sobre a dor da perda, conectando-se com a própria essência sombria do Submundo e fazendo o guardião lamentar em vez de atacar.", "s2b_cerberus", 0, 0, 0, 0, 1);
        scene2.addNewChoice("Acordes retumbantes e agressivos que simulam o rugido da guerra, impondo respeito e subjugando o cão pela força e imponência do som.", "s2c_cerberus", 0, 0, 0, 1, 0);


        // Cenas 2a, 2b e 2c - Resultados das escolhas com o Cérbero
        scene2a.addNewDialogue("Os acordes suaves da lira ecoam como a brisa entre as folhas, fazendo o olhar furioso de Cérbero suavizar-se até que suas três cabeças desabem no chão de pedra em um sono profundo, permitindo que Orfeu se esgueire em direção às sombras do rio Aqueronte murmurando que o amor os guiará de volta.");
        //scene2a.setNextScene(scene3);
        //chapter.changeCurrentScene("s3_river_styx");


        scene2b.addNewDialogue("As notas graves e melancólicas carregadas do peso de um luto insuportável fazem Cérbero soltar ganidos lúgubres pelas três bocas, chorando em sintonia com a dor do bardo enquanto este contorna o guardião cabisbaixo, determinado a transformar a própria tragédia no caminho para resgatar sua amada.");
        //scene2b.setNextScene(scene3);
        //chapter.changeCurrentScene("s3_river_styx");


        scene2c.addNewDialogue("O dedilhado agressivo e vibrante ressoa como o estalo do trovão, intimidando a besta colossal que dá passos para trás e se curva em submissão involuntária, abrindo passagem para Orfeu avançar com passos firmes em direção às profundezas do reino dos mortos.");
        //scene2c.setNextScene(scene3);
        //chapter.changeCurrentScene("s3_river_styx");


        // Cena 3 - Margem do Rio Estige
        scene3.addNewDialogue("...");


        chapter.newScene(scene1);
        chapter.newScene(scene2);
        chapter.newScene(scene2a);
        chapter.newScene(scene2b);
        chapter.newScene(scene2c);
        chapter.newScene(scene3);


        return chapter;
    }

    public static Chapter BuildChapter2(){
        Chapter chapter = new Chapter("Capítulo 2 - Teste");

        Scene scene1 = new Scene("Teste");
        Scene scene2 = new Scene("Teste2");

        // Cena 1 - Introdução
        scene1.addNewDialogue("A.");
        
        
        scene2.addNewDialogue("B");
        
        chapter.newScene(scene1);
        chapter.newScene(scene2);
        
        return chapter;
    }
}