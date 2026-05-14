public class Noticia {

    private String texto;
    private String classificacao;

    public String getTexto() {
        return texto;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public Noticia(String texto) {
        this.texto = texto;
    }

    public Noticia(String texto, String classificacao) {
        this.texto = texto;
        this.classificacao = classificacao;
    }
}
