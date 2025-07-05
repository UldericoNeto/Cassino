import java.util.*;

public class Jogo {
    private List<Integer> baralho = new ArrayList<>();
    private int[] cartas = new int[10];

    public void CriarBaralho(float tamanho) {
        for(int i=1; i < 11; i++){
            for(int j=1; j<(4*tamanho); j++){
                this.baralho.add(i);
            }
            if(i == 10){
                for(int j=1; j<(4*tamanho)*4; j++){
                    this.baralho.add(i);
                }
            }
        }
    } //criar um baralho de acordo com a dificuldade passada

    public void EmbaralharBaralho() {
        Collections.shuffle(this.baralho);
    } //aleatorizar o baralho

    public void SortearCartas()  {
        EmbaralharBaralho(); //criar uma aleatoridade maior
        for (int i = 0; i < this.cartas.length; i++) {
            if(this.cartas[i] == 0) {
                this.cartas[i] = this.baralho.get(0);
                break;
            }
        }
        RemoverCarta(); //remove a carta sorteado do baralho para não poder puxala novamente
    } //puxar uma carta do baralho

    public void RemoverCarta(){
        this.baralho.remove(0);
    } //remover a primeira carta do baralho

    public int[] GetCartas() {
        return this.cartas;
    }

    public boolean Resultado(){
        boolean resultado = false;
        int total = Pontuacao();
        if(total == 21) resultado = true;
        return resultado;
    } //saber se o jogador atingiu 21

    public int Pontuacao(){
        int total = 0;
        for(int i=0; i<this.cartas.length; i++){
            total += this.cartas[i];
        }
        return total;
    } //calcular a soma de todas as cartas do jogador

    public boolean CartasCompletas(){
        for(int i=0; i<this.cartas.length; i++){
            if(this.cartas[i] == 0) return false;
        }
        return true;
    } //saber se o jogador possui 10 cartas

    public Jogo(){

    }
}
