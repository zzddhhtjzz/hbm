/**
 * 
 */
package com.neu.msd.controllers;

import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.neu.msd.entities.Activity;
import com.neu.msd.entities.ActivityContainer;
import com.neu.msd.entities.AdminActivityAnswer;
import com.neu.msd.entities.Answer;
import com.neu.msd.entities.Topic;
import com.neu.msd.entities.User;
import com.neu.msd.entities.Scoremodel;
import com.neu.msd.exception.AdminException;
import com.neu.msd.exception.UserException;
import com.neu.msd.service.UserService;

/**
 * @author Harsh
 *
 */
@Controller
public class UserController {

	@Autowired
	UserService userService;

	private final int VIDEO_TEMPLATE_ID =1;
	private final int IMAGE_TEMPLATE_ID =2;
	private final int MCQ_TEMPLATE_ID =3;
	private final int INFORMATION_TEMPLATE_ID =4;
	private final int FLIP_TEMPLATE_ID =5;
	private final int MAX_FLIP_OPTION =6;
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/redirectToDiagnostic.action", method = RequestMethod.GET)
	public String redirectToDiagnostic(Model model) {

		try {
			List<AdminActivityAnswer> activityAnswers = userService.getDiagnosticQuestions();
			model.addAttribute("activityAnswers", activityAnswers);
			return "diagnostic";
		} catch (UserException e) {
			return "errorPage";
		} catch (AdminException e) {
			return "errorPage";
		}
	}

	@RequestMapping(value = "/loadUserTopicsPage.action", method = RequestMethod.GET)
	public String loadTopicsOfUser(HttpSession session, Model model) {
		try {
			User user = new User();
			user = (User) session.getAttribute("user");
			if (user.isDiagnosticTaken() == false) {
				return redirectToDiagnostic(model);
			} else {
				List<Topic> topics = new ArrayList<Topic>();
				topics = userService.getTopicsOfUser(user);
				model.addAttribute("topics", topics);
			}

		} catch (UserException ex) {
			ex.printStackTrace();
			return "errorPage";
		}
		return "topics";
	}

	@RequestMapping(value = "/dg.action", method = RequestMethod.POST)
	public String redirectToUserhome(Scoremodel scores, Model model, HttpSession session) {
		
		try {
			User user = (User) session.getAttribute("user");

			Integer[] weigh = userService.getweigh();

			int b = -1;
			double score = 0;
			for (Integer a : scores.getScores()) {
				if (a != null)
					score += (double) (((double) (a - 1)) / (double) weigh[b]);
				b++;
			}
			score = score / 5 * 100;
			user=userService.addscore(user, score);

			// List<AdminActivityAnswer> activityAnswers =
			// userService.getDiagnosticQuestions();
			// model.addAttribute("activityAnswers", activityAnswers);
			List<Topic> topics = new ArrayList<Topic>();
			topics = userService.getTopicsOfUser(user);
			session.setAttribute("user", user);
			model.addAttribute("topics", topics);
			return "topics";
		} catch (Exception e) {
			e.printStackTrace();
			return "errorPage";
		}
	}

