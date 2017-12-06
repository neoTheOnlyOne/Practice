package nowapps.nxton;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class InfraMgmt {

	public InfraMgmt() {
		/*
		 * URL url = getClass().getResource("Server.json"); File file = new
		 * File(url.getPath()); doPrintln(file.toPath());
		 */
	}

	public static void main(String args[]) {
		InfraMgmt infra = new InfraMgmt();

		/*
		 * String basePath = new File("").getAbsolutePath();
		 * System.out.println(basePath);
		 * 
		 * String path = new File("Server.json").getAbsolutePath();
		 * System.out.println("full path: " + path);
		 */

		try {
			String pth = "D:/mh_stuff/prac_ws_new/TestProject/src/nowapps/nxton/Server.json";
			FileReader fRead = new FileReader(pth);
			infra.readJSONFile(fRead);
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		}
	}

	public void readJSONFile(FileReader file) {
		// JSONObject obj = (JSONObject) new JSONParser().parse(file);
		JSONParser parser = new JSONParser();
		try {
			// Path pathAbsolute = Paths.get("/Server.info");
			FileReader fRead = new FileReader("D:/mh_stuff/prac_ws_new/TestProject/src/nowapps/nxton/Server.json");

			Object obj = parser.parse(fRead);
			JSONObject jObj = (JSONObject) obj;
			JSONArray serverListJSON = (JSONArray) jObj.get("serverFamily");

			Object serverObjArray[] = serverListJSON.toArray();
			int len = serverObjArray.length;
			ArrayList<ServerInfo> serverList = new ArrayList<ServerInfo>(len);

			for (Object serverObj : serverObjArray) {
				JSONObject serverJObj = (JSONObject) serverObj;
				String serverName = serverJObj.get("name").toString();
				String softwareType = serverJObj.get("softwareType").toString();
				String softwareName = serverJObj.get("softwareName").toString();
				Float softwareVersion = Float.parseFloat(serverJObj.get("softwareVersion").toString());

				ServerInfo serverInfo = new ServerInfo();
				serverInfo.setServerName(serverName);
				serverInfo.setSoftwareType(softwareType);
				serverInfo.setSoftwareName(softwareName);
				serverInfo.setSoftwareVersion(softwareVersion);
				serverList.add(serverInfo);
				doPrintln(serverName + ", " + softwareType + ", " + softwareName + ", " + softwareVersion);
			}

			Collections.sort(serverList, new SortBySoftware());

			String prevSoftware = serverList.get(0).getSoftwareName();
			Float prevVersion = serverList.get(0).getSoftwareVersion();
			String software = null;
			ArrayList<ServerInfo> outDatedList = new ArrayList<ServerInfo>();

			for (ServerInfo sInfo : serverList) {
				if (software == null)
					software = sInfo.getSoftwareName();
				else {
					if (prevSoftware.equals(sInfo.getSoftwareName())) {
						if (prevVersion != sInfo.getSoftwareVersion()) {
							outDatedList.add(sInfo);
						}
					}
					prevSoftware = sInfo.getSoftwareName();
					prevVersion = sInfo.getSoftwareVersion();
				}

				/*
				 * doPrintln(sInfo.getServerName() + ", " + sInfo.getSoftwareType() +", " +
				 * sInfo.getSoftwareName() + ", " + sInfo.getSoftwareVersion());
				 */
			}

			doPrintln("\n\nSorted by software version");
			for (ServerInfo sInfo : outDatedList) {
				doPrintln(sInfo.getServerName() + ", " + sInfo.getSoftwareType() + ", " + sInfo.getSoftwareName() + ", "
						+ sInfo.getSoftwareVersion());
			}

			// doPrintln("list size: " + serverList.tri);

			/*
			 * Iterator<JSONObject> itr = serverList.iterator(); while(itr.hasNext()) {
			 * JSONObject jObj1 = (JSONObject)itr.next(); String serverName =
			 * (String)jObj1.get("name"); doPrint(", " +serverName); }
			 */

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
	}

	class ServerInfo {
		private String serverName;
		private String softwareType;
		private String softwareName;
		private float softwareVersion;

		public String getServerName() {
			return serverName;
		}

		public void setServerName(String serverName) {
			this.serverName = serverName;
		}

		public String getSoftwareType() {
			return softwareType;
		}

		public void setSoftwareType(String softwareType) {
			this.softwareType = softwareType;
		}

		public String getSoftwareName() {
			return softwareName;
		}

		public void setSoftwareName(String softwareName) {
			this.softwareName = softwareName;
		}

		public float getSoftwareVersion() {
			return softwareVersion;
		}

		public void setSoftwareVersion(float softwareVersion) {
			this.softwareVersion = softwareVersion;
		}

		/*
		 * public Comparator<ServerInfo> versionComparator = new
		 * Comparator<ServerInfo>() {
		 * 
		 * @Override public int compare(ServerInfo o1, ServerInfo o2) { if(o1) return 0;
		 * } };
		 */
	}

	// sorts Descending
	class SortByVersion implements Comparator<ServerInfo> {
		@Override
		public int compare(ServerInfo s1, ServerInfo s2) {
			if (s1.getSoftwareVersion() > s2.getSoftwareVersion())
				return -1;
			if (s1.getSoftwareVersion() < s2.getSoftwareVersion())
				return 1;
			return 0;
		}
	}

	/** sorts by two keys : softwareName and softwareVersion*/
	class SortBySoftware implements Comparator<ServerInfo> {
		@Override
		public int compare(ServerInfo s1, ServerInfo s2) {
			int softwareResult = s1.getSoftwareName().compareTo(s2.getSoftwareName());
			if (softwareResult != 0)
				return softwareResult;
			return (s1.getSoftwareVersion() > s2.getSoftwareVersion() ? -1
					: (s1.getSoftwareVersion() < s2.getSoftwareVersion() ? 1 : 0));
		}
	}

	static <T> void doPrintln(T t) {
		System.out.println(t);
	}

	static <T> void doPrint(T t) {
		System.out.print(t);
	}

}
