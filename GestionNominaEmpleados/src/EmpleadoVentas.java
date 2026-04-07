public class EmpleadoVentas extends Empleado {
    private float totalVentas;
    private float porcentajeComision;

    public EmpleadoVentas(String nombre, String documento, int edad, float salarioBase, 
                          CategoriaEmpleado categoria, float dSalud, float dPension,
                          float totalVentas, float porcentajeComision) {
        super(nombre, documento, edad, salarioBase, categoria, dSalud, dPension);
        
        this.totalVentas = totalVentas;

        // Validación de porcentaje de comisión (0 a 100) [cite: 85]
        if (porcentajeComision < 0 || porcentajeComision > 100) {
            System.out.println("Error: Comisión fuera de rango. Se asignará 0%.");
            this.porcentajeComision = 0;
        } else {
            this.porcentajeComision = porcentajeComision;
        }
    }

    @Override
    public float calcularSalarioBruto() { [cite: 60]
        float comision = totalVentas * (porcentajeComision / 100); [cite: 65]
        return salarioBase + calcularBonificacionCategoria() + comision; [cite: 61, 62, 63]
    }
}
