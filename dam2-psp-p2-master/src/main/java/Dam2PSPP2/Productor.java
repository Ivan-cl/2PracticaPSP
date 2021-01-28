package Dam2PSPP2;

import java.util.Objects;
import java.util.Random;

public class Productor implements Runnable {


    private int id;
    private int numVueltas;
    private Thread hilo;
    protected App app;

    public Productor(int numVueltas,int id,App app) {

        this.numVueltas = numVueltas;
        this.id=id;
        this.app=app;
        hilo = new Thread(this);
        hilo.start();
    }


    @Override
    public void run() {
        while (true){
            if(numVueltas!=0){
                Random random=new Random();
                //System.out.println("soy el productor "+id+" y la cola está "+app.cola.isOcupada());
                if(app.cola.isOcupada()){
                    try {
                        hilo.sleep(random.nextInt(1));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    app.cola.setOcupada(true);
                    if(app.cola.isLlena()){
                        app.cola.setOcupada(false);
                        try {
                            hilo.sleep(random.nextInt(1));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        int numeroAleatorio = random.nextInt(100);
                        app.cola.anadeNumero(numeroAleatorio);
                        System.out.println("productor ["+id+"] ---> produce :"+numeroAleatorio);
                        app.cola.setOcupada(false);
                        numVueltas--;
                        try {
                            hilo.sleep(random.nextInt(1));
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
