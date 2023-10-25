package mutante;

public class AnalizarADN {
    public boolean isMutant(String[] adn){
        int n = adn.length;
        
        if (n != 6) {
            //si el lenght del String es distinto de 6, no sigue ya que necesito si o si que sea 6
            return false;
        }
        
        //va a recorrer cada una de las secuencias dentro del String
        for (String secuencia : adn) {
            //si una de las secuencias tiene mas o menos de 6 elementos termina el recorrido
            if (secuencia.length() != 6) {
                return false;
            }
        }
        
        int contador = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char baseNitrogenada = adn[i].charAt(j);
                
                //verifico si en alguno de los tres casos que pueden haber es verdadero
                //pasando como parametros el string ADN, la base nitrogenada de la secuencia en la que esta el for, y los indices i y j
                if (vertical(adn,baseNitrogenada,i,j) || horizontal(adn,baseNitrogenada,i,j) || diagonal(adn,baseNitrogenada,i,j)) {
                    contador ++;
                }
                
                if (contador > 1) {
                    return true;
                }
            }
        }
        //si no se cumple en ninguna de las tres posibilidades devuelve falso
        return false;
    }
    
    private boolean vertical(String[] adn,char baseNitrogenada,int i,int j){
        //al ser vertical tengo que recorrer la fila
        //revisa que la letra que le sigue en la secuencia de ADN en i, es igual a la que esta guardada en j
        return i + 3 < 6 && adn[i + 1].charAt(j) == baseNitrogenada && 
                adn[i + 2].charAt(j) == baseNitrogenada && 
                adn[i + 3].charAt(j) == baseNitrogenada;
    }
    
    private boolean horizontal(String[] adn,char baseNitrogenada,int i,int j){
        //al ser horizontal tengo que recorrer las columnas
        //revisa que la letra en i, es igual a la que sigue en la columna
        return j + 3 < 6 && adn[i].charAt(j + 1) == baseNitrogenada && 
                adn[i].charAt(j + 2) == baseNitrogenada && 
                adn[i].charAt(j + 3) == baseNitrogenada;
    }
    
    private boolean diagonal(String[] adn,char baseNitrogenada,int i,int j){
        //como tengo que recorrer la diagonal
        //lo que hace es ir aumentando tanto filas como columnas para ver si las letras en las diagonales son iguales
        return i + 3 < 6 && j + 3 < 6 && 
                adn[i + 1].charAt(j + 1) == baseNitrogenada && 
                adn[i + 2].charAt(j + 2) == baseNitrogenada && 
                adn[i + 3].charAt(j + 3) == baseNitrogenada;
    }
}
