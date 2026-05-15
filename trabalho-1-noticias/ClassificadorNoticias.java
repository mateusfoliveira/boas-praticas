import model.Classificacao;
import model.Noticia;

import java.util.ArrayList;

public class ClassificadorNoticias {

    private final ArrayList<Noticia> noticias = new ArrayList<>();

    private static final String[] TERMOS_SENSACIONALISTAS = {"URGENTE", "!!!"};

    public ArrayList<Noticia> getNoticias() {
        return noticias;
    }

    public void criarNoticia(String texto, Classificacao classificacao) {

        if (texto == null || classificacao == null){
            throw new IllegalArgumentException();
        }

        Noticia noticia = new Noticia(texto,classificacao);

        noticias.add(noticia);

    }

    private int calcularSuspeita(String texto){

        int nivelDeSuspeita = 0;

        String textoCapslock = texto.toUpperCase();

        if (!textoCapslock.contains("FONTE")) {
            nivelDeSuspeita++;
        }

        for (String termoSensacionalista:TERMOS_SENSACIONALISTAS){
            if (textoCapslock.contains(termoSensacionalista)) {
                nivelDeSuspeita++;
            }
        }

        if (textoCapslock.length() < 10) {
            nivelDeSuspeita++;
        }

        return nivelDeSuspeita;
    }

    public Classificacao classificarTexto(String texto) {

        int nivelDeSuspeita = calcularSuspeita(texto);

        if (nivelDeSuspeita == 0) {
            return Classificacao.confiavel;
        } else if (nivelDeSuspeita == 1) {
            return Classificacao.duvidosa;
        } else {
            return Classificacao.falsa;
        }
    }
}
