import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Consulta consulta = new Consulta();
        Scanner teclado = new Scanner(System.in);
        Scanner salir = new Scanner(System.in);
        var opcion = 20;
        List<Conversion> historial = new ArrayList<>();
        var menu = """
                ****************************************************************
                
                Lista de divisas disponibles:
                
                AED - United Arab Emirates Dirham, United Arab Emirates
                ARS - Argentine Peso, Argentina
                AUD - Australian Dollar, Australia
                BRL - Brazilian Real, Brazil
                CAD - Canadian Dollar, Canada
                CHF - Swiss Franc, Switzerland
                CLP - Chilean Peso, Chile
                CNY - Chinese Yuan, China
                COP - Colombian Peso, Colombia
                EUR - Euro, European Union
                GBP - Pound Sterling, United Kingdom
                INR - Indian Rupee, India
                JPY - Japanese Yen, Japan
                KRW - South Korean Won, South Korea
                MXN - Mexican Peso, Mexico
                NZD - New Zealand Dollar, New Zealand
                PEN - Peruvian Sol, Peru
                QAR - Qatar Rial, Qatar
                RUB - Russian Ruble, Russia
                SAR - Saudi Riyal, Saudi Arabia
                SGD - Singapore Dollar, Singapore
                THB - Tai Bath, Thailand
                TRY - Turkish Lira, Turkey
                TDW - New Taiwan Dollar, Taiwan
                UAH - Ukrainian Hryvnia, Ukraine
                USD - United States Dollar, United States
                UYU - Uruguay Peso, Uruguay
                ZAR - South African Rand, South Africa
                
                ****************************************************************

                """;
        while (opcion != 0){
            System.out.println("Para utilizar el conversor de monedas presiona 1 o 0 para salir");
            opcion = salir.nextInt();
            salir.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println(menu);
                    System.out.println("Escribe el codigo de la divisa que deseas convertir, en mayusculas y sin espacios:");
                    var baseb = teclado.nextLine();
                    System.out.println("A que divisa la deseas convertir?, tambien en mayusculas y sin espacios");
                    var objetivo = teclado.nextLine();
                    System.out.println("Escribe el monto a convertir, sin decimales.");
                    var monto = teclado.nextInt();
                    teclado.nextLine();
                    Conversion resultado = consulta.convierte(baseb, objetivo, monto);
                    historial.add(resultado);
                    System.out.println("Monto convertido: "+resultado.conversion_result());
                    opcion = -1;
                    break;
                case 0:
                    GeneradorGson generar = new GeneradorGson();
                    try {
                        generar.guardarJson(historial);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(historial);
                    System.out.println("Finalizando Aplicacion");
                    break;
                default:
                    System.out.println("Opción no válida, inténtelo nuevamente");
            }
        }
    }
}