package com.jpdevv.schoolsys.presentation.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpdevv.schoolsys.business.dto.DisciplineDTO;
import com.jpdevv.schoolsys.business.dto.StudentDTO;
import com.jpdevv.schoolsys.business.services.IOService;
import com.jpdevv.schoolsys.presentation.controller.DisciplineController;
import com.jpdevv.schoolsys.presentation.controller.StudentController;

@Component
public class Menu {
    /* 
     * There is still a need to create the methods to enroll students in a discipline
     * and to unenroll them from a discipline.
    */

    @Autowired
    private IOService ioService;
    @Autowired
    private StudentController studentController;
    @Autowired
    private DisciplineController disciplineController;

    public void displayMainMenu() {
        ioService.print("--------------- SCHOOL SYSTEM ---------------");
        ioService.print("1 - Register Discipline");
        ioService.print("2 - Register Student");
        ioService.print("3 - Enroll Student in Discipline");
        ioService.print("4 - Delete Discipline");
        ioService.print("5 - Delete Student");
        ioService.print("6 - Unenroll Student from Discipline");
        ioService.print("7 - Update Discipline");
        ioService.print("8 - Update Student");
        ioService.print("9 - List");
        ioService.print("0 - Exit");
        String option = ioService.read("Choose an option: ");

        switch(option) {
            case "0" -> {
                ioService.print("Exiting the application. Goodbye!");
                System.exit(0);
            }
            case "1" -> showRegisterDiscipline();
            case "2" -> showRegisterStudent();
            case "4" -> showDeleteDiscipline();
            case "5" -> showDeleteStudent();
            case "7" -> showUpdateDiscipline();
            case "8" -> showUpdateStudent();
            case "9" -> showListMenu();
            default -> {
                ioService.print("[ERROR] - Invalid option. Please try again.");
                displayMainMenu();
            }
        }
    }

    public void showRegisterStudent() {
        ioService.print("--------------- REGISTER STUDENT ---------------");
        String registration = ioService.read("Student registration: ");
        String name = ioService.read("Student name: ");
        String email = ioService.read("Student email: ");
        String address = ioService.read("Student address: ");

        StudentDTO student = new StudentDTO(registration, name, email, address);
        String result = studentController.addStudent(student);
        ioService.print(result);
        displayMainMenu();
    }

    public void showDeleteStudent() {
        ioService.print("--------------- DELETE STUDENT ---------------");
        String registration = ioService.read("Student registration: ");

        String result = studentController.deleteStudent(registration);
        ioService.print(result);
        displayMainMenu();
    }

    public void showUpdateStudent() {
        ioService.print("--------------- UPDATE STUDENT ---------------");
        ioService.print("If you do not want to change any item below, leave it blank.");
        String registration = ioService.read("Student registration: ");
        String name = ioService.read("New student name: ");
        String email = ioService.read("New student email: ");
        String address = ioService.read("New student address: ");

        StudentDTO student = new StudentDTO(registration, name, email, address);
        String result = studentController.updateStudent(student);
        ioService.print(result);
        displayMainMenu();
    }

    public void showRegisterDiscipline() {
        ioService.print("--------------- REGISTER DISCIPLINE ---------------");
        String code = ioService.read("Discipline code: ");
        String name = ioService.read("Discipline name: ");
        String workload = ioService.read("Maximum number of students: ");

        DisciplineDTO discipline = new DisciplineDTO(code, name, workload);
        String result = disciplineController.addDiscipline(discipline);
        ioService.print(result);
        displayMainMenu();
    }

    public void showDeleteDiscipline() {
        ioService.print("--------------- DELETE DISCIPLINE ---------------");
        String code = ioService.read("Discipline code: ");

        String result = disciplineController.deleteDiscipline(code);
        ioService.print(result);
        displayMainMenu();
    }

    public void showUpdateDiscipline() {
        ioService.print("--------------- UPDATE DISCIPLINE ---------------");
        ioService.print("If you do not want to change any item below, leave it blank.");
        String code = ioService.read("Discipline code: ");
        String name = ioService.read("New discipline name: ");
        String workload = ioService.read("New maximum number of students: ");

        DisciplineDTO discipline = new DisciplineDTO(code, name, workload);
        String result = disciplineController.updateDiscipline(discipline);
        ioService.print(result);
        displayMainMenu();
    }

    public void showListMenu() {
        ioService.print("--------------- LIST MENU ---------------");
        ioService.print("1 - List Students");
        ioService.print("2 - List Disciplines");
        ioService.print("0 - Back to Main Menu");
        String option = ioService.read("Choose an option: ");

        switch(option) {
            case "0" -> displayMainMenu();
            case "1" -> {
                List<StudentDTO> result = studentController.getAllStudents();
                StringBuilder sb = new StringBuilder("Registered Students:\n");
                for (StudentDTO student : result) {
                    sb.append(student.toString()).append("\n");
                }
                ioService.print(sb.toString());
                showListMenu();
            }
            case "2" -> {
                List<DisciplineDTO> result = disciplineController.getAllDisciplines();
                StringBuilder sb = new StringBuilder("Registered Disciplines:\n");
                for (DisciplineDTO discipline : result) {
                    sb.append(discipline.toString()).append("\n");
                    for (StudentDTO student : discipline.getStudents()) {
                        if (discipline.getStudents().isEmpty()) {
                            sb.append("    - No students enrolled.\n");
                            break;
                        } else {
                            sb.append("    - ").append(student.toString()).append("\n");
                        }
                    }
                }
                ioService.print(sb.toString());
                showListMenu();
            }
            default -> {
                ioService.print("[ERROR] - Invalid option. Please try again.");
                showListMenu();
            }
        }
    }
}
