public class Main {
    public static void main(String[] args) {

        ClassificadorNoticias classificadorNoticias = new ClassificadorNoticias();

        InterfaceNoticia interfaceNoticia = new InterfaceNoticia(classificadorNoticias);

        interfaceNoticia.menu();
    }
}
