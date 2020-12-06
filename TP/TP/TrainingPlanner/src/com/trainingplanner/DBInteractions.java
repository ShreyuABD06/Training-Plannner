package com.trainingplanner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBInteractions {
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	Statement stmt = null;

	private Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/trainer";
		try {
			con = DriverManager.getConnection(url, "root", "mysql123");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return con;
	}

	public void close() {
		if (con != null)
			try {
				con.close();
			} catch (SQLException s1) {
				System.out.println(s1.getMessage());
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException s1) {
				System.out.println(s1.getMessage());
			}
		if (pst != null)
			try {
				pst.close();
			} catch (SQLException s1) {
				System.out.println(s1.getMessage());
			}
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException s1) {
				System.out.println(s1.getMessage());
			}

	}

	public String addInstructor(Instructor instructor) {
		try {
			con = getConnection();
			String query = "insert into instructor(name,email,yearofexp) values(?,?,?)";
			pst = con.prepareStatement(query);
			pst.setString(1, instructor.getName());
			pst.setString(2, instructor.getEmail());
			pst.setInt(3, instructor.getYearsExp());
			int isExecuted = pst.executeUpdate();
			if (isExecuted != 0)
				return instructor.getName();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return null;
	}

	public List<Instructor> getInstrctors() {
		Instructor inst = null;
		List<Instructor> instList = new ArrayList<Instructor>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "Select * from instructor";
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				inst = new Instructor();
				inst.setInstId(rs.getInt(1));
				inst.setName(rs.getString(2));
				inst.setEmail(rs.getString(3));
				inst.setYearsExp(rs.getInt(4));
				instList.add(inst);
			}
		} catch (SQLException e) {
			System.out.println("While Getting Instrctors " + e);
		} finally {
			close();
		}
		return instList;
	}

	public Instructor updateInstructor(Instructor value) {
		try {
			con = getConnection();
			String query = "update Instructor set email=? where instid=?";
			pst = con.prepareStatement(query);
			pst.setString(1, value.getEmail());
			pst.setInt(2, value.getInstId());
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return value;
	}

	public String addProgram(Program prog) {
		try {
			con = getConnection();
			String s = "insert into programs(title,location,startDate,endDate,fee,instid)values(?,?,?,?,?,?)";
			pst = con.prepareStatement(s);
			pst.setString(1, prog.getTitle());
			pst.setString(2, prog.getLocation());
			pst.setObject(3, prog.getStartDate());
			pst.setObject(4, prog.getEndDate());
			pst.setDouble(5, prog.getFee());
			pst.setInt(6, prog.getInstId());
			int isExecuted = pst.executeUpdate();
			if (isExecuted != 0)
				return prog.getTitle();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return null;
	}

	public List<Program> getAllPrograms() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Program prog = null;
		List<Program> progList = new ArrayList<Program>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "select *from programs";
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				prog = new Program();
				prog.setProgId(rs.getInt(1));
				prog.setTitle(rs.getString(2));
				prog.setLocation(rs.getString(3));
				prog.setStartDate(rs.getDate(4));
				prog.setEndDate(rs.getDate(5));
				prog.setFee(rs.getDouble(6));
				prog.setInstId(rs.getInt(7));
				progList.add(prog);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return progList;
	}

	public Program updateProgram(Program prog) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = getConnection();
			String query = "update programs set location=? where courid=?";
			pst = con.prepareStatement(query);
			pst.setString(1, prog.getLocation());
			pst.setInt(2, prog.getProgId());
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return prog;
	}

	public String registerTrainee(Trainee trainee) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = getConnection();
			String n = "insert into trainee(name,qualification,email,contry) values(?,?,?,?)";
			pst = con.prepareStatement(n);
			pst.setString(1, trainee.getName());
			pst.setString(2, trainee.getQualification());
			pst.setString(3, trainee.getEmail());
			pst.setString(4, trainee.getContry());
			int isExecuted = pst.executeUpdate();
			if (isExecuted != 0)
				return trainee.getName();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return null;
	}

	public Trainee updateTrainee(Trainee trainee) {
		try {
			con = getConnection();
			String query = "update trainee set email=? where stuid=?";
			pst = con.prepareStatement(query);
			pst.setString(1, trainee.getEmail());
			pst.setInt(2, trainee.gettId());
			pst.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return trainee;
	}

	public List<Trainee> getAllTrainees() {
		Trainee t = null;
		List<Trainee> traineeList = new ArrayList<Trainee>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "select * from trainee";
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				t = new Trainee();
				t.settId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setQualification(rs.getString(3));
				t.setEmail(rs.getString(4));
				t.setContry(rs.getString(5));

				traineeList.add(t);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return traineeList;
	}

	public List<Trainee> getAllTraineesByProgram(int progId) {
		Trainee tr = null;
		List<Trainee> tList = new ArrayList<Trainee>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = " select t.tId,t.name,t.qualification,t.email,t.contry from trainee t"
					+ " inner join traineeprogram s on t.tId=s.tId " + "inner join programs c on s.progId=c.progId "
					+ "where s.progId=" + progId;
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				tr = new Trainee();
				tr.settId(rs.getInt(1));
				tr.setName(rs.getString(2));
				tr.setQualification(rs.getString(3));
				tr.setEmail(rs.getString(4));
				tr.setContry(rs.getString(5));
				tList.add(tr);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return tList;
	}

	public boolean registerTraineeForTraining(int tId, int progId) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = getConnection();
			String query = "insert into traineeprogram(tId,progId) values(?,?)";
			pst = con.prepareStatement(query);
			pst.setInt(1, tId);
			pst.setInt(2, progId);
			int isExcecuted = pst.executeUpdate();
			if (isExcecuted != 0)
				return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
			System.out.println("connections Closed");
		}
		return false;
	}

	public List<TrainingReport> getAllTrainingsDetail() {
		TrainingReport cRp = null;
		List<TrainingReport> reportList = new ArrayList<TrainingReport>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = " select c.progId,c.title,i.name,t.name,c.fee from trainee t "
					+ "inner join traineeProgram s on t.tId=s.tId " + "inner join programs c on s.progId=c.progId"
					+ " inner join instructor i on c.instId=i.instId ";
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				cRp = new TrainingReport();
				cRp.setProgId(rs.getInt(1));
				cRp.setTitle(rs.getString(2));
				cRp.setInstructorName(rs.getString(3));
				cRp.setTraineeName(rs.getString(4));
				cRp.setFee(rs.getDouble(5));
				reportList.add(cRp);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return reportList;
	}

	public Instructor getInstructor(int instId) {
		Instructor inst = null;
		try {
			con = getConnection();
			String sql = "select * from instructor where instid=" + instId;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				inst = new Instructor();
				inst.setInstId(rs.getInt(1));
				inst.setName(rs.getString(2));
				inst.setEmail(rs.getString(3));
				inst.setYearsExp(rs.getInt(4));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return inst;
	}

	public Trainee getTraineeById(int tId) {
		Trainee stu = null;
		try {
			con = getConnection();
			String sql = "select * from trainee where tId=" + tId;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				stu = new Trainee();
				stu.settId(rs.getInt(1));
				stu.setName(rs.getString(2));
				stu.setQualification(rs.getString(3));
				stu.setEmail(rs.getString(4));
				stu.setContry(rs.getString(5));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
			System.out.println("Connections Closed");
		}
		return stu;
	}

	public Program getProgramById(int progId) {
		Program c = null;
		try {
			con = getConnection();
			String sql = "select * from programs where progId=" + progId;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				c = new Program();
				c.setProgId(rs.getInt(1));
				c.setTitle(rs.getString(2));
				c.setLocation(rs.getString(3));
				c.setStartDate(rs.getDate(4));
				c.setEndDate(rs.getDate(5));
				c.setFee(rs.getDouble(6));
				c.setInstId(rs.getInt(7));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return c;
	}

	public Instructor findInstructor(String name, String email) {
		Instructor inst = null;
		try {
			con = getConnection();
			String sql = "select * from instructor where name= ? and email=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, email);
			rs = pst.executeQuery();
			while (rs.next()) {
				inst = new Instructor();
				inst.setInstId(rs.getInt(1));
				inst.setName(rs.getString(2));
				inst.setEmail(rs.getString(3));
				inst.setYearsExp(rs.getInt(4));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return inst;
	}

	public double getTrainingFeeById(int progId) {
		Program prog = null;
		double s = 0;
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = "select fee from programs where progId=" + progId;
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				prog = new Program();
				prog.setFee(rs.getDouble(1));
				return rs.getDouble(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	public List<TrainingReport> getAllTrainingsDetail(int progId) {
		TrainingReport cRp = null;
		List<TrainingReport> reportList = new ArrayList<TrainingReport>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			String view = " select c.progId,c.title,i.name,t.name,c.fee from trainee t "
					+ "inner join TraineeProgram s on t.tid=s.tid " + "inner join programs c on s.progId=c.progId"
					+ " inner join instructor i on c.instId=i.instId " + "where c.progId=" + progId;
			rs = stmt.executeQuery(view);
			while (rs.next()) {
				cRp = new TrainingReport();
				cRp.setProgId(rs.getInt(1));
				cRp.setTitle(rs.getString(2));
				cRp.setInstructorName(rs.getString(3));
				cRp.setTraineeName(rs.getString(4));
				cRp.setFee(rs.getDouble(5));
				reportList.add(cRp);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return reportList;
	}

	public String addRequester(Requester req) {
		try {
			con = getConnection();
			String query = "insert into requester(name,phoneNo,reqProgName,location,traineesExpected) values(?,?,?,?,?)";
			pst = con.prepareStatement(query);
			pst.setString(1, req.getName());
			pst.setString(2, req.getPhoneNo());
			pst.setString(3, req.getReqProgName());
			pst.setString(4, req.getLocation());
			pst.setInt(5, req.getTraineesExpected());
			int isExecuted = pst.executeUpdate();
			if (isExecuted != 0)
				return req.getName();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return null;
	}

	public Program getProgramByName(String reqProgName) {
		Program c = null;
		try {
			con = getConnection();
			String sql = "select * from programs where title= ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, reqProgName);
			rs = pst.executeQuery();
			while (rs.next()) {
				c = new Program();
				c.setProgId(rs.getInt(1));
				c.setTitle(rs.getString(2));
				c.setLocation(rs.getString(3));
				c.setStartDate(rs.getDate(4));
				c.setEndDate(rs.getDate(5));
				c.setFee(rs.getDouble(6));
				c.setInstId(rs.getInt(7));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
		return c;
	}
}
