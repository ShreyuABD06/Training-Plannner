package com.trainingplanner.main;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.trainingplanner.Instructor;
import com.trainingplanner.Planner;
import com.trainingplanner.Program;
import com.trainingplanner.Requester;
import com.trainingplanner.Trainee;
import com.trainingplanner.TraineeProgram;
import com.trainingplanner.TrainingReport;

public class Manager {
	public static void main(String[] args) {
		Manager m = new Manager();
		m.start();
	}

	private void start() {
		while (true) {
			System.out.println("1:ADD Instructor");
			System.out.println("2:Get Active Instructors");
			System.out.println("3:Update Instructor(email)");
			System.out.println("4:ADD Training Program");
			System.out.println("5:List Available Training Programs:");
			System.out.println("6:Change/Update Training Program Location");
			System.out.println("7:Register Trainee To a Training Program");
			System.out.println("8:GET all Registered Trainees");
			System.out.println("9:Update Trainee");
			System.out.println("10:Get Trainees Report By training Program Id");
			System.out.println("11:Get Trainings Report");
			System.out.println("12:GEt Instructors By Id");
			System.out.println("13:Get Training Programs By Id");
			System.out.println("14:Request Training Program");
			Scanner sc = new Scanner(System.in);
			Planner c = new Planner();
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				Instructor instructor = new Instructor();
				String s = c.addInstructor(instructor);
				System.out.println("Please wait .......................... ");
				if (s != null) {
					System.out.println("Instructor : " + s);
				} else {
					System.out.println("Instructor could nOt Be Added");
				}
				break;
			case 2:
				List<Instructor> list = c.getInstrctors();
				System.out.println("Please wait .......................... ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if (list != null) {
					System.out.println("....Instructors....");
					System.out.println("*******************");
					Iterator<Instructor> itr = list.iterator();
					while (itr.hasNext()) {
						System.out.println(itr.next());
					}
				} else {
					System.out.println("No Instructors Currently Available in our plan");
				}
				break;
			case 3:
				Instructor instructor1 = new Instructor();
				instructor1 = c.updateInstructor(instructor1);
				System.out.println("Please wait .......................... ");
				System.out.println("After Update");
				System.out.println(instructor1);
				break;
			case 4:
				Program prog = new Program();
				String cr = c.addProgram(prog);
				System.out.println("Please wait .......................... ");
				if (cr != null) {
					System.out.println("Training Program = " + cr);
				} else {
					System.out.println("Program Not Added");
				}
				break;
			case 5:
				List<Program> st = c.getAllPrograms();
				System.out.println("Please wait .......................... ");
				if (st != null) {
					System.out.println("Available Programs");
					Iterator<Program> itr = st.iterator();
					while (itr.hasNext()) {
						System.out.println(itr.next());
					}
				} else {
					System.out.println("No Training Programs to Display");
				}
				break;
			case 6:
				Program p1 = new Program();
				p1 = c.updateprogram(p1);
				System.out.println("Please wait .......................... ");
				if (p1 != null) {
					System.out.println(p1);
				} else {
					System.out.println("Could NOt Update Training Program Location");
				}
				break;
			case 7:
				System.out.println("1:Register Trainee");
				System.out.println("2:Join Training");
				System.out.println("3:Exit");
				System.out.println("Enter your choice");
				int z = sc.nextInt();
				switch (z) {
				case 1:
					Trainee tr = new Trainee();
					String stu = c.registerTrainee(tr);
					System.out.println("Please wait .......................... ");
					if (stu != null) {
						System.out.println("Registered Successfully to our Portal");
						System.out.println("Student : " + stu);
					} else {
						System.out.println("Could nOt Register ....Try Again:)");
					}
					break;
				case 2:
					TraineeProgram trainee = new TraineeProgram();
					Trainee trainee1 = new Trainee();
					System.out.println("Enter Trainee Id to Register for a course");
					int tId = sc.nextInt();
					trainee1 = c.getTraineeById(tId);
					if (trainee1 != null) {
						trainee.settId(tId);
						System.out.println("Enter program Id to register");
						int progId = sc.nextInt();
						trainee.setProgId(progId);
						boolean isRegister = c.registerTraineeFortraining(tId, progId);
						System.out.println("Please wait .......................... ");
						if (isRegister) {
							System.out.println("Pay your Training fee");
							System.out.println("1:Cash   2:Card");
							int n = sc.nextInt();
							if (n == 1) {
								double fee = c.getCostByProgId(progId);
								System.out.println("Please pay rupees " + fee);
								System.out.println("Are you paying......(y/n)");
								String d = sc.next();
								if (d.equalsIgnoreCase("y")) {
									System.out.println("Joined trainee to Training Program Successfully");

								}
							}
							if (n == 2) {
								double fee = c.getCostByProgId(progId);
								System.out.println("Enter your cArd Number");
								System.out.println("Please Enter your Card Number");
								sc.nextInt();
								System.out.println("Please Wait While we confirm With the Bank");
								System.out.println("Please wait .......................... ");
								System.out.println("Rs." + fee + " Have Been Deducted From your Bank Account");
								System.out.println("Joined trainee to Training Program Successfully");
								List<TrainingReport> cR = c.getAllTrainingsDetail(progId);
								if (cR != null) {
									Iterator<TrainingReport> itr = cR.iterator();
									System.out.println("Your Bill .......................... ");
									while (itr.hasNext()) {

										System.out.println(itr.next());
									}
								} else {
									System.out.println("Sorry couldnt generate Bill");
								}
							}
							if (n != 1 && n != 2) {
								System.out.println("Invalid Choice");
							}
						} else {
							System.out.println("Sorry...!  Could Not join u to the requested Program");
							System.out.println("Try again");
						}
					} else {
						System.out.println("Register before you join a course....:)");
					}
					break;
				case 3:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice");
					break;
				}
			case 8:
				List<Trainee> list1 = c.getAllTrainees();
				System.out.println("Please wait .......................... ");
				if (list1 != null) {
					Iterator<Trainee> itr = list1.iterator();
					while (itr.hasNext()) {
						System.out.println(itr.next());
					}
				} else {
					System.out.println("No Trainees to Display");
				}
				break;
			case 9:
				Trainee trai1 = new Trainee();
				trai1 = c.updateTrainee(trai1);
				System.out.println("Please wait .......................... ");
				if (trai1 != null) {
					System.out.println(trai1);
				} else {
					System.out.println("Could not Update trainee email");
				}
				break;
			case 10:
				System.out
						.println("Enter the Training Program Id To Get trainees registered for the Training program ");
				int progId = sc.nextInt();
				List<Trainee> st1 = c.getAllTrainees(progId);
				System.out.println("Please wait .......................... ");
				if (st1 != null) {
					Iterator<Trainee> itr = st1.iterator();
					System.out.println("Registered Students of Training Program with id  " + progId);
					while (itr.hasNext()) {
						System.out.println(itr.next());
					}
				} else {
					System.out.println("No Student Registered for Course " + progId);
				}
				break;
			case 11:
				List<TrainingReport> cR = c.getAllTrainingsDetail();
				if (cR != null) {
					Iterator<TrainingReport> itr = cR.iterator();
					System.out.println("Please wait .......................... ");
					while (itr.hasNext()) {

						System.out.println(itr.next());
					}
				} else {
					System.out.println("Nothing to Report");
				}
				break;
			case 12:
				Instructor instructor3 = new Instructor();
				System.out.println("Enter Instructor Id to get Instructor");
				int instId = sc.nextInt();
				instructor3 = c.getInstructor(instId);
				System.out.println("Please wait .......................... ");
				if (instructor3 != null) {
					System.out.println(instructor3);
				} else {
					System.out.println("Instructor with id " + instId + " Not Found");
				}
				break;
			case 13:
				Program cou = new Program();
				System.out.println("Enter Training Id to get Program");
				int programId = sc.nextInt();
				cou = c.getProgramById(programId);
				System.out.println("Please wait .......................... ");
				if (cou != null) {
					System.out.println(cou);
				} else {
					System.out.println("Program with id " + programId + " notFound");
				}
				break;
			case 14:
				Requester req = new Requester();
				System.out.println("Enter Requester Name");
				String name = sc.next();
				req.setName(name);
				System.out.println("Enter phone nO");
				String phoneNo = sc.next();
				req.setPhoneNo(phoneNo);
				System.out.println("Enter Requesteing Program");
				String reqProgName = sc.next();
				req.setReqProgName(reqProgName);
				System.out.println("Enter Location Preferred");
				String location = sc.next();
				req.setLocation(location);
				System.out.println("Enter Trainees Expected");
				int yoe = sc.nextInt();
				req.setTraineesExpected(yoe);
				String re = c.addRequester(req);
				System.out.println("Please wait .......................... ");
				if (re != null) {
					System.out.println("Requester : " + re);
				} else {
					System.out.println("Requester could nOt Be Added");
				}
				Program cou1 = new Program();
				cou1 = c.getProgramByName(reqProgName);
				System.out.println("Please wait .......................... ");
				if (cou1 != null) {
					System.out.println("Here are your Requested program details");
					System.out.println(cou1);
				} else {
					System.out.println("Program with name " + reqProgName + " notFound");
					System.out.println("Please Add requested Program");
				}

				break;
			}
		}
	}
}
