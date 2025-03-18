package org.uniquindio.edu.co.poo.app;

import org.uniquindio.edu.co.poo.model.Estudiante;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //se crea el scanner

        System.out.println("Ingrese el nombre del estudiante: ");
        String nombres = scanner.nextLine();

        System.out.println("Ingrese el apellido del estudiante: ");
        String apellidos = scanner.nextLine();

        System.out.println("Ingrese el ID del estudiante: ");
        String numeroIdentificacion = scanner.nextLine();

        System.out.println("Ingrese el edad del estudiante: ");
        byte edad = Byte.parseByte(scanner.nextLine());

        System.out.println("Ingrese el correo del estudiante: ");
        String correo = scanner.nextLine();

        System.out.println("Ingrese el telefono del estudiante: ");
        String telefono = scanner.nextLine();

        Estudiante estudiante1 = new Estudiante(nombres, apellidos, numeroIdentificacion,
                correo,telefono, edad);

        System.out.println("\n Informacion del estudiante: ");
        System.out.println(estudiante1);


    }
}

