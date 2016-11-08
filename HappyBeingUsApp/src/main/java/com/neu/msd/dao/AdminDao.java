/**
 * 
 */
package com.neu.msd.dao;

import java.util.List;
import java.util.Map;

import com.neu.msd.entities.Activity;
import com.neu.msd.entities.ActivityContainer;
import com.neu.msd.entities.ActivityTemplate;
import com.neu.msd.entities.ActivityType;
import com.neu.msd.entities.AdminActivityAnswer;
import com.neu.msd.entities.Answer;
import com.neu.msd.entities.Topic;
import com.neu.msd.entities.User;
import com.neu.msd.entities.UserAuthentication;
import com.neu.msd.entities.Version;
import com.neu.msd.exception.AdminException;

/**
 * @author Harsh
 *
 */
public interface AdminDao {
	
	public List<Topic> loadTopics() throws AdminException;

	public List<ActivityContainer> loadActivityContainersByTopicId(int topicId) throws AdminException;

	public List<Activity> loadActivitiesByActivityContainerId(int activityContainerId) throws AdminException;

	public ActivityContainer loadActivityContainerById(int activityContainerId) throws AdminException;

	public List<ActivityTemplate> getAllActivityTemplates() throws AdminException;

	public int renameTopic(String topicName, int topicId) throws AdminException;

	public void loadActivityTemplate(Map<Integer, ActivityTemplate> activityTemplateMap) throws AdminException;
	
	public void loadActivityType(Map<Integer, ActivityType> activityTypeMap) throws AdminException;

	public AdminActivityAnswer getAdminActivityAnswerByActivityId(int activityId) throws AdminException;

	public User authenticateAdminByUsernamePassword(UserAuthentication userAuthentication) throws AdminException;

	public int addTopic(String topicName) throws AdminException;

	public int deleteTopic(int deletableId) throws AdminException;
	
	public int deleteActivityContainer(int deletableId) throws AdminException;

	public ActivityContainer addNewActivityContainer(String containerName, int topicId) throws AdminException;

	public int deleteActivity(Integer deletableId) throws AdminException;

	public int renameActivityContainer(String containerName, int containerId) throws AdminException;

	public List<Version> loadAllVersion() throws AdminException;

	public int assignTopicToVersion(int topicId, int versionId) throws AdminException;

	public Activity saveActivity(Activity activity) throws AdminException;

	public Answer saveAnswer(Answer answer) throws AdminException;

	public void saveAdminActivityAnswer(int activityId, int answerId, boolean isCorrect) throws AdminException;

	public int deleteFromAdminActivityAnswer(Integer activityId) throws AdminException;

	public int deleteFromUserTopicContainerActivity(Integer activityId) throws AdminException;

	public Activity loadActivityById(int activityId) throws AdminException;

	public List<Answer> loadAnswersByActivityId(int activityId) throws AdminException;

	public Activity updateActivity(Activity activity) throws AdminException;

	public int registerAdmin(User user) throws AdminException;

	public int registerAdminAuthentication(int userId, UserAuthentication userAuthentication) throws AdminException;
	
	
}
