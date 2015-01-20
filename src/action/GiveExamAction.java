package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import pojo.Exam;
import pojo.Question;
import pojo.QuestionExt;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class GiveExamAction implements SessionAware,ModelDriven<List<QuestionExt>>, Preparable{

	private List<QuestionExt> questExtList;
	private Map session;
	private String action;
	
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public List<QuestionExt> getQuestExtList() {
		return questExtList;
	}

	public void setQuestExtList(List<QuestionExt> questExtList) {
		this.questExtList = questExtList;
	}
	@Override
	public List<QuestionExt> getModel() {
		// TODO Auto-generated method stub
		return questExtList;
	}

	@Override
	public void prepare() throws Exception {

		questExtList=new ArrayList<QuestionExt>();
		System.out.println("inside...");
		setSession(ActionContext.getContext().getSession());
		Exam e = (Exam) session.get("exam");
		action=(String)session.get("action");
		if(action !=null && action.equals("se")){						
//			for (int i = 0; i < e.getNo_of_qus(); i++) {
//				questList.add(new Question());
//			}	
		}		
	}
}
