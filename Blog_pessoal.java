import java.util.ArrayList;
import java.util.Scanner;

public class Blog_pessoal {

  public static ArrayList<Integer> ids = new ArrayList<Integer>();
  public static ArrayList<String> nomes = new ArrayList<String>();
  public static ArrayList<String> datas = new ArrayList<String>();
  public static ArrayList<String> categorias = new ArrayList<String>();
  public static ArrayList<String> titulos = new ArrayList<String>();
  public static ArrayList<String> conteudos = new ArrayList<String>();

  public static int create_post(int id, String nome, String data, String categoria, String titulo, String conteudo) {

    int titulo_existe = titulos.indexOf(titulo);

    if (titulo_existe < 0) {
      ids.add(id);
      nomes.add(nome);
      datas.add(data);
      categorias.add(categoria);
      titulos.add(titulo.toLowerCase());
      conteudos.add(conteudo);
    } else {
      return -2;
    }

    return 0;
  }

  public static int read_post(int id, String categoria, String titulo) {

    String titulo_busca;
    int indice, id_busca;

    for (indice = 0; indice < titulos.size(); indice++) {
      titulo_busca = titulos.get(indice);

      if (titulo_busca.equals(titulo)) {
        return indice;
      } else {
        continue;
      }
    }

    for (indice = 0; indice < ids.size(); indice++) {
      id_busca = ids.get(indice);

      if (id_busca == id) {
        return indice;
      } else {
        continue;
      }
    }

    return 0;
  }

  public static int update_post(int id, String nome, String data, String categoria, String titulo,
      String conteudo) {

    int id_busca = ids.indexOf(id);

    if (id >= 1) {
      nomes.set(id_busca, nome);
      datas.set(id_busca, data);
      categorias.set(id_busca, categoria);
      titulos.set(id_busca, titulo);
      conteudos.set(id_busca, conteudo);
    } else {
      return -1;
    }

    return 0;
  }

  public static int delete_post(int id) {

    int id_busca = ids.indexOf(id);

    if (id >= 1) {
      ids.remove(id_busca);
      nomes.remove(id_busca);
      datas.remove(id_busca);
      categorias.remove(id_busca);
      titulos.remove(id_busca);
      conteudos.remove(id_busca);
    } else {
      return -1;
    }

    return 0;
  }

