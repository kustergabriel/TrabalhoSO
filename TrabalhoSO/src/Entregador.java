public abstract class Entregador extends Thread {
    private final int idEntregador; // ID unico para cada restaurante instanciado
    private static int proximoId = 1; // Campo estático para rastrear o próximo ID
    private Restaurante restaurante;

    Entregador (Restaurante restaurante) {
        this.idEntregador = proximoId++;
        this.restaurante = restaurante;
    }

    public abstract void run();

    public int getIdEntregador() {
        return this.idEntregador;
    }

    // Nao sei se isso eh valido
    public int getIDRestaurante() {
        return restaurante.getIdRestaurante();
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

}
