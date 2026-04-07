public abstract class Empleado {
    protected String nombre;
    protected String documento;
    protected int edad;
    protected float salarioBase;
    protected CategoriaEmpleado categoria;
    protected float descuentoSalud;
    protected float descuentoPension;

    public Empleado(String nombre, String documento, int edad, float salarioBase, 
                    CategoriaEmpleado categoria, float descuentoSalud, float descuentoPension) {
        
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.categoria = categoria;

        // Validación de salario base [cite: 81]
        if (salarioBase < 0) {
            System.out.println("Error: El salario base no puede ser negativo. Se asignará 0.");
            this.salarioBase = 0;
        } else {
            this.salarioBase = salarioBase;
        }

        // Validación de descuentos (0 a 100) [cite: 83, 84]
        if (descuentoSalud < 0 || descuentoSalud > 100) {
            System.out.println("Error: Descuento de salud inválido. Se asignará 0%.");
            this.descuentoSalud = 0;
        } else {
            this.descuentoSalud = descuentoSalud;
        }

        if (descuentoPension < 0 || descuentoPension > 100) {
            System.out.println("Error: Descuento de pensión inválido. Se asignará 0%.");
            this.descuentoPension = 0;
        } else {
            this.descuentoPension = descuentoPension;
        }
    }

    public abstract float calcularSalarioBruto(); [cite: 27]

    public float calcularBonificacionCategoria() {
        // Lógica de bonificación según categoría [cite: 37, 38, 39]
        return switch (categoria) {
            case JUNIOR -> salarioBase * 0.05f;
            case SEMI_SENIOR -> salarioBase * 0.10f;
            case SENIOR -> salarioBase * 0.15f;
        };
    }

    public float calcularDescuentos() { [cite: 29]
        float bruto = calcularSalarioBruto();
        return bruto * ((descuentoSalud + descuentoPension) / 100);
    }

    public float calcularSalarioNeto() { [cite: 30]
        return calcularSalarioBruto() - calcularDescuentos();
    }

    public ResumenPago generarResumenPago() { [cite: 101]
        return new ResumenPago(
            this.documento,
            this.nombre,
            this.getClass().getSimpleName(),
            calcularSalarioBruto(),
            calcularDescuentos(),
            calcularSalarioNeto()
        );
    }
}
