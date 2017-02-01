
package backendjdbc;

import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BackendJDBC {

   
    public static void main(String[] args) {
       Backend gestor = new Backend();
        try{
        gestor.conectar();
            System.out.println("Estableciendo la conexión con el servidor...");
            
            System.out.println("Insertando Equipo...");
            Equipo c = new Equipo("Karlos", "barcelona", LocalDate.of(1996,02,20));
            gestor.insertarEquipo(c);
            System.out.println("Equipo dado de alta");
            
            
            
            System.out.println("Insertando Jugador...");
             Jugador p = new Jugador("Patatas",  LocalDate.of(1996,3,20),4, 3,8,"pichichi", "Karlos");
             gestor.insertarJugador(p);
             System.out.println("Jugador dado de alta");
             
             
//             System.out.println("Update Jugador...");
//           Jugador e = new Jugador ("petu", LocalDate.of(1995,05,20),6,3,7,"defensa",c);
//            gestor.updateCanAsisReb(e);
//            System.out.println("Jugador actualizado");
//            
//            
//            System.out.println("Borrando Jugador...");
//            Jugador f = new Jugador("Patatas", LocalDate.of(1996,8,20),4,3,8,"pichichi",c);
//            gestor.eliminarJugador(f);
//            System.out.println("Jugador borrado");
//            
//            System.out.println("Buscando Jugador...");
//            String name = "Patatas";
//            gestor.obtenerJugadorNombre(name);
//            System.out.println("Jugador encontrado");
            
            System.out.println("selectJugadoresByEquipoPosicion");
            gestor.selectJugadoresByEquipoPosicion("Karlos", "pichichi");
                    
            
            
            gestor.desconectar();
        }catch(SQLException ex){
            System.out.println("Error con la bbdd: "+ex.getMessage());
        }
        
        
        
          
    }
    
}
 