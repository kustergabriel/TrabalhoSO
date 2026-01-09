import java.util.concurrent.Semaphore;

public class Restaurante {
    public Semaphore moto = new Semaphore(1); 
    public Semaphore pedido = new Semaphore(1);
    private final int idRestaurante; // ID unico para cada restaurante instanciado
    private static int proximoId = 1; // Campo estático para rastrear o próximo ID

    Restaurante () {
        this.idRestaurante = proximoId++;
    }

    public int getIdRestaurante() {
        return this.idRestaurante;
    }

}
