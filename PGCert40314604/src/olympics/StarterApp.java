package olympics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * John Ross 40314604
 *
 */
public class StarterApp {

	// stores the data read and mapped for the csv file
	public static ArrayList<Medal> medals = new ArrayList<Medal>();

	/**
	 * Start point for the app
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {

		// read all records in from file
		readInRecordsFromFile(medals);

		// run show menu
		showMenu();
	}

	public static void showMenu() {
		System.out.println();
		Scanner scanner = new Scanner(System.in);
		int option;
		System.out.println("Olympics stats ");
		do {
			System.out.println("1. Display all medals");
			System.out.println("2. Output to screen the details of all Gold medals won by Ireland");
			System.out.println("3. Output to screen the total of all medal types won by a USER INPUTTED country");
			System.out.println("4. Output to screen the records of all medals won in a USER INPUTTED year");
			System.out.println("5. Output to screen the records of all medals won by a Sebastian Coe");
			System.out
					.println("6. Output to screen the last year that a USER INPUTTED sport was played at the olympics");
			System.out.println("7. Output to screen the total medals won by a german athlete (East, West & unified)");
			System.out.println("8. Output to screen the total gold medals won by British men");
			System.out.println(
					"9. Output to screen the Roll Of Honour (Male & Female for the event 100m Freestyle  - Swimming)");
			System.out.println("10. Output to screen the total gold medals each country has won");
			System.out.println("11. Output to screen the records of medals won by Jamaicans in athletics in 2012");
			System.out.println("12. Output to screen a list of cities who have hosted the olympics");
			System.out.println("13. Output to screen a formatted list of records and save to file");
			System.out.println("14. Quit");
			System.out.println("Enter option ...");
			option = scanner.nextInt();

			switch (option) {

			case 1:
				showAllRecords(medals);
				System.out.println();
				break;
			case 2:
				showAllRecords(searchByCountry(medals, "IRL"));
				System.out.println();
				break;
			case 3:
				System.out.println("Please enter a country using 3 letter code .....eg ...GBR,IRL,USA");
				medalTallyByCountry(medals, scanner.next());
				System.out.println();
				break;
			case 4:
				boolean ok = false;
				do {
					try {
						System.out.println("Please enter a year.....eg ...2008");
						showAllRecords(searchByYear(medals, scanner.nextInt()));
						ok = true;
					} catch (Exception e) {
						System.out.println("Invalid input.....make sure you enter a number");
						ok = false;
						scanner.next();
					}
				} while (!ok);
				System.out.println();
				break;
			case 5:
				showAllRecords(searchByAthlete(medals, "coe sebastian"));
				System.out.println();
				break;
			case 6:
				System.out.println("Please enter a sport.....eg ...baseball");
				lastYearSportFeatured(medals, scanner.next());
				System.out.println();
				break;
			case 7:
				allMedalsWonByGermans(medals);
				System.out.println();
				break;
			case 8:
				goldsWonByGenderAndCountry(medals, "men", "gbr");
				System.out.println();
				break;
			case 9:
				rollCallOutput(rollCallFor100MFreestyleSwimming(medals));
				System.out.println();
				break;
			case 10:
				countrysGoldMedals(medals);
				System.out.println();
				break;
			case 11:
				showAllRecords(medalByCountryAndYear(medals, "jam", "athletics", 2012));
				System.out.println();
				break;
			case 12:
				hostCities(medals);
				System.out.println();
				break;
			case 13:
				writeNewFile(medals);
				System.out.println();
				break;
			case 14:
				System.out.println("Quitting");
				break;
			default:
				System.out.println("Try options again...");
				System.out.println();
			}
		} while (option != 14);
		scanner.close();
	}

	/**
	 * reads in records from csv file
	 * 
	 * @param medals
	 */
	public static void readInRecordsFromFile(ArrayList<Medal> medals) {

		// read the csv file data
		File file = new File("summer.csv");
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String medalRecords;
			String[] medalDetails;

			bufferedReader.readLine();
			medalRecords = bufferedReader.readLine();
			bufferedReader.readLine();

			while (medalRecords != null) {
				Medal medal = new Medal();

				medalDetails = medalRecords.split(",");

				medal.setYear(Integer.parseInt(medalDetails[0]));
				medal.setCity(medalDetails[1]);
				medal.setSport(medalDetails[2]);
				medal.setDiscipline(medalDetails[3]);
				medal.setAthlete(medalDetails[4]);
				medal.setCountry(medalDetails[5]);
				medal.setGender(medalDetails[6]);
				medal.setEvent(medalDetails[7]);
				medal.setMedalType(Integer.parseInt(medalDetails[8]));

				// add to arraylist
				medals.add(medal);

				// get new athlete
				medalRecords = bufferedReader.readLine();

			}

			bufferedReader.close();
			fileReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (Exception exception) {
			System.out.println("General issue....");
			exception.printStackTrace();

		}
	}

