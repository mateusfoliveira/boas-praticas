import java.util.Scanner;

public class InterfaceNoticia {

    private final Sistema sistema;

    private final Scanner scanner = new Scanner(System.in);

    public InterfaceNoticia(Sistema sistema){
        this.sistema = sistema;

    }

    public String capturarTexto(){

        System.out.print("Digite o texto: ");

        return scanner.nextLine();
    }

    public String capturarClassificacao(){

        System.out.print("Digite classificacao: ");
        return scanner.nextLine();
    }

    public void adicionarNoticiaComClassificacao() {

        String texto = capturarTexto();
        String classificacao = capturarClassificacao();

        sistema.criarNoticia(texto,classificacao);
    }

    public void adicionarNoticiaSemClassificacao() {

        String texto = capturarTexto();

        String classificacao = sistema.classificarTexto(texto);

        sistema.criarNoticia(texto, classificacao);
    }

    public void listarNoticias() {

        for (Noticia noticia : sistema.getNoticias()) {
            System.out.println("Texto: " + noticia.getTexto());
            System.out.println("Classificacao: " + noticia.getClassificacao());
            System.out.println("-------------------");
        }
    }

    public void printMenu(){
        System.out.println("1 - adicionar manual");
        System.out.println("2 - adicionar automatico");
        System.out.println("3 - listar");
        System.out.println("4 - sair");
    }


    public void menu() {
        while(true) {

            printMenu();

            String opcao = scanner.nextLine();

            switch (opcao) {
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
                    System.out.println("errado");
                    break;
            }
        }
    }

}
