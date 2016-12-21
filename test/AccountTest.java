import static org.junit.Assert.assertEquals;

public class AccountTest {

	public void testEbaoSantBoletoParse() {
		String ourNumber = "00000007185952";
		System.out.println(Long.valueOf(ourNumber.substring(1,ourNumber.length()-1)));
		assertEquals(Long.valueOf("718595"), Long.valueOf(ourNumber.substring(1,ourNumber.length()-1)));
	}
}
