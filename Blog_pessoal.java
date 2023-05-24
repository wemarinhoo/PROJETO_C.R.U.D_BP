import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

 public class Blog_pessoal {

  public static ArrayList<Integer> ids = new ArrayList<>();
  public static ArrayList<String> nomes = new ArrayList<>();
  public static ArrayList<String> categorias = new ArrayList<>();
  public static ArrayList<String> titulos = new ArrayList<>();
  public static ArrayList<String> conteudos = new ArrayList<>();
  public static ArrayList<Date> datas = new ArrayList<>();

  public static int create_post (Integer id, String nome, String categoria, String titulo, String conteudo, Date data){

      int postagem_existe = read_post(id);

      if(postagem_existe >= 1){
              return 2;
      }

      ids.add(id);
      nomes.add(nome);
      categorias.add(categoria);
      titulos.add(titulo);
      conteudos.add(conteudo);
      datas.add(data);

      return 0;

  }

  public static int read_post (Integer id, String tema, Date data){
      

  }

  public static int update_post (){

  }

  public static int delete_post (){

  }
  public static void main(String[] args) {

      int id = 1, operacao;

      Scanner scan = new Scanner(System.in);

      while(true){
          System.out.println("Selecione o Número Que Representa a Operação Desejada:");
          System.out.println("1 - Criar Postagem");
          System.out.println("2 - Buscar Postagem");
          System.out.println("3 - Atualizar Postagem");
          System.out.println("4 - Deletar Postagem");
          System.out.println("5 - Listar Todas as Postagens");
          System.out.println("0 - Sair");
          System.out.println("-----------------------------------");
          operacao = scan.nextInt();

          if(operacao == 1){

          }
      }

      scan.close();
  }
}