import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Empresa empresa = new Empresa();

        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Agregar empleado planta");
            System.out.println("2. Agregar empleado ventas");
            System.out.println("3. Agregar empleado temporal");
            System.out.println("4. Mostrar empleados");
            System.out.println("5. Buscar por documento");
            System.out.println("6. Mayor salario");
            System.out.println("7. Nómina total");
            System.out.println("8. Resumen pagos");
            System.out.println("9. Salir");

            opcion = sc.nextInt();

            try {
                switch (opcion) {

                    case 1 -> {
                        Empleado e = new EmpleadoPlanta(
                                "Juan", "123", 25,
                                2000000, CategoriaEmpleado.SENIOR,
                                4, 4,
                                "Ingeniero", 10, 20000, 140000
                        );
                        empresa.agregarEmpleado(e);
                    }

                    case 2 -> {
                        Empleado e = new EmpleadoVentas(
                                "Ana", "456", 30,
                                1500000, CategoriaEmpleado.SEMI_SENIOR,
                                4, 4,
                                5000000, 5
                        );
                        empresa.agregarEmpleado(e);
                    }

                    case 3 -> {
                        Empleado e = new EmpleadoTemporal(
                                "Luis", "789", 22,
                                0, CategoriaEmpleado.JUNIOR,
                                4, 4,
                                20, 50000
                        );
                        empresa.agregarEmpleado(e);
                    }

                    case 4 -> empresa.mostrarEmpleados();

                    case 5 -> {
                        System.out.println("Documento:");
                        String doc = sc.next();
                        Empleado e = empresa.buscarPorDocumento(doc);
                        if (e != null) e.mostrarInformacion();
                        else System.out.println("No encontrado");
                    }

                    case 6 -> {
                        Empleado e = empresa.empleadoMayorSalario();
                        if (e != null) e.mostrarInformacion();
                    }

                    case 7 -> System.out.println("Total nómina: " + empresa.nominaTotal());

                    case 8 -> empresa.mostrarResumenes();

                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 9);
    }
}
