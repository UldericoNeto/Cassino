import java.util.*;
public class Main {
    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        int[] jogador1, jogador2;
        Scanner sc = new Scanner(System.in);

        matrizBase();

        while (true) {
            //0 - linha; 1 - coluna;
            jogador1 = jogador1(sc);
            jogo.jogada(jogador1[0], jogador1[1], 'X');
            jogo.imprimir();
            if(jogo.vitoria('X')){
                System.out.println("X ganhou!");
                break;
            }else if (jogo.completo()){
                System.out.println("Empate!");
                break;
            }

            jogador2 = jogador2(sc);
            jogo.jogada(jogador2[0], jogador2[1], 'O');
            jogo.imprimir();
            if(jogo.vitoria('O')){
                System.out.println("O ganhou!");
                break;
            }

        }
        sc.close();
    }
    public static void matrizBase() {
        System.out.println("[L0C0] [L0C1] [L0C2]\n[L1C0] [L1C1] [L1C2]\n[L2C0] [L2C1] [L2C2]");
    }

    public static int[] jogador1(Scanner sc) {
        System.out.println("Jogador 1");
        System.out.print("Linha: ");
        int linha = sc.nextInt();
        System.out.print("Coluna: ");
        int coluna = sc.nextInt();
        return new int[] {linha, coluna};
    }

    public static int[] jogador2(Scanner sc) {
        System.out.println("Jogador 2");
        System.out.print("Linha: ");
        int linha = sc.nextInt();
        System.out.print("Coluna: ");
        int coluna = sc.nextInt();
        return new int[] {linha, coluna};
    }
}