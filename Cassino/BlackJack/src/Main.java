import java.util.*;

/*
obs: implementar no futuro quando tiver uma UI boa;
NOTA MENTAL: 1->copas; 2->ouros; 3->paus; 4->espadas;
             cada carta vem acompanhada do seu naipe;
             ex: 11-> 1 de copas; 34-> 3 de espadas;
*/

public class Main {
    public static void main(String[] args) {
        int op;
        Scanner sc = new Scanner(System.in);
        float dificuladade;

        Jogo jogo = new Jogo();
        int[] cartas; //armazenar todas as cartas ja sorteadas

        System.out.print("Digite a deficuladade do baralho:\n[1]-> Facil\n[2]-> Medio\n[3]-> Dificil\n[5]-> Sair\n>> ");
        dificuladade = sc.nextFloat();
        sc.nextLine();

        //setar para q seja um baralho completo(1), meio(2) ou um quarto(3)
        if(dificuladade == 1) dificuladade = 1f;
        else if(dificuladade == 2) dificuladade = 0.5f;
        else if(dificuladade == 3) dificuladade = 0.25f;
        jogo.CriarBaralho(dificuladade);

        //sortear as 2 primeiras cartas para começar o jogo
        jogo.SortearCartas();
        jogo.SortearCartas();
        cartas = jogo.GetCartas();
        MostrarCartas(cartas);

        //loop do jogo até parar de sortear ou ter 10 na mão
        while (true) {
            System.out.print("Deseja puxar mais cartas? 1->sim; 2->nao\n>> ");
            op = sc.nextInt();
            sc.nextLine();
            if (op == 2 || jogo.CartasCompletas()) {
                if (jogo.Resultado()) {
                    System.out.println("Total de pontos: " + jogo.Pontuacao());
                    System.out.println("Parabens por ganhar o jogo!");
                    break;
                } else {
                    System.out.println("Total de pontos: " + jogo.Pontuacao());
                    System.out.println("Voce perdeu!");
                    break;
                }
            }
            jogo.SortearCartas();
            cartas = jogo.GetCartas();
            MostrarCartas(cartas);
        }

        sc.close();
    }

    private static void MostrarCartas(int[] cartas){
        System.out.print("Cartas sorteadas: ");
        for(int i=0; i<10; i++){
            if(cartas[i] == 0) break;
            System.out.print(cartas[i]+" ");
        }
        System.out.println();
    }

}