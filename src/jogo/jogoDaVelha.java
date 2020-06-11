package jogo;

/*********************************************************************/
/**         Centro Universitario Senac                              **/
/**         TADS - 1o semestre de 2020                              **/
/**         <Fernando Almeida>                                      **/
/**                                                                 **/
/**         Projeto SEMESTRAL I                                     **/
/**         Arquivo: <grupo2-JulioLuanThiago.zip>                   **/
/**                                                                 **/
/**         <Julio Cesar Pereira Santos>                            **/
/**         <Luan Costa de Oliveira>                                **/
/**         <Thiago Gilabel de Souza>                               **/
/**                                                                 **/
/**         <23:59 do dia 13 de junho de 2020 (domingo)>            **/
/*********************************************************************/

import java.util.Scanner;
import java.util.Random;

public class jogoDaVelha {

    static Scanner cap = new Scanner(System.in);
    static String[][] tabuleiro = new String[3][3];
    static Random gerador = new Random();

    public static void main(String[] args) {

        imprimeMenuPrincipal();

    }

    static void inicializarTabuleiro() {// tipo primitivo indefinido

        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = " ";
            }
        }
    }

    static void imprimirTabuleiro() {

        System.out.println("");
        System.out.println(tabuleiro[0][0] + " | " + tabuleiro[0][1] + " | " + tabuleiro[0][2]);
        System.out.println("--+---+--");
        System.out.println(tabuleiro[1][0] + " | " + tabuleiro[1][1] + " | " + tabuleiro[1][2]);
        System.out.println("--+---+--");
        System.out.println(tabuleiro[2][0] + " | " + tabuleiro[2][1] + " | " + tabuleiro[2][2]);
        System.out.println("");
    }

    static int imprimeMenuPrincipal() {

        int mododeJogo = 0;

        do {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("| Escolha o modo de jogo:     |");
            System.out.println("| 1) modo jogador vs jogador  |");
            System.out.println("| 2) modo jogador vs maquina  |");
            System.out.println("| 3) modo maquina vs maquina  |");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            mododeJogo = cap.nextInt();
        } while (mododeJogo < 1 || mododeJogo > 3);

        switch (mododeJogo) {
            case 1:
                modoJogador();
                break;
            case 2:
                modoFacil();
                break;
            case 3:
                modoMaquinavsMaquina();
                break;
        }
        return mododeJogo;
    }

    static int leiaCoordenadaLinha() {
        int linha = 0;

        do {
            System.out.print("Digite a linha: ");
            linha = cap.nextInt();
        } while (linha < 0 || linha > 2);

        return linha;
    }

    static int leiaCoordenadaColuna() {
        int coluna = 0;

        do {
            System.out.println("");
            System.out.print("Digite a coluna: ");
            coluna = cap.nextInt();
            System.out.println("");

        } while (coluna < 0 || coluna > 2);

        return coluna;
    }

    static void imprimePontuacao(int jogador1, int jogador2) {

        System.out.println("");
        System.out.println("\tPontuação:\n");
        System.out.println("Jogador 1: " + jogador1 + "\t jogador 2: " + jogador2);

    }

    static boolean posicaoValida(int linha, int coluna, int count) {// ele verifica se no turno do jogador fulano se ele quer colocar em um lugar ja marcado
        boolean jogada = false;

        if (count % 2 == 0) {
            if (tabuleiro[linha][coluna] == "O" || tabuleiro[linha][coluna] == "X") {
                jogada = false;
            } else {
                jogada = true;
            }
        }
        if (count % 2 == 1) {
            if (tabuleiro[linha][coluna] == "X" || tabuleiro[linha][coluna] == "O") {
                jogada = false;
            } else {
                jogada = true;
            }
        }
        return jogada;
    }

    static boolean verificaVencedor(int count) {// a funcao ta verificando todas as possibilidades de vitoria no tabuleiro
        boolean vencedor = false;
        if (count % 2 == 0) { // vez do jogador X
            if (tabuleiro[0][0] == "X" && tabuleiro[1][1] == "X" && tabuleiro[2][2] == "X") {
                vencedor = true;
            } else if (tabuleiro[0][0] == "X" && tabuleiro[0][1] == "X" && tabuleiro[0][2] == "X") {
                vencedor = true;
            } else if (tabuleiro[1][0] == "X" && tabuleiro[1][1] == "X" && tabuleiro[1][2] == "X") {
                vencedor = true;
            } else if (tabuleiro[2][0] == "X" && tabuleiro[2][1] == "X" && tabuleiro[2][2] == "X") {
                vencedor = true;
            } else if (tabuleiro[0][2] == "X" && tabuleiro[1][1] == "X" && tabuleiro[2][0] == "X") {
                vencedor = true;
            } else if (tabuleiro[0][0] == "X" && tabuleiro[1][1] == "X" && tabuleiro[2][2] == "X") {
                vencedor = true;
            } else if (tabuleiro[0][0] == "X" && tabuleiro[1][0] == "X" && tabuleiro[2][0] == "X") {
                vencedor = true;
            } else if (tabuleiro[0][1] == "X" && tabuleiro[1][1] == "X" && tabuleiro[2][1] == "X") {
                vencedor = true;
            } else if (tabuleiro[0][2] == "X" && tabuleiro[1][2] == "X" && tabuleiro[2][2] == "X") {
                vencedor = true;
            }
        }
        if (count % 2 == 1) { // vez do jogador O
            if (tabuleiro[0][0] == "O" && tabuleiro[1][1] == "O" && tabuleiro[2][2] == "O") {
                vencedor = true;
            } else if (tabuleiro[0][0] == "O" && tabuleiro[0][1] == "O" && tabuleiro[0][2] == "O") {
                vencedor = true;
            } else if (tabuleiro[1][0] == "O" && tabuleiro[1][1] == "O" && tabuleiro[1][2] == "O") {
                vencedor = true;
            } else if (tabuleiro[2][0] == "O" && tabuleiro[2][1] == "O" && tabuleiro[2][2] == "O") {
                vencedor = true;
            } else if (tabuleiro[0][2] == "O" && tabuleiro[1][1] == "O" && tabuleiro[2][0] == "O") {
                vencedor = true;
            } else if (tabuleiro[0][0] == "O" && tabuleiro[1][1] == "O" && tabuleiro[2][2] == "O") {
                vencedor = true;
            } else if (tabuleiro[0][0] == "O" && tabuleiro[1][0] == "O" && tabuleiro[2][0] == "O") {
                vencedor = true;
            } else if (tabuleiro[0][1] == "O" && tabuleiro[1][1] == "O" && tabuleiro[2][1] == "O") {
                vencedor = true;
            } else if (tabuleiro[0][2] == "O" && tabuleiro[1][2] == "O" && tabuleiro[2][2] == "O") {
                vencedor = true;
            }
        }

        return vencedor;
    }

    static boolean verificaVelha(boolean vencedor) {// caso ao fim da partida o verificaVencedor for falso, significa que nao houve vencedor, logo deu velha 
        boolean velha = false;

        if (vencedor == false) {
            velha = true;
        }
        return velha;
    }

    static void modoJogador() { // jogador vs jogador

        int jogador1 = 0;
        int jogador2 = 0;

        int count = 0;// count vai ter o dever de controlar o turno da partida, quando count for par é vez do jogador 1, quando for impar sera do jogador 2
        int count1 = 0;
        inicializarTabuleiro();

        do {
            imprimirTabuleiro();
            int linha = leiaCoordenadaLinha();
            int coluna = leiaCoordenadaColuna();
            boolean posicao = posicaoValida(linha, coluna, count);

            if (posicao == false) {
                do {
                    System.out.println("Posicao Invalida");
                    linha = leiaCoordenadaLinha();
                    coluna = leiaCoordenadaColuna();
                    posicao = posicaoValida(linha, coluna, count);

                } while (posicao == false);
            }

            String jogada = jogar(linha, coluna, count);
            boolean vencedor = verificaVencedor(count);

            if (vencedor == true) {
                if (count % 2 == 0) {
                    System.out.println("Jogador 1 venceu!");
                    jogador1++;
                    count = -1;
                    count1 = 0;
                    imprimePontuacao(jogador1, jogador2);
                    inicializarTabuleiro();
                } else if (count % 2 == 1) {
                    System.out.println("Jogador 2 venceu!");
                    jogador2++;
                    count = 0;
                    count1 = 0;
                    imprimePontuacao(jogador1, jogador2);
                    inicializarTabuleiro();
                }
            }

            if (count1 == 9) {
                boolean velha = verificaVelha(vencedor);
                if (velha == true) {
                    imprimirTabuleiro();
                    System.out.println("Deu velha!");
                    inicializarTabuleiro();
                    count = 0;
                    count1 = 0;
                }
            }
            count++;
            count1++;

        } while (jogador1 < 3 && jogador2 < 3);

        if (jogador1 == 3) {
            System.out.println("Parabens, o Vencedor foi o jogador 1");
        } else if (jogador2 == 3) {
            System.out.println("Parabens, o Vencedor foi o jogador 2");
        }
    }

    static void modoMaquinavsMaquina() {

        int jogador1 = 0;
        int jogador2 = 0;

        int count = 0;// count vai ter o dever de controlar o turno da partida, quando count for par é vez do jogador 1, quando for impar sera do jogador 2
        int count1 = 0;
        inicializarTabuleiro();

        do {
            imprimirTabuleiro();
            int linha = gerador.nextInt(3);
            int coluna = gerador.nextInt(3);
            boolean posicao = posicaoValida(linha, coluna, count);

            if (posicao == false) {
                do {
                    linha = gerador.nextInt(3);
                    coluna = gerador.nextInt(3);
                    posicao = posicaoValida(linha, coluna, count);

                } while (posicao == false);
            }

            String jogada = jogar(linha, coluna, count);
            boolean vencedor = verificaVencedor(count);

            if (vencedor == true) {
                if (count % 2 == 0) {
                    imprimirTabuleiro();
                    System.out.println("Jogador 1 venceu!");
                    jogador1++;
                    count = -1;
                    count1 = 0;
                    imprimePontuacao(jogador1, jogador2);
                    inicializarTabuleiro();
                } else if (count % 2 == 1) {
                    imprimirTabuleiro();
                    System.out.println("Jogador 2 venceu!");
                    jogador2++;
                    count = 0;
                    count1 = 0;
                    imprimePontuacao(jogador1, jogador2);
                    inicializarTabuleiro();
                }
            }

            if (count1 == 9) {
                boolean velha = verificaVelha(vencedor);
                if (velha == true) {
                    imprimirTabuleiro();
                    System.out.println("Deu velha!");
                    inicializarTabuleiro();
                    count = 0;
                    count1 = 0;
                }
            }
            count++;
            count1++;

        } while (jogador1 < 3 && jogador2 < 3);

        if (jogador1 == 3) {
            System.out.println("Parabens, o Vencedor foi o jogador 1");
        } else if (jogador2 == 3) {
            System.out.println("Parabens, o Vencedor foi o jogador 2");
        }
    }

    static void modoFacil() {
        int jogador1 = 0;
        int jogador2 = 0;
        int linha = 0;
        int coluna = 0;

        inicializarTabuleiro();

        int count = 0; // controlador de turnos do jogo
        int count1 = 0; // controlador para verificar se deu velha

        do {

            imprimirTabuleiro();
            boolean vencedor = false;

            if (count % 2 == 0) {

                linha = leiaCoordenadaLinha();
                coluna = leiaCoordenadaColuna();
                jogadaUsuario(count, linha, coluna);
                vencedor = verificaVencedor(count);

            } else if (count % 2 == 1) {

                linha = gerador.nextInt(3);
                coluna = gerador.nextInt(3);
                jogadaMaquinaFacil(count, linha, coluna);
                vencedor = verificaVencedor(count);

            }

            if (vencedor == true) {
                if (count % 2 == 0) {

                    imprimirTabuleiro();
                    System.out.println("Jogador 1 venceu!");
                    jogador1++;
                    imprimePontuacao(jogador1, jogador2);
                    inicializarTabuleiro();
                    count = -1;
                    count1 = 0;

                } else if (count % 2 == 1) {

                    imprimirTabuleiro();
                    System.out.println("Jogador 2 venceu!");
                    jogador2++;
                    imprimePontuacao(jogador1, jogador2);
                    inicializarTabuleiro();
                    count = 0;
                    count1 = 0;

                }
            }

            if (count1 == 9) {
                boolean velha = verificaVelha(vencedor);
                if (velha == true) {

                    System.out.println("Deu velha!");
                    inicializarTabuleiro();
                    count = 0;
                    count1 = 0;

                }
            }

            count++;
            count1++;

        } while (jogador1 < 3 && jogador2 < 3);

        if (jogador1 == 3) {
            System.out.println("Parabens, o Vencedor foi o jogador 1");
        } else if (jogador2 == 3) {
            System.out.println("Parabens, o Vencedor foi o jogador 2");
        }

    }

    static String jogar(int leiaCoordenadaLinha, int leiaCoordenadaColuna, int count) { // quando a jogada for valida pelo verificaPosicao, essa funcao vai atribuir X ou O na linha e coluna

        if (count % 2 == 0) {// quando count for par, sera vez do X
            tabuleiro[leiaCoordenadaLinha][leiaCoordenadaColuna] = "X";
        } else if (count % 2 == 1) {// quando count for impar, sera vez do O
            tabuleiro[leiaCoordenadaLinha][leiaCoordenadaColuna] = "O";
        }

        return tabuleiro[leiaCoordenadaLinha][leiaCoordenadaColuna];
    }

    static String jogadaUsuario(int count, int linha, int coluna) {

        boolean posicao = posicaoValida(linha, coluna, count);

        if (posicao == false) {
            do {
                System.out.println("Posicao Invalida");
                linha = leiaCoordenadaLinha();
                coluna = leiaCoordenadaColuna();
                posicao = posicaoValida(linha, coluna, count);

            } while (posicao == false);
        }

        String jogada = jogar(linha, coluna, count);

        return jogada;
    }

    static String jogadaMaquinaFacil(int count, int linha, int coluna) {
        boolean posicao = posicaoValida(linha, coluna, count);

        if (posicao == false) {
            do {
                linha = gerador.nextInt(3);
                coluna = gerador.nextInt(3);
                posicao = posicaoValida(linha, coluna, count);

            } while (posicao == false);
        }

        String jogada = jogar(linha, coluna, count);

        return jogada;
    }
}
