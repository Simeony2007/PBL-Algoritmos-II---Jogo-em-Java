package scr.model.repository;

import scr.model.service.Chapter;
import scr.model.service.Npc;
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
        Scene scene4 = new Scene("s4_soul");
        Scene scene4a = new Scene("s4a_soul", "s5_charon");
        Scene scene4b = new Scene("s4b_soul", "s5_charon");
        Scene scene5 = new Scene("s5_charon");
        Scene scene5a = new Scene("s5a_charon", "s6_charon_boat");
        Scene scene5b = new Scene("s5b_charon", "s5c_charon");
        Scene scene5c = new Scene("s5c_charon", "s6_charon_boat");
        Scene scene6 = new Scene("s6_charon_boat");
        Scene scene6a = new Scene("s6a_charon_boat", "s7_end_chapter");
        Scene scene6b = new Scene("s6b_charon_boat", "s7_end_chapter");
        Scene scene6c = new Scene("s6c_charon_boat", "s7_end_chapter");
        Scene scene7 = new Scene("s7_end_chapter", null);



        // Cena 1 - Introdução
        scene1.addNewDialogue("Orfeu, filho da musa Calíope, era considerado o maior bardo de toda a Grécia. Com a harpa de Apolo em mãos, ele viajou com os Argonautas, entoando canções que acalmavam mares e feras.");
        scene1.addNewDialogue("Sua vida ganhou verdadeiro sentido ao se casar com a bela ninfa Eurídice. No entanto, a alegria durou pouco. Logo após a cerimônia, enquanto fugia de um perseguidor invejoso e cheio de ódio, ela foi picada por uma víbora e seu espírito foi levado para o reino dos mortos.");
        scene1.addNewDialogue("Consumido pelo luto, Orfeu toma uma decisão impensável: descer ao próprio Submundo, desafiar as leis da vida e da morte, e trazer sua amada de volta para a luz.");
        scene1.addNewDialogue("O que mais motiva os passos de Orfeu em direção ao abismo?");

        scene1.addNewChoice("Seu peito queima com um amor que transcende a mortalidade. Você avança movido pela convicção de que nem mesmo Hades pode separar duas almas gêmeas.", "s2_cerberus", 0, 0, 2, 0, 0);
        scene1.addNewChoice("Cada nota que toca é um lamento lúgubre. A dor de não tê-la ao seu lado é um peso esmagador que o arrasta naturalmente para as sombras.", "s2_cerberus", 0, 0, 0, 0, 2);
        scene1.addNewChoice("Como os deuses permitiram tamanha injustiça? Sua música agora é um hino de fúria contra o destino cruel, e você não aceitará um \"não\" como resposta.", "s2_cerberus", 0, 0, 2, 0, 0);

        // Cena 2 - Confronto com Cérbero
        scene2.addNewDialogue("A jornada o leva até o sombrio Cabo Tênaro, onde o ar se torna gélido e com cheiro de enxofre. Diante da caverna profunda, uma criatura aterrorizante barra definitivamente o seu caminho.");
        scene2.addNewDialogue("É Cérbero, o cão gigante de três cabeças, rosnando e babando, pronto para devorar qualquer ser vivo que ouse adentrar os domínios de seu mestre. Orfeu, ciente de que armas mortais são inúteis aqui, não puxa uma espada, mas sim as cordas douradas de sua harpa.");
        scene2.addNewDialogue("Qual música Orfeu tocará para lidar com o guardião infernal?");
        scene2.addNewChoice("Música sobre o descanso e o acalento da natureza", "s2a_cerberus", 0, 0, 1, 0, 0);
        scene2.addNewChoice("Música sobre o peso da perda", "s2b_cerberus", 0, 0, 0, 0, 1);
        scene2.addNewChoice("Música sobre guerra", "s2c_cerberus", 0, 0, 0, 1, 0);


        // Cenas 2a, 2b e 2c - Resultados das escolhas com o Cérbero
        scene2a.addNewDialogue("As notas fluem suaves como a brisa da primavera, lembrando o cão dos campos verdejantes. As três cabeças se acalmam, deitando no chão e caindo em um sono sereno, abrindo caminho.");
        scene2b.addNewDialogue("As notas graves e melancólicas carregadas do peso de um luto insuportável fazem Cérbero soltar ganidos lúgubres pelas três bocas, chorando em sintonia com a dor do bardo enquanto este contorna o guardião cabisbaixo, determinado a transformar a própria tragédia no caminho para resgatar sua amada.");
        scene2c.addNewDialogue("O dedilhado agressivo e vibrante ressoa como o estalo do trovão, intimidando a besta colossal que dá passos para trás e se curva em submissão involuntária, abrindo passagem para Orfeu avançar com passos firmes em direção às profundezas do reino dos mortos.");


        // Cena 3 - Margem do Rio Estige
        scene3.addNewDialogue("A escuridão engole Orfeu enquanto ele desce pelas entranhas da terra. Em pouco tempo, ele chega a uma costa sombria, margeada por um rio lamacento e coberta por uma névoa densa.");
        scene3.addNewDialogue("O local está lotado de almas translúcidas humanas, que vagam sem rumo murmurando lamentos incessantes. Atracado na água escura do rio, um pequeno barco de madeira balança levemente, guiado por um homem velho, de pele cinzenta, que aguarda impassível.");
        scene3.addNewDialogue("O que você faz ao observar a margem do rio dos mortos?");

        scene3.addNewChoice("Se aproximar do Caronte", "s5_charon", 0, 0, 0, 0, 0);
        scene3.addNewChoice("Interagir com uma das almas", "s4_soul", 0, 0, 0, 0, 0);

        // Cena 4 - Conversa com alma
        scene4.addNewDialogue("Você se aproxima de uma sombra curvada que chora compulsivamente na beira do rio, estendendo suas mãos pálidas para as águas negras.");;
        scene4.addNewDialogue("Orfeu: Quem é você, e por que chora mais alto que o próprio correr destas águas?");
        scene4.addNewDialogue("Alma Esquecida: Sou apenas um pobre coitado, bardo... Estou vagando por esta margem há um século. Minha família me enterrou às pressas, sem a honra de uma moeda sob a língua.");
        scene4.addNewDialogue("Alma Esquecida: Dizem que, de vez em quando, algumas moedas extras perdidas aparecem pelo chão de terra da margem, trazidas pelas correntes. Mas meus olhos já estão opacos... Eu nunca achei uma sequer.");
        scene4.addNewDialogue("Como você reage ao lamento centenário dessa alma?");

        scene4.addNewChoice("Oferecer seu único óbolo","s4a_soul", "Charon", -1, 1, 0, 0, 0);
        scene4.addNewChoice("Deixar a Alma para trás", "s4b_soul", 0, 0, 0, 0, 0);

        // Cena 4a e 4b
        scene4a.addNewDialogue("Você coloca uma moeda brilhante na mão espectral. A alma chora lágrimas de gratidão e desaparece rumo ao barco. Ao longe, o velho barqueiro observa seu ato com um olhar intrigado.");
        scene4b.addNewDialogue("Você se afasta com pesar, deixando a alma continuar sua eterna e frustrante busca no barro.");

        // Cena 5 - Conversa com Caronte
        scene5.addNewDialogue("Você finalmente para diante do barqueiro do Submundo. Caronte o observa de cima a baixo com olhos ocos que brilham com uma luz esverdeada e avarenta sob o capuz esfarrapado.");
        scene5.addNewDialogue("Caronte: Mais um espírito choroso para encher meu barco... Não, espere. Há sangue quente correndo sob essa pele.");
        scene5.addNewDialogue("Orfeu: Preciso cruzar este rio. Tenho assuntos a tratar no reino de Hades, no outro lado.");
        scene5.addNewDialogue("Caronte: Assuntos de vivos não me dizem respeito, bardo. Meu único negócio aqui é a cobrança. A regra é imutável: eu espero a moeda, o passageiro paga a moeda. Enquanto houver pagamento, eu não me importo se você respira ou não.");
        scene5.addNewDialogue("Como você negociará a travessia com o barqueiro?");

        scene5.addNewChoice("Pagar a moeda", "s5a_charon", -1, 0, 0, 0, 0);
        scene5.addNewChoice("Tentar convencer o Caronte a deixá-lo passar sem pagar", "s5b_charon" , "Charon", 0, 0, 0, 0, 0);
        scene5.addNewChoice("Voltar para a margem", "s5c_charon", 0, 0, 0, 0, 0);

        // Cena 5a, 5b e 5c
        scene5a.addNewDialogue("Sem hesitar, você coloca o óbolo na mão esquelética de Caronte. Ele sente o peso do metal, dá um sorriso desdentado e aponta com a cabeça para que você suba na barca.");
        scene5b.addNewDialogue("Orfeu: Você não sabe quem eu sou? Minha música vale mais que todos os tesouros de Hades! Me deixe passar!");
        scene5b.addNewDialogue("Caronte: E minha paciência vale menos do que a poeira que você pisa. Sem prata, sem viagem. Saia daqui, mortal insolente!");
        scene5c.addNewDialogue("Desolado por não ter como pagar, você se afasta do píer. Você chora e passa horas cavando a terra fria, até que o brilho de um óbolo esquecido reflete na penumbra. Com ele em mãos, você retorna à barca e garante sua passagem.");

        // Cena 6 - Conversa na Barca
        scene6.addNewDialogue("A madeira podre range sob seus pés enquanto a barca corta as águas densas do submundo. O silêncio é pesado, quebrado apenas pelo som do remo batendo contra a correnteza.");
        scene6.addNewDialogue("Caronte: Não costumo receber passageiros com um coração batendo no peito. A maioria dos mortais foge de fininho do Submundo, não entra nele marchando.");
        scene6.addNewDialogue("Caronte: Diga-me, vivo... O que exatamente te arrastou para a terra dos mortos?");
        scene6.addNewDialogue("O que você responde às indagações de Caronte?");

        scene6.addNewChoice("Não faça perguntas, apenas me leve em frente", "s6a_charon_boat","Charon", 0, -1, 0, 0, 0);
        scene6.addNewChoice("Desejo rever o amor da minha vida", "s6b_charon_boat","Charon", 0, 0, 0, 0, 0);
        scene6.addNewChoice("Não consigo viver sem ela", "s6c_charon_boat","Charon", 0, 0, 0, 0, 0);

        // Cena 6a, 6b e 6c
        scene6a.addNewDialogue("Caronte aperta o remo com força, irritado com a sua hostilidade.");
        scene6a.addNewDialogue("Caronte: Tolo arrogante.");
        scene6a.addNewDialogue("Caronte: Hades vai mastigar sua insolência.");
        scene6b.addNewDialogue("A postura tensa do barqueiro relaxa um pouco.");
        scene6b.addNewDialogue("Caronte: Amor... O veneno dos vivos.");
        scene6c.addNewDialogue("Você desvia o olhar, encarando seu próprio reflexo distorcido na água negra.");
        scene6c.addNewDialogue("Caronte solta um suspiro rouco, há muito acostumado com o desespero, mas levemente impressionado pela profundidade da sua dor.");

        // Cena 7
        scene7.addNewDialogue("Caronte: Escute bem, vivo. Minha jurisdição é limitada pelas águas. Posso levá-lo apenas uma região por vez. Se deseja se embrenhar mais a fundo nos domínios de Hades, precisará de mais moedas para o resto do trajeto.");

        chapter.newScene(scene1);
        chapter.newScene(scene2);
        chapter.newScene(scene2a);
        chapter.newScene(scene2b);
        chapter.newScene(scene2c);
        chapter.newScene(scene3);
        chapter.newScene(scene4);
        chapter.newScene(scene4a);
        chapter.newScene(scene4b);
        chapter.newScene(scene5);
        chapter.newScene(scene5a);
        chapter.newScene(scene5b);
        chapter.newScene(scene5c);
        chapter.newScene(scene6);
        chapter.newScene(scene6a);
        chapter.newScene(scene6b);
        chapter.newScene(scene6c);
        chapter.newScene(scene7);


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