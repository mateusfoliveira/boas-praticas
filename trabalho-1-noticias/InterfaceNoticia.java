import java.util.Scanner;

public class InterfaceNoticia {

    private final Sistema sistema;

    private final Scanner scanner = new Scanner(System.in);

    public InterfaceNoticia(Sistema sistema){
        this.sistema = sistema;

    }


    public void adicionarNoticiaComClassificacao() {

        System.out.print("Digite o texto: ");
        String texto = scanner.nextLine();

        System.out.print("Digite classificacao: ");
        String classificacao = scanner.nextLine();

        sistema.criarNoticia(texto,classificacao);
    }

    public void adicionarNoticiaSemClassificacao() {

        System.out.print("Digite o texto: ");
        String texto = scanner.nextLine();

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
