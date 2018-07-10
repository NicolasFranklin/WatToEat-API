import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//  4f9804d8ba1a13f66833607fba6a555f  Waterloo Food Services

// AIzaSyB_SCwVfVXAgUO7_m5GOqfV7uLfA0Qrml0 Google Maps

// https://dzone.com/articles/how-to-parse-json-data-from-a-rest-api-using-simpl

//https://api.uwaterloo.ca/v2/
//https://api.uwaterloo.ca/v2/foodservices/locations.json?key=4f9804d8ba1a13f66833607fba6a555f

public class WatToEatApi {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Long> id = new ArrayList<Long>();
		
		
		URL url = new URL("https://api.uwaterloo.ca/v2/foodservices/locations.json?key=4f9804d8ba1a13f66833607fba6a555f"); 
		
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		
		conn.setRequestMethod("GET");
		
		conn.connect(); 
		
		int responsecode = conn.getResponseCode(); 
		
		if(responsecode != 200)
			throw new RuntimeException("HttpResponseCode: " +responsecode);
			else
			{
				Scanner sc = new Scanner(url.openStream());
				String inline = "";
				System.out.println("JSON data in string format");
				while(sc.hasNext())
				{
					inline += sc.nextLine() +"\n";
					//System.out.println(inline);
				}
				sc.close();
				
				JSONObject test = (JSONObject) new JSONParser().parse(inline);
				
				test.get("data");
				
				// loop array
	            JSONArray msg = (JSONArray) test.get("data");
	            Iterator<JSONObject> iterator = msg.iterator();
	            while (iterator.hasNext()) {
	                //System.out.println(iterator.next());
	            	JSONObject item = iterator.next();
	            	System.out.println(item.get("outlet_name"));
	            	names.add((String) item.get("outlet_name"));
	            }
	            
	        
	            
	            JSONObject storeID = (JSONObject) new JSONParser().parse(inline);
				
				storeID.get("data");
	            
				// loop array
	            JSONArray msg2 = (JSONArray) test.get("data");
	            Iterator<JSONObject> iterator2 = msg2.iterator();
	            while (iterator2.hasNext()) {
	                //System.out.println(iterator.next());
	            	JSONObject item = iterator2.next();
	            	//System.out.println(item.get("outlet_id"));
	            	id.add((Long) item.get("outlet_id"));
	            }
	            
	            System.out.println(names);
	            System.out.println(id);
	            
	            
				
				System.out.println("JSON data in string format");

				
				
				
				//Want: Outlet_name, description, Location
				
			}
		
		
		
	}

}
