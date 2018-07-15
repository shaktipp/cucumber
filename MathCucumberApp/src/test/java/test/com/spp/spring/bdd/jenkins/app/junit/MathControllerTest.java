package test.com.spp.spring.bdd.jenkins.app.junit;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.spp.spring.bdd.jenkins.app.MathCucumberAppApplication;
import com.spp.spring.bdd.jenkins.app.entity.MathInput;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;



@RunWith(SpringRunner.class)
@SpringBootTest(classes =MathCucumberAppApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MathControllerTest 
{
    Logger logger =  LoggerFactory.getLogger(MathControllerTest.class); 
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    TestRestTemplate restTemplate = new TestRestTemplate(); 
    
    @Test
    //@Ignore
    public void addTest()
    {
        logger.info("Enter");
        ResponseEntity<Long> response = restTemplate.exchange("/math/add/5/4", HttpMethod.GET,null, Long.class);
        Long result = response.getBody();
        logger.info("Result found=" + result);
        Assert.assertEquals(new Long(9), result);
        logger.info("Exit");
        
    }
    
    @Test
    //@Ignore
    public void subTest()
    {
        logger.info("Enter");
        ResponseEntity<Long> response = restTemplate.exchange("/math/sub/5/4", HttpMethod.GET,null, Long.class);
        Long result = response.getBody();
        logger.info("Result found=" + result);
        Assert.assertEquals(new Long(1), result);
        logger.info("Exit");
        
    }
    
    @Test
    //@Ignore
    public void mulTest()
    {
        logger.info("Enter");
        ResponseEntity<Long> response = restTemplate.exchange("/math/mul/5/4", HttpMethod.GET,null, Long.class);
        Long result = response.getBody();
        logger.info("Result found=" + result);
        Assert.assertEquals(new Long(20), result);
        logger.info("Exit");
        
    }
    
    @Test
    //@Ignore
    public void divTest()
    {
        logger.info("Enter");
        ResponseEntity<Long> response = restTemplate.exchange("/math/div/10/4", HttpMethod.GET,null, Long.class);
        Long result = response.getBody();
        logger.info("Result found=" + result);
        Assert.assertEquals(new Long(2), result);
        logger.info("Exit");
        
    }
    
    @Test
    //@Ignore
    public void mathCalcTest()
    {
        logger.info("Enter");
        MathInput mathInput = new MathInput(new Long(30),new Long(10),"add");
        HttpEntity<MathInput> requestBody = new HttpEntity<>(mathInput);
        
        ResponseEntity<MathInput> mathCalcResult = restTemplate.exchange("/math/calc", HttpMethod.POST,requestBody, MathInput.class);
        MathInput mathResult = mathCalcResult.getBody();
        
        logger.info("Result found=" + mathResult.disp( ));
        Assert.assertEquals(mathResult.getResult( ), new Long(40));
        logger.info("Exit");
        
    }

}
