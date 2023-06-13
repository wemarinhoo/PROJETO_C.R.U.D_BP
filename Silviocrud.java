import java.util.ArrayList;
import java.util.Scanner;

public class Silviocrud {

  public static ArrayList<Integer> ids = new ArrayList<Integer>();
  public static ArrayList<String> nomes = new ArrayList<String>();
  public static ArrayList<String> datas = new ArrayList<String>();
  public static ArrayList<String> categorias = new ArrayList<String>();
  public static ArrayList<String> titulos = new ArrayList<String>();
  public static ArrayList<String> conteudos = new ArrayList<String>();



  public static void main(String[] args){

    Scanner scan = new Scanner(System.in);

    String nome, data, conteudo, categoria, titulo, option3;
    boolean running = true;
    int id = 0, option, option2;

    while (running) {
      System.out.println("Selecione o Número Que Representa a Operação Desejada:");
      System.out.println("1 - Criar Postagem");
      System.out.println("2 - Buscar Postagem");
      System.out.println("3 - Atualizar Postagem");
      System.out.println("4 - Deletar Postagem");
      System.out.println("5 - Exibir Todas as Postagens Publicadas");
      System.out.println("0 - Sair");
      System.out.println("-----------------------------------");
      option = scan.nextInt();

      switch (option) {
        case 0:
          running = false;
          break;
        case 1:
          System.out.println("ID da postagem: " + id++);
          ids.add(id);

          System.out.print("Digite o nome do Autor: ");
          scan.nextLine();
          nome = scan.nextLine();
          nomes.add(nome);

          System.out.print("Digite a data da publicação DD/MM/AAAA: ");
          data = scan.next();
          datas.add(data);

          System.out.print("Digite a categoria do conteudo: ");
          scan.nextLine();
          categoria = scan.nextLine();
          categorias.add(categoria);

          System.out.print("Digite o titulo do conteudo: ");
          titulo = scan.nextLine();
          titulos.add(titulo);

          System.out.println("Digite o conteudo da postagem: ");
          conteudo = scan.nextLine();
          conteudos.add(conteudo);

          System.out.println("Post Adicionado com sucesso");

          break;
        case 2:
          System.out.println("Escolha por qual opção você quer buscar");
          System.out.println("1 - ID");
          System.out.println("2 - Titulo");
          System.out.println("3 - Categoria");
          option = scan.nextInt();

          switch (option) {
            case 1:
              System.out.print("Qual o id da postagem? ");
              option2 = scan.nextInt();

              for (int i = 0; i < ids.size(); i++ ) {
                if (ids.get(i) == ids.get(option2)) {
                  System.out.println("ID: " + ids.get(option2));
                  System.out.println("Nome do Autor: " + nomes.get(option2));
                  System.out.println("Data de Publicação: " + datas.get(option2));
                  System.out.println("Categoria: " + categorias.get(option2));
                  System.out.println("Título: " + titulos.get(option2));
                  System.out.println("Conteúdo: " + conteudos.get(option2));
                }
              }
              break;
            case 2:
              System.out.print("Qual o titulo da postagem? ");
              scan.nextLine();
              option3 = scan.nextLine();

              for (int i = 0; i < ids.size(); i++ ) {
                if (titulos.get(i).toLowerCase().equals(option3.toLowerCase())) {
                  System.out.println("ID: " + ids.get(i));
                  System.out.println("Nome do Autor: " + nomes.get(i));
                  System.out.println("Data de Publicação: " + datas.get(i));
                  System.out.println("Categoria: " + categorias.get(i));
                  System.out.println("Título: " + titulos.get(i));
                  System.out.println("Conteúdo: " + conteudos.get(i));
                }
              }
              break;
            case 3:
              System.out.print("Qual a categoria da postagem? ");
              scan.nextLine();
              option3 = scan.nextLine();

              for (int i = 0; i < ids.size(); i++ ) {
                if (categorias.get(i).toLowerCase().equals(option3.toLowerCase())) {
                  System.out.println("ID: " + ids.get(i));
                  System.out.println("Nome do Autor: " + nomes.get(i));
                  System.out.println("Data de Publicação: " + datas.get(i));
                  System.out.println("Categoria: " + categorias.get(i));
                  System.out.println("Título: " + titulos.get(i));
                  System.out.println("Conteúdo: " + conteudos.get(i));
                }
              }
              break;
            default:
              System.out.println("Opção Invalida");
          }

          break;
        case 3:

          break;
        case 4:
          break;
        case 5:
          for (int indice = 0; indice < ids.size(); indice++) {
            System.out.println("ID: " + ids.get(indice));
            System.out.println("Nome do Autor: " + nomes.get(indice));
            System.out.println("Data de Publicação: " + datas.get(indice));
            System.out.println("Categoria: " + categorias.get(indice));
            System.out.println("Título: " + titulos.get(indice));
            System.out.println("Conteúdo: " + conteudos.get(indice));
            System.out.println("-----------------------------------");
          }
          break;
        default:
          System.out.println("Opção inválida.");
      }
    }
  }
}