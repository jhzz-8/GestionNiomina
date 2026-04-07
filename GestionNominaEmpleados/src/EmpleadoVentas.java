public class EmpleadoVentas extends Empleado {
    private float totalVentas;
    private float porcentajeComision;

    public EmpleadoVentas(String nombre, String documento, int edad, float salarioBase, 
                          CategoriaEmpleado categoria, float dSalud, float dPension,
                          float totalVentas, float porcentajeComision) {
        super(nombre, documento, edad, salarioBase, categoria, dSalud, dPension);
        
        this.totalVentas = totalVentas;

        if (porcentajeComision < 0 || porcentajeComision > 100) {
            System.out.println("Error: Comisión fuera de rango. Se asignará 0%.");
            this.porcentajeComision = 0;
        } else {
            this.porcentajeComision = porcentajeComision;
        }
    }

    @Override
    public float calcularSalarioBruto() { 
        float comision = totalVentas * (porcentajeComision / 100); 
        return salarioBase + calcularBonificacionCategoria() + comision;
    }
}
