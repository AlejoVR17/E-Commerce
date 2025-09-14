import java.util.Objects;

public class Producto {
    private String sku;
    private String nombre;
    private double precio;

    public Producto(String sku, String nombre, double precio) {
        this.sku = sku;
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto producto)) return false;
        return sku.equals(producto.sku);
    }

    @Override
    public int hashCode() {
        return sku.hashCode();
    }

    @Override
    public String toString() {
        return "Producto{" +
                "sku='" + sku + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    public String getSku() {
        return sku;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
