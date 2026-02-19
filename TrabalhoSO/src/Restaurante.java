import java.util.concurrent.Semaphore;

public class Restaurante {
    public Semaphore moto; 
    public Semaphore pedido;
    private int idRestaurante; 

    Restaurante (int id) {
        this.idRestaurante = id;
        this.pedido = new Semaphore(1); 
        this.moto = new Semaphore(1);
    }

    public int getIdRestaurante() {
        return this.idRestaurante;
    }

}
