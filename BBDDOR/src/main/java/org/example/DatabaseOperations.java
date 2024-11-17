package org.example;

import org.postgresql.util.PGobject;

import java.sql.*;

public class DatabaseOperations {

    // URL, usuario y contraseña de la base de datos
    private static final String URL = "jdbc:postgresql://localhost:5432/root";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Paso 1: Crear el tipo compuesto 'producto_t'
            createTipoProducto(conn);

            // Paso 2: Crear la función 'valor_inventario'
            createValorInventarioFunction(conn);

            // Paso 3: Crear la tabla 'productos'
            createProductosTable(conn);

            // Paso 4: Insertar algunos productos
            insertProducto(conn, 10.5, 100);  // Producto con precio 10.5 y cantidad 100
            insertProducto(conn, 20.75, 50);  // Producto con precio 20.75 y cantidad 50

            // Paso 5: Consultar productos
            selectProductos(conn);

            // Paso 6: Actualizar un producto
            updateProducto(conn, 1, 15.5, 120);  // Actualizar producto con id 1

            // Paso 7: Consultar productos nuevamente
            selectProductos(conn);

            // Paso 8: Eliminar un producto
            deleteProducto(conn, 2);  // Eliminar producto con id 2

            // Paso 9: Consultar productos finales
            selectProductos(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para crear el tipo compuesto 'producto_t'
    public static void createTipoProducto(Connection conn) throws SQLException {
        String sql = "CREATE TYPE producto_t AS (" +
                "precio NUMERIC," +
                "cantidad INT" +
                ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Tipo 'producto_t' creado.");
        }
    }

    // Método para crear la función 'valor_inventario'
    public static void createValorInventarioFunction(Connection conn) throws SQLException {
        String sql = "CREATE OR REPLACE FUNCTION valor_inventario(p_producto producto_t) " +
                "RETURNS NUMERIC AS $$ " +
                "BEGIN " +
                "    RETURN p_producto.precio * p_producto.cantidad; " +
                "END; " +
                "$$ LANGUAGE plpgsql;";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Función 'valor_inventario' creada.");
        }
    }

    // Método para crear la tabla 'productos'
    public static void createProductosTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS productos (" +
                "id SERIAL PRIMARY KEY," +
                "producto producto_t" +
                ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Tabla 'productos' creada.");
        }
    }

    // Método para insertar un producto
    public static void insertProducto(Connection conn, double precio, int cantidad) throws SQLException {
        String sql = "INSERT INTO productos (producto) VALUES (ROW(?, ?))";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, precio);
            pstmt.setInt(2, cantidad);
            pstmt.executeUpdate();
            System.out.println("Producto insertado.");
        }
    }

    // Método para eliminar un producto por ID
    public static void deleteProducto(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Producto eliminado.");
        }
    }

    // Método para actualizar un producto por ID
    public static void updateProducto(Connection conn, int id, double precio, int cantidad) throws SQLException {
        String sql = "UPDATE productos SET producto = ROW(?, ?) WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, precio);
            pstmt.setInt(2, cantidad);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            System.out.println("Producto actualizado.");
        }
    }

    // Método para seleccionar y mostrar los productos
    public static void selectProductos(Connection conn) throws SQLException {
        String sql = "SELECT id, producto FROM productos";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                PGobject productoObj = (PGobject) rs.getObject("producto");

                // Extraer los valores del PGobject (producto_t)
                String productoValue = productoObj.getValue(); // Esto es una cadena como "(precio,cantidad)"
                String[] values = productoValue.replace("(", "").replace(")", "").split(",");
                double precio = Double.parseDouble(values[0]);
                int cantidad = Integer.parseInt(values[1]);

                System.out.println("ID: " + id + ", Precio: " + precio + ", Cantidad: " + cantidad);
            }
        }
    }
}
