import java.util.ArrayList;

public class Sistema {

    private final ArrayList<Noticia> noticias = new ArrayList<>();

    private static final String[] TERMOS_SENSACIONALISTAS = {"URGENTE", "!!!"};

    public ArrayList<Noticia> getNoticias() {
        return noticias;
    }

    public void criarNoticia(String texto, Classificacao classificacao) {

        if (texto != null) {
            if (classificacao == null) {
                classificacao = Classificacao.duvidosa;
            }

            Noticia noticia = new Noticia(texto,classificacao);

            noticias.add(noticia);

        } else {
            System.out.println("erro");
        }
    }

    private int calcularSuspeita(String texto){

        int nivelDeSuspeita = 0;

        if (!texto.contains("FONTE")) {
            nivelDeSuspeita++;
        }

        for (String termoSensacionalista:TERMOS_SENSACIONALISTAS){
            if (texto.contains(termoSensacionalista)) {
                nivelDeSuspeita++;
            }
        }

        if (texto.length() < 10) {
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
