package model;

public class Noticia {

    private final String texto;

    private final Classificacao classificacao;

    public String getTexto() {
        return texto;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public Noticia(String texto, Classificacao classificacao) {
        this.texto = texto;
        this.classificacao = classificacao;
    }
}
