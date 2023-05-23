import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

/** Códigos 
 * 0 = OK
 * 1 = Erro
 * 2 = Id já utilizado por uma postagem
 * */

public class Blog_pessoal {

    public static ArrayList<Integer> ids = new ArrayList<>();
    public static ArrayList<String> nomes = new ArrayList<>();
    public static ArrayList<String> titulos = new ArrayList<>();
    public static ArrayList<String> conteudos = new ArrayList<>();
    public static ArrayList<Date> datas = new ArrayList<>();

    public static int create_post (Integer id, String nome, String titulo, String conteudo, Date data){

        int postagem_existe = read_post(id);

        if(postagem_existe >= 2){
                return 2;
        }

        ids.add(id);
        nomes.add(nome);
        titulos.add(titulo);
        conteudos.add(conteudo);
        datas.add(data);

        return 0;

    }

    public static int read_post (Integer id){
        

    }

    public static int update_post (){

    }

    public static int delete_post (){

    }
    public static void main(String[] args) {

        int id = 1;

        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.println("Selecione o Número Que Representa a Operação Desejada:");
            /* criar os inputs do scanner aqui */
        }
        scan.close();
    }
}