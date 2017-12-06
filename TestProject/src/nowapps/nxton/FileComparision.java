/**
 * 
 */
package nowapps.nxton;

import java.lang.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;

/**
 * @author Mahesh
 *
 */

public class FileComparision {

	static String pathSrc = "L:\\Seagate Dashboard 2.0\\HOMELP\\Mahesh\\Backup\\8e45baaa-ad5a-4967-8bd0-9b6c97525f10\\20140523_115112_Mahesh\\I\\Songs";
	static String pathToFindMissingObj = "F:\\songs";

	static ArrayList<String> fileListPopu = new ArrayList<String>();	//file name list
	static ArrayList<Double> fileSizePopu = new ArrayList<Double>();	//file size to be stored in KB

	static ArrayList<String> fileListSrc = new ArrayList<String>();
	static ArrayList<String> fileListToFindMissingObj = new ArrayList<String>();
	static ArrayList<Double> fileSizeOfMissingObj = new ArrayList<Double>();	//file size in KB

	static ArrayList<String> matchingFiles = new ArrayList<String>();
	static ArrayList<String> missingFiles1 = new ArrayList<String>();
	static ArrayList<String> missingFiles2 = new ArrayList<String>();

	static ArrayList<String> missingFilesPath1 = new ArrayList<String>();

	static void listFilesAndFolders(String dirPath, boolean searchInDepth) {

		try {
			File directory = new File(dirPath);
			File[] fileList = directory.listFiles();
			if(fileList == null || fileList.length == 0) {
				throw new Exception("No files found for path: \n" + dirPath);
			} else {

				for(File file: fileList) {
					if(file.isFile()) {
						fileListPopu.add(file.getName());
						fileSizePopu.add((double)file.length() / 1024);
					}

					if(file.isDirectory() && searchInDepth)
						listFilesAndFolders(file.getAbsolutePath(), searchInDepth);
				}
				//fileListPopu.sort(String::compareToIgnoreCase);
			}

		} catch(SecurityException se) {
			System.out.println("Security exception: " + se);
		}
		catch (Exception e) {
			System.out.println("exception: " + e);
		}
	}


	/**
		finds missing files/objects from the given list
		list1 : Source List of files
		list2 : List of files - to find missing files
	*/
	static void findMissingFiles(ArrayList<String> list1, ArrayList<String> listToChkForMissingObj) {
		boolean found = false;
		for(String file : list1) {
			if(listToChkForMissingObj.contains(file)) {
				found = true;
				matchingFiles.add(file);
			} else {
				missingFiles1.add(file);
				found = false;
			}
		}
		//Iterator iter =
		print("Missing files from ." + pathToFindMissingObj + "\n");
		System.out.println("missingFiles size ...." + missingFiles1.size());

		for(String file : missingFiles1) {
			System.out.println(file);
		}

		/*System.out.println("matchingFiles size ...." + matchingFiles.size());
		for(String file : matchingFiles) {
			System.out.println(file);
		}*/

	}

	class FileObjectHolder {
		List<String> filePath = new ArrayList<String>();
		List<Double> fileSizeInKB = new ArrayList<Double>();

		List<Double> getFileSizeInKB() {
			return fileSizeInKB;
		}
	}


	static public void main(String args[]) {

		//String path1 = "L:\\Seagate Dashboard 2.0\\HOMELP\\Mahesh\\Backup\\8e45baaa-ad5a-4967-8bd0-9b6c97525f10\\20140523_115112_Mahesh\\I\\videos\\TV_Serials\\Devo_Ke_Dev_Mahadev";
		//String path2 = "E:\\Torrent_Downloads/DEVON KE DEV MAHADEV (1-425)";


		if(args.length > 0) {
			pathSrc = args[0];
			pathToFindMissingObj = args[1];
		}

		//Source File Path
		System.out.println("list of files Source => \n ");
		ArrayList<String> objList = new ArrayList<String>();

		listFilesAndFolders(pathSrc, true);
		fileListSrc = fileListPopu;
		System.out.println("fileListSrc size=> " + fileListSrc.size());

		fileListPopu = new ArrayList<String>();
		fileSizePopu = new ArrayList<Double>();

		//File Path of Missing Objects to be found
		System.out.println("List of files - to find missing files=> \n ");
		listFilesAndFolders(pathToFindMissingObj, true);
		fileListToFindMissingObj = fileListPopu;
		fileSizeOfMissingObj = fileSizePopu;
		System.out.println("fileListToFindMissingObj size=> " + fileListToFindMissingObj.size());

		if(fileListSrc != null && fileListSrc.size() > 0) {
			findMissingFiles(fileListSrc, fileListToFindMissingObj);
		} else {
			print("no files to compare!");
		}

		//test();

		//testSS();
		//test2();

	}


	static void test() {
		try {
			long fileCount = Files.list(Paths.get("E:/Torrent_Downloads/DEVON KE DEV MAHADEV (1-425)")).count();
			System.out.println("fileCount");
		} catch(IOException ioe) {
			System.out.println("IOException => " + ioe);
		}
	}


	static void testSS() {
		Random r = new Random();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		ArrayList<Integer> similarElements = new ArrayList<Integer>();
		ArrayList<Integer> missingList1 = new ArrayList<Integer>();
		ArrayList<Integer> missingList2 = new ArrayList<Integer>();

		for(int i=1; i<20000; i++) {
			int number = r.nextInt(20000);
			list1.add(new Integer(number));
		}
		for(int i=1; i<20000; i++) {
			int number = r.nextInt(2000);
			list2.add(new Integer(number));
		}

		Iterator iter1 = list1.iterator();
		while(iter1.hasNext()) {
			Integer in = (Integer)iter1.next();
			if(list2.contains(in)) {
				similarElements.add(in);
			} else {
				missingList2.add(in);
			}
		}

		Iterator iter2 = list2.iterator();
		while(iter2.hasNext()) {
			Integer in = (Integer)iter2.next();
			if(!list2.contains(in)) {
				missingList1.add(in);
			}
		}

		System.out.println();

	}

	static void test2() {
		Integer i1 = new Integer(10);
		Integer i2 = new Integer(10);

		print(i1 == i2);

		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		arr1.add(i1);
		arr1.add(i2);

		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.add(new Integer(10));
		arr2.add(new Integer(10));

		print("arrayList comparision: ");
		print(arr1.get(0) == arr2.get(0)); //

		print("Integer comparision: ");
		print(i1 == i2);

		Integer i3 = new Integer(10);

		if(arr1.contains(i3)) {
			print("arr1 contains i3 - true");
		} else {
			print("arr1 contains i3 - false");
		}

	}

	static void print(Object obj) {
		System.out.println(obj);
	}

}





/*
Backup path:

Songs
L:\Seagate Dashboard 2.0\HOMELP\Mahesh\Backup\8e45baaa-ad5a-4967-8bd0-9b6c97525f10\20140523_115112_Mahesh\I\Songs
Videos
L:\Seagate Dashboard 2.0\HOMELP\Mahesh\Backup\8e45baaa-ad5a-4967-8bd0-9b6c97525f10\20140523_115112_Mahesh\I\Videos
Photos
L:\Seagate Dashboard 2.0\HOMELP\Mahesh\Backup\8e45baaa-ad5a-4967-8bd0-9b6c97525f10\20140523_115112_Mahesh\I\photos


Videos
L:\Seagate Dashboard 2.0\HOMELP\Mahesh\Backup\8e45baaa-ad5a-4967-8bd0-9b6c97525f10\20140524_102157_MaheshInc1\I\videos





*/

