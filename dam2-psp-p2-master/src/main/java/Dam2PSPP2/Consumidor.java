package Dam2PSPP2;

import java.util.Objects;
import java.util.Random;

public class Consumidor implements Runnable {


    private int id;
    private int numVueltas;
    private Thread hilo;
    protected App app;

    //private final StringBuilder sb = new StringBuilder("cons[").append(id).append("] consume ");


    public Consumidor(int numVueltas,int id,App app) {
        this.numVueltas = numVueltas;
        this.id=id;
        this.app=app;
        hilo = new Thread(this);
        hilo.start();
    }



    @Override
    public void run() {

        while (true){
            Random random=new Random();
            //System.out.println("soy el comsumer "+id+" y la cola está "+app.cola.isOcupada());
            if (numVueltas!=0){

                if(app.cola.isOcupada()){
                    try {
                        hilo.sleep(random.nextInt(999)+1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    app.cola.setOcupada(true);
                    if(app.cola.getNumerosConsumir()[0]==null){
                        try {
                            app.cola.setOcupada(false);
                            hilo.sleep(random.nextInt(999)+1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        Integer integer = app.cola.cunsumirNumero();
                        numVueltas--;
                        System.out.println("Consumer ["+id+"] ---> consume :"+integer.intValue());
                        app.cola.setOcupada(false);
                        try {
                            System.out.println("me duermo");
                            hilo.sleep(random.nextInt(999)+1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }

            }else {
                hilo.stop();
            }


        }


    }

    public int getNumVueltas() {
        return numVueltas;
    }

}
