import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException;

/* Códigos
 * 0 = OK
 * 1 = Erro
 * 2 = Título já utilizado por uma postagem */

public class Blog_pessoal {

  public static ArrayList<Integer> ids = new ArrayList<Integer>();
  public static ArrayList<String> nomes = new ArrayList<String>();
  public static ArrayList<String> datas = new ArrayList<String>();
  public static ArrayList<String> categorias = new ArrayList<String>();
  public static ArrayList<String> titulos = new ArrayList<String>();
  public static ArrayList<String> conteudos = new ArrayList<String>();

  public static int create_post(Integer id, String nome, String data, String categoria, String titulo,
      String conteudo) {

    int titulo_existe = read_post(titulo);

    if (titulo_existe >= 0) {
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

  public static int read_post(Integer id, String data, String categoria, String titulo) {

    String titulo_busca;

    for (indice = 0; indice < titulos.size(); indice++) {
      titulo_busca = titulos.get(indice);

      if(titulo_busca.equals(titulo)){
        return indice;
      }
    }
     return 0;
  }

  public static int update_post(Integer id, String nome, String data, String categoria, String titulo,
      String conteudo) {

    int indice = read_post(id);

    if (indice < 0) {
      return -1;
    }

    nomes.set(indice, nome);
    datas.set(indice, data);
    categorias.set(indice, categoria);
    titulos.set(indice, titulo);
    conteudos.set(indice, conteudo);

    return 0;
  }

  public static int delete_post() {

  }

  public static void main(String[] args) {

    String nome, categoria, titulo, conteudo, data;
    int id = 0, operacao, operacao_update, status, indice;

    Scanner scan = new Scanner(System.in);

    while (true) {

      System.out.println("Selecione o Número Que Representa a Operação Desejada:");
      System.out.println("1 - Criar Postagem");
      System.out.println("2 - Buscar Postagem");
      System.out.println("3 - Atualizar Postagem");
      System.out.println("4 - Deletar Postagem");
      System.out.println("5 - Exibir Todas as Postagens Publicadas");
      System.out.println("0 - Sair");
      System.out.println("-----------------------------------");
      operacao = scan.nextInt();

      if (operacao == 1) {
        System.out.println("ID: " + id++);

        System.out.print("Digite o Nome do Autor da Postagem: ");
        nome = scan.next();

        System.out.print("Digite a Data de Publicação da Postagem(DD/MM/AAAA): ");
        data = scan.next();
        scan.nextLine();
        System.out.print("Digite a Categoria da Postagem(ex:Tecnologia, Saúde...): ");
        categoria = scan.nextLine();
        System.out.print("Digite o Título da Postagem: ");
        titulo = scan.next();
        System.out.print("Digite o Conteúdo da Postagem: ");
        conteudo = scan.nextLine();
        scan.nextLine();
        status = create_post(id, nome, data, categoria, titulo, conteudo);

        if (status == 0) {
          System.out.println("Postagem Adicionada!!");
        } else {
          System.out.println("Erro ao Adicionar Postagem!!");
        }

      } else if (operacao == 2) {

        System.out.println("Escolha o Método de Busca Desejado:");
        System.out.println("1 - Pesquisar Por ID da Postagem");
        System.out.println("2 - Buscar Por Categoria da Postagem");
        System.out.println("3 - Filtrar Postagens Por Período(Datas de Publicação)");
        operacao = scan.nextInt();

        /* switch (operacao){
          case 1{
            
        }
      } */
    }
      else if (operacao == 3) {

        System.out.println("Digite o ID da Postagem a Ser Atualizada:");
        id = scan.nextInt();
        System.out.println("--------------------------------");

        System.out.println("Escolha Qual o Tópico a Ser Atualizado");
        System.out.println("1 - Atualizar Nome do Autor");
        System.out.println("2 - Atualizar Data de Publicação da Postagem");
        System.out.println("3 - Atualizar Categoria da Postagem");
        System.out.println("4 - Atualizar Título da Postagem");
        System.out.println("5 - Atualizar Conteúdo da Postagem");
        operacao = scan.nextInt();

          switch (operacao) {
          case 1:
          System.out.print("Digite o Novo Nome do Autor: ");
          nome = scan.nextLine();
          break;
          case 2:
          System.out.print("Digite a Nova Data de Publicação da Postagem: ");
          data = scan.next();
          break;
          case 3:
          System.out.print("Digite a Nova Categoria da Postagem: ");
          categoria = scan.next();
          break;
          case 4:
          System.out.print("Digite o Novo Título da Postagem: ");
          categoria = scan.nextLine();
          break;
          case 5:
          System.out.print("Atualizar Conteúdo da Postagem: ");
          conteudo = scan.nextLine();
          break;
          default:
          System.out.println("Escolha Incorreta");
        }

            else if(operacao == 3){

        if (status == 0) {
          System.out.println("Postagem Atualizada!!");
        } else {
          System.out.println("Erro ao Atualizar Postagem!!");
        }
      }

      else if (operacao == 4) {

      }

      else if (operacao == 5) {

        for (indice = 0; indice < ids.size(); indice++) {
          System.out.println("ID: " + ids.get(indice));
          System.out.println("Nome do Autor: " + nomes.get(indice));
          System.out.println("Data de Publicação: " + datas.get(indice));
          System.out.println("Categoria: " + categorias.get(indice));
          System.out.println("Título: " + titulos.get(indice));
          System.out.println("Conteúdo: " + conteudos.get(indice));
          System.out.println("-----------------------------------");
        }
      }

      else if (operacao == 0) {
        break;
      } else {
        System.out.println("Operação Incorreta");
      }
    }

    scan.close();

      }
    }
