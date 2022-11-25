import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        int tamMax = 300;
        int numLinhas = 0;
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
            System.out.print("*==<Principal> ");
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
                    int ttLinhasApagadas = 0;
                    for (int i = 0; i < apagadas.length; i++) {
                        if (apagadas[i]) {
                            ttLinhasApagadas++;
                        }
                    }
                    int ttLinhasAtivas = numLinhas - ttLinhasApagadas;
                    String[] linhasAtivas = new String[ttLinhasAtivas];
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
                    int ttLinhasApagadas2 = 0;
                    for (int i = 0; i < apagadas.length; i++) {
                        if (apagadas[i]) {
                            ttLinhasApagadas2++;
                        }
                    }
                    int ttLinhasAtivas2 = numLinhas - ttLinhasApagadas2;
                    String[] linhasAtivas2 = new String[ttLinhasAtivas2];
                    System.out.println("*");
                    System.out.println("**************************************************************");
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
                        System.out.print("**=<Editar> ");
                        menuEditar = new Scanner(System.in).next();
                        System.out.println("\n\n\n\n");
                        System.out.println("**************************************************************");

                        switch (menuEditar.toLowerCase()) {
                            case "i":
                                System.out.println("*** INSERIR LINHA");
                                System.out.println("**************************************************************");

                                break;
                            case "a":
                                System.out.println("*** APAGAR LINHA NA POSIÇÃO (n)");
                                System.out.println("**************************************************************");

                                break;
                            case "l":
                                System.out.println("*** APAGAR LINHAS DA POSIÇÃO (n) ATÉ (m)");
                                System.out.println("**************************************************************");

                                break;
                            case "r":
                                System.out.println("*** RECUPERAR LINHA");
                                System.out.println("**************************************************************");

                                break;
                            case "e":
                                System.out.println("*** ELIMINAR LINHAS APAGADAS");
                                System.out.println("**************************************************************");

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
                case "f":
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
                        System.out.print("**=<Ferramentas> ");
                        menuFerramentas = new Scanner(System.in).next();
                        System.out.println("\n\n\n\n");
                        System.out.println("**************************************************************");

                        switch (menuFerramentas.toLowerCase()) {
                            case "m":
                                System.out.println("*** MOSTRAR LINHAS ONDE OCORRERAM A PALAVRA P");
                                System.out.println("**************************************************************");

                                break;
                            case "s":
                                System.out.println("*** SUBSTITUIR A PALAVRA P");
                                System.out.println("**************************************************************");

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