import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final double PI = 3.1416;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tipoFigura, operacion;
        boolean continuar = true;
        ArrayList<String> operacionesRealizadas = new ArrayList<>();
        ArrayList<Double> resultadosOperaciones = new ArrayList<>();

        while (continuar) {
            System.out.println("\nCalculadora Geométrica");
            System.out.println("\nOpciones de figuras geométricas: ");
            System.out.println("\n1. Círculo");
            System.out.println("\n2. Cuadrado");
            System.out.println("\n3. Triángulo");
            System.out.println("\n4. Rectángulo");
            System.out.println("\n5. Pentágono");

            System.out.print("\nSeleccione el tipo de figura que desea calcular: ");
            tipoFigura = scanner.nextInt();

            System.out.print("\n¿Qué operación desea realizar? \n\n1. para medir Area \n2. para medir el perímetro");
            operacion = scanner.nextInt();

            double[] resultados;
            String operacionRealizada;

            switch (tipoFigura) {
                case 1:
                    resultados = calcularCirculo(scanner, operacion);
                    operacionRealizada = operacion == 1 ? "Área de Círculo" : "Perímetro de Círculo";
                    break;
                case 2:
                    resultados = calcularCuadrado(scanner, operacion);
                    operacionRealizada = operacion == 1 ? "Área de Cuadrado" : "Perímetro de Cuadrado";
                    break;
                case 3:
                    resultados = calcularTriangulo(scanner, operacion);
                    operacionRealizada = operacion == 1 ? "Área de Triángulo" : "Perímetro de Triángulo";
                    break;
                case 4:
                    resultados = calcularRectangulo(scanner, operacion);
                    operacionRealizada = operacion == 1 ? "Área de Rectángulo" : "Perímetro de Rectángulo";
                    break;
                case 5:
                    resultados = calcularPentagono(scanner, operacion);
                    operacionRealizada = operacion == 1 ? "Área de Pentágono" : "Perímetro de Pentágono";
                    break;
                default:
                    System.out.println("\nOPCIÓN INVALIDA.");
                    continue;
            }

            if (resultados != null) {
                System.out.println("Resultado de " + operacionRealizada + ":");
                for (double resultado : resultados) {
                    System.out.println(String.format("%.2f", resultado));
                    resultadosOperaciones.add(resultado);
                }
                operacionesRealizadas.add(operacionRealizada);
            }

            System.out.print("\n¿Desea realizar otra operación? (Si/No): ");
            String respuesta = scanner.next();

            if (respuesta.equalsIgnoreCase("No")) {
                continuar = false;
            }
        }

        // Imprimir operaciones realizadas al final
        System.out.println("\nOperaciones realizadas:");
        for (int i = 0; i < operacionesRealizadas.size(); i++) {
            System.out.println(operacionesRealizadas.get(i) + ": " + String.format("%.2f", resultadosOperaciones.get(i)));
        }
    }

    public static double[] calcularCirculo(Scanner scanner, int operacion) {
        System.out.print("\nIngresa el radio del círculo: ");
        double radio = scanner.nextDouble();
        double resultado = 0;
        if (operacion == 1) {
            resultado = PI * radio * radio;
        } else {
            resultado = 2 * PI * radio;
        }
        return new double[]{resultado};
    }

    public static double[] calcularCuadrado(Scanner scanner, int operacion) {
        System.out.print("\nIngresa la longitud del lado del cuadrado: ");
        double lado = scanner.nextDouble();
        double resultado = 0;
        if (operacion == 1) {
            resultado = lado * lado;
        } else {
            resultado = 4 * lado;
        }
        return new double[]{resultado};
    }

    public static double[] calcularTriangulo(Scanner scanner, int operacion) {
        double resultado = 0;
        if (operacion == 1) {
            System.out.print("\nIngresa la base y la altura del triángulo (separados por un espacio): ");
            double base = scanner.nextDouble();
            double altura = scanner.nextDouble();
            resultado = 0.5 * base * altura;
        } else {
            System.out.print("\nIngresa la longitud de los tres lados del triángulo (separados por un espacio): ");
            double lado1 = scanner.nextDouble();
            double lado2 = scanner.nextDouble();
            double lado3 = scanner.nextDouble();
            resultado = lado1 + lado2 + lado3;
        }
        return new double[]{resultado};
    }

    public static double[] calcularRectangulo(Scanner scanner, int operacion) {
        double resultado = 0;
        if (operacion == 1) {
            System.out.print("\nIngresa la longitud y el ancho del rectángulo (separados por un espacio): ");
            double longitud = scanner.nextDouble();
            double ancho = scanner.nextDouble();
            resultado = longitud * ancho;
        } else {
            System.out.print("\nIngresa la longitud y el ancho del rectángulo (separados por un espacio): ");
            double longitud = scanner.nextDouble();
            double ancho = scanner.nextDouble();
            resultado = 2 * (longitud + ancho);
        }
        return new double[]{resultado};
    }

    public static double[] calcularPentagono(Scanner scanner, int operacion) {
        double resultado = 0;
        if (operacion == 1) {
            System.out.print("\nIngresa la longitud de un lado del pentágono: ");
            double lado = scanner.nextDouble();
            resultado = 0.5 * lado * lado * (2.2361 + 5) * 0.2;
        } else {
            System.out.print("\nIngresa la longitud de un lado del pentágono: ");
            double lado = scanner.nextDouble();
            resultado = 5 * lado;
        }
        return new double[]{resultado};
    }
}