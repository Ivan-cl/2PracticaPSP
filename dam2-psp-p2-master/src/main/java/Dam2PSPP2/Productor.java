package Dam2PSPP2;

import java.util.Objects;
import java.util.Random;

public class Productor extends Thread {


    private int id;
    private int numVueltas;
    protected ColaDeTareas colaDeTareas;

    public Productor(int numVueltas,int id,ColaDeTareas colaDeTareas) {

        this.numVueltas = numVueltas;
        this.id=id;
        this.colaDeTareas=colaDeTareas;
    }


    @Override
    public void run() {

        while (numVueltas >0){
            Random random=new Random();
            int numAleatorio=random.nextInt(100);
            colaDeTareas.anadeNumero(numAleatorio);
            numVueltas--;
            System.out.println("Soy el productor " + id + " y produzco " + numAleatorio);
        }
    }

}