	/**
	 * Output all stored records to screen
	 * 
	 * @param students
	 */
	private static void showAllRecords(ArrayList<Medal> medals) {
		for (Medal medal : medals) {
			medal.displayAllRecords();

		}
		System.out.println("Total records : " + medals.size());
	}

	/**
	 * this method searches for all details of athletes from a specified country who
	 * won a specified medal type - eg IRL gold medals
	 * 
	 * @param medals
	 * @param country
	 * @return
	 */
	public static ArrayList<Medal> searchByCountry(ArrayList<Medal> medals, String country) {
		System.out.println(country +" gold medals:");
		ArrayList<Medal> searchList = new ArrayList<Medal>();
		for (Medal medal : medals) {
			if (medal.getCountry().equalsIgnoreCase(country) && medal.getMedalType().equalsIgnoreCase("gold")) {
				searchList.add(medal);
			}
		}

		return searchList;
	}

	/**
	 * This method searches for the number of gold, silver and bronze medals won by
	 * a specified country
	 * 
	 * @param medals
	 * @param country
	 * @return
	 */

	public static void medalTallyByCountry(ArrayList<Medal> medals, String country) {

		int goldCount = 0;
		int silverCount = 0;
		int bronzeCount = 0;

		// ArrayList<Medal> searchList = new ArrayList<Medal>();
		for (Medal medal : medals) {
			if (medal.getCountry().equalsIgnoreCase(country) && medal.getMedalType().equalsIgnoreCase("GOLD")) {
				goldCount++;
			} else if (medal.getCountry().equalsIgnoreCase(country)
					&& medal.getMedalType().equalsIgnoreCase("Silver")) {
				silverCount++;
			} else if (medal.getCountry().equalsIgnoreCase(country)
					&& medal.getMedalType().equalsIgnoreCase("Bronze")) {
				bronzeCount++;

			}
		}

		if (goldCount == 0 && silverCount == 0 && bronzeCount == 0) {
			System.out.println("Invalid country.... try again.....");
		} else {
			System.out.println("medals won by : " + country);
			System.out.println("Gold : " + goldCount);
			System.out.println("Silver : " + silverCount);
			System.out.println("Bronze : " + bronzeCount);

		}

	}

	/**
	 * Search for all medals in a specified year returns a message
	 * to screen if an invalid year is input
	 * 
	 * @param medals
	 * @param year
	 * @return
	 */
	public static ArrayList<Medal> searchByYear(ArrayList<Medal> medals, int year) {

		System.out.println("Medals won in year " + year + " :");
		ArrayList<Medal> searchList = new ArrayList<Medal>();
		for (Medal medal : medals) {
			if (medal.getYear() == year) {
				searchList.add(medal);
			}
		}
		if (searchList.isEmpty()) {
			System.out.println("No olympics this year");
		}
		return searchList;
	}

	/**
	 * Search for all medals won by a specified athlete
	 * 
	 * @param medals
	 * @param athleteName
	 * @return
	 */
	public static ArrayList<Medal> searchByAthlete(ArrayList<Medal> medals, String athleteName) {
		System.out.println("Medals won by " + athleteName + " : ");
		ArrayList<Medal> searchList = new ArrayList<Medal>();
		for (Medal medal : medals) {
			if (medal.getAthlete().equalsIgnoreCase(athleteName)) {
				searchList.add(medal);
			}
		}

		return searchList;

	}

	/**
	 * this method adds up the amount of medals won by a German athlete including
	 * athletes from East, West & unified Germany
	 * 
	 * @param medals
	 */
	public static void allMedalsWonByGermans(ArrayList<Medal> medals) {
		int medalCount = 0;
		for (Medal medal : medals) {
			if (medal.getCountry().equalsIgnoreCase("GDR")) {
				medalCount++;
			}
			if (medal.getCountry().equalsIgnoreCase("FRG")) {
				medalCount++;
			}
			if (medal.getCountry().equalsIgnoreCase("GER")) {
				medalCount++;
			}
		}

		System.out.println("Total medals won by a German athlete : " +medalCount);
		System.out.println("Includes medals won by East, West and unified Germany");
	}

	/**
	 * Counts all gold medals won by a specified gender and country
	 * 
	 * @param medals
	 * @param gender
	 * @param country
	 */
	public static void goldsWonByGenderAndCountry(ArrayList<Medal> medals, String gender, String country) {
		int medalCount = 0;
		for (Medal medal : medals) {
			if (medal.getGender().equalsIgnoreCase(gender) && medal.getCountry().equalsIgnoreCase(country)
					&& medal.getMedalType().equalsIgnoreCase("gold")) {
				medalCount++;
			}

		}

		System.out.println("Gold medals won by " + gender + " from " + country + " : " + medalCount);
	}

