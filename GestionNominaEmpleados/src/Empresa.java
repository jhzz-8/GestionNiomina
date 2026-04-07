import java.util.*;
import javax.swing.JOptionPane;

public class Empresa {
    private List<Empleado> empleados = new ArrayList<>();

    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }

    public void listarTodos() {
        if (empleados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados.");
        } else {
            String lista = "--- LISTA DE EMPLEADOS ---\n";
            for (Empleado e : empleados) {
                lista += "ID: " + e.documento + " | Nombre: " + e.nombre + " | Neto: $" + e.calcularSalarioNeto() + "\n";
            }
            JOptionPane.showMessageDialog(null, lista);
        }
    }

    public Empleado buscarPorDoc(String doc) {
        for (Empleado e : empleados) {
            if (e.documento.equals(doc)) return e;
        }
        return null;
    }

    public Empleado obtenerMayorSalario() {
        if (empleados.isEmpty()) return null;
        Empleado mayor = empleados.get(0);
        for (Empleado e : empleados) {
            if (e.calcularSalarioNeto() > mayor.calcularSalarioNeto()) mayor = e;
        }
        return mayor;
    }

    public float calcularNominaTotal() {
        float total = 0;
        for (Empleado e : empleados) {
            total += e.calcularSalarioNeto();
        }
        return total;
    }

    public void mostrarResumenes() {
        if (empleados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay datos para generar resúmenes.");
            return;
        }
        String reporte = "--- RESÚMENES DE PAGO (RECORDS) ---\n";
        for (Empleado e : empleados) {
            ResumenPago r = e.generarResumenPago();
            reporte += "Empleado: " + r.nombre() + " [" + r.tipoEmpleado() + "]\n" +
                    "Bruto: $" + r.salarioBruto() + " | Descuentos: $" + r.descuentos() + "\n" +
                    "Neto a pagar: $" + r.salarioNeto() + "\n----------------------------------\n";
        }
        JOptionPane.showMessageDialog(null, reporte);
    }
}
