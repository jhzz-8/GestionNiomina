public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Empresa empresa = new Empresa();
        int opcion;

        do {
            System.out.println("\n--- SISTEMA DE NOMINA ---");
            System.out.println("1. Agregar Planta  2. Agregar Ventas  3. Agregar Temporal");
            System.out.println("4. Listar Todos    5. Buscar por Doc  6. Mayor Salario");
            System.out.println("7. Nomina Total    8. Ver Resúmenes   9. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion >= 1 && opcion <= 3) {
                System.out.print("Nombre: "); String nom = sc.nextLine();
                System.out.print("Documento: "); String doc = sc.nextLine();
                System.out.print("Edad: "); int edad = sc.nextInt();
                System.out.print("Salario Base: "); float sb = sc.nextFloat();
                System.out.print("Categoría (0:JUNIOR, 1:SEMI_SENIOR, 2:SENIOR): ");
                int catIdx = sc.nextInt();
                CategoriaEmpleado cat = CategoriaEmpleado.values()[catIdx];
                System.out.print("Salud %: "); float ds = sc.nextFloat();
                System.out.print("Pensión %: "); float dp = sc.nextFloat();

                switch (opcion) {
                    case 1 -> {
                        System.out.print("Cargo: "); sc.nextLine(); String cargo = sc.nextLine();
                        System.out.print("Horas Extra: "); int he = sc.nextInt();
                        System.out.print("Valor H.E: "); float vhe = sc.nextFloat();
                        System.out.print("Aux. Transporte: "); float at = sc.nextFloat();
                        empresa.agregarEmpleado(new EmpleadoPlanta(nom, doc, edad, sb, cat, ds, dp, cargo, he, vhe, at));
                    }
                    case 2 -> {
                        System.out.print("Ventas Totales: "); float vt = sc.nextFloat();
                        System.out.print("Comisión %: "); float pc = sc.nextFloat();
                        empresa.agregarEmpleado(new EmpleadoVentas(nom, doc, edad, sb, cat, ds, dp, vt, pc));
                    }
                    case 3 -> {
                        System.out.print("Días Trabajados: "); int dt = sc.nextInt();
                        System.out.print("Valor por Día: "); float vd = sc.nextFloat();
                        empresa.agregarEmpleado(new EmpleadoTemporal(nom, doc, edad, sb, cat, ds, dp, dt, vd));
                    }
                }
            } else if (opcion == 4) empresa.listarTodos();
            else if (opcion == 5) {
                System.out.print("Doc a buscar: "); String d = sc.next();
                Empleado e = empresa.buscarPorDoc(d);
                if (e != null) e.mostrarInformacion(); else System.out.println("No existe.");
            }
            else if (opcion == 6) {
                Empleado m = empresa.obtenerMayorSalario();
                if (m != null) m.mostrarInformacion();
            }
            else if (opcion == 7) System.out.println("Nómina Total Empresa: $" + empresa.calcularNominaTotal());
            else if (opcion == 8) empresa.mostrarResumenes();

        } while (opcion != 9);
        sc.close();
    }
}
