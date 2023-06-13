import java.util.ArrayList;
import java.util.Scanner;

public class Blog_pessoal {

    public static ArrayList<Integer> ids = new ArrayList<Integer>();
    public static ArrayList<String> nomes = new ArrayList<String>();
    public static ArrayList<String> datas = new ArrayList<String>();
    public static ArrayList<String> categorias = new ArrayList<String>();
    public static ArrayList<String> titulos = new ArrayList<String>();
    public static ArrayList<String> conteudos = new ArrayList<String>();

    public static int create_post(int id, String nome, String data, String categoria, String titulo,
                                  String conteudo) {

        int titulo_existe = titulos.indexOf(titulo);

        if (titulo_existe < 0) {
            ids.add(id);
            nomes.add(nome);
            datas.add(data);
            categorias.add(categoria);
            titulos.add(titulo);
            conteudos.add(conteudo);
        } else {
            return -2;
        }

        return 0;
    }

    public static int read_post(int id, String categoria, String titulo) {

        String titulo_busca;
        int indice;

        for (indice = 0; indice < titulos.size(); indice++) {
            titulo_busca = titulos.get(indice);

            if (titulo_busca.equals(titulo)) {
                return indice;
            } else if (indice == titulos.size()) {
                return -1;
            } else {
                continue;
            }
        }

        return 0;
    }

    public static int update_post(int id, String nome, String data, String categoria, String titulo,
    String conteudo) {

        int indice = ids.indexOf(id);

        if (indice >= 0) {
            nomes.set(indice, nome);
            datas.set(indice, data);
            categorias.set(indice, categoria);
            titulos.set(indice, titulo);
            conteudos.set(indice, conteudo);
        } else {
            return -1;
        }

        return 0;
    }

    public static int delete_post(int id) {

        int indice = ids.indexOf(id);

        if (indice >= 0) {
            ids.remove(indice);
            nomes.remove(indice);
            datas.remove(indice);
            categorias.remove(indice);
            titulos.remove(indice);
            conteudos.remove(indice);
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {

        String nome, categoria, titulo, conteudo, data;
        int id = 0, operacao, status, indice;

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
                System.out.println("Criando Postagem:");
                System.out.println("-----------------------------");
                System.out.println("ID: " + id++);
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
                    System.out.println("Postagem Adicionada!!");
                    System.out.println("-----------------------------");
                } else {
                    System.out.println("Erro ao Adicionar Postagem!! Título Já Existente");
                    System.out.println("-----------------------------");
                }

            } else if (operacao == 2) {
                System.out.println("Buscando Postagem:");
                System.out.println("-----------------------------");
                System.out.println("Escolha o Método de Busca Desejado:");
                System.out.println("1 - Pesquisar Por ID da Postagem");
                System.out.println("2 - Buscar Por Categoria da Postagem");
                operacao = scan.nextInt();

            } else if (operacao == 3) {
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
            } else if (operacao == 4) {
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
            } else if (operacao == 5) {
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
            } else if (operacao == 0) {
                break;
            } else {
                System.out.println("Operação Incorreta");
                System.out.println("-----------------------------");
            }
        }

        scan.close();
    }
}
