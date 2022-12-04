
import java.io.*;
 
class archivos {
    public static int v=0, e=0;

    public String leerTxt(String direccion){
        String regex = "[0-9\\-/@#$%^&_+=()]+";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(direccion));
            String vString = reader.readLine(); // this will read the first line
            v = Integer.valueOf(vString);

            String line=null;
            while ((line = reader.readLine()) != null){ //loop will run from 2nd line
                
                if (line.matches(regex)) {
                    e = Integer.valueOf(line);
                }

            }    
        }catch(Exception e){ 
            System.err.println("No se encontro archivo");
        }
        return null;
    }
}

class GFG{
// Function that calculates Edge Cover
static int edgeCover(int n)
{
    int result = 0;
    result = (int)Math.ceil((double)n / 2.0);
    return result;
}
    public static void main(String args[]){        
        archivos a = new archivos();
        String s1 = a.leerTxt("EnfermeraJoey.txt");

        System.out.println("Numero de vertices: "+archivos.v+" Numero de aristas: "+archivos.e);
        System.out.print("Minimos campamentos: "+edgeCover(archivos.e));
    }
}