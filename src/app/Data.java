package app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Data {
    public static void main(String[] args) throws Exception {
        LocalDate hoje = LocalDate.now();
        // System.out.println(hoje);
        
        LocalDate olimpidasRio = LocalDate.of(2020, Month.JUNE, 5);
        
        // int anos = olimpidasRio.getYear() - hoje.getYear();
        // System.out.println(anos);
        
        Period periodo = Period.between(hoje, olimpidasRio);
        System.out.println(periodo);
        
        LocalDate proximasOlimpiadas = olimpidasRio.plusYears(4);
        // System.out.println(proximasOlimpiadas);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("ddMMyyyy");
        System.out.println(formatador.format(proximasOlimpiadas));
        
        DateTimeFormatter formatadorComHora = DateTimeFormatter.ofPattern("ddMMyyyy hh:mm");
        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora.format(formatadorComHora));
        
        LocalTime intervalo = LocalTime.of(15, 30);
        System.out.println(intervalo);
    }
}