import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.bluebank.domain.model.Account;
import com.bluebank.domain.model.Customer;
import com.bluebank.domain.model.Transaction;
import com.bluebank.domain.repository.AccountRepository;
import com.github.springtestdbunit.DbUnitTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:com/bluebank/**/WEB-INF/spring-context.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,TransactionalTestExecutionListener.class,DbUnitTestExecutionListener.class})
public class DBTest {
	
	@Autowired
	private AccountRepository acc;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Test
	public void saveNewAccount() throws ParseException {
		
		String accountNumber = "20161221000000001";
		boolean isActive = true;
		Calendar startDate = Calendar.getInstance();
		startDate.setTime(sdf.parse("21/12/2016"));
		Calendar endDate = Calendar.getInstance();
		endDate.setTime(sdf.parse("31/12/2100"));
		BigDecimal balance = new BigDecimal("30000.00");
		BigDecimal dailyLimit = new BigDecimal("2000.00");
		List<Transaction> transactionsList = new LinkedList<Transaction>();
		
		Customer accountHolder = new Customer();
		accountHolder.setName("Mauricio Heidi Seii");
		Calendar birthDate = Calendar.getInstance();
		birthDate.setTime(sdf.parse("24/05/1990"));
		accountHolder.setBirthDate(birthDate);
		accountHolder.setSsn("34804857826");
		
		Account entity = new Account(accountNumber, isActive, startDate, endDate, accountHolder, balance, dailyLimit, transactionsList);
		Assert.assertNotNull(acc.save(entity));
	}

}
