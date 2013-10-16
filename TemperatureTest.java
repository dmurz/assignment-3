/** 
 * @author Aditya Mahajan <aditya.mahajan@mcgill.ca>
 * @version 2013.10.06
 * Unit Testing Temperature class
 */

import org.junit.* ;

import static org.junit.Assert.* ;

public class TemperatureTest {
	
	//precision of 1e-6
	final double PRECISION_VALUE = 0.000001;

	@Test
	//getValue() tests
	//possible values are negative and positive
	public void getValueTest() {
		//0.0 Kelvin, negative Kelvin throws an Exception
		Temperature boundaryTest = new Temperature(0.0,Temperature.Units.KELVIN);
		assertEquals("expected 0.0 Kelvin", 0.0, boundaryTest.getValue(), PRECISION_VALUE);

		//positive input 5.0 Celsius
		Temperature positiveCTest = new Temperature(5.0, Temperature.Units.CELSIUS);
		assertEquals("expected 5.0 Celsius", 5.0, positiveCTest.getValue(), PRECISION_VALUE);

		//negative input -5.0 Celsius
		Temperature negativeCTest = new Temperature(-5.0, Temperature.Units.CELSIUS);
		assertEquals("expected -5.0 Celsius", -5.0, negativeCTest.getValue(), PRECISION_VALUE);

		//positive input 5.0 Fahrenheit
		Temperature positiveFTest = new Temperature(5.0, Temperature.Units.FAHRENHEIT);
		assertEquals("expected 5.0 Fahrenheit", 5.0, positiveFTest.getValue(), PRECISION_VALUE);

		//negative input -5.0 Fahrenheit
		Temperature negativeFTest = new Temperature(-5.0, Temperature.Units.FAHRENHEIT);
		assertEquals("expected -5.0 Fahrenheit", -5.0, negativeFTest.getValue(), PRECISION_VALUE);
	}

	@Test
	//getUnits() tests
	// 3 possible values - celsius, fahrenheit, kelvin
	public void getUnitsTest() {
		//Celsius input
		Temperature celsiusTest = new Temperature(10.0, Temperature.Units.CELSIUS);
		assertEquals("expected Celsius", Temperature.Units.CELSIUS, celsiusTest.getUnits()); 

		//Fahrenheit input
		Temperature fahrenheitTest = new Temperature(10.0, Temperature.Units.FAHRENHEIT); 
		assertEquals("expected Fahrenheit", Temperature.Units.FAHRENHEIT, fahrenheitTest.getUnits()); 

		//Kelvin input
		Temperature kelvinTest = new Temperature(10.0, Temperature.Units.KELVIN);
		assertEquals("expected Kelvin", Temperature.Units.KELVIN, kelvinTest.getUnits()); 
	}

	
	/* 
	*  6 possible conversions : 
	*  celsius -> kelvin, fahrenheit
	*  kelvin -> celsius, fahrenheit
	*  fahrenheit -> celsius, kelvin 
	*/

	@Test
	//celsius changeUnits() tests
	public void cChangeUnitsTest() {
		//celsius -> kelvin
		Temperature cToK = new Temperature(0.0, Temperature.Units.CELSIUS);
		cToK.changeUnits(Temperature.Units.KELVIN);
		assertEquals("expected 273.15", 273.15, cToK.getValue(), PRECISION_VALUE);
		assertEquals("expected Kelvin", Temperature.Units.KELVIN, cToK.getUnits());

		//celsius -> fahrenheit
		Temperature cToF = new Temperature(0.0, Temperature.Units.CELSIUS);
		cToF.changeUnits(Temperature.Units.FAHRENHEIT);
		assertEquals("expected 32.0", 32.0, cToF.getValue(), PRECISION_VALUE);
		assertEquals("expected Fahrenheit", Temperature.Units.FAHRENHEIT, cToF.getUnits());

	}

	@Test
	//fahrenheit changeUnits() tests
	public void fChangeUnitsTest() {
		//fahrenheit -> kelvin
		Temperature fToK = new Temperature(0.0, Temperature.Units.FAHRENHEIT);
		fToK.changeUnits(Temperature.Units.KELVIN);
		assertEquals("expected 255.372", 255.372, fToK.getValue(), PRECISION_VALUE);
		assertEquals("expected Kelvin", Temperature.Units.KELVIN, fToK.getUnits());

		//fahrenheit -> celsius
		Temperature fToC = new Temperature(0.0, Temperature.Units.FAHRENHEIT);
		fToC.changeUnits(Temperature.Units.CELSIUS);
		assertEquals("expected -17.7778", -17.7778, fToC.getValue(), PRECISION_VALUE);
		assertEquals("expected Fahrenheit", Temperature.Units.CELSIUS, fToC.getUnits());

	}

	@Test
	//Kelvin changeUnits() tests
	public void kChangeUnitsTest() {
		//Kelvin -> celsius
		Temperature kToC = new Temperature(0.0, Temperature.Units.KELVIN);
		kToC.changeUnits(Temperature.Units.CELSIUS);
		assertEquals("expected -273.15", -273.15, kToC.getValue(), PRECISION_VALUE);
		assertEquals("expected Celsius", Temperature.Units.CELSIUS, kToC.getUnits());

		//Kelvin -> fahrenheit
		Temperature kToF = new Temperature(0.0, Temperature.Units.KELVIN);
		kToF.changeUnits(Temperature.Units.FAHRENHEIT);
		assertEquals("expected -459.67", -459.67, kToF.getValue(), PRECISION_VALUE);
		assertEquals("expected Fahrenheit", Temperature.Units.FAHRENHEIT, kToF.getUnits());

	}

	
}
