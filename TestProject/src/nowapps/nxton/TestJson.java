package nowapps.nxton;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;

public class TestJson {

	public static void main(String args[]) {
		List<String> list = new ArrayList<String>();
		list.add("Anil");
		list.add("00145289BCZ77");
		list.add("MH12-VF-3990");
		
		Date currentTime = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		JSONObject jObj = new JSONObject();
		jObj.put("name", "Anil");
		jObj.put("smartCardId", "00145289BCZ77");
		jObj.put("VehicleNo", "MH12-VF-3990");
		jObj.put("entryTime", dateFormat.format(currentTime));
		
		try {
			FileWriter file = new FileWriter("E:/java_prac/test.json");
			file.write(jObj.toJSONString());
			file.flush();
			file.close();
		} catch(IOException io) {
			System.out.println("Exception occured: " + io);
			io.printStackTrace();
		}
		
		System.out.println(jObj);
		
		
		Arrays.asList(null);
		
	}
}
