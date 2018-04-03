package test.com.spp.spring.bdd.jenkins.app.cucumber;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.spp.spring.bdd.jenkins.app.entity.MathInput;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MathAppCucumberPostXmlTest extends CucumberRoot
{
    private ResponseEntity< Long > response; // output
    
    List<MathInput> mathInput_response_list = new ArrayList<>();

 
    @When("^the client calls POST /math/calc with :$")
    public void the_client_calls_POST_math_calc_with(DataTable arg1) throws Throwable 
    {
    	List<MathInput> mathInput_input_list = arg1.asList(MathInput.class) ;
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_XML);
    	
    	for(MathInput mathInput : mathInput_input_list)
    	{
    		HttpEntity<MathInput> entity = new HttpEntity<MathInput>(mathInput, headers);
    		ResponseEntity<MathInput> responseentiry= restTemplate.postForEntity("/math/calc", entity, MathInput.class);
    		mathInput_response_list.add(responseentiry.getBody());
    		logger.info( "mathResponse\n" + responseentiry.getBody().disp());
    		
    	}	
    	assertEquals(mathInput_response_list.size() > 0, true);
    	
        
    }

    @Then("^the response has the following attributes:$")
    public void the_response_has_the_following_attributes(DataTable arg1) throws Throwable 
    {
    	List<MathInput> mathInput_outputProvided_list = arg1.asList(MathInput.class) ;
    	
    	for(int i=0; i < mathInput_outputProvided_list.size();i++)
    	{
    		if(mathInput_outputProvided_list.get(i).getResult().equals( mathInput_response_list.get(i).getResult()))
    		{
    			logger.info("\nTest Case Passed");
    			logger.info("Math Input, Index=" + i + " , Value=" + mathInput_response_list.get(i).disp());
    			logger.info("Math Output, Index=" + i + " , Value=" + mathInput_outputProvided_list.get(i).disp());
    		}
    		else
    		{  
    			logger.info("\nTest Case Failed");
    			logger.info("Math Input, Index=" + i + " , Value=" + mathInput_response_list.get(i).disp());
    			logger.info("Math Output, Index=" + i + " , Value=" + mathInput_outputProvided_list.get(i).disp());
    			logger.info(mathInput_outputProvided_list.get(i).getResult() + " = " + mathInput_response_list.get(i).getResult());
    			fail("Mismatch the Input and output");
    			
    		}
    		
    	}
    	
    	
    }
    
    @Test
    public void samplePostTest()
    {
        System.out.println( "Sample REST With POST Data" );
    }

   

}// End of class MathAppCucumberPostXmlTest