package entities;


public class Jogo {

    String[] opcoes = new String[]{"X", "O"};
    
    // se o jogador 1 digitar algo diferente de X e O o jogo não dá prosseguimento
    public boolean verifcaAEntrada(String escolha){
        if (!escolha.equals("X") && !escolha.equals("O")){
            return true;
        }
        return false;
    }

    public String escolhaDoJogador1(String escolha){
        if (escolha.equals(opcoes[0])){
            String jogador1 = opcoes[0];
            return jogador1;
        }
        else {
            String jogador1 = opcoes[1];
            return jogador1;
        }
    }

    public String escolhaDoJogador2(String escolha){
        if (escolha.equals(opcoes[0])){
            String jogador2 = opcoes[1];
            return jogador2;
        }
        else{
            String jogador2 = opcoes[0];
            return jogador2;
        }
    }
    
    // verfica se a linha e a coluna que o jogador está tentando colocar a sua peça já possua uma outra peça, caso seja true, o programa principal exibe uma mensagem, caso contrário ele segue normalmente.
    public boolean espacoOcupado(String[][] tabuleiro, int posicaoLinha, int posicaoColuna){  
        if (tabuleiro[posicaoLinha][posicaoColuna] != null) {
            return true;
        }
        
        return false;
    }
        
    // vai indicar a vez do jogador, ou seja, se está na vez do jogador 1 ou do jogador 2
    // jogador 1 o resto da divisão é 1, para o 2 o resto tem que ser 0
    public boolean vezDoJogador(int count){
        if (count % 2 == 1) {
            return true;
        }
        return false;
    }
    
    public String atualizandoTabuleiro(String [][] tabuleiro, int posicaoLinha, int posicaoColuna) {
    	for (int i = 0; i < tabuleiro.length; i++) {
        	System.out.print(i);
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][j] != null){
                    System.out.print(" [" + tabuleiro[i][j] + "]");
                }
                else {
                	System.out.print(" [ ]");
                }

            }
            System.out.println();
        }
        System.out.print("   0   1   2");
		return "";
    }
    
    public boolean xGanha(String[][] tabuleiro){
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[0][0] == "X" && tabuleiro[1][0] == "X" && tabuleiro[2][0] == "X") {
                    return true;
                }
                else if (tabuleiro[0][1] == "X" && tabuleiro[1][1] == "X" && tabuleiro[2][1] == "X"){
                    return true;
                }
                else if (tabuleiro[0][2] == "X" && tabuleiro[1][2] == "X" && tabuleiro[2][2] == "X") {
                    return true;   
                }
                // horizontal
                else if (tabuleiro[0][0] == "X" && tabuleiro[0][1] == "X" && tabuleiro[0][2] == "X") {
                    return true;
                }
                else if (tabuleiro[1][0] == "X" && tabuleiro[1][1] == "X" && tabuleiro[1][2] == "X"){
                    return true;
                }
                else if (tabuleiro[2][0] == "X" && tabuleiro[2][1] == "X" && tabuleiro[2][2] == "X"){
                    return true;
                }
                // diagonal
                else if (tabuleiro[0][0] == "X" && tabuleiro[1][1] == "X" && tabuleiro[2][2] == "X") {
                    return true;
                }
                else if (tabuleiro[0][2] == "X" && tabuleiro[1][1] == "X" && tabuleiro[2][0] == "X") {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean oGanha(String[][] tabuleiro){
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[0][0] == "O" && tabuleiro[1][0] == "O" && tabuleiro[2][0] == "O") {
                    return true;
                }
                else if (tabuleiro[0][1] == "O" && tabuleiro[1][1] == "O" && tabuleiro[2][1] == "O"){
                    return true;
                }
                else if (tabuleiro[0][2] == "O" && tabuleiro[1][2] == "O" && tabuleiro[2][2] == "O") {
                    return true;   
                }
                // horizontal
                else if (tabuleiro[0][0] == "O" && tabuleiro[0][1] == "O" && tabuleiro[0][2] == "O") {
                    return true;
                }
                else if (tabuleiro[1][0] == "O" && tabuleiro[1][1] == "O" && tabuleiro[1][2] == "O"){
                    return true;
                }
                else if (tabuleiro[2][0] == "O" && tabuleiro[2][1] == "O" && tabuleiro[2][2] == "O"){
                    return true;
                }
                // diagonal
                else if (tabuleiro[0][0] == "O" && tabuleiro[1][1] == "O" && tabuleiro[2][2] == "O") {
                    return true;
                }
                else if (tabuleiro[0][2] == "O" && tabuleiro[1][1] == "X" && tabuleiro[2][0] == "O") {
                    return true;
                }
            }
        }
        return false;
    }
    
    public String vencedor(String[][] tabuleiro, String escolha) {
    	
    	if (xGanha(tabuleiro) == true && escolhaDoJogador1(escolha).equals("X")){
            return "Jogador 1 Venceu";
        }
    	
    	else if (xGanha(tabuleiro) == true && escolhaDoJogador2(escolha).equals("X")){
            return "Jogador 2 venceu";
        }
    	
    	else if (oGanha(tabuleiro) == true && escolhaDoJogador1(escolha).equals("O")){
            return  "Jogador 1 venceu";
        }
    	
    	else {
    		return "Jogador 2 venceu";
    	}
    }
}
