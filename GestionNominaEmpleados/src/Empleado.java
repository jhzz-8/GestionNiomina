public abstract class Empleado {
    protected String nombre;
    protected String documento;
    protected int edad;
    protected float salarioBase;
    protected CategoriaEmpleado categoria;
    protected float descuentoSalud;
    protected float descuentoPension;

    public Empleado(String nombre, String documento, int edad, float salarioBase, 
                    CategoriaEmpleado categoria, float dSalud, float dPension) {
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.categoria = categoria;

        // Validaciones con mensajes en pantalla
        if (salarioBase < 0) {
            System.out.println("Error: Salario negativo. Se asignará 0.");
            this.salarioBase = 0;
        } else {
            this.salarioBase = salarioBase;
        }

        this.descuentoSalud = (dSalud < 0 || dSalud > 100) ? 0 : dSalud;
        this.descuentoPension = (dPension < 0 || dPension > 100) ? 0 : dPension;
    }

    public abstract float calcularSalarioBruto();

    public float calcularBonificacionCategoria() {
        return switch (categoria) {
            case JUNIOR -> salarioBase * 0.05f;
            case SEMI_SENIOR -> salarioBase * 0.10f;
            case SENIOR -> salarioBase * 0.15f;
        };
    }

    public float calcularDescuentos() {
        return calcularSalarioBruto() * ((descuentoSalud + descuentoPension) / 100);
    }

    public float calcularSalarioNeto() {
        return calcularSalarioBruto() - calcularDescuentos();
    }

    public ResumenPago generarResumenPago() {
        return new ResumenPago(
            documento, 
            nombre, 
            this.getClass().getSimpleName(),
            calcularSalarioBruto(), 
            calcularDescuentos(), 
            calcularSalarioNeto()
        );
    }

    public void mostrarInformacion() {
        System.out.println("ID: " + documento + " | Nombre: " + nombre + " | Neto: $" + calcularSalarioNeto());
    }
}
