package edu.UPAO.proyecto.Service;

import edu.UPAO.proyecto.DAO.ProveedorDAO;
import edu.UPAO.proyecto.Modelo.Proveedor;
import java.util.List;

public class ProveedorService {

    private ProveedorDAO proveedorDAO = new ProveedorDAO();

    public ProveedorService() {
        // Datos de prueba (ID se asigna automático en el DAO)
        registrarProveedor(new Proveedor("Distribuidora Norte SAC", "20123456789", "Calle A 123", "044-123456", "contacto@nortesac.com", "Carlos Díaz", true));
        registrarProveedor(new Proveedor("Servicios Industriales del Sur", "20987654321", "Av. B 456", "054-654321", "ventas@indsur.com", "María López", true));
        registrarProveedor(new Proveedor("Insumos Médicos Andinos", "20456789123", "Jr. C 789", "01-4567890", "soporte@insumed.com", "José Ramos", false));
        registrarProveedor(new Proveedor("TecnoGlobal Importaciones", "20111222334", "Av. D 101", "01-7654321", "info@tecnoglobal.pe", "Ana Torres", true));
        registrarProveedor(new Proveedor("AgroExport Trujillo", "20678912345", "Calle E 202", "044-987654", "ventas@agroexporttrujillo.com", "Luis Gómez", true));
    }

    // Listar proveedores
    public List<Proveedor> listarProveedores() {
        return proveedorDAO.listar();
    }

    // Buscar proveedor por ID
    public Proveedor buscarPorId(int id) {
        return proveedorDAO.buscarPorId(id);
    }

    // Buscar proveedor por nombre
    public Proveedor buscarPorNombre(String nombre) {
        return proveedorDAO.listar().stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    // Registrar un nuevo proveedor (validando RUC duplicado y formato)
    public boolean registrarProveedor(Proveedor proveedor) {
        if (!proveedor.getRuc().matches("\\d{11}")) {
            System.out.println("El RUC debe tener 11 dígitos numericos.");
            return false;
        }
        if (proveedorDAO.buscarPorRuc(proveedor.getRuc()) != null) {
            System.out.println("Ya existe un proveedor con el RUC: " + proveedor.getRuc());
            return false;
        }
        proveedorDAO.agregar(proveedor);
        System.out.println("Proveedor agregado: " + proveedor.getNombre());
        return true;
    }

    // Actualizar proveedor
    public boolean actualizarProveedorCampos(int id, String nombre, String ruc, String telefono,
            String correo, String direccion, String contactoPrincipal) {
        Proveedor proveedor = proveedorDAO.buscarPorId(id);
        if (proveedor == null) {
            System.out.println("No se encontro un proveedor con ID: " + id);
            return false;
        }

        try {
            proveedorDAO.actualizarCampos(id, nombre, ruc, telefono, correo, direccion, contactoPrincipal);
            System.out.println("Proveedor actualizado parcialmente (ID " + id + ")");
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Error al actualizar proveedor: " + e.getMessage());
            return false;
        }
    }

    // Activar / Desactivar proveedor
    public void activarDesactivarProveedor(int id) {
        Proveedor p = proveedorDAO.buscarPorId(id);
        if (p != null) {
            proveedorDAO.cambiarEstado(id, !p.isActivo());
            String estado = p.isActivo() ? "Activo" : "Inactivo";
            System.out.println("Estado cambiado: " + p.getNombre() + " ahora esta " + estado);
        }
    }
}
