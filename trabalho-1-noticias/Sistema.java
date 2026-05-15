import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    private final ArrayList<Noticia> noticias = new ArrayList<>();

    public ArrayList<Noticia> getNoticias() {
        return noticias;
    }

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
}
