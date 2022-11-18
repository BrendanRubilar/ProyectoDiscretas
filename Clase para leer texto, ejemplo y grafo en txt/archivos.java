import java.io.*;

public class archivos {

    String texto = "";
    int V, E; 
    String Vertices[] = new String[1000]; //ESTO ES SOLO PARA DESARROLLAR LA IDEA DE COMO LEER EL TEXTO, luego podemos almacenar en arraylist de tipo vertice y aristas, arraylist multidim. etc..
    String Aristas[] = new String[1000];

    public String leerTxt(String direccion){ //Direccion del archivo de texto
        

        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            while((bfRead = bf.readLine()) != null){  //haz el ciclo, mientras bfRead tiene datos
                temp = temp + bfRead; //guardado el texto del archivo
                System.out.println(temp); //Esto es una bandera para ver como va leyendo el archivo

                /* -Willy
                IDEA ALGORITMO PARA LEER EL ARCHIVO DE TEXTO 
                (Quiza no es la manera mas optima pero se me ocurrio esto por ahora) 
                Explicacion: El archivo de texto tiene solo una vez las siguientes lineas <n: >" y <m: > entonces, primero buscamos en el string temp 
                (Es la linea que se esta leyendo, normalmente leeria todo el texto y lo guardaria, pero para este algortimo luego de leer una linea pasa a valer "", asi podemos
                analizar cada linea sin mayores problemas) si es que existe un caracter ':' de ser asi sabemos que primero sera el numero de vertices y luego el numero de aristas,
                entonces con ayuda de un int auxiliar podemos cambiar el lugar en donde almacenaremos estos datos.
                Luego para obtener las ciudades de manera similiar vemos que NO exista un < en la linea (string) desde el index 1 (Posicion, en otras palabras si las ciudades tienen
                <> y las aristas <><> entonces si no encuentra otro < despues de la posicion 0 es ciudad) tambien se comprueba que no exista un ':'.
                Sistema analogo al de arriba para rutas (Aristas).

                Para ver que el programa funciona correctamente deben quitar las // de las banderas (Marcado con @@@)
                 */
                int i = 0; 
                int aux = temp.indexOf(':');
                
                if(aux!=-1){
                    if(i==0){
                        
                        String SoloEnteros= temp.replaceAll("[^0-9]", ""); //Este es un array auxiliar que elimina todo lo que no sean int's
                        V = Integer.parseInt(SoloEnteros); //Obtenemos los ints del array auxiliar y los pasamos a int, asignamos este valor a nuestra variabel Vertices
                        //System.out.println(V); //Bandera para comprobar si es correcto el valor obtenido @@@

                        i++;
                    }else if(i ==1 ){
                       
                        String numberOnly= temp.replaceAll("[^0-9]", ""); //Proceso analogo al anterior
                        E = Integer.parseInt(numberOnly); 
                        //System.out.println(E); @@@

                        i++;
                    }
                }

                int j=0;
                int aux2 = temp.indexOf('<',1);
                if(aux == -1 && aux2 == -1 ){
                    String Ciudades= temp.replaceAll("[<,>]", "");
                    Vertices[j]=Ciudades; //Almacenar las ciudades en un arraylist de tipo String es solo una idea, podria ser un arraylist de cualquier tipo u otra forma de almacenar.
                    //System.out.println(Vertices[j]); //Bandera que te devuelve la ciudad sin los <> si la reconoce correctamente @@@
                    j++;
                }

                int k = 0;
                if(aux == -1 && aux2 != -1){
                    String Rutas= temp.replaceAll("[<,>]", " "); //Esto es solo una idea, se debe modificar de acuerdo a necesidad
                    Aristas[k]=Rutas;
                    //System.out.println(Aristas[k]); //Bandera para comprobar que se obtuvieron las aristas de manera correcta @@@
                    k++;
                }

                temp = ""; //Luego de revisar la linea con todos los algoritmos anteriores la dejamos vacia para revisar la siguiente, hasta que leamos null.

            }
            
            texto = temp;
            
        }catch(Exception e){ 
            System.err.println("No se encontro archivo");
        }
        
        return null;
        
    }
    
}
