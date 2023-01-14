package olympics;

import java.util.Comparator;

/**
 * John Ross 40314604
 *
 */
public class Medal implements Comparable<Medal>, Comparator<Medal> {

	private int year;
	private String city;
	private String sport;
	private String discipline;
	private String athlete;
	private String country;
	private String gender;
	private String event;
	private String medalType;

	/**
	 * default constructor
	 */
	public Medal() {

	}

	/**
	 * Constructor with args
	 * 
	 * @param year
	 * @param city
	 * @param sport
	 * @param discipline
	 * @param athlete
	 * @param country
	 * @param gender
	 * @param event
	 * @param medalType
	 */
	public Medal(int year, String city, String sport, String discipline, String athlete, String country, String gender,
			String event, String medalType) {
		this.year = year;
		this.city = city;
		this.sport = sport;
		this.discipline = discipline;
		this.athlete = athlete;
		this.country = country;
		this.gender = gender;
		this.event = event;
		this.medalType = medalType;
	}

	/**
	 * @return the event
	 */
	public String getEvent() {
		return event;
	}

	/**
	 * @param event the event to set - i wanted to include the event that was outside
	 *              the parameters so i reset the event with 50 characters to 'event
	 *              too long' but kept the rest of the record included
	 */
	public void setEvent(String event) throws IllegalArgumentException {
		if (event.length() >= 1 && event.length() < 50) {
			this.event = event;
		} else if (event.length() == 50) {
			this.event = "event too long";
		} else {
			throw new IllegalArgumentException("Invalid event");
		}

	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) throws IllegalArgumentException {
		if (year >= 1896) {
			this.year = year;
		} else {
			throw new IllegalArgumentException("invalid year");
		}
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) throws IllegalArgumentException {
		if (city.length() >= 1 && city.length() < 30) {
			this.city = city;
		} else {
			throw new IllegalArgumentException("Invalid city name");
		}
	}

	/**
	 * @return the sport
	 */
	public String getSport() {
		return sport;
	}

	/**
	 * @param sport the sport to set
	 */
	public void setSport(String sport) throws IllegalArgumentException {
		if (sport.length() >= 1 && sport.length() < 50) {
			this.sport = sport;
		} else {
			throw new IllegalArgumentException("Invalid sport name");
		}

	}

	/**
	 * @return the discipline
	 */
	public String getDiscipline() {
		return discipline;
	}

	/**
	 * @param discipline the discipline to set
	 */
	public void setDiscipline(String discipline) throws IllegalArgumentException {
		if (discipline.length() >= 1 && discipline.length() < 80) {
			this.discipline = discipline;
		} else {
			throw new IllegalArgumentException("Invalid discipline");
		}
	}

	/**
	 * @return the athlete
	 */
	public String getAthlete() {
		return athlete;
	}

	/**
	 * @param athlete the athlete to set
	 */
	public void setAthlete(String athlete) throws IllegalArgumentException {
		if (athlete.length() >= 1 && athlete.length() < 80) {
			this.athlete = athlete;
		} else {
			throw new IllegalArgumentException("Invalid athlete format");
		}
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set i wanted to include the records with no
	 *                country name so any records with a blank country code i reset
	 *                the country name to unknown and included the rest of the
	 *                record.
	 */
	public void setCountry(String country) throws IllegalArgumentException {
		if (country.length() == 3) {
			this.country = country;
		} else if (country.length() < 3) {
			this.country = "unknown";
		} else
			throw new IllegalArgumentException("Invalid country");

	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) throws IllegalArgumentException {
		if (gender.length() >= 1 && gender.length() < 10) {
			this.gender = gender;
		} else {
			throw new IllegalArgumentException("Invalid athlete format");
		}

	}

	/**
	 * @return the medalType
	 */
	public String getMedalType() {
		return medalType;
	}

	/**
	 * @param medalType the medalType to set
	 */
	public void setMedalType(int medalType) throws IllegalArgumentException {
		if (medalType == 1) {
			this.medalType = "gold";
		} else if (medalType == 2) {
			this.medalType = "silver";
		} else if (medalType == 3) {
			this.medalType = "bronze";
		} else
			throw new IllegalArgumentException("Invalid");
	}

	/**
	 * method for formatting display of records in starter app
	 */
	public void displayAllRecords() {

		System.out.printf(
				"year : %-4s |country: %-15s |Sport : %-10s |Discipline : %-15s |Athlete : %-30s |Country : %-4s |Gender : %-6s |Event %-26s |Medal Type : %-6s \n",
				this.year, this.city, this.sport, this.discipline, this.athlete, this.country, this.gender, this.event,
				this.medalType);
	}

	/**
	 * method for formatting display of records in roll call search (100m freestyle)
	 */
	public void ouputForRollCall() {
		if (this.gender.equalsIgnoreCase("men")) {
			this.gender = "(m)";
		}
		if (this.gender.equalsIgnoreCase("women")) {
			this.gender = "(f)";
		}
		System.out.println("Year : " + this.year + ", Athlete : " + this.athlete + " " + this.gender);

	}

	@Override
	/**
	 * used for reversing alphabetical order list in search 11 reversed o.athlete
	 * and this.athlete and used collections.sort
	 */
	public int compareTo(Medal o) {
		// TODO Auto-generated method stub
		return o.athlete.compareTo(this.athlete);
	}

	@Override
	public int compare(Medal o1, Medal o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}