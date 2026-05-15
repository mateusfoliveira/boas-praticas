import java.util.ArrayList;

public class Sistema {

    private final ArrayList<Noticia> noticias = new ArrayList<>();

    private static final String[] TERMOS_SENSACIONALISTAS = {"URGENTE", "!!!"};

    public ArrayList<Noticia> getNoticias() {
        return noticias;
    }

    //TODO: refatorar essa funcao
    public void criarNoticia(String texto, String classificacao) {

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
