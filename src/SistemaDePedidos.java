import java.util.*;

public class SistemaDePedidos {

    private Map<String, Producto> catalogoProductos;
    private Queue<Orden> colaPedidos;

    public SistemaDePedidos(Map<String, Producto> catalogoProductos, Queue<Orden> colaPedidos) {
        this.catalogoProductos = new HashMap<>();
        this.colaPedidos = new LinkedList<>();
    }

    public SistemaDePedidos() {
        this.catalogoProductos = new HashMap<>();
        this.colaPedidos = new LinkedList<>();
    }

    public void agregarProductoAlCatalogo(Producto producto) {
        if (catalogoProductos.containsKey(producto.getSku())) {
            System.out.println("El producto con SKU " + producto.getSku() + " ya existe en el catálogo.");
        } else {
            catalogoProductos.put(producto.getSku(), producto);
            System.out.println("Producto con SKU " + producto.getSku() + " agregado al catálogo.");
        }
    }

    public Producto buscarProductoPorSku(String sku) {
        return catalogoProductos.get(sku);
    }

    public void registrarOrden(Orden orden) {
        boolean existe = colaPedidos.stream()
                .anyMatch(o -> o.getId() == orden.getId());
        if (existe) {
            System.out.println("La orden con ID " + orden.getId() + " ya existe en la cola.");
        } else {
            colaPedidos.offer(orden);
            System.out.println("Orden con ID " + orden.getId() + " registrada exitosamente.");
        }
    }

    public Orden procesarSiguienteOrden() {
        Orden siguienteOrden = colaPedidos.poll();
        if (siguienteOrden != null) {
            System.out.println("Procesando orden ID: " + siguienteOrden.getId() +
                    " con total: $" + siguienteOrden.calcularTotal());
        } else {
            System.out.println("No hay órdenes para procesar.");
        }
        return siguienteOrden;
    }

    public static <T> void imprimirColeccion(String titulo, Collection<T> coleccion) {
        System.out.println("\n-- " + titulo + " --");
        for (T item : coleccion) {
            System.out.println(item);
        }
        System.out.println("-- Fin de " + titulo + " --\n");
    }

    public Queue<Orden> getColaPedidos() {
        return colaPedidos;
    }

    public Map<String, Producto> getCatalogoProductos() {
        return catalogoProductos;
    }
}
