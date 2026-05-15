public class Main {
    public static void main(String[] args) {

        Sistema sistema = new Sistema();

        InterfaceNoticia interfaceNoticia = new InterfaceNoticia(sistema);

        interfaceNoticia.menu();
    }
}
