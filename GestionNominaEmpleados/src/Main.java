import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        int opcion = 0;

        String menu = "1. Agregar Planta\n2. Agregar Ventas\n3. Agregar Temporal\n" +
                "4. Listar Todos\n5. Buscar por Doc\n6. Mayor Salario\n" +
                "7. Nomina Total\n8. Ver Resúmenes\n9. Salir";

        while (opcion != 9) {
            String input = JOptionPane.showInputDialog(null, menu, "Menú de Nómina", JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                opcion = 9;
            } else {
                opcion = Integer.parseInt(input);
            }

            if (opcion >= 1 && opcion <= 3) {
                String nom = JOptionPane.showInputDialog("Nombre:");
                String doc = JOptionPane.showInputDialog("Documento:");
                int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
                float sb = Float.parseFloat(JOptionPane.showInputDialog("Salario Base:"));
                int catIdx = Integer.parseInt(JOptionPane.showInputDialog("Categoría (0:JUNIOR, 1:SEMI_SENIOR, 2:SENIOR):"));
                CategoriaEmpleado cat = CategoriaEmpleado.values()[catIdx];
                float ds = Float.parseFloat(JOptionPane.showInputDialog("Salud %:"));
                float dp = Float.parseFloat(JOptionPane.showInputDialog("Pensión %:"));

                if (opcion == 1) {
                    String cargo = JOptionPane.showInputDialog("Cargo:");
                    int he = Integer.parseInt(JOptionPane.showInputDialog("Horas Extra:"));
                    float vhe = Float.parseFloat(JOptionPane.showInputDialog("Valor H.E:"));
                    float at = Float.parseFloat(JOptionPane.showInputDialog("Auxilio Transporte:"));
                    empresa.agregarEmpleado(new EmpleadoPlanta(nom, doc, edad, sb, cat, ds, dp, cargo, he, vhe, at));
                } else if (opcion == 2) {
                    float vt = Float.parseFloat(JOptionPane.showInputDialog("Ventas Totales:"));
                    float pc = Float.parseFloat(JOptionPane.showInputDialog("Comisión %:"));
                    empresa.agregarEmpleado(new EmpleadoVentas(nom, doc, edad, sb, cat, ds, dp, vt, pc));
                } else if (opcion == 3) {
                    int dt = Integer.parseInt(JOptionPane.showInputDialog("Días Trabajados:"));
                    float vd = Float.parseFloat(JOptionPane.showInputDialog("Valor Día:"));
                    empresa.agregarEmpleado(new EmpleadoTemporal(nom, doc, edad, sb, cat, ds, dp, dt, vd));
                }
            } else if (opcion == 4) {
                empresa.listarTodos();
            } else if (opcion == 5) {
                String d = JOptionPane.showInputDialog("Doc a buscar:");
                Empleado e = empresa.buscarPorDoc(d);
                if (e != null) e.mostrarInformacion();
                else JOptionPane.showMessageDialog(null, "No encontrado");
            } else if (opcion == 6) {
                Empleado m = empresa.obtenerMayorSalario();
                if (m != null) m.mostrarInformacion();
            } else if (opcion == 7) {
                JOptionPane.showMessageDialog(null, "Total Nómina: $" + empresa.calcularNominaTotal());
            } else if (opcion == 8) {
                empresa.mostrarResumenes();
            }
        }
    }
}
