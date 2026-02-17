package agenda;

import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contacto> contactos;
    private int capacidad;

    public Agenda() {
        this(10);
    } // constructor para crear la agenda con capacidad para 10 contactos.

    public Agenda(int capacidad) {
        this.capacidad = capacidad; // Capacidad máxima
        this.contactos = new ArrayList<>(); // inicializa la lista de contactos vacía
    }

    public String añadirContacto(Contacto c) {
        if (agendaLlena()) {
            return "La agenda está llena. No se puede añadir más contactos.";
        }

        for (Contacto contacto : contactos) {
            if (contacto.equals(c)) {
                if (contacto.getTelefono().equals(c.getTelefono())) {
                    return "El contacto ya existe (mismo nombre, apellido y teléfono).";
                } else {
                    contacto.setTelefono(c.getTelefono());
                    return "Teléfono actualizado.";
                }
            }
        }

        contactos.add(c);
        return "Contacto añadido correctamente.";
    } // <-- ESTA LLAVE ESTABA MAL

    public boolean existeContacto(Contacto c) {
        return contactos.contains(c);
    }

    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            System.out.println("Lista de contactos:");
            for (Contacto c : contactos) {
                System.out.println(c);
            }
        }
    }

    /**
     * Busca un contacto por nombre y apellido.
     */
    public void buscaContacto(String nombre, String apellido) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                System.out.println("Teléfono de " + nombre + " " + apellido + ": " + c.getTelefono());
                return;
            }
        }
        System.out.println("No se encontró ningún contacto con ese nombre y apellido.");
    }

    // Eliminar un contacto
    public void eliminarContacto(Contacto c) {
        if (contactos.remove(c)) {
            System.out.println("Contacto eliminado correctamente.");
        } else {
            System.out.println("El contacto no existe, no se pudo eliminar.");
        }
    }

    public boolean agendaLlena() {
        return contactos.size() >= capacidad;
    }

    public int espaciosLibres() {
        return capacidad - contactos.size();
    }

    // Para la UI
    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public int espacioLibre() {
        return espaciosLibres();
    }
}