import java.util.ArrayList;
import java.util.Scanner;

class Noticia {
    String texto;
    String classificacao;
}

public class Sistema {

    static ArrayList<Noticia> noticias = new ArrayList<>();

    // função que faz tudo
    public static void criarNoticia(String texto, String classificacao) {
        // adiciona coisa
        if (texto != null && !texto.equals("")) {

            Noticia noticia = new Noticia();

            noticia.texto = texto;

            if (classificacao == null || classificacao.equals("")) {
                noticia.classificacao = "duvidosa";
            } else {
                noticia.classificacao = classificacao;
            }

            noticias.add(noticia);
        } else {
            System.out.println("erro");
        }
    }

    public static void listarNoticias() {
        // lista tudo
        for (int i = 0; i < noticias.size(); i++) {
            System.out.println("Texto: " + noticias.get(i).texto);
            System.out.println("Classificacao: " + noticias.get(i).classificacao);
            System.out.println("-------------------");
        }
    }

    public static String classificarTexto(String texto) {

        int nivelDeSuspeita = 0;

        if (!texto.contains("FONTE")) {
            nivelDeSuspeita = nivelDeSuspeita + 1;
        }

        if (texto.contains("!!!")) {
            nivelDeSuspeita = nivelDeSuspeita + 1;
        }

        if (texto.contains("URGENTE")) {
            nivelDeSuspeita = nivelDeSuspeita + 1;
        }

        if (texto.length() < 10) {
            nivelDeSuspeita = nivelDeSuspeita + 1;
        }

        if (nivelDeSuspeita == 0) {
            return "confiavel";
        } else if (nivelDeSuspeita == 1) {
            return "duvidosa";
        } else {
            return "falsa";
        }
    }

    public static void adicionarNoticiaComClassificacao(Scanner scanner) {

        System.out.print("Digite o texto: ");
        String texto = scanner.nextLine();

        System.out.print("Digite classificacao: ");
        String classificacao = scanner.nextLine();

        if (classificacao.equals("")) {
            criarNoticia(texto, null);
        } else {
            criarNoticia(texto, classificacao);
        }
    }

    public static void adicionarNoticiaSemClassificacao(Scanner scanner) {

        System.out.print("Digite o texto: ");

        String texto = scanner.nextLine();

        String classificacao = classificarTexto(texto);

        criarNoticia(texto, classificacao);
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - adicionar manual");
            System.out.println("2 - adicionar automatico");
            System.out.println("3 - listar");
            System.out.println("4 - sair");

            String opcao = scanner.nextLine();

            if (opcao.equals("1")) {
                adicionarNoticiaComClassificacao(scanner);
            } else if (opcao.equals("2")) {
                adicionarNoticiaSemClassificacao(scanner);
            } else if (opcao.equals("3")) {
                listarNoticias();
            } else if (opcao.equals("4")) {
                break;
            } else {
                System.out.println("errado");
            }
        }

        scanner.close();
    }

    // inicia programa
    public static void main(String[] args) {
        menu();
    }
}
