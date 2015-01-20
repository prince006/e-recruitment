/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author The Developer <Developer at APIIT>
 */
public class Advert {

    private Integer adv_no;
    private String subject;
    private String description;
    private String url;
    private String is_active;
    private String created_by;
    private Timestamp created_on;

    
    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Advert() {
    	created_on=new Timestamp(System.currentTimeMillis());
	}

	public Integer getAdv_no() {
        return adv_no;
    }

    public void setAdv_no(Integer adv_no) {
        this.adv_no = adv_no;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

   

    public Timestamp getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Timestamp created_on) {
		this.created_on = created_on;
	}

	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    

}
