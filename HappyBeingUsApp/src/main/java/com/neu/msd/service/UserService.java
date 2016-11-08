/**
 * 
 */
package com.neu.msd.service;

import java.sql.SQLException;
import java.util.List;

import com.neu.msd.entities.Activity;
import com.neu.msd.entities.ActivityContainer;
import com.neu.msd.entities.AdminActivityAnswer;
import com.neu.msd.entities.Answer;
import com.neu.msd.entities.Topic;
import com.neu.msd.entities.User;
import com.neu.msd.entities.User;
import com.neu.msd.exception.AdminException;
import com.neu.msd.exception.UserException;

/**
 * @author HP
 *
 */
public interface UserService {

	public List<AdminActivityAnswer> getDiagnosticQuestions() throws UserException, AdminException;

	public List<Topic> getTopicsOfUser(User user)throws UserException;


	User addscore(User user, double score) throws UserException;

	Integer[] getweigh() throws SQLException;

	public Topic settopic(int cId) throws SQLException;

	public List<Answer> getAnwser(int userId, int topicId, int containerId, Activity activity) throws AdminException, UserException;

	public void saveUserAnswerToBigTable(int userId, int topicId, int activityContainerId, int activityId, String userResponse) throws UserException;

	public void saveUserSelectionsToBigTable(int userId, int topicId, int activityContainerId, int activityId,
			String[] selectedAnswers) throws UserException;

	public void saveUserProgressToBigTable(int userId, int topicId, int activityContainerId, int activityId) throws UserException;

}
