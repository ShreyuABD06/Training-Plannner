package com.trainingplanner;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Planner {

	DBInteractions db = new DBInteractions();
	Scanner sc = new Scanner(System.in);

	public Instructor findInstructor(String name, String email) {
		Instructor instructor = new Instructor();
		instructor = db.findInstructor(name, email);
		if (instructor != null) {
			return instructor;
		} else {
			return null;
		}
	}

	public String addInstructor(Instructor instructor) {
		System.out.println("Enter Instructor Name");
		String name = sc.next();
		instructor.setName(name);
		System.out.println("Enter Email");
		String email = sc.next();
		instructor.setEmail(email);
		System.out.println("Enter Years of Experience");
		int yoe = sc.nextInt();
		instructor.setYearsExp(yoe);
		String s = db.addInstructor(instructor);
		if (s != null) {
			System.out.println("Instructor successfuly Added");
			return s;
		} else {
			return null;
		}
	}

	public List<Instructor> getInstrctors() {
		List<Instructor> instList = db.getInstrctors();
		if (instList != null) {
			return instList;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}

	public Instructor updateInstructor(Instructor updatedValue) {
		System.out.println("Enter Id of Instructor to be Updated");
		int Id = sc.nextInt();
		updatedValue = getInstructor(Id);
		System.out.println("Enter the email to be Updated");
		String email = sc.next();
		updatedValue.setEmail(email);
		return updatedValue = db.updateInstructor(updatedValue);
	}

	public String addProgram(Program prog) {
		System.out.println("Enter Program Name");
		String title = sc.next();
		prog.setTitle(title);

		System.out.println("Enter Location");
		String loc = sc.next();
		prog.setLocation(loc);

		System.out.println("Enter Start Date");
		Date startDate = java.sql.Date.valueOf(sc.next());
		// LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
		prog.setStartDate(startDate);

		System.out.println("Enter end Date");
		Date endDate = java.sql.Date.valueOf(sc.next());
		// LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
		prog.setEndDate(endDate);

		System.out.println("Enter Course Fee");
		Double fee = sc.nextDouble();
		prog.setFee(fee);

		System.out.println("Enter Instructor Id");
		int instId = sc.nextInt();
		prog.setInstId(instId);

		String s = db.addProgram(prog);
		if (s != null) {
			System.out.println("Program successfuly Added");
			return s;
		} else {
			return null;
		}
	}

	public Program updateprogram(Program prog) {
		System.out.println("Enter Id of Program to be Updated");
		int Id = sc.nextInt();
		prog = getProgramById(Id);
		System.out.println("Enter the location to be Updated");
		String location = sc.next();
		prog.setLocation(location);
		return prog = db.updateProgram(prog);

	}

	public List<Program> getAllPrograms() {
		List<Program> courseList = db.getAllPrograms();
		if (courseList != null) {
			return courseList;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}

	public String registerTrainee(Trainee t) {
		System.out.println("Enter Trainee's Name");
		String name = sc.next();
		t.setName(name);
		System.out.println("Enter Qualification");
		String qualification = sc.next();
		t.setQualification(qualification);
		System.out.println("Enter trainee's email");
		String email = sc.next();
		t.setEmail(email);

		System.out.println("Enter trainee's Country");
		String contry = sc.next();
		t.setContry(contry);

		String s = db.registerTrainee(t);
		if (s != null) {
			System.out.println("Trainee successfuly Added");
			return s;
		} else {
			return null;
		}
	}

	public Trainee updateTrainee(Trainee trainee) {
		System.out.println("Enter Id of Student to be Updated");
		int Id = sc.nextInt();
		trainee = getTraineeById(Id);
		System.out.println("Do you wish to update Trainee Mail......(y/n)");
		String d = sc.next();
		if (d.equalsIgnoreCase("y")) {
			System.out.println("Enter email to be Updated");
			String email = sc.next();
			trainee.setEmail(email);
			return trainee = db.updateTrainee(trainee);
		} else {
			return null;
		}
	}

	public List<Trainee> getAllTrainees() {
		List<Trainee> traineeList = db.getAllTrainees();
		if (traineeList != null) {
			return traineeList;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}

	public List<Trainee> getAllTrainees(int progId) {
		List<Trainee> stList = db.getAllTraineesByProgram(progId);
		if (stList != null) {
			return stList;
		} else {
			System.out.println("NO data avialable");
			return null;
		}

	}

	public boolean registerTraineeFortraining(int tId, int progId) {
		boolean status = db.registerTraineeForTraining(tId, progId);
		return status;
	}

	public List<TrainingReport> getAllTrainingsDetail() {
		List<TrainingReport> report = db.getAllTrainingsDetail();
		if (report != null) {
			return report;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}

	public Instructor getInstructor(int Id) {
		Instructor inst = db.getInstructor(Id);
		if (inst != null) {
			return inst;
		} else {
			return null;
		}
	}

	public Trainee getTraineeById(int Id) {
		Trainee stu = db.getTraineeById(Id);
		if (stu != null) {
			return stu;
		} else {
			return null;
		}
	}

	public Program getProgramById(int Id) {
		Program course = db.getProgramById(Id);
		if (course != null) {
			return course;
		} else {
			return null;
		}
	}

	public Double getCostByProgId(int progId) {
		return db.getTrainingFeeById(progId);
	}

	public List<TrainingReport> getAllTrainingsDetail(int progId) {
		List<TrainingReport> report = db.getAllTrainingsDetail(progId);
		if (report != null) {
			return report;
		} else {
			System.out.println("NO data avialable");
			return null;
		}
	}

	public String addRequester(Requester req) {
		
		return db.addRequester(req);
	}

	public Program getProgramByName(String reqProgName) {
		Program course = db.getProgramByName(reqProgName);
		if (course != null) {
			return course;
		} else {
			return null;
		}
	}

}
