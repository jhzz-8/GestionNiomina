public class EmpleadoVentas extends Empleado {
    private float totalVentas;
    private float porcentajeComision;

    public EmpleadoVentas(String nombre, String documento, int edad, float salarioBase, 
                          CategoriaEmpleado cat, float dS, float dP, 
                          float tVentas, float pComision) {
        super(nombre, documento, edad, salarioBase, cat, dS, dP);
        this.totalVentas = tVentas;
        this.porcentajeComision = (pComision < 0 || pComision > 100) ? 0 : pComision;
    }

    @Override
    public float calcularSalarioBruto() {
        return salarioBase + calcularBonificacionCategoria() + (totalVentas * porcentajeComision / 100);
    }
}
