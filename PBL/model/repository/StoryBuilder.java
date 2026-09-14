package PBL.model.repository;

import PBL.model.service.*;
import PBL.controller.Game;


public class StoryBuilder {
    public static void BuildGame(Game game){
        Npc charon = new Npc("charon", 0);
        Npc eurydice = new Npc("eurydice", 0);
        Npc sisyphus = new Npc("sisyphus", 0);

        game.addNpc(charon);
        game.addNpc(eurydice);
        game.addNpc(sisyphus);
    }

    public static Chapter BuildChapter1(Chapter chapter){
        chapter = new Chapter("Capítulo 1 - A Entrada do Submundo");

        Scene scene1 = new Scene();
        scene1.addDialogue("A música de Orfeu não apenas agradava aos homens; ela curvava as árvores, acalmava as feras e fazia as próprias pedras chorarem. Filho da musa Calíope, herdou a Lira de Ouro do próprio Apolo, o deus da luz e das artes. Seu nome já era lenda muito antes do luto: sua voz guiara os Argonautas ao lado de Jasão, Héracles e os maiores semideuses de toda a Grécia, superando até mesmo o canto mortal das Sereias. Orfeu era, sem contestação, o maior bardo que já pisou sobre a terra.");
        scene1.addDialogue("Sua sorte parecia completa ao unir-se à formosa ninfa Eurídice. No entanto, a felicidade dos mortais é um alvo fácil para a tragédia. Logo após o matrimônio, ao fugir da perseguição obstinada de Aristeu — um rival invejoso do bardo —, Eurídice pisou sobre uma serpente oculta na relva. A picada foi rápida; o veneno, fatal.");
        scene1.addDialogue("Nos braços de Orfeu, o feixe de luz de sua vida se apagou. Incapaz de aceitar o silêncio eterno de sua amada e recusando-se a curvar-se ao destino, o bardo toma uma decisão insana para qualquer mortal: caminhar até a garganta da terra e descer ao Submundo para arrancar Eurídice das garras de Hades.");
        scene1.addDialogue("À beira do abismo que leva ao reino dos mortos, a mão de Orfeu pesa sobre as cordas da lira. O som que ecoa da fenda escura não reflete apenas sua arte, mas a força exata que destrói sua alma.");
        scene1.addDialogue("Escolha a motivação de Orfeu:");
        scene1.addOption(1, "Jurei protegê-la até o fim dos meus dias, e nem mesmo a morte tem o direito de quebrar nosso laço.", "scene2", 0, 5, 0, 0, 0);
        scene1.addOption(2, "Ficar na terra sem Eurídice é uma sentença pior que o próprio Tártaro. Eu não tenho nada mais a perder.", "scene2", 0, 0, 0, 5, 0);
        scene1.addOption(3, "A tirania das Moiras não vai roubar minha esposa. Eu vou descer ao reino de Hades e tomar o que é meu de volta.", "scene2", 0, 0, 0, 0, 5);
        chapter.addScene(scene1);

        Scene scene2 = new Scene();
        scene2.addDialogue("A jornada de Orfeu o leva até o Cabo Tênaro, uma ponta rochosa e esquecida pelo sol no extremo sul da Grécia, onde uma caverna úmida e escura exala o cheiro de enxofre e esquecimento. Ali fica uma das passagens diretas para o Submundo.");
        scene2.addDialogue("À medida que adentra a penumbra, um rugido ecoa pelas paredes de pedra, fazendo o chão tremer. Das sombras surge a silhueta colossal de Cérbero, o guardião do Submundo. Com suas três cabeças de presas afiadas e uma cauda de serpente que chacoalha em aviso, a besta rosnante bloqueia completamente o caminho, pronta para devorar qualquer ser vivo que ouse cruzar aquele limite.");
        scene2.addDialogue("Forçar a passagem pela força é uma sentença de morte. A única arma de Orfeu é a Lira de Apolo, e sua capacidade de transformar sentimento puro em melodia para dominar a mente e os sentidos das criaturas.");
        scene2.addDialogue("Qual música você toca para passar por Cérbero?");
        scene2.addOption(0, "Uma melodia suave e envolvente que evoca o repouso da natureza, abrandando a ferocidade da besta até fazê-la adormecer.", null, 0, 1, 0, 0, 0);
        scene2.addOption(2, "Um canto lúgubre sobre a dor da perda, conectando-se com a própria essência sombria do Submundo e fazendo o guardião lamentar em vez de atacar.", null, 0, 0, 0, 1, 0);
        scene2.addOption(3, "Acordes retumbantes e agressivos que simulam o rugido da guerra, impondo respeito e subjugando o cão pela força e imponência do som.", null, 0, 0, 1, 0, 0);
        chapter.addScene(scene2);

        Scene scene3 = new Scene();
        scene3.addDialogue("Os acordes suaves da lira ecoam como a brisa entre as folhas, fazendo o olhar furioso de Cérbero suavizar-se até que suas três cabeças desabem no chão de pedra em um sono profundo, permitindo que Orfeu se esgueire em direção às sombras do rio Aqueronte murmurando que o amor os guiará de volta.");


        return chapter;
    }
}
