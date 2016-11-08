/**
 * 
 */
package com.neu.msd.dao;

import java.sql.SQLException;
import java.util.List;

import com.neu.msd.entities.Activity;
import com.neu.msd.entities.ActivityContainer;
import com.neu.msd.entities.Answer;
import com.neu.msd.entities.Topic;
import com.neu.msd.entities.User;
import com.neu.msd.exception.AuthenticationException;
import com.neu.msd.exception.UserException;

/**
 * @author Harsh
 *
 */
public interface UserDao {

	int getDiagnosticType() throws UserException;

	List<Activity> getActivitiesByType(int diagnosticType) throws UserException;

	Answer getAnswerById(int answerId) throws UserException;

	List<Topic> getTopicsOfUser(int id) throws UserException;


	User addscoreforuser(User user, double score) throws UserException;
	ActivityContainer setcontainer(int cId) throws SQLException;

	Integer[] getweigh() throws SQLException, AuthenticationException;
	Topic settopic(int tId) throws SQLException;

	String getUserAnswerFromBigTable(int userId, int topicId, int containerId, int activityId) throws UserException;

	List<Integer> getSelectedAnswerFromBigTable(int userId, int topicId, int containerId, int activityId) throws UserException;

	void saveUserAnswerToBigTable(int userId, int topicId, int activityContainerId, int activityId,
			String userResponse) throws UserException;

	void saveUserSelectionsToBigTable(int userId, int topicId, int activityContainerId, int activityId,
			String[] selectedAnswers) throws UserException;

	void saveUserProgressToBigTable(int userId, int topicId, int activityContainerId, int activityId) throws UserException;

}
