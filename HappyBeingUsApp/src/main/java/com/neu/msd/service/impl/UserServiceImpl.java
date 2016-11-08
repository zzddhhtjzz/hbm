/**
 * 
 */
package com.neu.msd.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.msd.dao.AdminDao;
import com.neu.msd.dao.UserDao;
import com.neu.msd.entities.Activity;
import com.neu.msd.entities.ActivityContainer;
import com.neu.msd.entities.AdminActivityAnswer;
import com.neu.msd.entities.Answer;
import com.neu.msd.entities.Topic;
import com.neu.msd.entities.User;
import com.neu.msd.exception.AdminException;
import com.neu.msd.exception.AuthenticationException;
import com.neu.msd.exception.UserException;
import com.neu.msd.service.AdminService;
import com.neu.msd.service.UserService;

/**
 * @author Harsh
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	AdminDao adminDao;
	
	private final int VIDEO_TEMPLATE_ID =1;
	private final int IMAGE_TEMPLATE_ID =2;
	private final int MCQ_TEMPLATE_ID =3;
	private final int INFORMATION_TEMPLATE_ID =4;
	private final int FLIP_TEMPLATE_ID =5;
	private final int MAX_FLIP_OPTION =6;

	public List<AdminActivityAnswer> getDiagnosticQuestions() throws UserException, AdminException {
		int diagnosticType = userDao.getDiagnosticType();
		List<Activity> activities = userDao.getActivitiesByType(diagnosticType);
		List<AdminActivityAnswer> adminActivityAnswers = new ArrayList<AdminActivityAnswer>();
		for(Activity activity : activities){
			AdminActivityAnswer adminActivityAnswer = adminDao.getAdminActivityAnswerByActivityId(activity.getId());
			List<Answer> answers = adminActivityAnswer.getAnswers();
			List<Answer> answers1 = new ArrayList<Answer>();
			for(Answer answer : answers){
				Answer answer1 = userDao.getAnswerById(answer.getId());
			    answers1.add(answer1);
			}
			
			
			
			Collections.sort(answers1,new SortByorder_answer());
			adminActivityAnswer.setActivity(activity);
		    adminActivityAnswer.setAnswers(answers1);
			adminActivityAnswers.add(adminActivityAnswer);
		}
		
		
		
		Collections.sort(adminActivityAnswers,new SortByorder());
		return adminActivityAnswers;
	}

	public List<Topic> getTopicsOfUser(User user) throws UserException {
		List<Topic> topics = new ArrayList<Topic>();
		topics = userDao.getTopicsOfUser(user.getId());
		try {
			adminService.loadTopicsWithActivityContainers(new HashMap<Integer, ActivityContainer>(), topics);
		} catch (AdminException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return topics;
	}


	@Override
	public User addscore(User user, double score) throws UserException {
		
		
		return userDao.addscoreforuser(user, score);
		
	}

	@Override
	public Integer[] getweigh() throws SQLException {
		// TODO Auto-generated method stub
		Integer[] weighList;
		try {
			weighList = userDao.getweigh();
			return weighList;
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	   
		
		
	}

	@Override
	public Topic settopic(int tId) throws SQLException {
		Topic topic=userDao.settopic(tId);
				
		return topic;
	}

	@Override
	public List<Answer> getAnwser(int userId, int topicId, int containerId, Activity activity) throws AdminException, UserException {
			AdminActivityAnswer adminActivityAnswer = adminDao.getAdminActivityAnswerByActivityId(activity.getId());
			int templateId = activity.getActivityTemplate().getId();
			String userPrevAnswer = "";
			List<Answer> answers = adminActivityAnswer.getAnswers();
			List<Answer> answers1 =new ArrayList<Answer>();
			for(Answer answer : answers){
				Answer answer1 = userDao.getAnswerById(answer.getId());
				answer1.setIsRightanswer(answer.getIsRightanswer());
				answers1.add(answer1);
			}
			Collections.sort(answers1,new SortByorder_answer());
			
			if(templateId == VIDEO_TEMPLATE_ID || templateId == IMAGE_TEMPLATE_ID){
				userPrevAnswer = userDao.getUserAnswerFromBigTable(userId, topicId, containerId, activity.getId());
				if(null != userPrevAnswer){
					Answer answer = new Answer();
					answer.setAnswerText(userPrevAnswer);
					answers1.add(answer);
				}
			}else if(templateId == MCQ_TEMPLATE_ID){
				List<Integer> selectedAnswers = userDao.getSelectedAnswerFromBigTable(userId, topicId, containerId, activity.getId());
				if(selectedAnswers.size() != 0){
					List<Answer> tempAnswers = new ArrayList<Answer>();
					for(Answer answer : answers1){
						for(int selectedAnswer : selectedAnswers){
							if(answer.getId() == selectedAnswer){
								answer.setIsCorrect(true);
							}
						}
						tempAnswers.add(answer);
					}
					answers1 = tempAnswers;
				}
			}

			return answers1;
	}

	public void saveUserAnswerToBigTable(int userId, int topicId, int activityContainerId, int activityId,
			String userResponse) throws UserException {
		userDao.saveUserAnswerToBigTable(userId, topicId, activityContainerId, activityId, userResponse);
		
	}

	public void saveUserSelectionsToBigTable(int userId, int topicId, int activityContainerId, int activityId,
			String[] selectedAnswers) throws UserException {
		userDao.saveUserSelectionsToBigTable(userId, topicId, activityContainerId, activityId, selectedAnswers);
		
	}

	public void saveUserProgressToBigTable(int userId, int topicId, int activityContainerId, int activityId)
			throws UserException {
		userDao.saveUserProgressToBigTable(userId, topicId, activityContainerId, activityId);
		
	}


}
