package fecha;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

public class Fechas{
    public static void main(String[] args) {
        
        // Crear una fecha específica usando números (15-11-2001)
        LocalDate birthday = LocalDate.of(2001, 11, 15);
        System.out.println("Birthday: " + birthday);
        System.out.println("Año: " + birthday.getYear());
        System.out.println("Mes: " + birthday.getMonth());
        System.out.println("Día: " + birthday.getDayOfMonth());

       
        LocalDate anotherDate = LocalDate.of(2001, Month.NOVEMBER, 15);
        System.out.println("Another date: " + anotherDate);

        // Capturar la fecha actual
        LocalDate today = LocalDate.now();
        
      
        // Crear un tiempo específico (hora, minuto, segundo, nanosegundo)
        LocalTime time1 = LocalTime.of(5, 30, 45, 35);
        System.out.println("Hora específica: " + time1);
        System.out.println("Hora: " + time1.getHour());
        System.out.println("Minuto: " + time1.getMinute());
        System.out.println("Segundo: " + time1.getSecond());
        System.out.println("Nanosegundo: " + time1.getNano());

        // Crear un tiempo solo con hora y minuto
        LocalTime time2 = LocalTime.of(14, 20);
        System.out.println("Hora y minuto: " + time2);

        // Capturar la hora actual
        LocalTime now = LocalTime.now();
        System.out.println("Hora actual: " + now);
    }
}
