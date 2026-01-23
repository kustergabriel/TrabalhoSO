public class Novato extends Entregador {
    boolean entregue = false;
    
    Novato (Restaurante restaurante) {
        super(restaurante);
    }

    @Override
    public void run () {
        while (!entregue) { // Enquanto for diferente de verdadeiro, significa que o entregador nao conseguiu entregar <FILA>
            try {
            getRestaurante().pedido.acquire(); // Novato pega o pedido
            System.out.println("O Entregador Novato de ID " + getIdEntregador() + ", Pegou o pedido do Restaurante " + getIDRestaurante() + "!");
            // Tempo de caminhada ate o pedido
            Thread.sleep(30); // O novato tem mais energia que o veterano, entao ele corre mais rapido!
            System.out.println("O Entregador Novato de ID " + getIdEntregador() + ", tenta pegar uma moto do Restaurante " + getIDRestaurante() + "!");

            if (getRestaurante().moto.tryAcquire()) {
                System.out.println("Novato " + getIdEntregador() + ", Pegou a moto do Restaurante " + getIDRestaurante() + "!");
                // Se depois disso ele conseguir pegar a moto pode entregar!
                getRestaurante().moto.release();
                getRestaurante().pedido.release();
                entregue = true;
                System.out.println("Pedido do entregador novato " + getIdEntregador() + " entregue!");
            } else {
                // Se ele nao conseguir pegar a moto, libera o pedido para o veterano
                System.out.println("Novato " + getIdEntregador() + ", nao conseguiu pegar a moto do restaurante " + getIDRestaurante() + " pedido liberado pra o proximo!");
                getRestaurante().pedido.release();
                Thread.sleep(120); // Dorme para esperar um tempo, ele estava cansado
            }

            } catch (Exception e) {
                System.err.println("Thread interrompida: " + e.getMessage());
                }
        }
    }
}

/*

 try {
            System.out.println("O Entregador Novato de ID " + getIdEntregador() + ", tenta pegar um pedido do Restaurante " + getIDRestaurante() + "!");
            if (!getRestaurante().pedido.tryAcquire()) {
                System.out.println("Novato " + getIdEntregador() + " esta aguardando conseguir um pedido do Restaurante " + getIDRestaurante() + "!");
                getRestaurante().pedido.acquire();
            }
            System.out.println("O Entregador Novato de ID " + getIdEntregador() + ", Pegou o pedido do Restaurante " + getIDRestaurante() + "!");
            
            // Tempo de caminhada
            Thread.sleep(60); 

            System.out.println("O Entregador Novato de ID " + getIdEntregador() + ", tenta pegar uma moto do Restaurante " + getIDRestaurante() + "!");
            if (!getRestaurante().moto.tryAcquire()) {
                System.out.println("Novato " + getIdEntregador() + " esta aguardando conseguir uma moto do Restaurante " + getIDRestaurante() + "!");
                getRestaurante().moto.acquire();
            }
            System.out.println("Novato " + getIdEntregador() + ", Pegou a moto do Restaurante " + getIDRestaurante() + "!");

            // Se conseguir pegar a moto devolve os recursos
            System.out.println("O Entregador Novato de ID " + getIdEntregador() + ", ENTREGOU o pedido do Restaurante " + getIDRestaurante() + "!");
            getRestaurante().moto.release();
            getRestaurante().pedido.release();

        } catch (InterruptedException e) {
            System.err.println("Thread interrompida: " + e.getMessage());
        }
    }

     */