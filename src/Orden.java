import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Orden {
    private int id;
    private List<Producto> productos;

    public Orden(int id, List<Producto> productos) {
        this.id = id;
        this.productos = new ArrayList<>();
    }

    public Orden(int id) {
        this.id = id;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    public Set<Producto> obtenerProductosUnicos() {
        return new HashSet<>(productos);
    }

    public int getId() {
        return id;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public String toString() {
        return "Orden{" +
                "id=" + id +
                ", productos=" + productos +
                '}';
    }
}
