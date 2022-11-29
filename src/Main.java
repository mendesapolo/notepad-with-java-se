import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        int tamMax = 300;
        int numLinhas = 0;
        int numLinhasAtiva = 0;
        int count = 0;
        String[] linhas = new String[tamMax];
        int[] numPalavras = new int[tamMax];
        int[] numChars = new int[tamMax];
        boolean[] apagadas = new boolean[tamMax];
        
        String opcao = "";
        do {
            System.out.println("**************************************************************");
            System.out.println("*\t(I)nserir linhas no fim (termine com uma linha vazia)");
            System.out.println("*\t(L)istar linhas");
            System.err.println("*\t(A)pagar última linha");
            System.out.println("*\t(E)ditar");
            System.out.println("*\t(F)erramentas");
            System.out.println("*\t(S)air");
            System.out.println("**************************************************************");
            System.out.print("*<Principal> ");
            opcao = new Scanner(System.in).next();
            System.out.println("\n\n\n\n");
            System.out.println("**************************************************************");
            
            switch(opcao.toLowerCase()){
                case "i":
                    System.out.println("** INSERIR LINHAS");
                    System.out.println("**************************************************************");
                    
                    int numLinhasInseridas = 0;
                    
                    for (int i = 0; i < linhas.length; i++) {
                        String linha = new Scanner(System.in).nextLine();
                        if (!linha.equalsIgnoreCase("")) {
                            linhas[numLinhas] = linha;
                            
                            numPalavras[numLinhas] = linha.split(" ").length;
                            numChars[numLinhas] = linha.replaceAll(" ", "").length();
                            apagadas[numLinhas] = false;
                            numLinhas++;
                            numLinhasAtiva++;
                            numLinhasInseridas++;
                        } else {
                            break;
                        }
                    }
                    System.out.println("*\tNº de Linhas inseridas: "+numLinhasInseridas);
                    break;
                case "l":
                    System.out.println("** LISTAR LINHAS");
                    System.out.println("**************************************************************");
                    String[] linhasAtivas = new String[numLinhasAtiva];
                    count = 0;
                    for (int i = 0; i < numLinhas; i++) {
                        if (!apagadas[i]) {
                            count++;
                            System.out.println(count+"\t| "+linhas[i]);
                            linhasAtivas[count-1] = linhas[i];
                        }
                    }
                    break;
                case "a":
                    System.err.println("** APAGAR ULTIMA LINHA");
                    System.out.println("**************************************************************");
                    
                    for (int i = numLinhas; i >= 0; i--) {
                        if (!apagadas[i-1]) {
                            apagadas[i-1] = true;
                            numLinhasAtiva--;

                            System.out.println("*\t\tA ultima linha foi apagada");
                            System.out.println("**************************************************************");

                            // As duas linhas abaixo ser apenas para pausar a tela até o utilizador primar a tecla enter
                            System.out.print("\n\n\nPrima ENTER para continuar...");
                            new Scanner(System.in).nextLine();
                            break;
                        }
                    }
                    break;
                case "e": {
                    String menuEditar = "";
                    do {
                        System.out.println("**\tMENU EDITAR");
                        System.out.println("**************************************************************");
                        System.out.println("**\t(I)nserir linha na posição n");
                        System.out.println("**\t(A)pagar linha na posição n");
                        System.out.println("**\tApagar (l)inhas da posição n à posição m");
                        System.out.println("**\t(R)ecuperar linha");
                        System.out.println("**\t(E)liminar linhas apagadas");
                        System.out.println("**\t(V)oltar");
                        System.out.println("**************************************************************");
                        System.out.print("**<Editar> ");
                        menuEditar = new Scanner(System.in).next();
                        System.out.println("\n\n\n\n");
                        System.out.println("**************************************************************");

                        switch (menuEditar.toLowerCase()) {
                            case "i":
                                System.out.println("*** INSERIR LINHA");
                                System.out.println("**************************************************************");
                                System.err.println("***>    Insira o número da linha que pretendes editar     <***");
                                System.out.print("* Linha Nº: ");
                                
                                int nLinha = new Scanner(System.in).nextInt();
                                int verifica = 0;
                                
                                if (nLinha > 0 && nLinha <= numLinhasAtiva) {
                                    for (int i = 0; i < numLinhas; i++){
                                        if (!apagadas[i]) {
                                            verifica++;
                                            if (verifica == nLinha) {
                                                String texto = new Scanner(System.in).nextLine();
                                                linhas[nLinha - 1] = texto;
                                                numPalavras[nLinha - 1] = texto.split(" ").length;
                                                numChars[nLinha - 1] = texto.replaceAll(" ", "").length();
                                                
                                                System.out.println("*\n*");
                                                System.out.println("*\tA linha Nº: "+nLinha+" foi editada com sucesso!");
                                                System.out.println("**************************************************************");
                                                
                                                // As duas linhas abaixo ser apenas para pausar a tela até o utilizador primar a tecla enter
                                                System.out.print("\n\n\nPrima ENTER para continuar...");
                                                new Scanner(System.in).nextLine();
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("*\tO número de linha escolhida não existe.");
                                    System.out.println("**************************************************************");
                                    // As duas linhas abaixo ser apenas para pausar a tela até o utilizador primar a tecla enter
                                    System.out.print("\n\n\nPrima ENTER para continuar...");
                                    new Scanner(System.in).nextLine();
                                }
                                break;
                            case "a":
                                System.out.println("*** APAGAR LINHA NA POSIÇÃO (n)");
                                System.out.println("**************************************************************");
                                System.err.println("*\n***>    Insira o número da linha que pretendes apagar     <***");
                                System.out.print("* Linha Nº: ");
                                int nLinha2 = new Scanner(System.in).nextInt();
                                int verifica2 = 0; 
                                if (nLinha2 > 0 && nLinha2 <= numLinhasAtiva) {
                                    for (int i = 0; i < numLinhas; i++){
                                        if (!apagadas[i]) {
                                            verifica2++;
                                            if (verifica2 == nLinha2) {
                                                apagadas[nLinha2 - 1] = true;
                                                numLinhasAtiva--;
                                                
                                                System.out.println("*\n*");
                                                System.out.println("*\tA linha Nº: "+nLinha2+" foi apagada!");
                                                System.out.println("**************************************************************");
                                                
                                                // As duas linhas abaixo ser apenas para pausar a tela até o utilizador primar a tecla enter
                                                System.out.print("\n\n\nPrima ENTER para continuar...");
                                                new Scanner(System.in).next();
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("*\tO número de linha escolhida não existe.");
                                    System.out.println("**************************************************************");
                                    // As duas linhas abaixo ser apenas para pausar a tela até o utilizador primar a tecla enter
                                    System.out.print("\n\n\nPrima ENTER para continuar...");
                                    new Scanner(System.in).next();
                                }
                                break;
                            case "l":
                                System.out.println("*** APAGAR LINHAS DA POSIÇÃO (n) ATÉ (m)");
                                System.out.println("**************************************************************");
                                System.err.println("*\n***>    Insira o intervalo de linha que pretendes apagar     <***");
                                System.out.print("* De: ");
                                int numLinhaN = new Scanner(System.in).nextInt();
                                System.out.print("* Até: ");
                                int numLinhaM = new Scanner(System.in).nextInt();
                                int verifica3 = 0;
                                count = 0;
                                if (numLinhaN > 0 && numLinhaN < numLinhaM && numLinhaM < numLinhasAtiva) {
                                    for (int i = 0; i < numLinhas; i++) {
                                        if (!apagadas[i]) {
                                            verifica3++;
                                            if (verifica3 >= numLinhaN && verifica3 <= numLinhaM) {
                                                apagadas[i] = true;
                                                numLinhasAtiva--;
                                                count++;
                                            }
                                        }
                                    }

                                    if(count > 0){
                                        System.out.println("*\n*");
                                        System.out.println("*\tAs linhas de "+numLinhaN+" até "+numLinhaM+" foram apagadas com sucesso");
                                        System.out.println("**************************************************************");
                                        
                                        // As duas linhas abaixo ser apenas para pausar a tela até o utilizador primar a tecla enter
                                        System.out.print("\n\n\nPrima ENTER para continuar...");
                                        new Scanner(System.in).nextLine();
                                    }
                                    
                                } else {
                                    System.out.println("*\n*");
                                    System.out.println("*\tO intervalo introduzido é inválido");
                                    System.out.println("**************************************************************");
                                    
                                    // As duas linhas abaixo ser apenas para pausar a tela até o utilizador primar a tecla enter
                                    System.out.print("\n\n\nPrima ENTER para continuar...");
                                    new Scanner(System.in).nextLine();
                                }
                                break;
                            case "r":
                                System.out.println("*** RECUPERAR LINHA");
                                System.out.println("**************************************************************");
                                for (int i = 0; i < tamMax; i++) {
                                    if (apagadas[i]) {
                                        System.out.println("Nº: "+(i+1)+"\t| "+linhas[i]);
                                    }
                                }
                                System.out.println("**************************************************************");
                                System.out.println("*\n***>           Qual linha pretendes restaurar?            <***");
                                System.out.print("* Linha Nº: ");
                                int linhaARestaurar = new Scanner(System.in).nextInt();
                                
                                if (linhaARestaurar > 0 && linhaARestaurar <= tamMax && apagadas[linhaARestaurar - 1]) {
                                    apagadas[linhaARestaurar - 1] = false;
                                    numLinhasAtiva++;
                                    System.out.println("*\n*\n*\n**************************************************************");
                                    System.out.println("*\tLinha restaurada com sucesso");
                                    System.out.println("**************************************************************");
                                    
                                    // As duas linhas abaixo ser apenas para pausar a tela até o utilizador primar a tecla enter
                                    System.out.print("\n\n\nPrima ENTER para continuar...");
                                    new Scanner(System.in).nextLine();
                                } else {
                                    System.out
                                            .println("**************************************************************");
                                    System.out.println("*\tLinha não encontrada");
                                    System.out
                                            .println("**************************************************************");

                                    // As duas linhas abaixo ser apenas para pausar a tela até o utilizador primar a
                                    // tecla enter
                                    System.out.print("\n\n\nPrima ENTER para continuar...");
                                    new Scanner(System.in).nextLine();
                                }
                                break;
                            case "e":
                                System.out.println("*** ELIMINAR LINHAS APAGADAS");
                                System.out.println("**************************************************************");
                                for (int i = 0; i < tamMax; i++) {
                                    if (apagadas[i]) {
                                        System.out.println("Nº: " + (i + 1) + "\t| " + linhas[i]);
                                    }
                                }
                                System.out.println("**************************************************************");
                                System.out.println("*\n***>     Qual linha pretendes eliminar permanentemente    <***");
                                System.out.print("*\n* Linha Nº: ");
                                int linhaAEliminar = new Scanner(System.in).nextInt();
                                if (linhaAEliminar > 0 && linhaAEliminar <= tamMax && apagadas[linhaAEliminar - 1]) {
                                    apagadas[linhaAEliminar - 1] = false;
                                    linhas[linhaAEliminar - 1] = null;
                                    numChars[linhaAEliminar - 1] = 0;
                                    numPalavras[linhaAEliminar - 1] = 0;
                                    numLinhas--;

                                    System.out.println("**************************************************************");
                                    System.out.println("*\tLinha eliminada com sucesso");
                                    System.out.println("**************************************************************");
                                    
                                    // As duas linhas abaixo ser apenas para pausar a tela até o utilizador primar a tecla enter
                                    System.out.print("\n\n\nPrima ENTER para continuar...");
                                    new Scanner(System.in).nextLine();
                                } else {
                                    System.out.println("**************************************************************");
                                    System.out.println("*\tLinha não encontrada");
                                    System.out.println("**************************************************************");
                                    
                                    // As duas linhas abaixo ser apenas para pausar a tela até o utilizador primar a tecla enter
                                    System.out.print("\n\n\nPrima ENTER para continuar...");
                                    new Scanner(System.in).nextLine();
                                }
                                break;
                            case "v":
                                break;
                            default:
                                System.out.println("**************************************************************");
                                System.out.println("***                    OPÇÃO INVÁLIDA                      ***");
                                System.out.println("**************************************************************");

                        }

                    } while (!menuEditar.equalsIgnoreCase("v"));
                    break;
                }
                case "f":{
                    String menuFerramentas = "";
                    do {
                        System.out.println("** MENU FERRAMENTAS");
                        System.out.println("**************************************************************");
                        System.out.println("**\t(M)ostrar linhas onde ocorre a palavra p");
                        System.out.println("**\t(S)ubstituir a palavra p na linha n");
                        System.out.println("**\tMostrar número de (l)inhas");
                        System.out.println("**\tMostrar número de (p)palavras");
                        System.out.println("**\tMostrar número de (c)aracteres");
                        System.out.println("**\t(V)oltar");
                        System.out.println("**************************************************************");
                        System.out.print("**<Ferramentas> ");
                        menuFerramentas = new Scanner(System.in).next();
                        System.out.println("\n\n\n\n");
                        System.out.println("**************************************************************");

                        switch (menuFerramentas.toLowerCase()) {

                            case "m":
                                System.out.println("*** MOSTRAR LINHAS ONDE OCORRERAM A PALAVRA P");
                                System.out.println("**************************************************************");
                                System.err.println("*\n***>            Qual palavra estas a procurar?          <***");
                                System.out.print("* Pesquisar: ");
                                String palavra = new Scanner(System.in).next();
                                System.out.println("**************************************************************");
                                count = 0;
                                for (int i = 0; i < numLinhas; i++) {
                                    if (!apagadas[i]) {
                                        String texto = linhas[i];
                                        if (texto.contains(palavra)) {
                                            System.out.println((i + 1) + "\t| " + texto);
                                            count++;
                                        }
                                    }
                                }
                                
                                if (count == 0) {
                                    System.out.println("***>           Nenhuma ocorrência foi encntrada           <***");
                                    System.out.println("**************************************************************");
                                    
                                    // As duas linhas abaixo ser apenas para pausar a tela até o utilizador primar a tecla enter
                                    System.out.print("\n\n\nPrima ENTER para continuar...");
                                    new Scanner(System.in).nextLine();
                                } else {
                                    System.out.println("*\tEsta palavra ocorre em "+count+" linha(s).");
                                    System.out.println("\n\n**************************************************************");
                                    
                                    // As duas linhas abaixo ser apenas para pausar a tela até o utilizador primar a tecla enter
                                    System.out.print("\n\n\nPrima ENTER para continuar...");
                                    new Scanner(System.in).nextLine();
                                }
                                break;
                            case "s":
                                System.out.println("*** SUBSTITUIR A PALAVRA P");
                                System.out.println("**************************************************************");
                                System.err.println("*\n***>         Qual palavra pretendes substituir?         <***");
                                System.out.print("* Subtituir: ");
                                String palavra2 = new Scanner(System.in).next();
                                System.out.print("* Para: ");
                                String palavra2Aux = new Scanner(System.in).next();
                                System.out.println("**************************************************************");
                                count = 0;
                                for (int i = 0; i < numLinhas; i++) {
                                    if (!apagadas[i]) {
                                        linhas[i].replaceAll(palavra2, palavra2Aux);
                                        System.out.println((i + 1) + "\t| " + linhas[i]);
                                        count++;
                                    }
                                } 
                                if (count > 0) {
                                    System.out.println("\n\n**************************************************************");
                                    System.out.println("*\tEsta palavra foi substituida em "+count+" linha(s).");
                                    System.out.println(" **************************************************************");
                                    
                                    // As duas linhas abaixo ser apenas para pausar a tela até o utilizador primar a tecla enter
                                    System.out.print("\n\n\nPrima ENTER para continuar...");
                                    new Scanner(System.in).nextLine();
                                }else {
                                    System.out.println("***>           Nenhuma ocorrência foi encntrada           <***");
                                    System.out.println("**************************************************************");
                                    
                                    // As duas linhas abaixo ser apenas para pausar a tela até o utilizador primar a tecla enter
                                    System.out.print("\n\n\nPrima ENTER para continuar...");
                                    new Scanner(System.in).nextLine();
                                }
                                break;
                            case "l":
                                System.out.println("***\tMOSTRAR O NÚMERO DE LINHAS");
                                System.out.println("**************************************************************");
                                int totalApagadas = 0;
                                for (int i = 0; i < apagadas.length; i++) {
                                    if (apagadas[i]) {
                                        totalApagadas++;
                                    }
                                }
                                System.out.println("*\t\tTotal de linhas: " + (numLinhas - totalApagadas));
                                System.out.println("*");
                                System.out.println("**************************************************************");
                                System.out.println("\n\n\n\n");
                                break;
                            case "p":
                                System.out.println("*** MOSTRAR O NÚMERO DE PALAVRAS");
                                System.out.println("**************************************************************");
                                int totalPalavras = 0;
                                for (int i = 0; i < numLinhas; i++) {
                                    if (!apagadas[i]) {
                                        totalPalavras += numPalavras[i];
                                    }
                                }
                                System.out.println("*\t\tTotal de palavras: " + totalPalavras);
                                System.out.println("**************************************************************");
                                System.out.println("\n\n\n\n");
                                break;
                            case "c":
                                System.out.println("*** MOSTRAR O NÚMERO DE CARACTERES");
                                System.out.println("**************************************************************");
                                int totalChars = 0;
                                for (int i = 0; i < numLinhas; i++) {
                                    if (!apagadas[i]) {
                                        totalChars += numChars[i];
                                    }
                                }
                                System.out.println("*\t\tTotal de caracteres: " + totalChars);
                                System.out.println("**************************************************************");
                                System.out.println("\n\n\n\n");
                                break;
                            case "v":
                                break;
                            default:
                                System.out.println("**************************************************************");
                                System.out.println("***                    OPÇÃO INVÁLIDA                      ***");
                                System.out.println("**************************************************************");

                        }
                    } while (!menuFerramentas.equalsIgnoreCase("v"));
                    break;
                }
                case "s":
                    System.err.println("**************************************************************");
                    System.err.println("**********                            ****             *******");
                    System.err.println("*******       **      PROGRAMA ENCERRADO!           **********");
                    System.err.println("*************             ***                             ****");
                    System.err.println("**************************************************************");

                    break;
                default:
                    System.out.println("Esta opção não existe.");
            }
        } while (!opcao.equalsIgnoreCase("S"));
    }
}