package  edu.umb.cs680.hw01;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CalculatorTest {

	@Test
	public void add3and4()
	{
		Calculator cal = new Calculator();
		float actual = cal.addtional(3,4);
		float expected = 7;
		assertEquals(actual, expected);
	}
	
	@Test
	public void sub3By4()
	{
		Calculator cal = new Calculator();
		float actual = cal.sub(4,3);
		float expected = 1;
		assertEquals(actual, expected);
	}
	
	@Test
	public void multiply3By4()
	{
		Calculator cal = new Calculator();
		float actual = cal.mul(3,4);
		float expected = 12;
		assertEquals(actual, expected);
	}
	
	@Test
	public void multiply1_5By2_5()
	{
		Calculator cal = new Calculator();
		float actual = cal.mul(1.5f,2.5f);
		float expected = 3.75f;
		assertEquals(actual, expected);
	}
	@Test
	public void divide2_5By5_5()
	{
		Calculator cal = new Calculator();
		float expected = 2.2f;
		float actual = cal.div(5.5f,2.5f);
		assertEquals(actual, expected); 
	}
	
	
	@Test
	public void divide5By0()
	{
		Calculator cal = new Calculator();
		Assertions.assertThrows(IllegalArgumentException.class, () -> cal.div(5, 0));
	}
}	