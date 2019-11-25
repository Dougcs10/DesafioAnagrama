       

        import java.io.LineNumberReader;
        import java.io.BufferedReader;
        import java.util.Scanner;
        import java.io.FileReader;
        import java.util.Arrays;
        import java.io.IOException;        
     
       
       
        public class DesafioAnagrama
        {
            
          
          
            
            public static void main(String[] args) 
            {
                 Scanner teclado = new Scanner(System.in);               
                 String linha = new String ();
                 String palavra;
                 Boolean AnagramaOk = false;
                 //---------------------------------------------------------------------------------------//
                 System.out.printf("Digite a palavra:\n");
                 palavra = (teclado.nextLine()).toUpperCase().replaceAll(" ",""); // tira espaços 
                
                 while(palavra.length() >= 16)//so aceita letras menores de 16 caracteres
                 {
                    System.out.printf("São aceitas apenas palavras com até 16 letras.\n");
                    System.out.printf("Digite a palavra:\n");
                    palavra = (teclado.nextLine()).toUpperCase().replaceAll(" ","");
                 }
                
                 if(palavra.matches("[a-zA-Z]+"))
                 {
                     System.out.printf("\nOs anagramas encontrados para " + palavra + " são:\n");
                     
                     try 
                     {
                         //Soma o numero de linhas
                         String nomeArquivo = "Palavras.txt"; 
                         FileReader arquivoLinhas = new FileReader(nomeArquivo);
                         LineNumberReader lnr = new LineNumberReader(arquivoLinhas);
                         lnr.skip(Integer.MAX_VALUE);
                         int QuantLinhas = 0;
                         QuantLinhas = lnr.getLineNumber() + 1;
                         arquivoLinhas.close();
                         // arquivo close
                         arquivoLinhas = new FileReader(nomeArquivo); // abre o arquivo novamente da primeira linha
                         String[] arrayLinhas = new String[QuantLinhas];
                                    
                         FileReader arquivoPalavras = new FileReader(nomeArquivo);
                         BufferedReader listaPalavras = new BufferedReader(arquivoPalavras);
                         
                            for (int i = 0; i < QuantLinhas; i++)
                                    {
                                        linha = listaPalavras.readLine(); //Lê cada linha
                                        arrayLinhas[i] = linha; //Armazena cada linha em um array
                                        
                                       
                                            
                                            if(palavra.length() == linha.length())// Verifica tamanho das palavras
                                            {
                                               
                                                char PalavraDigitadaSort[] = palavra.toCharArray(); // converte para um array
                                                char PalavraBlocoSort[] = linha.toCharArray(); 
                                                
                                                Arrays.sort(PalavraDigitadaSort); //coloca em ordem alfabetica o q foi digitado
                                                Arrays.sort(PalavraBlocoSort); // coloca em ordem alfabetica o que foi pego do bloco de notas
                                                
                                                
                                                int TesteAnagrama = ( Arrays.toString(PalavraDigitadaSort)).compareTo(Arrays.toString(PalavraBlocoSort));
                                                // testa se as palavras sao iguais em ordem alfabetica
                                                   
                                                
                                                if(TesteAnagrama == 0)// mostra resultados
                                                {
                                                   
                                                    System.out.println(linha); 
                                                    AnagramaOk = true;
                                                   
                                                }
                                               
                                                
                                                
                                                    
                                                
                                                
                                            }
                                            
                                    
                                         if(AnagramaOk == false && linha.isEmpty())
                                                {
                                                   System.out.println("Não foi encontrado nenhum anagrama");
                                                }
                                    }
                                    
                                }
                                    catch (IOException e) 
                                    {   // mensagem de erro caso o arquivo nao abra
                                        System.err.printf("Erro ao abrir o arquivo: %s.\n",
                                        e.getMessage());
                                    }  
                                    
                  }
                   else
                     {
                         System.out.println(" Caracter Inválido, Encerrando Aplicação ");
                     }
                     
            } 
            
        }