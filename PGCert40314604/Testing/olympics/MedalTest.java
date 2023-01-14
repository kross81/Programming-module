package olympics;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * John Ross 40314604
 * 
 * junit testing for medal class
 */
class MedalTest {

	// test data
	int yearValid, yearInvalid;
	String characterValid, characterInvalid, countryValid, countryInvalid, countrycharacterValid,
			countrycharacterInvalid, genderUpperLimitInvalid, medalTypeTestValid, characterUpperInvalid;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {

		yearValid = 2012;
		yearInvalid = 1880;
		characterValid = "good";
		characterInvalid = "";
		countrycharacterValid = "aaa";
		countrycharacterInvalid = "aaaa";
		genderUpperLimitInvalid = "genderUpperLimit";
		medalTypeTestValid = "gold";
		characterUpperInvalid = "characterUpperInvalidcharacterUpperInvalidcharacterUpperInvalidcharacterUpperInvalid";
	}

	/**
	 * Test method for {@link olympics.Medal#Medal()}.
	 */
	@Test
	final void testMedalDefaultConstructor() {
		Medal myMedal = new Medal();
		assertNotNull(myMedal);
	}

	/**
	 * Should be a number greater than 1880 Test method for
	 * {@link olympics.Medal#Medal(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testNonDefaultConstructor() {
		Medal myMedal = new Medal(yearValid, characterValid, characterValid, characterValid, characterValid,
				countrycharacterValid, characterValid, characterValid, characterValid);
		assertNotNull(myMedal);

		assertEquals(yearValid, myMedal.getYear());
	}

	/**
	 * Test method for {@link olympics.Medal#getEvent()}. Should be more than 1 but
	 * less than 50 characters
	 */
	@Test
	final void testSetGetEventValid() {
		Medal myMedal = new Medal();
		myMedal.setEvent(characterValid);
		assertEquals(characterValid, myMedal.getEvent());
	}

	/**
	 * Test method for {@link olympics.Medal#setEvent(java.lang.String)}. Should be
	 * more than 1 but less than 50 characters
	 */
	@Test
	final void testSetGetEventInvalid() {
		Medal myMedal = new Medal();
		assertThrows(IllegalArgumentException.class, () -> {
			myMedal.setEvent(characterInvalid);
			;
		});
	}

	/**
	 * Test method for {@link olympics.Medal#getYear()}.
	 */
	@Test
	final void testGetSetYearValid() {
		Medal myMedal = new Medal();
		myMedal.setYear(yearValid);
		assertEquals(yearValid, myMedal.getYear());
	}

	/**
	 * Test method for {@link olympics.Medal#setYear(int)}.
	 */
	@Test
	final void testGetSetYearInvalid() {
		Medal myMedal = new Medal();
		assertThrows(IllegalArgumentException.class, () -> {
			myMedal.setYear(yearInvalid);
		});

	}

	/**
	 * Test method for {@link olympics.Medal#getCity()}.
	 */
	@Test
	final void testGetSetCityValid() {
		Medal myMedal = new Medal();
		myMedal.setCity(characterValid);
		assertEquals(characterValid, myMedal.getCity());
	}

	/**
	 * Test method for {@link olympics.Medal#setCity(java.lang.String)}.
	 */
	@Test
	final void testGetSetCityInvalid() {
		Medal myMedal = new Medal();
		assertThrows(IllegalArgumentException.class, () -> {
			myMedal.setCity(characterInvalid);
			;
		});
	}

	/**
	 * Test method for {@link olympics.Medal#getSport()}.
	 */
	@Test
	final void testGetSetSportValid() {
		Medal myMedal = new Medal();
		myMedal.setSport(characterValid);
		assertEquals(characterValid, myMedal.getSport());
	}

	/**
	 * Test method for {@link olympics.Medal#setSport(java.lang.String)}.
	 */
	@Test
	final void testGetSetSportInvalid() {
		Medal myMedal = new Medal();
		assertThrows(IllegalArgumentException.class, () -> {
			myMedal.setSport(characterInvalid);
			;
		});
	}

	/**
	 * Test method for {@link olympics.Medal#getDiscipline()}.
	 */
	@Test
	final void testGetSetDisciplineValid() {
		Medal myMedal = new Medal();

		myMedal.setDiscipline(characterValid);
		assertEquals(characterValid, myMedal.getDiscipline());

	}

	/**
	 * Test method for {@link olympics.Medal#setDiscipline(java.lang.String)}.
	 */
	@Test
	final void testGetSetDisciplineInvalid() {
		Medal myMedal = new Medal();

		assertThrows(IllegalArgumentException.class, () -> {
			myMedal.setDiscipline(characterInvalid);
			;
		});

	}

	/**
	 * Test method for {@link olympics.Medal#getAthlete()}.
	 */
	@Test
	final void testGetSetAthleteValid() {
		Medal myMedal = new Medal();
		myMedal.setAthlete(characterValid);
		assertEquals(characterValid, myMedal.getAthlete());
	}

	/**
	 * Test method for {@link olympics.Medal#setAthlete(java.lang.String)}.
	 */
	@Test
	final void testGetSetAthleteInvalid() {
		Medal myMedal = new Medal();
		assertThrows(IllegalArgumentException.class, () -> {
			myMedal.setAthlete(characterInvalid);
			;
		});
	}

	/**
	 * Test method for {@link olympics.Medal#getCountry()}.
	 */
	@Test
	final void testGetSetCountryValid() {
		Medal myMedal = new Medal();
		myMedal.setAthlete(countrycharacterValid);
		assertEquals(countrycharacterValid, myMedal.getAthlete());
	}

	/**
	 * Test method for {@link olympics.Medal#setCountry(java.lang.String)}.
	 */
	@Test
	final void testGetSetCountryInvalid() {
		Medal myMedal = new Medal();
		assertThrows(IllegalArgumentException.class, () -> {
			myMedal.setCountry(countrycharacterInvalid);
			;
		});
	}

	/**
	 * Test method for {@link olympics.Medal#getGender()}.
	 */
	@Test
	final void testGetSetGenderValid() {
		Medal myMedal = new Medal();
		myMedal.setGender(characterValid);
		assertEquals(characterValid, myMedal.getGender());
	}

	/**
	 * Test method for {@link olympics.Medal#setGender(java.lang.String)}.
	 */
	@Test
	final void testGetSetGenderInvalidUpperLimit() {
		Medal myMedal = new Medal();
		assertThrows(IllegalArgumentException.class, () -> {
			myMedal.setGender(genderUpperLimitInvalid);
			;
		});
	}

	/**
	 * Test method for {@link olympics.Medal#getMedalType()}.
	 */
	@Test
	final void testGetSetMedalTypeValid() {
		Medal myMedal = new Medal();
		String expected = medalTypeTestValid;
		myMedal.setMedalType(1);
		String actual = myMedal.getMedalType();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link olympics.Medal#setMedalType(int)}.
	 */
	@Test
	final void testGetSetMedalTypeInvalid() {
		Medal myMedal = new Medal();
		assertThrows(IllegalArgumentException.class, () -> {
			myMedal.setMedalType(4);
			;
		});

	}

}
