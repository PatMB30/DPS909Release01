package release01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.i18n.phonenumbers.PhoneNumberMatch;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import org.json.JSONObject;

/**
 * Servlet implementation class JavaServer01
 */
@WebServlet("/JavaServer01")
public class JavaServer01 extends HttpServlet 
{
	private static String userInput;
	private static ArrayList<String> phoneNumbers;
	

	private HttpServletResponse res;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JavaServer01() 
    {
        super();
        userInput = "";
        phoneNumbers = new ArrayList<String>();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/plain");
		if(getRelativeUrl(request).contains("?file"))
		{
			doPost(request, response);
		}
		else
		{
			String arguments = "";
			if(getRelativeUrl(request).contains("?"))
			{
				int idx = getRelativeUrl(request).indexOf("?");
				arguments = getRelativeUrl(request).substring(idx, getRelativeUrl(request).length());
			
				PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
			
				phoneUtil.findNumbers(arguments, "CA");
			
				Iterator<PhoneNumberMatch> existsPhone = PhoneNumberUtil.getInstance().findNumbers(arguments, "CA").iterator();
			
				if(existsPhone.hasNext())
				{
					while (existsPhone.hasNext())
					{
						//System.out.println("Phone == " + existsPhone.next().number());
						phoneNumbers.add(existsPhone.next().number().toString());
					}
				}
				else
				{
					phoneNumbers.add("No phone numbers found...");
				}
			}
		
			JSONObject testObj = new JSONObject();
			//response.getWriter().append( phoneNumbers.toString());
			for(int i = 0; i < phoneNumbers.size(); i++)
			{
				String strToSeperate = phoneNumbers.get(i);
				int idx = strToSeperate.indexOf("National");
				String seperated = strToSeperate.substring(idx, strToSeperate.length());
				strToSeperate = strToSeperate.substring(0, idx);
				testObj.put( seperated, strToSeperate );
			}
			
			ObjectMapper mapper = new ObjectMapper();
		    Object json1 = mapper.readTree(testObj.toString());
		    
		    mapper.enable(SerializationFeature.INDENT_OUTPUT);
			if(testObj.length() > 0)
			{
				response.getWriter().append(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json1));
				//System.out.print(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json1));
			}
			//testObj.clear();
			saveResponse(response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		response.setContentType("text/plain");
		if(getRelativeUrl(request).contains("?file"))
		{
			PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
			
			//InputStream in = new FileInputStream(new File("D:\\Desktop Copy\\School\\Semester 9 - Winter 2018\\DPS909 - Open Source Project\\DPS909Release01\\src\\release01\\Base64.txt"));
			InputStream in = getClass().getResourceAsStream("Base64.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	        StringBuilder out = new StringBuilder();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            out.append(line);
	        }
			//String fileString = in.toString();
			
			phoneUtil.findNumbers(out.toString(), "CA");
			//response.getWriter().append(out.toString());
			
			Iterator<PhoneNumberMatch> existsPhone = PhoneNumberUtil.getInstance().findNumbers(out.toString(), "CA").iterator();
			
			if(existsPhone.hasNext())
			{
				while (existsPhone.hasNext())
				{
					phoneNumbers.add(existsPhone.next().number().toString());
				}
			}
			else
			{
				phoneNumbers.add("No phone numbers found...");
			}
			
			JSONObject testObj = new JSONObject();
			
			for(int i = 0; i < phoneNumbers.size(); i++)
			{
				String strToSeperate = phoneNumbers.get(i);
				int idx = strToSeperate.indexOf("National");
				String seperated = strToSeperate.substring(idx, strToSeperate.length());
				strToSeperate = strToSeperate.substring(0, idx);
				testObj.put( seperated, strToSeperate );
			}

			
			//Gson gson = new GsonBuilder().setPrettyPrinting().create();
			//testObj.toMap();
			//String formmated = gson.toJson(testObj.);
		    
		    ObjectMapper mapper = new ObjectMapper();
		    Object json1 = mapper.readTree(testObj.toString());
		    
		    mapper.enable(SerializationFeature.INDENT_OUTPUT);
			if(testObj.length() > 0)
			{
				response.getWriter().append(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json1));
				//System.out.print(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json1));
			}
				
			saveResponse(response);	
			
			
			//testObj.clear();
		}
		
	}
	
	public static String getRelativeUrl( HttpServletRequest request ) 
	{
		String baseUrl = null;
		    
		if ( ( request.getServerPort() == 80 ) || ( request.getServerPort() == 443 ) )
		    baseUrl = request.getScheme() + "://" + request.getServerName() + request.getContextPath();
		else
		    baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

		StringBuffer buf = request.getRequestURL();

		if ( request.getQueryString() != null ) 
		{
		    buf.append( "?" );
		    buf.append( request.getQueryString() );
		}

		return buf.substring( baseUrl.length() );
	}

	private void saveResponse(HttpServletResponse response)
	{
		res = response;
	}
	
	public HttpServletResponse getResponse()
	{
		return res;
	}
	
	public static ArrayList<String> getPhoneNumbers() {
		return phoneNumbers;
	}
}
