import java.util.ArrayList;
import java.util.Scanner;

class D {
    String t;
    String c;
}

public class Sistema {

    static ArrayList<D> data = new ArrayList<>();

    // função que faz tudo
    public static void criarNoticia(String texto, String classificacao) {
        // adiciona coisa
        if (texto != null && !texto.equals("")) {
            D d = new D();
            d.t = texto;

            if (classificacao == null || classificacao.equals("")) {
                d.c = "duvidosa";
            } else {
                d.c = classificacao;
            }

            data.add(d);
        } else {
            System.out.println("erro");
        }
    }

    public static void listarNoticias() {
        // lista tudo
        for (int i = 0; i < data.size(); i++) {
            System.out.println("Texto: " + data.get(i).t);
            System.out.println("Classificacao: " + data.get(i).c);
            System.out.println("-------------------");
        }
    }

    public static String classificarTexto(String texto) {
        int score = 0;

        if (!texto.contains("FONTE")) {
            score = score + 1;
        }
        if (texto.contains("!!!")) {
            score = score + 1;
        }
        if (texto.contains("URGENTE")) {
            score = score + 1;
        }
        if (texto.length() < 10) {
            score = score + 1;
        }

        if (score == 0) {
            return "confiavel";
        } else if (score == 1) {
            return "duvidosa";
        } else {
            return "falsa";
        }
    }

    public static void adicionarNoticiaComClassificacao(Scanner scanner) {
        System.out.print("Digite o texto: ");
        String t = scanner.nextLine();

        System.out.print("Digite classificacao: ");
        String c = scanner.nextLine();

        if (c.equals("")) {
            criarNoticia(t, null);
        } else {
            criarNoticia(t, c);
        }
    }

    public static void adicionarNoticiaSemClassificacao(Scanner scanner) {
        System.out.print("Digite o texto: ");
        String t = scanner.nextLine();

        String c = classificarTexto(t);
        criarNoticia(t, c);
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1 - adicionar manual");
            System.out.println("2 - adicionar automatico");
            System.out.println("3 - listar");
            System.out.println("4 - sair");

            String op = sc.nextLine();

            if (op.equals("1")) {
                adicionarNoticiaComClassificacao(sc);
            } else if (op.equals("2")) {
                adicionarNoticiaSemClassificacao(sc);
            } else if (op.equals("3")) {
                listarNoticias();
            } else if (op.equals("4")) {
                break;
            } else {
                System.out.println("errado");
            }
        }

        sc.close();
    }

    // inicia programa
    public static void main(String[] args) {
        menu();
    }
}
