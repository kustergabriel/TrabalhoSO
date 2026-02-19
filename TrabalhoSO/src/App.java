public class App {
    public static void main(String[] args) throws Exception {
        int numRestaurantes = 5;
        int qntdEntregadores = 10; 

        Restaurante[] restaurantes = new Restaurante[numRestaurantes];

        for (int l = 0; l < numRestaurantes; l++) {
            restaurantes[l] = new Restaurante(l); 
        }

        for (int l = 1; l <= qntdEntregadores; l++) {
            new Novato(restaurantes).start();
            new Veterano(restaurantes).start();
        }
    }
}
