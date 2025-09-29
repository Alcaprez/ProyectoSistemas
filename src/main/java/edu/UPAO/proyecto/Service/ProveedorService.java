
package edu.UPAO.proyecto.Service;
import edu.UPAO.proyecto.DAO.ProveedorDAO;
import edu.UPAO.proyecto.Modelo.Proveedor;
import java.util.List;

public class ProveedorService {
    private ProveedorDAO proveedorDAO = new ProveedorDAO();

    public ProveedorService() {
        // Datos de prueba (observa el campo correo incluido)
        proveedorDAO.agregar(new Proveedor(1, "Distribuidora Norte SAC", "20123456789", "Calle A 123", "044-123456", "contacto@nortesac.com", true));
        proveedorDAO.agregar(new Proveedor(2, "Servicios Industriales del Sur", "20987654321", "Av. B 456", "054-654321", "ventas@indsur.com", true));
        proveedorDAO.agregar(new Proveedor(3, "Insumos Médicos Andinos", "20456789123", "Jr. C 789", "01-4567890", "soporte@insumed.com", false));
        proveedorDAO.agregar(new Proveedor(4, "TecnoGlobal Importaciones", "20111222334", "Av. D 101", "01-7654321", "info@tecnoglobal.pe", true));
        proveedorDAO.agregar(new Proveedor(5, "AgroExport Trujillo", "20678912345", "Calle E 202", "044-987654", "ventas@agroexporttrujillo.com", true));
    }
    
    // Listar proveedores
    public List<Proveedor> listarProveedores() {
        return proveedorDAO.listar();
    }

    // Buscar proveedor por ID
    public Proveedor buscarPorId(int id) {
        return proveedorDAO.buscarPorId(id);
    }

    // Registrar un nuevo proveedor (validando RUC duplicado)
    public boolean registrarProveedor(Proveedor proveedor) {
        for (Proveedor p : proveedorDAO.listar()) {
            if (p.getRuc().equals(proveedor.getRuc())) {
                System.out.println("Ya existe un proveedor con el RUC: " + proveedor.getRuc());
                return false;
            }
        }
        proveedorDAO.agregar(proveedor);
        System.out.println("Proveedor agregado: " + proveedor.getNombre());
        return true;
    }

    // Actualizar proveedor
    public void actualizarProveedor(Proveedor proveedor) {
        proveedorDAO.actualizar(proveedor);
        System.out.println("Proveedor actualizado: " + proveedor.getNombre());
    }

    // Activar / Desactivar proveedor
    public void activarDesactivarProveedor(int id) {
        Proveedor p = proveedorDAO.buscarPorId(id);
        if (p != null) {
            proveedorDAO.activarDesactivar(id);
            String estado = p.isActivo() ? "Activo" : "Inactivo";
            System.out.println("Estado cambiado: " + p.getNombre() + " ahora está " + estado);
        }
    }
}
