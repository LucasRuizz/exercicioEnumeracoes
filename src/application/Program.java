
package application;

import entitie.enums.WorkerLevel;
import entities.Department;
import entities.HourContract;
import entities.Worker;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    
    public static void main(String[] args) throws ParseException {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/aaaa");
        
        System.out.println("Entre com o nome do departamento: ");
        String departmentName = sc.nextLine();
        
        System.out.print("Entre com os dados do trabalhador: ");
        System.out.print("Nome: ");
        String workerName = sc.nextLine();
        
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        
        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();
        
        Worker worker = new Worker(workerName, WorkerLevel.valueOf
        (workerLevel), baseSalary, new Department(departmentName));
        
        System.out.print("Quantos contratos esse trabalhador vai ter?: ");
        int n = sc.nextInt();
        int i;
        
        for (i=1; i<=n; i++){
            System.out.println("Entre com os dados do contrato #" + i + ": ");
            System.out.println("Data (DD/MM/AAAA): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Valor por hora: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duração (horas): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour
            , hours);
            worker.addContract(contract);
        }
        
        System.out.println();
        System.out.println("Entre com o mês e ano para calcular o salário(MM/AAAA): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        
        System.out.println("Nome: " + worker.getName());
        System.out.println("Departamento: " + worker.getDepartment().getName());
        System.out.println("Renda do " + monthAndYear + ": " + 
        String.format("%.2f", worker.income(year, month)));
        
        
        sc.close();
    } 
}
