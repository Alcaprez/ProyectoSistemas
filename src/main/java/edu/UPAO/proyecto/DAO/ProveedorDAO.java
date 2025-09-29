
package edu.UPAO.proyecto.DAO;

import edu.UPAO.proyecto.Modelo.Proveedor;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {
    private static final List<Proveedor> proveedores = new ArrayList<>();

    public void agregar(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    public List<Proveedor> listar() {
        return new ArrayList<>(proveedores);
    }

    public Proveedor buscarPorId(int id) {
        return proveedores.stream()
                .filter(p -> p.getIdProveedor() == id)
                .findFirst()
                .orElse(null);
    }

    public void actualizar(Proveedor proveedorActualizado) {
        for (int i = 0; i < proveedores.size(); i++) {
            if (proveedores.get(i).getIdProveedor() == proveedorActualizado.getIdProveedor()) {
                proveedores.set(i, proveedorActualizado);
                break;
            }
        }
    }

    public void activarDesactivar(int id) {
        Proveedor p = buscarPorId(id);
        if (p != null) {
            p.setActivo(!p.isActivo());
        }
    }
}
