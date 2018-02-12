package hyperglobal.services;

import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import hyperglobal.dataaccess.PolicyJDBCTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class CreatePolicyService {

	private static final String insertPolicyStatement="insert into policy(transaction_ref, business_data) values(?,?)";
	private static final String insertMessagesStatement="insert into messages(transaction_ref, data_to_send) values(?,?)";
	
	private static final String queryPolicyStatement="select transaction_ref from policy";
	private static final String queryMessagesStatement="select transaction_ref from messages";

	private static final Logger log = LoggerFactory.getLogger(CreatePolicyService.class);


	
	private static final String business_data = "{ 'name' : 'Brian', 'premium' : '100'}";
	private static final String message_data = "{ 'messageType' : 'policyCreation'}";
	
	
	private class Results{
	   String transRef;
	   
	   protected Results(String ref){
		   this.transRef = ref;
	   }
	   	
	}

	
	@Autowired
    PolicyJDBCTemplate policyTemplate;
	
	public CreatePolicyService(){

	}

	@Transactional
	public void addPolicyData(){
		String transactionid = UUID.randomUUID().toString();
		this.policyTemplate.jdbcTemplate().update(insertPolicyStatement, transactionid, business_data);
		this.policyTemplate.jdbcTemplate().update(insertMessagesStatement, transactionid, message_data);
		
	}
	
	public void queryData(){
		this.policyTemplate.jdbcTemplate().query(queryMessagesStatement, (resultSet, rowNum) -> new Results(resultSet.getString("transaction_ref"))
			        ).forEach(result -> log.info("Value in messages table " + result.transRef));
	}

}
