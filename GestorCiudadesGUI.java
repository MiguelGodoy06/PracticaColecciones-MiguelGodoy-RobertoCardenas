import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class GestorCiudadesGUI {

    private static Set<Ciudad> ciudades = new HashSet<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> crearInterfaz());
    }

    private static void crearInterfaz() {
        JFrame frame = new JFrame("Gestor de Ciudades");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnAñadir = new JButton("Añadir ciudad");
        JButton btnListar = new JButton("Listar ciudades");
        JButton btnBuscar = new JButton("Buscar ciudad");
        JButton btnSalir = new JButton("Salir");

        btnAñadir.addActionListener(e -> añadirCiudad());
        btnListar.addActionListener(e -> listarCiudades());
        btnBuscar.addActionListener(e -> buscarCiudad());
        btnSalir.addActionListener(e -> System.exit(0));

        frame.add(btnAñadir);
        frame.add(btnListar);
        frame.add(btnBuscar);
        frame.add(btnSalir);

        frame.setLocationRelativeTo(null); // Centra la ventana
        frame.setVisible(true);
    }

    private static void añadirCiudad() {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre de la ciudad:");
            if (nombre == null) return;
            String pais = JOptionPane.showInputDialog("País:");
            if (pais == null) return;
            String entrada = JOptionPane.showInputDialog("Número de habitantes (puedes escribir '2 millones', '18 mil', etc.):");
            if (entrada == null) return;

            int habitantes = interpretarNumeroHabitantes(entrada);

            Ciudad nueva = new Ciudad(nombre, pais, habitantes);
            if (ciudades.add(nueva)) {
                JOptionPane.showMessageDialog(null, "Ciudad añadida correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "La ciudad ya existe en la colección.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Entrada no válida para el número de habitantes.");
        }
    }

    private static void listarCiudades() {
        if (ciudades.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ciudades registradas.");
            return;
        }

        List<Ciudad> listaOrdenada = new ArrayList<>(ciudades);
        listaOrdenada.sort(Comparator.comparingInt(Ciudad::getHabitantes));

        StringBuilder sb = new StringBuilder("Ciudades registradas:\n");
        for (Ciudad c : listaOrdenada) {
            sb.append(c).append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void buscarCiudad() {
        String nombre = JOptionPane.showInputDialog("Nombre de la ciudad:");
        if (nombre == null) return;
        String pais = JOptionPane.showInputDialog("País:");
        if (pais == null) return;

        for (Ciudad c : ciudades) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getPais().equalsIgnoreCase(pais)) {
                JOptionPane.showMessageDialog(null, "Ciudad encontrada: " + c.getNombre() + ", " + c.getPais() + " (" + c.getHabitantes() + " habitantes)");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Ciudad no encontrada.");
    }

    private static int interpretarNumeroHabitantes(String entrada) {
        entrada = entrada.toLowerCase().replace(",", ".").trim();

        if (entrada.matches(".*millones?.*")) {
            entrada = entrada.replace("millones", "").replace("millón", "").trim();
            double numero = Double.parseDouble(entrada);
            return (int) (numero * 1_000_000);
        } else if (entrada.contains("mil")) {
            entrada = entrada.replace("mil", "").trim();
            double numero = Double.parseDouble(entrada);
            return (int) (numero * 1_000);
        } else {
            return Integer.parseInt(entrada.replace(".", ""));
        }
    }
}

class Ciudad {
    private String nombre;
    private String pais;
    private int habitantes;

    public Ciudad(String nombre, String pais, int habitantes) {
        this.nombre = nombre;
        this.pais = pais;
        this.habitantes = habitantes;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public int getHabitantes() {
        return habitantes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ciudad)) return false;
        Ciudad ciudad = (Ciudad) o;
        return nombre.equalsIgnoreCase(ciudad.nombre) && pais.equalsIgnoreCase(ciudad.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase(), pais.toLowerCase());
    }

    @Override
    public String toString() {
        return nombre + "," + pais + "(" + String.format("%,d", habitantes).replace(',', '.') + ")";
    }
}
