package Dam2PSPP2;

import java.util.concurrent.BlockingQueue;

public class ColaDeTareas {



    private Integer[] numerosConsumir;
    boolean ocupada;

    public ColaDeTareas() {
        numerosConsumir=new Integer[10];
        ocupada=false;
    }

    public void anadeNumero(int numeroAnadir) {
        boolean encontradoNull=false;
        int posicionNull=0;
        while (!encontradoNull){
            if(numerosConsumir[posicionNull]==null){
                encontradoNull=true;
            }else {
                posicionNull++;
            }
        }
        numerosConsumir[posicionNull]=numeroAnadir;
    }


    public Integer cunsumirNumero() {
        int numeroConsumido=numerosConsumir[0];
        for (int i=0;i<numerosConsumir.length-1;i++){
            numerosConsumir[i]=numerosConsumir[i+1];
        }
        numerosConsumir[numerosConsumir.length-1]=null;
        return numeroConsumido;
    }



    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public boolean isLlena() {
        boolean llena=true;
        int contador=0;
        while (llena && contador<numerosConsumir.length){
            if (numerosConsumir[contador]==null){
                llena=false;
            }else {
                contador++;
            }
        }
        return llena;
    }

    public Integer[] getNumerosConsumir() {
        return numerosConsumir;
    }

}
