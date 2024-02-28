package sv.edu.udb.model;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

public class DiscoDAO extends AppConnection {

    /**
     * This method inserts into discos table a new row.
     *
     * @param disco
     * @throws SQLException
     */
    public void insert(disco disco) throws SQLException {
        connect();
        pstmt = conn.prepareStatement("INSERT INTO discos (nombre_disco, id_artista, numero_canciones, precio) VALUES (?, ?, ?, ?)");
        pstmt.setString(1, disco.getNombre_disco());
        pstmt.setInt(2, disco.getId_artista());
        pstmt.setInt(3, disco.getNumero_canciones());
        pstmt.setBigDecimal(4, disco.getPrecio());
        pstmt.execute();
        close();
    }

    private void setBigDecimal(int i, BigDecimal precio) {
		// TODO Auto-generated method stub
		
	}

	/**
     * Update all fields from discos table using its id
     *
     * @param disco
     * @throws SQLException
     */
    public void update(disco disco) throws SQLException {
        connect();
        pstmt = conn.prepareStatement("UPDATE discos SET nombre_disco = ?, id_artista = ?, numero_canciones = ?, precio = ? WHERE id_disco = ?");
        pstmt.setString(1, disco.getNombre_disco());
        pstmt.setInt(2, disco.getId_artista());
        pstmt.setInt(3, disco.getNumero_canciones());
        pstmt.setBigDecimal(4, disco.getPrecio());
        pstmt.setInt(5, disco.getId_disco());
        pstmt.execute();
        close();
    }

    /**
     * Deletes a disco by id
     *
     * @param id
     */
    public void delete(int id) throws SQLException {
        connect();
        pstmt = conn.prepareStatement("DELETE FROM discos WHERE id_disco = ?");
        pstmt.setInt(1, id);
        pstmt.execute();
        close();
    }

    /**
     * Returns the list of discos from table.
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<disco> findAll() throws SQLException {
        connect();
        stmt = conn.createStatement();
        resultSet = stmt.executeQuery("SELECT id_disco, nombre_disco, id_artista, numero_canciones, precio FROM discos");
        ArrayList<disco> disco = new ArrayList();

        while (resultSet.next()) {
            disco tmp = new disco();
            tmp.setId_disco(resultSet.getInt(1));
            tmp.setNombre_disco(resultSet.getString(2));
            tmp.setId_artista(resultSet.getInt(3));
            tmp.setNumero_canciones(resultSet.getInt(4));
            tmp.setPrecio(resultSet.getBigDecimal(5));

            disco.add(tmp);
        }

        close();

        return disco;
    }

    /**
     * Find a disco and returns it using the disco id
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public disco findById(int id) throws SQLException {
        disco disco = null;

        connect();
        pstmt = conn.prepareStatement("SELECT id_disco, nombre_disco, id_artista, numero_canciones, precio FROM discos WHERE id_disco = ?");
        pstmt.setInt(1, id);

        resultSet = pstmt.executeQuery();

        while (resultSet.next()) {
            disco = new disco();
            disco.setId_disco(resultSet.getInt(1));
            disco.setNombre_disco(resultSet.getString(2));
            disco.setId_artista(resultSet.getInt(3));
            disco.setNumero_canciones(resultSet.getInt(4));
            disco.setPrecio(resultSet.getBigDecimal(5));
        }

        close();
        return disco;
    }
}

