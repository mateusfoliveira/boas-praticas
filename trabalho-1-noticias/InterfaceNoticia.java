import java.util.Scanner;

public class InterfaceNoticia {

    private final Sistema sistema;

    private final Scanner scanner = new Scanner(System.in);

    public InterfaceNoticia(Sistema sistema){
        this.sistema = sistema;

    }

    private boolean validarEntradaTexto(String texto){
        return !texto.isBlank();
    }

    private String capturarTexto(){

        String texto;

        while(true){

            System.out.print("Digite o texto: ");
            texto = scanner.nextLine();

            if(validarEntradaTexto(texto)){
                break;
            }

            else{
                System.out.println("Erro: Texto inválido! (vazio) Tente novamente.");
            }

        }

        return texto;
    }

    private Classificacao capturarClassificacao(){

        String classificacaoString;

        System.out.print("Digite a classificacao (confiavel,falsa,duvidosa): ");

        classificacaoString = scanner.nextLine();

        try {
            return Classificacao.valueOf(classificacaoString.trim().toLowerCase());

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: Classificação invalida! Classificando como duvidosa.");
            return Classificacao.duvidosa;
        }
    }

    private void adicionarNoticiaComClassificacao() {

        String texto = capturarTexto();

        Classificacao classificacao = capturarClassificacao();

        sistema.criarNoticia(texto,classificacao);
    }

    private void adicionarNoticiaSemClassificacao() {

        String texto = capturarTexto();

        Classificacao classificacao = sistema.classificarTexto(texto);

        sistema.criarNoticia(texto, classificacao);
    }

    private void listarNoticias() {

        for (Noticia noticia : sistema.getNoticias()) {
            System.out.println("Texto: " + noticia.getTexto());
            System.out.println("Classificacao: " + noticia.getClassificacao().toString());
            System.out.println("-------------------");
        }
    }

    private void printMenu(){
        System.out.println("1 - adicionar manual");
        System.out.println("2 - adicionar automatico");
        System.out.println("3 - listar");
        System.out.println("4 - sair");
    }

    public void menu() {
        while(true) {

            printMenu();

            switch (scanner.nextLine()) {
                case "1":
                    adicionarNoticiaComClassificacao();
                    break;
                case "2":
                    adicionarNoticiaSemClassificacao();
                    break;
                case "3":
                    listarNoticias();
                    break;
                case "4":
                    scanner.close();
                    return;
                default:
                    System.out.println("Entrada inválida! Tente novamente.");
                    break;
            }
        }
    }

}
