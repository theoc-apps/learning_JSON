package learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;





import com.google.gson.Gson;

public class main {
	
	private static String readUrl(String urlString) throws Exception {
	    BufferedReader reader = null;
	    try {
	        URL url = new URL(urlString);
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        while ((read = reader.read(chars)) != -1)
	            buffer.append(chars, 0, read); 

	        return buffer.toString();
	    } finally {
	        if (reader != null)
	            reader.close();
	    }
	}
		
	public static void main(String[] args) throws Exception {
	    Gson gson = new Gson(); 
	    String json = readUrl("http://www1.toronto.ca/City_Of_Toronto/Information_&_Technology/Open_Data/Data_Sets/Assets/Files/greenPParking.json");
	    
	    Parking parkinglots = gson.fromJson(json, Parking.class);
	    //Carparks carparks = gson.fromJson(parkinglots.getCarparks(), Carparks.class);
	    
	    String test = parkinglots.getCarparks().get(0).toString();
	    
	    System.out.println(test);
	    Carparks carparks = gson.fromJson(test, Carparks);
	    for (Carparks carparks : parkinglots.getCarparks())
	        System.out.println("    " + carparks.getId());
	    
	    //for (int i = 0; i < carpark.size(); i++){
	    //	System.out.println(carpark.get(i));
	    //}
	    //parkinglots.setCarparks(parkinglots.getCarparks());
	    //System.out.println(carparks.getId());
	    
	    
	    //System.out.println(json);
	    
	    //for (carparks item : page.items)
	    //    System.out.println("    " + item.id);
	    
	    /*
	    Page page = gson.fromJson(json, Page.class);

	    System.out.println(page.title);
	    for (Item item : page.items)
	        System.out.println("    " + item.description);
	        */
	}

	

}
