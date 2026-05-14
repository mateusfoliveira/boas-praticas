import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    ArrayList<Noticia> noticias = new ArrayList<>();

    // função que faz tudo
    public void criarNoticia(String texto, String classificacao) {
        // adiciona coisa
        if (texto != null && !texto.equals("")) {

            Noticia noticia = new Noticia(texto);

            if (classificacao == null || classificacao.equals("")) {
                noticia.setClassificacao("duvidosa");
            } else {
                noticia.setClassificacao(classificacao);
            }

            noticias.add(noticia);
        } else {
            System.out.println("erro");
        }
    }

    public void listarNoticias() {
        // lista tudo
        for (Noticia noticia : noticias) {
            System.out.println("Texto: " + noticia.getTexto());
            System.out.println("Classificacao: " + noticia.getClassificacao());
            System.out.println("-------------------");
        }
    }

    public int calcularSuspeita(String texto){

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

        return nivelDeSuspeita;
    }

    public String classificarTexto(String texto) {

        int nivelDeSuspeita = calcularSuspeita(texto);

        if (nivelDeSuspeita == 0) {
            return "confiavel";
        } else if (nivelDeSuspeita == 1) {
            return "duvidosa";
        } else {
            return "falsa";
        }
    }

    public void adicionarNoticiaComClassificacao(Scanner scanner) {

        System.out.print("Digite o texto: ");
        String texto = scanner.nextLine();

        System.out.print("Digite classificacao: ");
        String classificacao = scanner.nextLine();

        criarNoticia(texto,classificacao);
    }

    public void adicionarNoticiaSemClassificacao(Scanner scanner) {

        System.out.print("Digite o texto: ");

        String texto = scanner.nextLine();

        String classificacao = classificarTexto(texto);

        criarNoticia(texto, classificacao);
    }

    public void menu(Scanner scanner) {

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
}
