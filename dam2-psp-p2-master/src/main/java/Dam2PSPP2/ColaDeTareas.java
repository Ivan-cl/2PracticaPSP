package Dam2PSPP2;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ColaDeTareas {



    private Integer[] numerosConsumir;

    public ColaDeTareas() {
        numerosConsumir=new Integer[10];
    }

    public synchronized void anadeNumero(int numeroAnadir) {

        try{
            Random r =new Random();
            wait(r.nextInt(1000));
            int posicionNull=0;
            if(!estoyLLena()){
                for (int i=0;i<numerosConsumir.length;i++){
                    if (numerosConsumir[i]==null){
                        posicionNull=i;
                        break;
                    }
                }
                numerosConsumir[posicionNull]=numeroAnadir;
            }
        }catch (Exception e){
            e.getMessage();
        }
        notify();
    }


    public synchronized Integer cunsumirNumero() {

        try{
            Random r =new Random();
            wait(r.nextInt(1000));
            Integer numeroConsumido=numerosConsumir[0];
            if (numeroConsumido!=null){

                for (int i=0;i<numerosConsumir.length-1;i++){
                    numerosConsumir[i]=numerosConsumir[i+1];
                }
                numerosConsumir[numerosConsumir.length-1]=null;
                notify();
                return numeroConsumido;
            }else {
                notify();
                return -1;
            }
        }catch (Exception e){
            e.getMessage();
            return -1;
        }


    }


    public Integer[] getNumerosConsumir() {
        return numerosConsumir;
    }

    private boolean estoyLLena(){
        boolean estoyLLena=true;
        for (Integer i:numerosConsumir){
            if (i==null){
                estoyLLena=false;
            }
        }
        return estoyLLena;
    }
}