  public static void main(String[] args) {

    String nome, categoria, titulo, conteudo, data, option3;
    int id = 1, operacao, status, indice, option, option2;
    boolean running = true;

    Scanner scan = new Scanner(System.in);

    while (running) {

      System.out.println("Selecione o Número Que Representa a Operação Desejada:");
      System.out.println("1 - Criar Postagem");
      System.out.println("2 - Buscar Postagem");
      System.out.println("3 - Atualizar Postagem");
      System.out.println("4 - Deletar Postagem");
      System.out.println("5 - Exibir Todas as Postagens Publicadas");
      System.out.println("0 - Sair");
      System.out.println("-----------------------------------");
      operacao = scan.nextInt();

      switch (operacao) {
        case 0:
          running = false;
          break;
        case 1:
          System.out.println("Criando Postagem:");
          System.out.println("-----------------------------");
          System.out.println("ID: " + id);
          scan.nextLine();
          System.out.print("Digite o Nome do Autor da Postagem: ");
          nome = scan.nextLine();
          System.out.print("Digite a Data de Publicação da Postagem (DD/MM/AAAA): ");
          data = scan.next();
          scan.nextLine();
          System.out.print("Digite a Categoria da Postagem (ex: Tecnologia, Saúde...): ");
          categoria = scan.nextLine();
          System.out.print("Digite o Título da Postagem: ");
          titulo = scan.nextLine();

          System.out.print("Digite o Conteúdo da Postagem: ");
          conteudo = scan.nextLine();
          System.out.println("-----------------------------");
          status = create_post(id, nome, data, categoria, titulo, conteudo);

          if (status == 0) {
            id++;
            System.out.println("Postagem Adicionada!!");
            System.out.println("-----------------------------");
            
          } else {
            System.out.println("Erro ao Adicionar Postagem!! Título Já Existente");
            System.out.println("-----------------------------");
          }

          break;
        case 2:
          System.out.println("Escolha por qual opção você quer buscar");
          System.out.println("1 - ID");
          System.out.println("2 - Titulo");
          System.out.println("3 - Categoria");
          System.out.println("-----------------------------------");

          option = scan.nextInt();

          switch (option) {
            case 1:
              System.out.print("Digite o ID da Postagem: ");
              option2 = scan.nextInt();

              for (int i = 0; i < ids.size(); i++) {
                if (ids.get(i) == ids.get(option2)) {
                  System.out.println("ID: " + ids.get(i));
                  System.out.println("Nome do Autor: " + nomes.get(option2));
                  System.out.println("Data de Publicação: " + datas.get(option2));
                  System.out.println("Categoria: " + categorias.get(option2));
                  System.out.println("Título: " + titulos.get(option2));
                  System.out.println("Conteúdo: " + conteudos.get(option2));
                  System.out.println("-----------------------------------");

                }
              }
              break;
            case 2:
              System.out.print("Digite o Título da Postagem: ");
              scan.nextLine();
              option3 = scan.nextLine();

              for (int i = 0; i < ids.size(); i++) {
                if (titulos.get(i).toLowerCase().equals(option3.toLowerCase())) {
                  System.out.println("ID: " + ids.get(i));
                  System.out.println("Nome do Autor: " + nomes.get(i));
                  System.out.println("Data de Publicação: " + datas.get(i));
                  System.out.println("Categoria: " + categorias.get(i));
                  System.out.println("Título: " + titulos.get(i));
                  System.out.println("Conteúdo: " + conteudos.get(i));
                  System.out.println("-----------------------------------");
                }
              }
              break;
            case 3:
              System.out.print("Digite a Categoria da Postagem: ");
              scan.nextLine();
              option3 = scan.nextLine();

              for (int i = 0; i < ids.size(); i++) {
                if (categorias.get(i).toLowerCase().equals(option3.toLowerCase())) {
                  System.out.println("ID: " + ids.get(i));
                  System.out.println("Nome do Autor: " + nomes.get(i));
                  System.out.println("Data de Publicação: " + datas.get(i));
                  System.out.println("Categoria: " + categorias.get(i));
                  System.out.println("Título: " + titulos.get(i));
                  System.out.println("Conteúdo: " + conteudos.get(i));
                  System.out.println("-----------------------------------");
                }
              }
              break;
            default:
              System.out.println("Opção Invalida");
          }

          break;
        case 3:
          System.out.println("Atualizando Postagem:");
          System.out.println("-----------------------------");
          System.out.println("Digite o ID da Postagem a Ser Atualizada:");
          id = scan.nextInt();
          System.out.println("--------------------------------");
          scan.nextLine();
          System.out.print("Digite o Novo Nome do Autor da Postagem: ");
          nome = scan.nextLine();
          System.out.print("Digite a Nova Data de Publicação da Postagem (DD/MM/AAAA): ");
          data = scan.next();
          scan.nextLine();
          System.out.print("Digite a Nova Categoria da Postagem (ex: Tecnologia, Saúde...): ");
          categoria = scan.nextLine();
          System.out.print("Digite o Novo Título da Postagem: ");
          titulo = scan.nextLine();

          System.out.print("Digite o Novo Conteúdo da Postagem: ");
          conteudo = scan.nextLine();

          status = update_post(id, nome, data, categoria, titulo, conteudo);

          if (status == 0) {
            System.out.println("Postagem Atualizada!!");
            System.out.println("-----------------------------");
          } else {
            System.out.println("Erro ao Atualizar Postagem!!, Não Encontrada");
            System.out.println("-----------------------------");
          }
          break;
        case 4:
          System.out.println("Deletando Postagem:");
          System.out.println("-----------------------------");
          System.out.println("Digite o ID da Postagem a Ser Deletada:");
          id = scan.nextInt();

          status = delete_post(id);

          if (status == 0) {
            System.out.println("Postagem Encontrada e Deletada!!");
            System.out.println("-----------------------------");
          } else {
            System.out.println("Postagem Não Encontrada!!");
            System.out.println("-----------------------------");
          }
          break;
        case 5:
          System.out.println("Exibindo Todas as Postagens:");
          System.out.println("-----------------------------");
          for (indice = 0; indice < ids.size(); indice++) {
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
          break;
      }

    }

    scan.close();
  }
}