	@RequestMapping(value = "/getActivitypage.action", method = RequestMethod.POST)
	public String showActivity(@RequestParam("actcon") String actcon, Model model, HttpSession session) {

		try {
			String[] id = actcon.split("_");
			int tId = Integer.parseInt(id[0]);
			int cId = Integer.parseInt(id[1]);
			Topic topic = userService.settopic(tId);
			List<ActivityContainer> containers = new ArrayList<ActivityContainer>();
			containers = topic.getActivityContainers();
			List<ActivityContainer> p_containers = new ArrayList<ActivityContainer>();
			List<ActivityContainer> n_containers = new ArrayList<ActivityContainer>();
			ActivityContainer c_container = new ActivityContainer();

			int next = 0;
			for (ActivityContainer contain : containers) {
				if (next == 0) {
					if (cId != contain.getActivityContainerId()) {
						p_containers.add(contain);
					} else {
						c_container = contain;
						next = 1;
					}
				} else {
					n_containers.add(contain);
				}
			}

			List<Activity> p_act = new ArrayList<Activity>();

			Activity c_act = new Activity();
			List<Activity> n_act = new ArrayList<Activity>();
			int first = 0;
			for (Activity act : c_container.getActivities()) {
				if (first == 0) {
					c_act = act;
					first = 1;
				} else {
					n_act.add(act);
				}
			}
			System.out.println(c_act.getId());
			User user = (User) session.getAttribute("user");
			int userId = 0;
			if(null != user){
				userId = user.getId();
			}
			List<Answer> answers = userService.getAnwser(userId, tId, c_container.getActivityContainerId(), c_act);
			session.setAttribute("act_max", 1 + p_act.size() + n_act.size());
			session.setAttribute("con_max", 1 + p_containers.size() + n_containers.size());
			session.setAttribute("p_act", p_act);
			session.setAttribute("n_act", n_act);
			session.setAttribute("c_act", c_act);
			session.setAttribute("p_containers", p_containers);
			session.setAttribute("n_containers", n_containers);
			session.setAttribute("c_container", c_container);
			session.setAttribute("answers", answers);
			session.setAttribute("topicId", tId);
			System.out.println(answers);
			return "activityUser";
		} catch (Exception e) {
			e.printStackTrace();
			return "errorPage";
		}
	}

