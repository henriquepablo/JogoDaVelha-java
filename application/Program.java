package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Jogo;

public class Program {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        Jogo jogo = new Jogo();

        String[][] tabuleiro = new String[3][3];

        int posicaoLinha = 0;
        int posicaoColuna = 0;
        int count = 9; // vai ajudar a identificar a vez do jogador

        System.out.println("------------ JOGO DA VELHA ------------\n");

        System.out.print("Escolha 'X' ou 'O': ");
        String escolha = input.next().toUpperCase();

        System.out.println();

        while (jogo.verifcaAEntrada(escolha) == true) {
            System.out.print("Escolha errada. Tente novamente: ");
            escolha = input.next().toUpperCase();
        }
        
        System.out.println("Jogador 1 escolheu " + jogo.escolhaDoJogador1(escolha));
        System.out.println("Jogador 2 escolheu " + jogo.escolhaDoJogador2(escolha));

        System.out.println();
        
        System.out.println(jogo.atualizandoTabuleiro(tabuleiro, posicaoLinha, posicaoColuna));
        

        while (true){

        	System.out.println();
        	
            if (jogo.vezDoJogador(count) == true) {
                System.out.println("Vez do Jogador 1\n");
            }
            else {
                System.out.println("Vez do jogador 2\n");
            }

            try {
            	do{
            
            		System.out.print("Informe em qual linha você vai jogar a sua peça: ");
            		posicaoLinha = input.nextInt();

            		System.out.print("Informe em qual coluna você vai jogar a sua peça: ");
            		posicaoColuna = input.nextInt();

            		System.out.println();
            	
            	} while (jogo.espacoOcupado(tabuleiro, posicaoLinha, posicaoColuna) == true);
            }
            catch (IndexOutOfBoundsException e) {
				System.out.println("Erro: O número informado é maior que a Matriz");
				break;
			}
            catch (InputMismatchException e) {
				System.out.println("Erro: O valor digitado não é um número");
				break;
			}
            
            
            if (jogo.vezDoJogador(count) == true){
                    tabuleiro[posicaoLinha][posicaoColuna] = jogo.escolhaDoJogador1(escolha);
            }
            else{
                    tabuleiro[posicaoLinha][posicaoColuna] = jogo.escolhaDoJogador2(escolha);
			} 

            System.out.println();
            
            System.out.println(jogo.atualizandoTabuleiro(tabuleiro, posicaoLinha, posicaoColuna));
            
            if (jogo.xGanha(tabuleiro) == true || jogo.oGanha(tabuleiro) == true) {
            	System.out.println();
            	System.out.println(jogo.vencedor(tabuleiro, escolha));
            	break;
			}
            
            count--;
            if (count == 0) {
                System.out.println("VELHA");
                break;
            }
            
        }
        input.close();
    }    
}
