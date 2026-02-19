public abstract class Entregador extends Thread {
    private final int idEntregador; // ID unico para cada restaurante instanciado
    private static int proximoId = 1;
    private Restaurante[] restaurantes;
    private int indiceSorteado; // Para guardar qual restaurante ele escolheu

    Entregador (Restaurante[] restaurante) {
        this.idEntregador = proximoId++; // ID UNICO 
        this.restaurantes = restaurante;
        
        java.util.Random random = new java.util.Random(); // Colocar um restaurante randomico em cada entregador
        this.indiceSorteado = random.nextInt(restaurantes.length);
    }

    public abstract void run();

    public int getIdEntregador() {
        return this.idEntregador;
    }

    public int getIDRestaurante() {
        return restaurantes[indiceSorteado].getIdRestaurante();    
    }

    public Restaurante getRestaurante() {
        return restaurantes[indiceSorteado];
    }
}
