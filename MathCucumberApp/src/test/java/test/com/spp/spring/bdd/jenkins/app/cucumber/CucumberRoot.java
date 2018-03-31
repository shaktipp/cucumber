package test.com.spp.spring.bdd.jenkins.app.cucumber;

import org.junit.Before;
import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.spp.spring.bdd.jenkins.app.MathCucumberAppApplication;

@RunWith( SpringRunner.class )
@SpringBootTest( classes = MathCucumberAppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
@ContextConfiguration( classes = MathCucumberAppApplication.class )
public abstract class CucumberRoot
{
    Logger           logger       = LoggerFactory.getLogger( CucumberRoot.class );
    
    @Autowired
    TestRestTemplate restTemplate = new TestRestTemplate( );

    @Before
    public void before()
    {        
        restTemplate.getRestTemplate( ).setInterceptors( Collections.singletonList( ( request, body, execution ) -> {
            return execution.execute( request, body );
        } ) );
    }

}