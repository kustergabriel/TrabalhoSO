public class Veterano extends Entregador{
    boolean entregue = false;

    Veterano (Restaurante restaurante) {
        super(restaurante);
    }

    @Override
    public void run () {
        // Usando Thread temos que usar o bloco try-catch por conta das interrupcoes
        while (!entregue) { // Enquanto for diferente de verdadeiro, significa que o entregador nao conseguiu entregar <FILA>
            try {
            getRestaurante().moto.acquire(); // Novato pega o pedido
            System.out.println("O Entregador Veterano de ID " + getIdEntregador() + ", Pegou a moto do Restaurante " + getIDRestaurante() + "!");
            // Tempo de caminhada ate o pedido
            Thread.sleep(120); 
            System.out.println("O Entregador Veterano de ID " + getIdEntregador() + ", tenta pegar um pedido do Restaurante " + getIDRestaurante() + "!");

            if (getRestaurante().pedido.tryAcquire()) {
                System.out.println("Veterano " + getIdEntregador() + ", Pegou o pedido e a moto do Restaurante " + getIDRestaurante() + "!");
                // Se depois disso ele conseguir pegar a moto pode entregar!
                getRestaurante().moto.release();
                getRestaurante().pedido.release();
                entregue = true;
                System.out.println("Pedido do entregador veterano " + getIdEntregador() + " ENTREGUE!");
            } else {
                // Se ele nao conseguir pegar a moto, libera o pedido para o veterano
                System.out.println("Veterano " + getIdEntregador() + ", nao conseguiu pegar o pedido do restaurante " + getIDRestaurante() + " moto liberado pra o proximo!");
                getRestaurante().moto.release();
                Thread.sleep(120); // Dorme para esperar um tempo, ele estava cansado
            }
            
            } catch (Exception e) {
                    System.err.println("Thread interrompida: " + e.getMessage());
                }   
        }
    }
}





/*try {
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
        } */