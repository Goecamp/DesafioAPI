package sv.edu.udb.model;

import java.sql.SQLException;
import java.util.ArrayList;

public class ArtistaDAO extends AppConnection {

    /**
     * This method inserts into artista table a new row.
     *
     * @param artista
     * @throws SQLException
     */
    public void insert(artista artista) throws SQLException {
        connect();
        pstmt = conn.prepareStatement("INSERT INTO artistas (nombre_artista, descripcion) VALUES (?, ?)");
        pstmt.setString(1, artista.getNombre_artista());
        pstmt.setString(2, artista.getDescripcion());
        pstmt.execute();
        close();
    }

    /**
     * Update all fields from artista table using its id
     *
     * @param artista
     * @throws SQLException
     */
    public void update(artista artista) throws SQLException {
        connect();
        pstmt = conn.prepareStatement("UPDATE artistas SET nombre_artista = ?, descripcion = ? WHERE id_artista = ?");
        pstmt.setString(1, artista.getNombre_artista());
        pstmt.setString(2, artista.getDescripcion());
        pstmt.setInt(3, artista.getArtista());
        pstmt.execute();
        close();
    }

    /**
     * Deletes an artista by id
     *
     * @param id
     */
    public void delete(int id) throws SQLException {
        connect();
        pstmt = conn.prepareStatement("DELETE FROM artistas WHERE id_artista = ?");
        pstmt.setInt(1, id);
        pstmt.execute();
        close();
    }

    /**
     * Returns the list of artistas from table.
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<artista> findAll() throws SQLException {
        connect();
        stmt = conn.createStatement();
        resultSet = stmt.executeQuery("SELECT id_artista, nombre_artista, descripcion FROM artistas");
        ArrayList<artista> artista = new ArrayList();

        while (resultSet.next()) {
            artista tmp = new artista();
            tmp.setArtista(resultSet.getInt(1));
            tmp.setNombre_artista(resultSet.getString(2));
            tmp.setDescripcion(resultSet.getString(3));

            artista.add(tmp);
        }

        close();

        return artista;
    }

    /**
     * Find an artista and returns it using the artista id
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public artista findById(int id) throws SQLException {
        artista artista = null;

        connect();
        pstmt = conn.prepareStatement("SELECT id_artista, nombre_artista, descripcion FROM artistas WHERE id_artista = ?");
        pstmt.setInt(1, id);

        resultSet = pstmt.executeQuery();

        while (resultSet.next()) {
            artista = new artista();
            artista.setArtista(resultSet.getInt(1));
            artista.setNombre_artista(resultSet.getString(2));
            artista.setDescripcion(resultSet.getString(3));
        }

        close();
        return artista;
    }
}
