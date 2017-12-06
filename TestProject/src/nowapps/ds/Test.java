/*
package nowapps.ds;

public interface UserDAO {
	public void insert(User user);

	public void update(User user);

	public void delete(int userId);
}

// Implementation: // suppose we accessing MySQL DB using JPA
public class UserJpaDAO implements UserDAO {
	@Override
	public void delete(int userId) {
		// delete user from user table
	}

	@Override
	public User[] findAll() {
		// get a list of all Users from user table
		return null;
	}

	@Override
	public User findByKey(int userId) {
		// get User information for a given userId
		return null;
	}

	@Override
	public void insert(User user) {
		// insert user into user table
	}

	@Override
	public void update(User user) {
		// update user information in user table
	}
}

// Implementation: // suppose we accessing Oracle DB using JDBC
public class UserJdbcDAO implements UserDAO {
	@Override
	public void delete(int userId) {
		// delete user from user table
	}

	@Override
	public User[] findAll() {
		// get a list of all Users from user table
		return null;
	}

	@Override
	public User findByKey(int userId) {
		// get User information for a given userId
		return null;
	}

	@Override
	public void insert(User user) {
		// insert user into user table
	}

	@Override
	public void update(User user) {
		// update user information in user table
	}
}

// Factory class
public class UserDAOFactory {
	public static UserDAO getUserDAO(String type) {
		if (type.equalsIgnoreCase("JPA")) {
			return new UserJpaDAO();
		} else if (type.equalsIgnoreCase("JDBC")) {
			return new UserJdbcDAO();
		}
	}
}
*/








