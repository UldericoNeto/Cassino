public class Jogo {
    private char[][] matriz = new char[3][3];

    public Jogo() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                this.matriz[i][j] = '\u0000';
            }
        }
    }

    //virifica se a posição que deseja é valida e marca ela
    public void jogada(int linha, int coluna, char simbolo) {
        if (!posicaoVerificar(linha, coluna)) {
            System.out.println("Informe uma posição valida");
            return;
        }else if (!posicaoValida(linha, coluna)) {
            System.out.println("Outro jogador ja marcou nessa posição");
            return;
        }
        matriz[linha][coluna] = simbolo;

    }

    //verificar se ganhou o jogo
    public boolean vitoria(char simbolo) {
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] == simbolo && matriz[i][1] == simbolo && matriz[i][2] == simbolo) {
                return true;
            }
            if (matriz[0][i] == simbolo && matriz[1][i] == simbolo && matriz[2][i] == simbolo) {
                return true;
            }
            if (i == 0 && matriz[0][0] == simbolo && matriz[1][1] == simbolo && matriz[2][2] == simbolo) {
                return true;
            }
            if (i == 0 && matriz[0][2] == simbolo && matriz[1][1] == simbolo && matriz[2][0] == simbolo) {
                return true;
            }
        }
        return false;
    }

    public boolean completo(){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == '\u0000') {
                    return false;
                }
            }
        }
        return true;
    }

    //imprimir a matriz
    public void imprimir() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
    }

    //verificar se a coluna e linha digitadas está dentro dos limites
    public boolean posicaoVerificar(int linha, int coluna){
        return linha >= 0 && linha < matriz.length && coluna >= 0 && coluna < matriz[linha].length;
    }

    //verificar se existe outro simbolo no local
    public boolean posicaoValida(int linha, int coluna){
        return posicaoVerificar(linha, coluna) && matriz[linha][coluna] == '\u0000';
    }
}
