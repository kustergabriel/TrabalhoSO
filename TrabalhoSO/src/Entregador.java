public abstract class Entregador extends Thread {
    private final int idEntregador; // ID unico para cada restaurante instanciado
    private static int proximoId = 1;
    private Restaurante[] restaurantes;
    private int indiceSorteado; 

    Entregador (Restaurante[] restaurante) {
        this.idEntregador = proximoId++; 
        this.restaurantes = restaurante;
        
        java.util.Random random = new java.util.Random(); // "emprega" um entregador para um restaurante
        this.indiceSorteado = random.nextInt(restaurantes.length);
    }

    public abstract void run();

    public int getIdEntregador() {
        return this.idEntregador;
    }

    public int getIdRestauranteAtendido() {
        return restaurantes[indiceSorteado].getIdRestaurante();    
    }

    public Restaurante meuRestaurante() {
        return restaurantes[indiceSorteado];
    }
    
}
