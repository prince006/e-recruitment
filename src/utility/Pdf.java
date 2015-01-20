package utility;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

import pojo.Resume;
import pojo.Resume_Experience;
import pojo.Resume_qualification;
import pojo.UserPojo;
 
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.Cell;
import com.lowagie.text.pdf.PdfCell;

import dao.ResumeDao;
 
public class Pdf{
 
    public static void main(String[] args) {
    	Resume r= new ResumeDao().search(2);
    	new Pdf().createPDF(r);
      
    }
    public void getUserResumePdf(UserPojo pojo){
    	Resume resume=new ResumeDao().searchByUser(pojo);
    	new Pdf().createPDF(resume);
    }
    public void createPDF(Resume resume){
    	java.util.List<Resume_qualification> qualifications = new ResumeDao().getQualification(resume);
    	java.util.List<Resume_Experience> experiences = new ResumeDao().getExperience(resume);
    	  try {    		  
              OutputStream file = new FileOutputStream(new File("Resume.pdf"));
              Document document = new Document();
              PdfWriter.getInstance(document, file); 
              BaseFont bf = BaseFont.createFont("c:/windows/fonts/bellb.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);              
              Paragraph name=new Paragraph(resume.getFirst_name()+" "+resume.getLast_name(),new Font(bf, 22));
              name.setAlignment(1);              
            //Inserting Table in PDF
                  PdfPTable table=new PdfPTable(2);
                  table.setTotalWidth(400);       
                  table.setWidths(new float[]{(float)0.5,(float)1.5});
                  PdfPCell cell;
                  cell=new PdfPCell(new Phrase("Address:"));
                  cell.setBorder(0);                                    
                  table.addCell(cell);
                  cell=new PdfPCell(new Phrase(resume.getC_address()));
                  cell.setBorder(0);             
                  table.addCell(cell);
                  cell=new PdfPCell(new Phrase("Mobile:"));
                  cell.setBorder(0);
                  table.addCell(cell);
                  cell=new PdfPCell(new Phrase(resume.getMobile_no()));
                  cell.setBorder(0);
                  table.addCell(cell);
                  cell=new PdfPCell(new Phrase("Email:"));
                  cell.setBorder(0);
                  table.addCell(cell);
                  cell=new PdfPCell(new Phrase(resume.getEmail()));
                  cell.setBorder(0);
                  table.addCell(cell);
                  cell=new PdfPCell(new Phrase("Experience:"));
                  cell.setBorder(0);
                  table.addCell(cell);
                  cell=new PdfPCell(new Phrase(resume.getExp().toString()+ " Years"));
                  cell.setBorder(0);
                  table.addCell(cell);
                  cell=new PdfPCell(new Phrase("Skills:"));
                  cell.setBorder(0);
                  table.addCell(cell);
                  cell=new PdfPCell(new Phrase(resume.getSkills()));
                  cell.setBorder(0);
                  table.addCell(cell);
                  table.setSpacingBefore(30.0f);       // Space Before table starts, like margin-top in CSS
                  table.setSpacingAfter(30.0f);        // Space After table starts, like margin-Bottom in CSS                                         
                  PdfPTable tblQuali =new PdfPTable(5);
                  tblQuali.setWidths(new float[]{1, 2,1,(float)0.5,(float)0.5});
                  
                  cell=new PdfPCell(new Paragraph("Education & Qualification",FontFactory.getFont("Bellb", new Float(12.0), Font.NORMAL, new BaseColor(255,255,255))));                		  
                  cell.setHorizontalAlignment (Element.ALIGN_CENTER);
                  cell.setColspan(5);
                  cell.setBackgroundColor (new BaseColor (0, 0, 0));                   
                  tblQuali.addCell(cell);
                  
                  String[] tblhead={"Qualification","Board/University","Passing Year","%","Grade"};
                  for (String string : tblhead) {
                	  cell=new PdfPCell(new Paragraph(string,FontFactory.getFont("Bellb", new Float(10.0), Font.NORMAL, new BaseColor(0,0,0))));
                      cell.setHorizontalAlignment (Element.ALIGN_CENTER);
                      cell.setBackgroundColor (new BaseColor (211, 211, 211));
                      tblQuali.addCell(cell);
				  }
                                    
                  for (Resume_qualification q : qualifications) {
					  cell=new PdfPCell(new Phrase(q.getQualification()));
                	  cell.setHorizontalAlignment (Element.ALIGN_CENTER);
                      tblQuali.addCell(cell);
                      cell=new PdfPCell(new Phrase(q.getBoard_university()));
                	  cell.setHorizontalAlignment (Element.ALIGN_CENTER);
                      tblQuali.addCell(cell);
                      cell=new PdfPCell(new Phrase(q.getPass_year().toString()));
                	  cell.setHorizontalAlignment (Element.ALIGN_CENTER);
                      tblQuali.addCell(cell);
                      cell=new PdfPCell(new Phrase(q.getPercentage().toString()));
                	  cell.setHorizontalAlignment (Element.ALIGN_CENTER);
                      tblQuali.addCell(cell);
                      cell=new PdfPCell(new Phrase(q.getGrade()));
                	  cell.setHorizontalAlignment (Element.ALIGN_CENTER);
                      tblQuali.addCell(cell);
                  }
                  tblQuali.setSpacingAfter(30.0f);        // Space After table starts, like margin-Bottom in CSS
                  
                  PdfPTable tblExp =new PdfPTable(6);
                  tblExp.setWidths(new float[]{(float)0.7, 1,(float)1.5,(float)0.9,(float)0.95,(float)0.95});
                  cell=new PdfPCell(new Paragraph("Work Experience",FontFactory.getFont("Bellb", new Float(12.0), Font.NORMAL, new BaseColor(255,255,255))));
                  cell.setHorizontalAlignment (Element.ALIGN_CENTER);
                  cell.setColspan(6);
                  cell.setBackgroundColor (new BaseColor (0, 0, 0));
                  tblExp.addCell(cell); 
                  
                  String[] tblhead2={"Job Title","Profile","Responsibility","Company","From","TO"};
                  for (String string : tblhead2) {
                	  cell=new PdfPCell(new Paragraph(string,FontFactory.getFont("Bellb", new Float(10.0), Font.NORMAL, new BaseColor(0,0,0))));
                	  cell.setBackgroundColor (new BaseColor (211, 211, 211));
                	  cell.setHorizontalAlignment (Element.ALIGN_CENTER);                      
                      tblExp.addCell(cell);
				  }
                          
                  tblExp.setSpacingAfter(30.0f);        // Space After table starts, like margin-Bottom in CSS
                  
                for (Resume_Experience e: experiences) {
				 	  cell=new PdfPCell(new Phrase(e.getJob_title()));
                      cell.setHorizontalAlignment (Element.ALIGN_CENTER);
                	  tblExp.addCell(cell);
				 	  cell=new PdfPCell(new Phrase(e.getJob_profile()));
                      cell.setHorizontalAlignment (Element.ALIGN_CENTER);
                	  tblExp.addCell(cell);
				 	  cell=new PdfPCell(new Phrase(e.getJob_responsibility()));
                      cell.setHorizontalAlignment (Element.ALIGN_CENTER);
                	  tblExp.addCell(cell);
				 	  cell=new PdfPCell(new Phrase(e.getCompany()));
                      cell.setHorizontalAlignment (Element.ALIGN_CENTER);
                	  tblExp.addCell(cell);
				 	  cell=new PdfPCell(new Phrase(e.getFrom_date()));
                      cell.setHorizontalAlignment (Element.ALIGN_CENTER);
                	  tblExp.addCell(cell);
				 	  cell=new PdfPCell(new Phrase(e.getTo_date()));
                      cell.setHorizontalAlignment (Element.ALIGN_CENTER);
                	  tblExp.addCell(cell);
                  }
                  PdfPTable tblPInfo=new PdfPTable(2);
                  tblPInfo.setWidths(new float[]{1,2});
                  cell=new PdfPCell(new Paragraph("Personal Information",FontFactory.getFont("Bellb", new Float(12.0), Font.NORMAL, new BaseColor(255,255,255))));                                    
                  cell.setHorizontalAlignment (Element.ALIGN_CENTER);
                  cell.setBackgroundColor (new BaseColor (0, 0, 0));
                  cell.setColspan(2);
                  tblPInfo.addCell(cell);
                  
                  cell=new PdfPCell(new Paragraph("Permanent Address",FontFactory.getFont("Bellb", new Float(10.0), Font.NORMAL, new BaseColor(0,0,0))));
            	  cell.setBackgroundColor (new BaseColor (211, 211, 211));
                  tblPInfo.addCell(cell);

                  cell=new PdfPCell(new Phrase(resume.getP_address()));
                  tblPInfo.addCell(cell);
                  
                  cell=new PdfPCell(new Paragraph("Married",FontFactory.getFont("Bellb", new Float(10.0), Font.NORMAL, new BaseColor(0,0,0))));
            	  cell.setBackgroundColor (new BaseColor (211, 211, 211));
                  tblPInfo.addCell(cell);
                  
                  cell=new PdfPCell(new Phrase(resume.getIs_married().equals("Y")?"Married":"Single"));
                  tblPInfo.addCell(cell);
                  
                  cell=new PdfPCell(new Paragraph("Gender",FontFactory.getFont("Bellb", new Float(10.0), Font.NORMAL, new BaseColor(0,0,0))));
            	  cell.setBackgroundColor (new BaseColor (211, 211, 211));
                  tblPInfo.addCell(cell);
                  cell=new PdfPCell(new Phrase(resume.getGender().equals("M")?"Male":"Female"));
                  tblPInfo.addCell(cell);    
                  
                  tblPInfo.setSpacingAfter(30.0f);
                  
                PdfPTable tblRemark=new PdfPTable(1);                  
                cell=new PdfPCell(new Paragraph("Remarks",FontFactory.getFont("Bellb", new Float(12.0), Font.NORMAL, new BaseColor(255,255,255))));                                    
                cell.setHorizontalAlignment (Element.ALIGN_CENTER);
                cell.setBackgroundColor (new BaseColor (0, 0, 0));
                cell.setColspan(2);
                tblRemark.addCell(cell);                  
                cell=new PdfPCell(new Phrase(""));                                    
                cell.setHorizontalAlignment (Element.ALIGN_CENTER);
                cell.setColspan(2);
                cell.setBorder(0);
                tblRemark.addCell(cell); 
                cell=new PdfPCell(new Phrase(resume.getRemarks()));                                    
                cell.setColspan(2);
                cell.setBorder(0);
                tblRemark.addCell(cell);
                tblRemark.setSpacingAfter(30.0f);  
                
                document.open();//PDF document opened........
                document.setPageSize(PageSize.A4);
                document.setMargins(10, 10, 10, 10); 
                document.add(Chunk.NEWLINE);   //Something like in HTML <img src="http://www.java4s.com/wp-includes/images/smilies/icon_smile.gif" alt=":-)" class="wp-smiley">  
                document.add(name);
                document.add(table);
                document.add(tblQuali);
                document.add(tblExp);
                document.add(tblPInfo);
                document.add(tblRemark);
                document.add(Chunk.NEWLINE);   //Something like in HTML <img src="http://www.java4s.com/wp-includes/images/smilies/icon_smile.gif" alt=":-)" class="wp-smiley">                  
                document.close();
 
                file.close();
                System.out.println("Pdf created successfully..");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}