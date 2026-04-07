public class EmpleadoTemporal extends Empleado {
    private int diasTrabajados;
    private float valorDia;

    public EmpleadoTemporal(String nombre, String documento, int edad, float salarioBase, 
                            CategoriaEmpleado cat, float dS, float dP, 
                            int diasT, float vDia) {
        super(nombre, documento, edad, salarioBase, cat, dS, dP);
        this.diasTrabajados = (diasT < 0) ? 0 : diasT;
        this.valorDia = (vDia < 0) ? 0 : vDia;
    }

    @Override
    public float calcularSalarioBruto() {
        return (diasTrabajados * valorDia) + calcularBonificacionCategoria();
    }
}
