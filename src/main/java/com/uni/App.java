package com.uni;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.uni.dao.StudentDao;
import com.uni.entity.Student;

public class App {
	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
			StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

			Scanner sc = new Scanner(System.in);
			Student s = new Student();

			boolean flag = true;

			do {

				System.out.println();
				System.out.println("\t\t Student Operations");
				System.out.println("\t\t *********************************");
				System.out.println("\t\t 1.Create");
				System.out.println("\t\t 2.Read");
				System.out.println("\t\t 3.Update");
				System.out.println("\t\t 4.Read by Id");
				System.out.println("\t\t 5.Delete by Id");
				System.out.println("\t\t 6.Exit");
				System.out.println();
				System.out.println("\t\t ----------------------------------");
				System.out.println();
				System.out.print("\t\t Enter Choice :");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.print("\n\t\t Enter id : ");
					s.setSId(sc.nextInt());
					sc.nextLine();
					System.out.print("\t\t Enter Name : ");
					s.setSName(sc.nextLine());
					System.out.print("\t\t Enter City : ");
					s.setSCity(sc.nextLine());
					studentDao.insert(s);
					System.out.println("\t\t Student Info Inserted Successfully........!! \n");
//				System.out.println(" row effected : " + rowEffected);

					break;
				case 2:
					int count = 0;
					List<Student> allStudent = studentDao.getAllStudent();
					System.out.println(" \t\tId \t\t Name \t\t City ");
					System.out.println("\t---------------------------------------------------------");
					for (Student as : allStudent) {
						System.out.println("\t\t " + as.getSId() + "\t\t " + as.getSName() + "\t\t " + as.getSCity());
						count++;
					}
					System.out.println("\n\t\t Total Number of student : " + count);

					break;
				case 3:
					System.out.print("\n\t\t Enter id : ");
					int uId = sc.nextInt();
					sc.nextLine();
					Student uStudent = studentDao.getStudent(uId);
					System.out.print("\t\t Enter Name : ");
					uStudent.setSName(sc.nextLine());
					System.out.print("\t\t Enter City : ");
					uStudent.setSCity(sc.nextLine());
					studentDao.update(uStudent);
					System.out.println("\t\t Student Info Update Successfully........!! \n");

					break;
				case 4:
					System.out.print("\n\t\t Enter id : ");
					int id = sc.nextInt();
					sc.nextLine();
					Student studentData = studentDao.getStudent(id);
					System.out.println("\t Id : " + studentData.getSId() + " Name : " + studentData.getSName()
							+ "City : " + studentData.getSCity() + "\n");
					break;
				case 5:
					System.out.print("Enter id : ");
					int did = sc.nextInt();
					studentDao.deleteStudent(did);
					System.out.println("\t\tStudent Info Delete Successfully........!! \n");

					break;
				case 6:
					System.out.println();
					System.out.println("\n\t\t********** Thank You..!! Visit Again**********");
					flag = false;
					// System.exit(0);
					break;
				default:
					System.out.println("\n\t\t Unexpected value : " + choice);

				}

			} while (flag == true);
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
