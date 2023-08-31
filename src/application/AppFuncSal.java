package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class AppFuncSal {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scString = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);

		List<Employee> empList = new ArrayList<>();

		System.out.print("Enter full file path: ");
		String path = scString.nextLine();

		System.out.print("Enter Salary: ");
		Double salBase = sc.nextDouble();
		
		Comparator<String> compStr = (str1, str2) -> str1.toUpperCase().compareTo(str2.toUpperCase());

		try (FileReader fr = new FileReader(path); BufferedReader br = new BufferedReader(fr)) {

			String line = br.readLine();

			while (line != null) {

				String[] fields = line.split(",");

				String tempName = fields[0];
				String tempEmail = fields[1];
				Double tempSalary = Double.parseDouble(fields[2]);

				Employee newEmp = new Employee(tempName, tempEmail, tempSalary);
				empList.add(newEmp);

				line = br.readLine();

			}
			
			List<String> salGreater = empList.stream()
			.filter(x -> x.getSalary() > salBase)
			.map(x -> x.getEmail())
			.sorted(compStr)
			.collect(Collectors.toList());
			
			System.out.println("Email of people whose salary is more than " + String.format("%.2f", salBase) + ":");
			salGreater.forEach(System.out::println);
			
			Double sumNameM = empList.stream()
			.filter(x -> x.getName().charAt(0) == 'M')
			.map(x -> x.getSalary())
			.reduce(0.0 , (x , y) -> (x + y));
			
			System.out.print("Sum of salary of people whose name starts with 'M': " + String.format("%.2f",  sumNameM));
			
		} catch (IOException e) {

			System.out.println("Error: " + e.getMessage());
		}

		sc.close();
		scString.close();

	}

}
