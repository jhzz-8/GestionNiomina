import java.util.ArrayList;

public class Empresa {

    private ArrayList<Empleado> empleados = new ArrayList<>();

    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }

    public void mostrarEmpleados() {
        for (Empleado e : empleados) {
            e.mostrarInformacion();
            System.out.println("----------------");
        }
    }

    public Empleado buscarPorDocumento(String doc) {
        for (Empleado e : empleados) {
            if (e.documento.equals(doc)) {
                return e;
            }
        }
        return null;
    }

    public Empleado empleadoMayorSalario() {
        if (empleados.isEmpty()) return null;

        Empleado mayor = empleados.get(0);
        for (Empleado e : empleados) {
            if (e.calcularSalarioNeto() > mayor.calcularSalarioNeto()) {
                mayor = e;
            }
        }
        return mayor;
    }

    public float nominaTotal() {
        float total = 0;
        for (Empleado e : empleados) {
            total += e.calcularSalarioNeto();
        }
        return total;
    }

    public void mostrarResumenes() {
        for (Empleado e : empleados) {
            System.out.println(e.generarResumenPago());
        }
    }
}
