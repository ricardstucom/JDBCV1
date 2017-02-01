/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendjdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author 46989075y
 */
public class Backend {

    private Connection conexion;

    public Backend() {

    }
//-------------------------------------------------------------
    //1
    public void insertarEquipo(Equipo c) throws SQLException {

        String insert = "insert into team values (?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, c.getName());
        ps.setString(2, c.getCity());
        ps.setDate(3, java.sql.Date.valueOf(c.getCreation()));
        ps.executeUpdate();
        ps.close();

    }
//-------------------------------------------------------------
    //2
    public void insertarJugador(Jugador p) throws SQLException {
        String insert = "insert into player values (?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, p.getName());
        ps.setDate(2, java.sql.Date.valueOf(p.getBirth()));
        ps.setInt(3, p.getNbaskets());
        ps.setInt(4, p.getNassists());
        ps.setInt(5, p.getNrebounds());
        ps.setString(6, p.getPosition());
        ps.setString(7, p.getTeam());
        ps.executeUpdate();
        ps.close();
    }
//-------------------------------------------------------------
    //3
    public void updateCanAsisReb(String name, int i, int j, int k) throws SQLException {

        String update = ("UPDATE player SET nassists=?, nbaskets=?,nrebounds=? WHERE name=?");
        PreparedStatement ps = conexion.prepareStatement(update);
        ps.setInt(1,i);
        ps.setInt(2,j);
        ps.setInt(3,k);
        ps.setString(4, name);
        ps.executeUpdate();
        ps.close();
    }
    //-------------------------------------------------------------
    //4
       public void modificarEquipoJugador (String name, Equipo team) throws SQLException{
        String update = ("UPDATE player SET team=? where name=?");
        PreparedStatement ps= conexion.prepareStatement(update);
        ps.setString(1, team.getName());
        ps.setString(2, name);
        ps.executeUpdate();
        ps.close();
    }
       //-------------------------------------------------------------
       //5
    public void eliminarJugador(String name) throws SQLException{
        String delete = ("DELETE FROM player WHERE name=? ");
          PreparedStatement ps = conexion.prepareStatement(delete);
        ps.setString(1, name);
        ps.executeUpdate();
        ps.close();
    }
    //-------------------------------------------------------------
    //6
public Jugador obtenerJugadorNombre (String name)throws SQLException{
        Jugador c = new Jugador();
        conectar();
        String query = ("SELECT * FROM player WHERE name='"+name+"'");
        Statement st = conexion.createStatement();
        ResultSet ps = st.executeQuery(query);
       
        
        while(ps.next()) {
            return createJugador(ps);
        }
        return c;
    }
//-------------------------------------------------------------

//7

public List<Jugador> selectAllJugadoresByNombre(String name) throws SQLException{
     List<Jugador> jugadores = new ArrayList<>();
    String query = ("SELECT * from player WHERE name like '%'+name+'%'");
    Statement consulta = conexion.createStatement();
     ResultSet ps = consulta.executeQuery(query);
   
    while(ps.next()){
        jugadores.add(createJugador(ps));
    }

    return jugadores;
}
//-------------------------------------------------------------

//8
public List<Jugador> selectAllJugadoresByCanastasParam(int canastas) throws SQLException{
    List<Jugador> jugadores = new ArrayList<>();
    String query = ("SELECT * from player WHERE nbaskets >="+canastas);
   Statement consulta = conexion.createStatement();

        ResultSet ps = consulta.executeQuery(query);
    
    while(ps.next()){
    jugadores.add(createJugador(ps));
              
    }
    
    return jugadores;
}
//-------------------------------------------------------------
//9
public List<Jugador> selectJugadorAsistenciasBetween()throws SQLException{
     List<Jugador> jugadores = new ArrayList<>();
     String query = ("SELECT * FROM player WHERE nassists between =? and =?");
  PreparedStatement ps= conexion.prepareStatement(query);
    ResultSet rs = ps.executeQuery(query);
while(rs.next()){
        Jugador c = new Jugador();
          c.setName(rs.getString("name"));
            c.setBirth(LocalDate.MIN);
            c.setNassists(rs.getInt("nassists"));
             c.setNbaskets(rs.getInt("nbaskets"));
              c.setNrebounds(rs.getInt("nrebounds"));
              c.setPosition(rs.getString("position"));
              c.setTeam(rs.getString("equipo"));
              
    }
rs.close();
    ps.close();
    return jugadores;
}
//-------------------------------------------------------------
//10
public List<Jugador> selectJugadorByPosition(String position)throws SQLException{
    List<Jugador> jugadores = new ArrayList<>();
     String query = ("SELECT * FROM player WHERE position ='"+position+"'");
 Statement consulta = conexion.createStatement();

        ResultSet ps = consulta.executeQuery(query);
while(ps.next()){
       jugadores.add(createJugador(ps));
              
    }

    return jugadores;
}
//-------------------------------------------------------------
//11

public List<Jugador> selectJugadorFecha (LocalDate birth)throws SQLException{
     List<Jugador> jugadores = new ArrayList<>();
     Date fecha = java.sql.Date.valueOf(birth);
     String query = ("SELECT * FROM player WHERE birth <"+fecha);
Statement consulta = conexion.createStatement();

        ResultSet ps = consulta.executeQuery(query);
while(ps.next()){
      jugadores.add(createJugador(ps));
              
    }

    return jugadores;
}
//-------------------------------------------------------------
//12
  public List<TogetherDTO> together () throws SQLException{

        List<TogetherDTO> jugadores = new ArrayList<>();

        String obtener = "select position, "
                + "AVG(nbaskets),"
                + "AVG(nassists),"
                + "AVG(nrebounds),"
                + "MAX(nbaskets),"
                + "MAX(nassists),"
                + "MAX(nrebounds),"
                + "MIN(nbaskets),"
                + "MIN(nassists),"
                + "MIN(nrebounds)"
                + " from player group by position";
        Statement query = conexion.createStatement();

        ResultSet ps = query.executeQuery(obtener);

        while (ps.next()) {
            TogetherDTO a = new TogetherDTO();

            a.setPosition(ps.getString("position"));
            a.setMediaCanas(ps.getDouble(2));
            a.setMediaAsists(ps.getDouble(3));
            a.setMediaRebounds(ps.getDouble(4));
            a.setMaxCana(ps.getInt(5));
            a.setMaxAsists(ps.getInt(6));
            a.setMaxRebounds(ps.getInt(7));
            a.setMinCana(ps.getInt(8));
            a.setMinasists(ps.getInt(9));
            a.setMinRebounds(ps.getInt(10));

            jugadores.add(a);
        }

        return jugadores;
    }

//RANKING
//----------------------------------------------------------------------
//13
public List<RankingDTO> ListJugadorCanastas() throws SQLException{
       List<RankingDTO> ranking = new ArrayList<>();
     String query = ("SELECT name, nbaskets FROM player ");
 Statement consulta= conexion.createStatement();
    ResultSet ps = consulta.executeQuery(query);
while(ps.next()){
      ranking.add(new RankingDTO(ps.getString("name"),ps.getInt("nbaskets")));
             
    }
 ranking.sort(Comparator.comparing(RankingDTO::getNbaskets));
    return ranking;
}

//------------------------------------------------------------------------
//14
public List<Jugador> selectJugadoresByEquipoPosicion(String equipo, String posicion)throws SQLException{
    String query = ("SELECT * FROM player where team=? and position=?");
   PreparedStatement ps = conexion.prepareStatement(query);
 Statement st= conexion.createStatement();
    ResultSet rs = st.executeQuery(query);
    ps.setString(1, equipo);
   ps.setString(2, posicion);
    List<Jugador> jugadores = new ArrayList<>();
    while(rs.next()){
        Jugador c = new Jugador();
          c.setName(rs.getString("name"));
            c.setBirth(LocalDate.MIN);
            c.setNassists(rs.getInt("nassis"));
             c.setNbaskets(rs.getInt("nbaskets"));
              c.setNrebounds(rs.getInt("nrebounds"));
              c.setPosition(rs.getString("position"));
              jugadores.add(c);
    }
    return jugadores;
}
//-------------------------------------------------------------
//15

public List<Equipo> ListEquipoCity(String city) throws SQLException{
       List<Equipo> equipos = new ArrayList<>();
     String query = ("SELECT * FROM team WHERE city = '"+ city+"'");
 Statement consulta= conexion.createStatement();
    ResultSet ps = consulta.executeQuery(query);
while(ps.next()){
       equipos.add(new Equipo(ps.getString("name"),ps.getString("city"),ps.getDate("creation").toLocalDate()));
             
    }

    return equipos;
}
//-------------------------------------------------------------
//16
public List<String> ListPlayerTeam(String equipo)throws SQLException{
    List<String> jugadores = new ArrayList<>();
    String query = ("SELECT name from player where team='"+equipo+"'");
    Statement consulta= conexion.createStatement();
    ResultSet ps = consulta.executeQuery(query);
    while(ps.next()){
         jugadores.add(ps.getString("name"));
             
    }

    return jugadores;
}


public List<Jugador> jugadoresEquipoPosicion(String nequipo, String posicion) throws SQLException{

        List<Jugador> jugadores = new ArrayList<>();

        String obtener = "select * from player WHERE team ='"+nequipo+"' and posicion ='"+posicion+"'";
        Statement consulta = conexion.createStatement();

        ResultSet ps = consulta.executeQuery(obtener);

        while (ps.next()){
            jugadores.add(createJugador(ps));
        }
        return jugadores;
    }
    public void conectar() throws SQLException {
        String url = "jdbc:mysql://localhost/basket";
        String usr = "root";
        String pass = "";
        conexion = DriverManager.getConnection(url, usr, pass);
    }

    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
    
       private Jugador createJugador(ResultSet ps) throws SQLException{

        Jugador p = new Jugador();
        p.setName(ps.getString("nombre"));
        p.setBirth(ps.getDate("fechan").toLocalDate());
        p.setNbaskets(ps.getInt("canasto"));
        p.setNassists(ps.getInt("asisto"));
        p.setNrebounds(ps.getInt("reboto"));
        p.setPosition(ps.getString("posicion"));
        String team = (ps.getString("team"));

        String obtenerT = "select * from team where name = '"+team+"'";
        Statement consulta2 = conexion.createStatement();

        ResultSet pst = consulta2.executeQuery(obtenerT);
        Equipo t = new Equipo();

        while(pst.next()) {
            t.setName(pst.getString("name"));
            t.setCity(pst.getString("localidad"));
            t.setCreation(pst.getDate("creation").toLocalDate());

            p.setTeam(t);
        }
        return p;
    }
}
