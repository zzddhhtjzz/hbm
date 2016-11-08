/**
 * 
 */
package com.neu.msd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Statement;
import com.neu.msd.dao.AuthenticateDao;
import com.neu.msd.entities.Daughter;
import com.neu.msd.entities.DaughterRegistration;
import com.neu.msd.entities.Mother;
import com.neu.msd.entities.MotherRegistration;
import com.neu.msd.entities.Topic;
import com.neu.msd.entities.User;
import com.neu.msd.exception.AdminException;
import com.neu.msd.exception.AuthenticationException;

/**
 * @author Harsh
 *
 */
/**
 * @author NISHA
 *
 */
@Repository("authenticateDao")
public class AuthenticateDaoImpl implements AuthenticateDao {

	@Autowired
	DataSource dataSource;

	private Connection connection;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neu.msd.dao.AuthenticateDao#registerDaughter(com.neu.msd.entities.
	 * DaughterRegistration)
	 */
	public int registerDaughter(Daughter daughter) throws AuthenticationException {

		PreparedStatement stmt = null;
		ResultSet keys = null;

		try {

			int nextUserId = getNextUserId();
			connection = dataSource.getConnection();

			String sql = "insert into user (user_id, user_type_id, first_name, last_name, birthdate, email_id, parent_id, is_diagnostic_taken) "
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, nextUserId);
			stmt.setInt(2, 3);
			stmt.setString(3, daughter.getFirstName());
			stmt.setString(4, daughter.getLastName());
			stmt.setDate(5, new java.sql.Date(daughter.getBirthdate().getTime()));
			stmt.setString(6, daughter.getEmail());
			stmt.setInt(7, daughter.getMother().getId());
			stmt.setBoolean(8, false);

			int records = stmt.executeUpdate();

			System.out.println("No. of records inserted: "+records);

			keys = stmt.getGeneratedKeys();

			return nextUserId;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AuthenticationException(e);
		} finally {
			try {
				if (null != keys)
					keys.close();
				if (null != stmt)
					stmt.close();
				if (null != connection)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AuthenticationException(e);
			}
		}
	}

	private int getNextUserId() throws AuthenticationException{

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();

			String sql = "SELECT MAX(user_id) AS user_id FROM user";

			stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			rs = stmt.executeQuery();

			if (rs.next()) {
				return rs.getInt(1) + 1;
			}

			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AuthenticationException(e);
		} finally {
			try {
				if (null != rs)
					rs.close();
				if (null != stmt)
					stmt.close();
				if (null != connection)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AuthenticationException(e);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neu.msd.dao.AuthenticateDao#getMotherRegistrationByEmail(java.lang.
	 * String)
	 */
	public MotherRegistration getMotherRegistrationByEmail(String motherEmail) throws AuthenticationException {

		PreparedStatement stmt = null;
		ResultSet rs = null;

		PreparedStatement stmtUserId = null;
		ResultSet rs_userId = null;

		try {
			Mother mother = new Mother();
			connection = dataSource.getConnection();
			String sql = "select * from user where email_id=?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, motherEmail);
			rs = stmt.executeQuery();
			while (rs.next()) {
				mother.setId(rs.getInt("user_id"));
				mother.getUserType().setId(rs.getInt("user_type_id"));
				mother.setFirstName(rs.getString("first_name"));
				mother.setLastName(rs.getString("last_name"));
				mother.setBirthdate(rs.getDate("birthdate"));
				mother.setEmail(rs.getString("email_id"));
			}

			MotherRegistration motherRegistration = new MotherRegistration();
			motherRegistration.setMother(mother);
			if (mother.getId() != 0) {
				String sqlCheckIfUserAuthExists = "select * from user_authentication where user_id= ?";
				stmtUserId = connection.prepareStatement(sqlCheckIfUserAuthExists, Statement.RETURN_GENERATED_KEYS);

				stmtUserId.setInt(1, motherRegistration.getMother().getId());
				rs_userId = stmtUserId.executeQuery();

				while(rs_userId.next()){
					motherRegistration.setUsername(rs_userId.getString("username"));
					motherRegistration.setPassword(rs_userId.getString("password"));
				}
			}

			return motherRegistration;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AuthenticationException(e);
		} finally {
			try {
				if (null != rs)
					rs.close();
				if (null != stmt)
					stmt.close();
				if (null != rs_userId)
					rs_userId.close();
				if (null != stmtUserId)
					stmtUserId.close();
				if (null != connection)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AuthenticationException(e);
			}
		}
	}

	public Mother createMotherWithEmail(String email) throws AuthenticationException {

		PreparedStatement stmt = null;
		ResultSet keys = null;
		try {
			int nextUserId = getNextUserId();
			connection = dataSource.getConnection();
			String sql = "insert into user (user_id, user_type_id, email_id) "
					+ " values (?, ?, ?)";
			stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setInt(1, nextUserId);
			stmt.setInt(2, 2);
			stmt.setString(3, email);

			int records = stmt.executeUpdate();

			System.out.println("No. of records inserted: "+records);

			keys = stmt.getGeneratedKeys();

			Mother mother = new Mother();
			mother.setId(nextUserId);
			mother.setEmail(email);
			mother.getUserType().setId(2);

			return mother;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AuthenticationException(e);
		} finally {
			try {
				if (null != keys)
					keys.close();
				if (null != stmt)
					stmt.close();
				if (null != connection)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AuthenticationException(e);
			}
		}
	}

	public int registerDaughterAuthentication(int daughterId, DaughterRegistration daughterRegistration)
			throws AuthenticationException {

		PreparedStatement stmt = null;
		try {
			connection = dataSource.getConnection();
			String sql = "insert into user_authentication (user_id, username, password, user_type_id) "
					+ " values (?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);

			stmt.setInt(1, daughterId);
			stmt.setString(2, daughterRegistration.getUsername());
			stmt.setString(3, daughterRegistration.getPassword());
			stmt.setInt(4, 3);

			int records = stmt.executeUpdate();

			System.out.println("No. of records inserted: "+records);

			return records;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AuthenticationException(e);
		} finally {
			try {
				if (null != stmt)
					stmt.close();
				if (null != connection)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AuthenticationException(e);
			}
		}

	}

	public User validUser(String username, String password) throws AuthenticationException {

		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		try {
			User user = new User();
			int id;
			connection = dataSource.getConnection();
			String sql = "select user_id from user_authentication where username=? and password=?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if(rs.next()==true){
				id=rs.getInt("user_id");

				String sql2 = "select * from user where user_id=?";

				stmt1 = connection.prepareStatement(sql2);
				stmt1.setInt(1, id);
				rs1 = stmt1.executeQuery();

				while(rs1.next()){
					user.setId(rs1.getInt("user_id"));
					rs1.getInt("user_type_id");
					user.setFirstName(rs1.getString("first_name"));
					user.setLastName(rs1.getString("last_name"));
					user.setBirthdate(rs1.getDate("birthdate"));
					user.setEmail(rs1.getString("email_id"));
					user.setDiagnosticTaken(rs1.getBoolean("is_diagnostic_taken"));
				}

				return user;
			} else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AuthenticationException(e);
		} finally {
			try {
				if (null != rs)
					rs.close();
				if (null != stmt)
					stmt.close();
				if (null != rs1)
					rs1.close();
				if (null != stmt1)
					stmt1.close();
				if (null != connection)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AuthenticationException(e);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neu.msd.dao.AuthenticateDao#updateMotherDetails(com.neu.msd.entities.
	 * MotherRegistration)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neu.msd.dao.AuthenticateDao#updateMotherDetails(com.neu.msd.entities.
	 * MotherRegistration)
	 */
	public int updateMotherDetails(MotherRegistration motherRegistration) throws AuthenticationException {
		PreparedStatement stmt = null;
		PreparedStatement stmtUserId = null;
		ResultSet rs_userId = null;
		PreparedStatement stmtUpdateUserAuth = null;

		try {
			connection = dataSource.getConnection();
			String sql = "update user set first_name = ?, last_name = ? where user_id = ?";

			stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, motherRegistration.getMother().getFirstName());
			stmt.setString(2, motherRegistration.getMother().getLastName());
			stmt.setInt(3, motherRegistration.getMother().getId());

			int records = stmt.executeUpdate();
			System.out.println("No. of records updated in the user table: " + records);

			String sqlCheckIfUserAuthExists = "SELECT user_id FROM user_authentication WHERE user_id= ?";
			stmtUserId = connection.prepareStatement(sqlCheckIfUserAuthExists, Statement.RETURN_GENERATED_KEYS);

			stmtUserId.setInt(1, motherRegistration.getMother().getId());
			rs_userId = stmtUserId.executeQuery();

			if (rs_userId.next()) {
				return 0;
			} else {
				String sqlUpdateUserAuth = "insert into user_authentication(user_id, username, password, user_type_id) "
						+ "values (?, ?, ?, ?)";

				stmtUpdateUserAuth = connection.prepareStatement(sqlUpdateUserAuth, Statement.RETURN_GENERATED_KEYS);

				stmtUpdateUserAuth.setInt(1, motherRegistration.getMother().getId());
				stmtUpdateUserAuth.setString(2, motherRegistration.getUsername());
				stmtUpdateUserAuth.setString(3, motherRegistration.getPassword());
				stmtUpdateUserAuth.setInt(4, 2);

				records = stmtUpdateUserAuth.executeUpdate();

				System.out.println("No. of records inserted in the user_authentication table: " + records);
			}
			return records;

		} catch (Exception e) {
			e.printStackTrace();
			throw new AuthenticationException(e);
		} finally {
			try {
				if (null != stmt)
					stmt.close();
				if (null != stmtUserId)
					stmtUserId.close();
				if (null != rs_userId)
					rs_userId.close();
				if (null != stmtUpdateUserAuth)
					stmtUpdateUserAuth.close();
				if (null != connection)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AuthenticationException(e);
			}
		}

	}

	public String resetUnamePassword(String emailID, String username, String password) throws AuthenticationException {

		PreparedStatement stmt = null;
		ResultSet rs = null;
		PreparedStatement stmt_restunamepwd = null;

		try {
			connection = dataSource.getConnection();
			String sql = "select * from user where email_id=?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, emailID);
			rs = stmt.executeQuery();

			if (rs.next()) {
				String sql_updateUnamePwd = "update user_authentication set username = ?, password = ? where user_id = ?";

				stmt_restunamepwd = connection.prepareStatement(sql_updateUnamePwd, Statement.RETURN_GENERATED_KEYS);

				stmt_restunamepwd.setString(1, username);
				stmt_restunamepwd.setString(2, password);
				stmt_restunamepwd.setInt(3, rs.getInt("user_id"));

				int records = stmt_restunamepwd.executeUpdate();
				System.out.println("No. of records updated in the user table: " + records);

				return "Reset Successful!";
			} else {
				return "Account does not exist. Try Sign Up...";
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new AuthenticationException(e);
		} finally {
			try {
				if (null != stmt)
					stmt.close();
				if (null != rs)
					rs.close();
				if (null != stmt_restunamepwd)
					stmt_restunamepwd.close();
				if (null != connection)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AuthenticationException(e);
			}
		}

	}

	public String checkUname(String uname) throws AuthenticationException {

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			String sql = "select * from user_authentication where username=?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, uname);
			rs = stmt.executeQuery();

			if (!rs.next()) {
				return uname + ", this username available";
			} else {
				return uname + ", This username is taken.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new AuthenticationException(e);
		} finally {
			try {
				if (null != stmt)
					stmt.close();
				if (null != rs)
					rs.close();
				if (null != connection)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AuthenticationException(e);
			}
		}
	}

	public String checkEmail(String email) throws AuthenticationException {

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			String sql = "select * from user where email_id=?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, email);
			rs = stmt.executeQuery();

			if (!rs.next()) {
				return "";
			} else {
				return email + ", The account already exists";
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new AuthenticationException(e);
		} finally {
			try {
				if (null != stmt)
					stmt.close();
				if (null != rs)
					rs.close();
				if (null != connection)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AuthenticationException(e);
			}
		}
	}

}