	@RequestMapping(value = "/reload.action", method = RequestMethod.POST)
	public String reloadact(@RequestParam("actcon") int actcon, Model model, 
			HttpSession session, HttpServletRequest request) {
		
		try {
			User user = (User) session.getAttribute("user");
			int userId = 0;
			if(null != user){
				userId = user.getId();
			}
			int topicId = (Integer) session.getAttribute("topicId");
			Activity currentActivity = (Activity) session.getAttribute("c_act");
			ActivityContainer currentContainer = (ActivityContainer) session.getAttribute("c_container");
			
			int templateId = currentActivity.getActivityTemplate().getId();
			
//		Saving the user response on to the big table
			if(templateId == VIDEO_TEMPLATE_ID || templateId == IMAGE_TEMPLATE_ID){
				String userResponse = request.getParameter("userAnswer");
				if(null!=userResponse && !userResponse.isEmpty()){
					userService.saveUserAnswerToBigTable(userId, topicId, currentContainer.getActivityContainerId(), 
							currentActivity.getId(), userResponse);
				}
			}else if(templateId == MCQ_TEMPLATE_ID){
				String[] selectedAnswers = request.getParameterValues("selectedAnswer");
				if(null!=selectedAnswers){
					userService.saveUserSelectionsToBigTable(userId, topicId, currentContainer.getActivityContainerId(), 
							currentActivity.getId(), selectedAnswers);
				}
			}else{
				userService.saveUserProgressToBigTable(userId, topicId, currentContainer.getActivityContainerId(), 
							currentActivity.getId());
			}

			if (actcon == 1) {
				Activity old_c_act = (Activity) session.getAttribute("c_act");
				List<Activity> p_act = (List<Activity>) session.getAttribute("p_act");
				List<Activity> n_act = (List<Activity>) session.getAttribute("n_act");
				ActivityContainer c_container = (ActivityContainer) session.getAttribute("c_container");
				n_act.add(0, old_c_act);
				System.out.print(old_c_act.getActivityText());
				
				Activity new_c_act = p_act.get(p_act.size() - 1);
				p_act.remove(p_act.size() - 1);
				List<Answer> answers = userService.getAnwser(userId, topicId, c_container.getActivityContainerId(), new_c_act);

				session.setAttribute("act_max", 1 + p_act.size() + n_act.size());
				session.setAttribute("p_act", p_act);
				session.setAttribute("n_act", n_act);
				session.setAttribute("c_act", new_c_act);
				session.setAttribute("answers", answers);
			} else if (actcon == 2) {
				Activity old_c_act = (Activity) session.getAttribute("c_act");
				List<Activity> p_act = (List<Activity>) session.getAttribute("p_act");
				List<Activity> n_act = (List<Activity>) session.getAttribute("n_act");
				ActivityContainer c_container = (ActivityContainer) session.getAttribute("c_container");
				System.out.println(old_c_act.getActivityText());
				p_act.add(old_c_act);

				Activity new_c_act = n_act.get(0);
				n_act.remove(0);
				List<Answer> answers = userService.getAnwser(userId, topicId, c_container.getActivityContainerId(), new_c_act);
				session.setAttribute("act_max", 1 + p_act.size() + n_act.size());
				session.setAttribute("p_act", p_act);
				session.setAttribute("n_act", n_act);
				session.setAttribute("c_act", new_c_act);
				session.setAttribute("answers", answers);
			} else if (actcon == 3) {
				ActivityContainer old_c_container = (ActivityContainer) session.getAttribute("c_container");
				List<ActivityContainer> p_containers = (List<ActivityContainer>) session.getAttribute("p_containers");
				List<ActivityContainer> n_containers = (List<ActivityContainer>) session.getAttribute("n_containers");
				ActivityContainer new_c_container = p_containers.remove(p_containers.size() - 1);
				n_containers.add(0, old_c_container);
				List<Activity> p_act = new ArrayList<Activity>();

				Activity c_act = new Activity();
				List<Activity> n_act = new ArrayList<Activity>();
				int first = 0;
				for (Activity act : new_c_container.getActivities()) {
					if (first == 0) {
						c_act = act;
						first = 1;
					} else {
						n_act.add(act);
					}
				}
				session.setAttribute("p_act", p_act);
				System.out.println(c_act.getId());
				List<Answer> answers = userService.getAnwser(userId, topicId, new_c_container.getActivityContainerId(), c_act);
				List<String> rightanswers=new ArrayList<String>();
				
				session.setAttribute("act_max", 1 + p_act.size() + n_act.size());
				session.setAttribute("con_max", 1 + p_containers.size() + n_containers.size());
				session.setAttribute("p_act", p_act);
				session.setAttribute("n_act", n_act);
				session.setAttribute("c_act", c_act);
				session.setAttribute("p_containers", p_containers);
				session.setAttribute("n_containers", n_containers);
				session.setAttribute("c_container", new_c_container);
				session.setAttribute("answers", answers);
				System.out.println(answers);
			} else if (actcon == 4) {
				ActivityContainer old_c_container = (ActivityContainer) session.getAttribute("c_container");
				List<ActivityContainer> p_containers = (List<ActivityContainer>) session.getAttribute("p_containers");
				List<ActivityContainer> n_containers = (List<ActivityContainer>) session.getAttribute("n_containers");
				ActivityContainer new_c_container = n_containers.remove(0);
				p_containers.add(old_c_container);
				List<Activity> p_act = new ArrayList<Activity>();

				Activity c_act = new Activity();
				List<Activity> n_act = new ArrayList<Activity>();
				int first = 0;
				for (Activity act : new_c_container.getActivities()) {
					if (first == 0) {
						c_act = act;
						first = 1;
					} else {
						n_act.add(act);
					}
				}

				System.out.println(c_act.getId());
				List<Answer> answers = userService.getAnwser(userId, topicId, new_c_container.getActivityContainerId(), c_act);

				session.setAttribute("act_max", 1 + p_act.size() + n_act.size());
				session.setAttribute("con_max", 1 + p_containers.size() + n_containers.size());
				session.setAttribute("p_act", p_act);
				session.setAttribute("n_act", n_act);
				session.setAttribute("c_act", c_act);
				session.setAttribute("p_containers", p_containers);
				session.setAttribute("n_containers", n_containers);
				session.setAttribute("c_container", new_c_container);
				session.setAttribute("answers", answers);
				System.out.println(answers);
			}
			else if(actcon==5){
				return loadTopicsOfUser(session, model);
			}
			return "activityUser";
		} catch (Exception e) {
			e.printStackTrace();
			return "errorPage";
		} 
	}

}
