public class App {
    public static void main(String[] args) throws Exception {
        int qntdEntregadores = 3; // Altere para o caos acontecer!
        Restaurante r1 = new Restaurante();

        // Criando os Novatos
        for (int i = 1; i <= qntdEntregadores; i++) {
            Novato n = new Novato(r1);
            n.start();
        }
        
        for (int i = 1; i <= qntdEntregadores; i++) {
            Veterano v = new Veterano(r1);
            v.start();
        }



    }
}
