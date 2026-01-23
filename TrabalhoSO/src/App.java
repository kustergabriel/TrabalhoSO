public class App {
    public static void main(String[] args) throws Exception {
        Restaurante r1 = new Restaurante();
        Novato n1 = new Novato(r1);
        Veterano v1 = new Veterano(r1);
        Novato n2 = new Novato(r1);
        Veterano v2 = new Veterano(r1);

        // DISPARAR AS THREADS EM PARALELO
        n1.start(); 
        v1.start(); 
        n2.start();
        v2.start();

    }
}
