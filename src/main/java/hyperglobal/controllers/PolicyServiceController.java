package hyperglobal.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hyperglobal.services.CreatePolicyService;

@RestController
public class PolicyServiceController {
	
	private static final Logger log = LoggerFactory.getLogger(PolicyServiceController.class);
	
	@Autowired
	protected CreatePolicyService policyService;
	
	
	public void setPolicyService(CreatePolicyService policyService) {
		this.policyService = policyService;
	}


	@PostMapping("/addPolicy")
	public @ResponseBody ResponseEntity<String> addPolicyRequest() {
		log.info("start contoller ");
		policyService.addPolicyData();		
		policyService.queryData();
	    return new ResponseEntity<String>("Policy Added", HttpStatus.OK);
	}
}
