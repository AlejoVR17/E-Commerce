public class Main {
    public static void main(String[] args) {
        SistemaDePedidos sistemaDePedidos = new SistemaDePedidos();

        Producto producto1 = new Producto("SKU001", "Laptop", 1200.00);
        Producto producto2 = new Producto("SKU002", "Smartphone", 800.00);
        Producto producto3 = new Producto("SKU003", "Tablet", 400.00);
        Producto producto4 = new Producto("SKU004", "Monitor", 300.00);

        sistemaDePedidos.agregarProductoAlCatalogo(producto1);
        sistemaDePedidos.agregarProductoAlCatalogo(producto2);
        sistemaDePedidos.agregarProductoAlCatalogo(producto3);
        sistemaDePedidos.agregarProductoAlCatalogo(producto4);

        // Ordenes
        Orden orden1 = new Orden(101);
        orden1.agregarProducto(producto1);
        orden1.agregarProducto(producto2);
        orden1.agregarProducto(producto2);

        Orden orden2 = new Orden(102);
        orden2.agregarProducto(producto3);

        Orden orden3 = new Orden(103);
        orden3.agregarProducto(producto4);
        orden3.agregarProducto(producto1);

        sistemaDePedidos.registrarOrden(orden1);
        sistemaDePedidos.registrarOrden(orden2);
        sistemaDePedidos.registrarOrden(orden3);

        SistemaDePedidos.imprimirColeccion("Catálogo de Productos", sistemaDePedidos.getCatalogoProductos().values());

        while (!sistemaDePedidos.getColaPedidos().isEmpty()) {
            sistemaDePedidos.procesarSiguienteOrden();
        }

        sistemaDePedidos.procesarSiguienteOrden();

        System.out.println("\nProductos únicos en la orden #101: ");
        for (Producto p : orden1.obtenerProductosUnicos()) {
            System.out.println(p);
        }
    }
}