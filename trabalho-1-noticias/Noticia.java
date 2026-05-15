public class Noticia {

    private final String texto;

    private Classificacao classificacao;

    public String getTexto() {
        return texto;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public Noticia(String texto) {
        this.texto = texto;
    }

    public Noticia(String texto, Classificacao classificacao) {
        this.texto = texto;
        this.classificacao = classificacao;
    }
}
