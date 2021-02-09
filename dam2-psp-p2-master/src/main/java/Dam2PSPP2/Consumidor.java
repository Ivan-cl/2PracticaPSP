package Dam2PSPP2;

import java.util.Objects;
import java.util.Random;

public class Consumidor  extends Thread {


    private int id;
    private int numVueltas;
    private ColaDeTareas colaDeTareas;



    public Consumidor(int numVueltas,int id,ColaDeTareas colaDeTareas) {
        this.numVueltas = numVueltas;
        this.id=id;
        this.colaDeTareas=colaDeTareas;
    }



    @Override
    public void run() {

        while (numVueltas>0){
            Integer integer = colaDeTareas.cunsumirNumero();
            if (integer!=-1){
                numVueltas--;
                System.out.println("Soy el consumidor " + id + " y voy a consumir " + integer);
            }
        }
    }
}
