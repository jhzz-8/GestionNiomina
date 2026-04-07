import java.util.*;

class Empresa {
    private List<Empleado> empleados = new ArrayList<>();

    public void agregarEmpleado(Empleado e) { empleados.add(e); }
    
    public void listarTodos() { 
        if(empleados.isEmpty()) System.out.println("No hay empleados.");
        else empleados.forEach(Empleado::mostrarInformacion); 
    }

    public Empleado buscarPorDoc(String doc) {
        return empleados.stream().filter(e -> e.documento.equals(doc)).findFirst().orElse(null);
    }

    public Empleado obtenerMayorSalario() {
        return empleados.stream().max(Comparator.comparing(Empleado::calcularSalarioNeto)).orElse(null);
    }

    public float calcularNominaTotal() {
        return (float) empleados.stream().mapToDouble(Empleado::calcularSalarioNeto).sum();
    }

    public void mostrarResumenes() {
        empleados.forEach(e -> System.out.println(e.generarResumenPago()));
    }
}
