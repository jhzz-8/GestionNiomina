public class EmpleadoPlanta extends Empleado {
    private String cargo;
    private int horasExtra;
    private float valorHoraExtra;
    private float auxilioTransporte;

    public EmpleadoPlanta(String nombre, String documento, int edad, float salarioBase, 
                          CategoriaEmpleado cat, float dS, float dP, 
                          String cargo, int hE, float vHE, float auxT) {
        super(nombre, documento, edad, salarioBase, cat, dS, dP);
        this.cargo = cargo;
        this.horasExtra = (hE < 0) ? 0 : hE;
        this.valorHoraExtra = (vHE < 0) ? 0 : vHE;
        this.auxilioTransporte = auxT;
    }

    @Override
    public float calcularSalarioBruto() {
        return salarioBase + calcularBonificacionCategoria() + (horasExtra * valorHoraExtra) + auxilioTransporte;
    }
}
