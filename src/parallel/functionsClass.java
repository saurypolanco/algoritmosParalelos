package parallel;

import javax.swing.JTextField;

public class functionsClass extends Thread {

    public int option;
    int array[];
    int numberToSearch;
    int sup;
    int inf;
    public String rsecuencial, rbinaria, rburbuja, rquicksort, rinsercion;
    JTextField tf;

    
    @Override
    public void run() {
        switch (option) {
            case 1:
                busquedaSecuencial(array, numberToSearch);
                break;
            case 2:
                busquedaBinaria(array, numberToSearch);
                break;
            case 3:
                ordenarBurbuja(array);
                break;
            case 4:
                quickSort(array, inf, sup); 
                break;
            case 5:
                insercion(array);
                break;
            default:
                System.out.println("no hay opcion seleccionada");
                break;
        }
        
        
        synchronized(this){
           notify();
       }
        

    }
    
    public functionsClass(int option, int array[], int numberToSearch, int sup, int inf, JTextField tfield) {
        this.option = option;
        this.array = array;
        this.numberToSearch = numberToSearch;
        this.sup = sup;
        this.inf = inf;
        tf = tfield;
    }

    
    /***************************************/
    /********* busqueda secuencial *********/
    /***************************************/
    public void busquedaSecuencial(int array[], int numeroBuscar) {
        double tini, tfin;
        tini = System.currentTimeMillis();
        boolean x = false;
        
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] == numeroBuscar) {
                System.out.println("Valor: '" + numeroBuscar + "' encontrado en la posicion #" + i);
                x = true;
            }
        }

        if (!x) {
            System.out.println("No se ha encontrado el valor " + numeroBuscar + " en el arreglo");
        }
            System.out.println("1");
         try{
                Thread.sleep(1);
            }catch(InterruptedException ex){}
        tfin = System.currentTimeMillis();
        
//        this.rsecuencial=();
        this.tf.setText(calcularTiempo("Busqueda Secuencial", tini, tfin));
        
    }

  
    
    
    
   
    /**************************************/
    /********** busqueda binaria **********/
    /**************************************/
    public void busquedaBinaria(int array[], int numeroBuscar) {
        double tini, tfin;
        
        
        int aux = 0;
        //se ordena el arreglo por metodo burbuja 

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[i] > array[j + 1]) {
                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }

            }

        }

        //inicio de busqueda
        tini = System.currentTimeMillis();
        int n, i, num, primero, ultimo, medio;
        
        n = array.length;

        primero=0;
        ultimo=n-1;
        medio=(primero+ultimo)/2;
        while (primero<=ultimo) {
            if (array[medio]< numeroBuscar){
                primero=medio+1;
            } else if (array[medio]== numeroBuscar) {
//                System.out.println("Se encontró el valor en la posición "+ (medio+1));

                break;
            }
            else {
                ultimo = medio - 1;
            }

            medio = (primero+ultimo)/2;
        }

        if (primero>ultimo){

//            System.out.println("No se ha encontrado el valor");

        }
            try{
                Thread.sleep(1);
            }catch(InterruptedException ex){}

         tfin = System.currentTimeMillis();
        
        this.tf.setText(calcularTiempo("Busqueda Binaria", tini, tfin));
       
        

    }

    /************************************************/
    /************ Ordenamiento por burbuja **********/
    /************************************************/
    public void ordenarBurbuja(int array[]) {
        double tini, tfin;
        tini = System.currentTimeMillis();
        int aux = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }

            }
        }
         try{
                Thread.sleep(1);
            }catch(InterruptedException ex){}
         tfin = System.currentTimeMillis();
         
         this.tf.setText(calcularTiempo("Ordenamiento Burbuja", tini, tfin));
 
    }

    /*****************************************/
    /************ Método quick sort **********/
    /*****************************************/
    public void quickSort(int array[], int inf, int sup) {
        double tini, tfin;
        tini = System.currentTimeMillis();
        int i = inf;
        int j = sup;
        int tam = 0;
        int x = array[inf + (sup - inf) / 2];
       
        while (i <= j) {
            while (array[i] < x) {
                i += 1;
            }
            while (array[j] > x) {
                j -= 1;
            }

            if (i <= j) {
                tam = array[i];
                array[i] = array[j];
                array[j] = array[i];
                i += 1;
                j -= 1;
            }
        }

        if (inf < j) {
            quickSort(array, inf, j);
        }
        if (i < sup) {
            quickSort(array, i, sup);
        }
         try{
                Thread.sleep(1);
            }catch(InterruptedException ex){}
         tfin = System.currentTimeMillis();
        
        
       this.tf.setText(calcularTiempo("Ordenamiento QuickSort ", tini, tfin));
    }

    /**********************************************/
    /************* metodo de insercion ************/
    /**********************************************/
    public void insercion(int array[]) {
        double tini, tfin;
        tini = System.currentTimeMillis();
        int clave, i;

        for (int j = 0; j < array.length; j++) {
            clave = array[j];
            i = j - 1;

            while (i > -1 && array[i] > clave) {

                array[i + 1] = array[i];
                i = i - 1;
            }
            array[i + 1] = clave;
        }
         try{
                Thread.sleep(1);
            }catch(InterruptedException ex){}
        tfin = System.currentTimeMillis();
        
        this.tf.setText(calcularTiempo("Busqueda Inserción ", tini, tfin));
    }
    
    
    public String calcularTiempo(String metodo, double ini, double fin){
    
        
        return metodo +" tardó "+ (fin - ini)+" milisegundos";
    
    }
   

}
