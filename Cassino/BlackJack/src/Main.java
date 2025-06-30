import java.util.*;

/*
obs: implementar no futuro quando tiver uma UI boa;
NOTA MENTAL: 1->copas; 2->ouros; 3->paus; 4->espadas;
             cada carta vem acompanhada do seu naipe;
             ex: 11-> 1 de copas; 34-> 3 de espadas;
*/

public class Main {
    public static void main(String[] args) {
        int op, pux, total=0;
        List<Integer> baralho = new ArrayList<>();
        for(int i=1; i < 11; i++){
            for(int j=1; j<5; j++){
                baralho.add(i);
            }
        }
        String jogador;
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("Digite uma opcao: 1-> jogar; 2-> sair\n>> ");
            op = sc.nextInt();
            sc.nextLine();
            if(op == 2) break;

            System.out.print("Digite seu nome: ");
            jogador = sc.nextLine();


            //SORTEAR AS CARTAS
            Collections.shuffle(baralho);
            int[] cartas = new int[10];
            cartas[0] = baralho.get(0);
            baralho.remove(0);
            cartas[1] = baralho.get(0);
            baralho.remove(0);

            System.out.print("Cartas sorteadas: "+cartas[0]+" "+cartas[1]);
            for(int i=2; i<11; i++){
                System.out.print("\nDeseja puxar mais alguma carta? 1->sim; 2->nao\n>> ");
                pux = sc.nextInt();
                if(pux == 2) break;

                Collections.shuffle(baralho);
                cartas[i] = baralho.get(0);
                baralho.remove(0);
                System.out.println("Carta puxada: "+cartas[i]);
                System.out.print("Suas cartas: ");
                for(int j=0; j < cartas.length; j++ ){
                    if(cartas[j] == 0) break;
                    System.out.print(cartas[j]+" ");

                }
            }
            for(int i=0; i<10; i++){
                total = total + cartas[i];
            }
            System.out.println("\nTotal das cartas: " + total);
            if(total < 21) {
                System.out.println("Por apenas " + (21-total) + " voce não ganhou mas chegou muito perto " + jogador + ". Boa sorte na proxima vez :D");
            } else if(total == 21) {
                System.out.println("Parabens por conseguir um valor de 21 " + jogador + "!");
            }else if(total > 21) {
                System.out.println("Voce estourou a mão por " + (total-21) + " Boa sorte na proxima vez :D");
            }

        }

        //System.out.println(baralho);
        sc.close();
    }
}