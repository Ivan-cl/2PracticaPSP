package Dam2PSPP2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 */
public final class App {

    final int numProductores;
    final int numConsumidores;



    final ColaDeTareas cola;

    public App(int numProductores, int numConsumidores) {

        if (numProductores < 0 || numConsumidores < 0 ) {
            throw new IllegalArgumentException("mmmm");
        }

        this.numProductores = numProductores;
        this.numConsumidores = numConsumidores;



        cola = new ColaDeTareas();
    }

    public void empezar() {




        List<Productor> productores=new ArrayList<Productor>();
        List<Consumidor> consumidores=new ArrayList<Consumidor>();

        Random random=new Random();
        for (int i = 0; i < numProductores; ++i) {
          Productor productor= new Productor(random.nextInt(5),i,cola);
          productores.add(productor);
        }

        for (int i = 0; i < numConsumidores; ++i) {
          Consumidor consumidor=new Consumidor(random.nextInt(5), i,cola);
          consumidores.add(consumidor);
        }

        try {
            for (Productor productor:productores){
                productor.start();
            }
            for (Consumidor consumidor:consumidores){
                consumidor.start();
            }
        }catch (Exception e){
            e.getMessage();
        }

        try {
            for (Productor productor:productores){
                productor.join();
            }
            for (Consumidor consumidor:consumidores){
                consumidor.join();
            }
        }catch (Exception e){
            e.getMessage();
        }


        Integer[] numerosConsumir = cola.getNumerosConsumir();
        String salidaCola="La cola ha quedado con los siguientes numeros ";
        for (Integer i :numerosConsumir){
            if(i!=null){
                salidaCola+=" "+i.intValue();
            }
        }
        System.out.println(salidaCola);
        System.out.println("Programa terminado");




        System.out.println("[]\nFIN");
    }

    /**
     * Says hello to the world.
     *
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        new App(50, 10).empezar();
    }


}
