package it.beije.surabaya.timesheet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DBImportExport {

	//IMPORT CSV METHOD
	public static String[] importCsv(String pathFile) throws IOException{
		
		List<String> rows = new ArrayList<String>();

		rows = getFileAsStrings(pathFile);
//		rows.remove(0);
		
		String[] insert = new String[rows.size()]; //ritorna tutte le query necessarie

			int i=0;
			//INSERT
			for (String conversione : rows) {
			    String[] parts = conversione.split(";");
			    
			    String first_name = parts[1];
			    String last_name = parts[2];
			    String personal_email = parts[3];
			    String work_email = parts[4];
			    String phone = parts[5];
			    String fiscal_code = parts[6];
			    String admin = parts[7];
			    String password = parts[8];

//			INSERT
			insert[i] = "INSERT INTO user (id, first_name, last_name, personal_email, work_email, phone, fiscal_code, admin, password) "
					+ "VALUES (null, '"+ first_name + "' , '" + last_name + "' , '" + personal_email + "' , '" + work_email + "',"
							+ " '" +phone+ "', '" +fiscal_code+ "', "+admin+ ", '" +password+ "')";
			i++;
			}

		System.out.println("Csv importato");
		return insert;
		} //Chiusura Metodo
	
	//EXPORT CSV METHOD
	public static void exportCsv(String pathfile, Connection conn, Statement stmt) {

		ResultSet rset = null;
		
        try {
            FileWriter fw = new FileWriter(pathfile);
			
            String query = "select * from user";
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                fw.append(rset.getString(1));
                fw.append(';');
                fw.append(rset.getString(2));
                fw.append(';');
                fw.append(rset.getString(3));
                fw.append(';');
                fw.append(rset.getString(4));
                fw.append(';');
                fw.append(rset.getString(5));
                fw.append(';');
                fw.append(rset.getString(6));
                fw.append(';');
                fw.append(rset.getString(7));
                fw.append(';');
                fw.append(rset.getString(8));
                fw.append(';');
                fw.append(rset.getString(9));
                fw.append('\n');
               }
            fw.flush();
            fw.close();
            System.out.println("CSV File creato correttamente.");
            }
    	catch (SQLException se) {
		System.out.println("SQLError: " + se.getMessage() + " code: " + se.getErrorCode());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				rset.close();
			}catch (Exception e) {
				e.printStackTrace();
			} 
		}       
	} //End exportCsv
	
	//CREATE XML FILE 
	public static void exportXml(String pathfile, Connection conn, Statement stmt) throws Exception {
		
		 DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
	        DocumentBuilder build = dFact.newDocumentBuilder();
	        Document doc = build.newDocument();

	        Element root = doc.createElement("User");
	        doc.appendChild(root);
	        
			ResultSet rset = null;
			
		try {
			
            String query = "select * from user";
            rset = stmt.executeQuery(query);
            while (rset.next()) {
            	String row = rset.getString(1) + ";" + rset.getString(2) + ";" +rset.getString(3) + ";" 
            				+rset.getString(4) + ";" +rset.getString(5) + ";" +rset.getString(6) 
            				+ ";" +rset.getString(7) + ";" +rset.getString(8) + ";" +rset.getString(9) + ";";
            	String[] parts = row.split(";");
            	
            	Element Details = doc.createElement("Dipendente");
		        root.appendChild(Details);	
		        
		        String id_element = parts[0];
		        String first_name_element = parts[1];
		        String last_name_element = parts[2];
		        String personal_email_element = parts[3];
		        String work_email_element = parts[4];
		        String phone_element = parts[5];
		        String fiscal_code_element = parts[6];
		        String admin_element = parts[7];
		        String password_element = parts[8];

	            Element id = doc.createElement("id");
	            id.appendChild(doc.createTextNode(id_element));
	            Details.appendChild(id);

		        
	            Element first_name = doc.createElement("first_name");
	            first_name.appendChild(doc.createTextNode(first_name_element));
	            Details.appendChild(first_name);

	            
	            Element last_name = doc.createElement("last_name");
	            last_name.appendChild(doc.createTextNode(last_name_element));
	            Details.appendChild(last_name);

	            
	            Element personal_email = doc.createElement("personal_mail");
	            personal_email.appendChild(doc.createTextNode(personal_email_element));
	            Details.appendChild(personal_email);

	            
	            Element work_email = doc.createElement("work_mail");
	            work_email.appendChild(doc.createTextNode(work_email_element));
	            Details.appendChild(work_email);
	            
	            
	            Element phone = doc.createElement("phone");
	            phone.appendChild(doc.createTextNode(phone_element));
	            Details.appendChild(phone);

	            
	            Element fiscal_code = doc.createElement("fiscal_code");
	            fiscal_code.appendChild(doc.createTextNode(fiscal_code_element));
	            Details.appendChild(fiscal_code);

	            
	            Element admin = doc.createElement("admin");
	            admin.appendChild(doc.createTextNode(admin_element));
	            Details.appendChild(admin);


	            Element password = doc.createElement("password");
	            password.appendChild(doc.createTextNode(password_element));
	            Details.appendChild(password);
               } //end while
		} 
    	catch (SQLException se) {
		System.out.println("SQLError: " + se.getMessage() + " code: " + se.getErrorCode());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				rset.close();
			}catch (Exception e) {
				e.printStackTrace();
			} 
		}

	         // Save the document to the disk file
	        TransformerFactory tranFactory = TransformerFactory.newInstance();
	        Transformer aTransformer = tranFactory.newTransformer();
	        
	        // format the XML nicely
	        aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");

	        aTransformer.setOutputProperty(
	                "{http://xml.apache.org/xslt}indent-amount", "4");
	        aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

	        DOMSource source = new DOMSource(doc);
	        try {
	            FileWriter fos = new FileWriter(pathfile);
	            StreamResult result = new StreamResult(fos);
	            aTransformer.transform(source, result);
	            System.out.println("XML File creato correttamente.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	} //End exportXml
	
	
	//GET FILE AS STRING metodo usato per import CSV
	private static List<String> getFileAsStrings(String pathFile) throws IOException {
		List<String> content = new ArrayList<String>();
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(pathFile));
			
			while(reader.ready()) {
				content.add(reader.readLine());
			}
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		} finally {
			try {
				reader.close();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}
		return content;
	}
	
} //END CLASS