package pojo;

import java.util.ArrayList;
import java.util.List;

public class QuestionExt extends Question{
	private String reponse;
    
	public QuestionExt() {
		// TODO Auto-generated constructor stub
	}
	
	public QuestionExt(Question q,String reponse) {
		setQus_no(q.getQus_no());
		setQus(q.getQus());
		setAnsa(q.getAnsa());
		setAnsb(q.getAnsb());
		setAnsc(q.getAnsc());
		setAnsd(q.getAnsd());
		setCorrectans(q.getCorrectans());
		this.reponse=reponse;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	
	
}
