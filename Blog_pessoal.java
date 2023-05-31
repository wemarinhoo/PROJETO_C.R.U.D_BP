import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

/* Códigos
 * 0 = OK
 * 1 = Erro
 * 2 = Id já utilizado por uma postagem */

 public class Blog_pessoal {

  public static ArrayList<Integer> ids = new ArrayList<>();
  public static ArrayList<String> nomes = new ArrayList<>();
  public static ArrayList<String> datas = new ArrayList<>();
  public static ArrayList<String> categorias = new ArrayList<>();
  public static ArrayList<String> titulos = new ArrayList<>();
  public static ArrayList<String> conteudos = new ArrayList<>();

  public static int create_post (Integer id, String nome, String data, String categoria, String titulo, String conteudo){

      int postagem_existe = read_post(id);

      if(postagem_existe >= 0){
              return 2;
      }

      ids.add(id);
      nomes.add(nome);
      datas.add(data);
      categorias.add(categoria);
      titulos.add(titulo);
      conteudos.add(conteudo);

      return 0;

  }

  public static int read_post (Integer id, String categoria, String data){
      

  }

  public static int update_post (){

  }

  public static int delete_post (){

  }
  public static void main(String[] args) {

    String nome, categoria, titulo, conteudo, data; 
    int id = 0, operacao, status, indice;

      Scanner scan = new Scanner(System.in);

      while(true){

          System.out.println("Selecione o Número Que Representa a Operação Desejada:");
          System.out.println("1 - Criar Postagem");
          System.out.println("2 - Buscar Postagem");
          System.out.println("3 - Atualizar Postagem");
          System.out.println("4 - Deletar Postagem");
          System.out.println("5 - Exibir Todas as Postagens Publicadas");
          System.out.println("0 - Sair");
          System.out.println("-----------------------------------");
          operacao = scan.nextInt();

          if(operacao == 1){
            System.out.println("ID: " + id++);

            System.out.println("Digite o Nome do Autor da Postagem");
            nome = scan.next();
            
            // recebendo a data no tipo string
            System.out.println("Digite a Data de Publicação da Postagem(DD/MM/AAAA)");
            data = scan.next();

            // formatar data do tipo string para date
            DateFormat formato_data = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formato_data.parse(data);
            System.out.println(formato_data.format(data));

            System.out.println("Digite a Categoria da Postagem(ex:Tecnologia, Saúde...)");
            categoria = scan.next();
            System.out.println("Digite o Título da Postagem");
            titulo = scan.next();
            System.out.println("Digite o Conteúdo da Postagem");
            conteudo = scan.next();

            status = create_post(id, nome, data, categoria, titulo, conteudo);

            if(status == 0){
              System.out.println("Postagem Adicionada");
            } else{
              System.out.println("Postagem Não Adicionada");
            }

          } else if(operacao == 2){

            }

            else if(operacao == 3){

            }

            else if(operacao == 4){

            }

            else if(operacao == 5){

              for(indice = 0; indice < ids.size(); indice++){
                System.out.println(ids.get(indice));
                System.out.println(nomes.get(indice));
                System.out.println(datas.get(indice));
                System.out.println(categorias.get(indice));
                System.out.println(titulos.get(indice));
                System.out.println(conteudos.get(indice));
                System.out.println("-----------------------------------");
              }
            }

            else if(operacao == 0){
              break;
            } else {
              System.out.println("Operação Incorreta");
            }
          }

          scan.close();
          
        }
    
         
        
      }