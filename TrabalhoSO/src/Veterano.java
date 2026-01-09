public class Veterano extends Entregador{
    // Provavelmente nao tera nenhuma atributo
    

    Veterano (Restaurante restaurante) {
        super(restaurante);
    }

    @Override
    public void run () {
        // Usando Thread temos que usar o bloco try-catch por conta das interrupcoes
        try {
            System.out.println("O Entregador Veterano de ID " + getIdEntregador() + ", tenta pegar uma moto do Restaurante " + getIDRestaurante() + "!");
            if (!getRestaurante().moto.tryAcquire()) {
                System.out.println("Veterano " + getIdEntregador() + " esta aguardando conseguir uma moto do Restaurante " + getIDRestaurante() + "!");
                getRestaurante().moto.acquire();
            } 
            System.out.println("O Entregador Veterano de ID " + getIdEntregador() + " Pegou a moto do Restaurante " + getIDRestaurante() + "!");

            // Tempo de caminhada
            Thread.sleep(60); 

            System.out.println("O Entregador Veterano de ID " + getIdEntregador() + ", tenta pegar um pedido do Restaurante " + getIDRestaurante() + "!");
            if (!getRestaurante().pedido.tryAcquire()) {
                System.out.println("Veterano " + getIdEntregador() + " esta aguardando conseguir um pedido do Restaurante " + getIDRestaurante() + "!");
                getRestaurante().pedido.acquire();
            }
            System.out.println("Veterano " + getIdEntregador() + " Pegou o pedido do Restaurante " + getIDRestaurante() + "!");

            // Se conseguir pegar a moto devolve os recursos
            System.out.println("O Entregador Veterano de ID " + getIdEntregador() + ", ENTREGOU o pedido do Restaurante " + getIDRestaurante() + "!");
            getRestaurante().moto.release();
            getRestaurante().pedido.release();

        } catch (InterruptedException e) {
            System.err.println("Thread interrompida: " + e.getMessage());
        }
    }
}