	/**
	 * Returns a list of swimmers who have won the 100m freestyle event
	 * 
	 * @param medals
	 * @return
	 */
	public static ArrayList<Medal> rollCallFor100MFreestyleSwimming(ArrayList<Medal> medals) {
		System.out.println("All winners of the 100m Freestyle swimming event");
		ArrayList<Medal> searchList = new ArrayList<Medal>();
		for (Medal medal : medals) {
			if (medal.getEvent().equalsIgnoreCase("100M FREESTYLE") && medal.getMedalType().equalsIgnoreCase("Gold")) {
				searchList.add(medal);
			}
		}

		return searchList;

	}

	/**
	 * limited output for roll calls. Prints year, athlete name, and gender
	 * 
	 * @param medals
	 */
	private static void rollCallOutput(ArrayList<Medal> medals) {
		for (Medal medal : medals) {
			medal.ouputForRollCall();

		}
	}

	/**
	 * Display the last year that a specified sport featured in the
	 * olympics
	 * 
	 * @param medals
	 * @param sport
	 */
	public static void lastYearSportFeatured(ArrayList<Medal> medals, String sport) {

		List<Integer> myList = new ArrayList<Integer>();
		int year = 0;

		for (Medal medal : medals) {
			if (medal.getSport().equalsIgnoreCase(sport)) {
				myList.add(medal.getYear());
				Collections.max(myList);
				year = Collections.max(myList);
			}

		}

		if (myList.isEmpty()) {
			System.out.println("Invalid sport....please try again");
		} else {
			System.out.println("Last year for " + sport + " : " + year);
		}
	}

	/**
	 * ReturnS a list of records of Jamaicans in athletics in 2012.
	 * Listed in reverse alphabetical order. used collections.sort
	 * 
	 * @param medals
	 * @param country
	 * @param sport
	 * @param year
	 * @return
	 */
	public static ArrayList<Medal> medalByCountryAndYear(ArrayList<Medal> medals, String country, String sport,
			int year) {
		System.out.println("Records of all Athletics medals won by Jamaicans in 2012 ");
		System.out.println();
		ArrayList<Medal> myList = new ArrayList<>();
		for (Medal medal : medals) {
			if (medal.getCountry().equalsIgnoreCase(country) && medal.getSport().equalsIgnoreCase(sport)
					&& medal.getYear() == year) {
				myList.add(medal);
				Collections.sort(myList);
			}
		}

		return myList;

	}

	/**
	 * This method will return a count of how many gold medals each country has won
	 * 
	 * @param medals
	 */
	public static void countrysGoldMedals(ArrayList<Medal> medals) {
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();

		for (Medal medal : medals) {
			if (medal.getMedalType().equalsIgnoreCase("gold")) {
				String country = medal.getCountry();

				String[] tokens = country.split(",");

				for (String token : tokens) {
					if (treeMap.containsKey(token)) {
						int count = treeMap.get(token);
						treeMap.put(token, count + 1);
					} else {
						treeMap.put(token, 1);
					}
				}

			}

		}
		System.out.println("Roll of honour - Gold Medals");
		for (String key : treeMap.keySet()) {
			System.out.printf("%s %s\n", key, treeMap.get(key));
		}
	}

	/**
	 * ReturnS a list of host cities in Alphabetical order with no
	 * duplicates
	 * 
	 * @param medals
	 */
	public static void hostCities(ArrayList<Medal> medals) {

		SortedSet<String> mySortSet = new TreeSet<String>();

		for (Medal medal : medals) {
			mySortSet.add(medal.getCity());
		}

		System.out.println("Host Cities : ");
		System.out.println(mySortSet);
	}

	/**
	 * Create a new file with a new format and sorted by year. Host
	 * city to uppercase also displays to screen
	 * 
	 * @param medals
	 */
	public static void writeNewFile(ArrayList<Medal> medals) {

		String data = "Year,City,Sport,Athlete,Country,Medal";
		File file = new File("summer_updated.csv");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file, false);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(data);

			for (Medal medal : medals) {
				String year = String.valueOf(medal.getYear());
				String city = medal.getCity().toUpperCase();
				String sport = medal.getSport();
				String athlete = medal.getAthlete();
				String country = medal.getCountry();
				String medalType = medal.getMedalType();

				String[] myArray = { year, city, sport, athlete, country, medalType };

				System.out.println(Arrays.toString(myArray));

				bw.write("\n");
				bw.write(Arrays.toString(myArray));

			}
			bw.flush();
			bw.close();
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong");
			System.out.println("the end");
		}
	}
}
