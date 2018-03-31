package test.com.spp.spring.bdd.jenkins.app.cucumber;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MathAppCucumberTest extends CucumberRoot
{
    private ResponseEntity< Long > response; // output

    @When( "^the client calls GET /math/add/(\\d+)/(\\d+)$" )
    public void the_client_calls_GET_math_add( int num1, int num2 ) throws Throwable
    {
        response = restTemplate.getForEntity( "/math/add/20/10", Long.class );
        logger.info( "Input Provided num1=" + num1 + " , num2=" + num2 + "\nResponse=" + response );
    }

    @Then( "^the client receives response status code of (\\d+)$" )
    public void the_client_receives_response_status_code_of( int statusCode ) throws Throwable
    {
        HttpStatus currentStatusCode = response.getStatusCode( );
        logger.info( "Input Provided statusCode=" + statusCode + " , Actual Status Code found=" + currentStatusCode.value( ) );
        assertThat( "status code is incorrect : " + response.getBody( ), currentStatusCode.value( ), is( statusCode ) );
    }

    @When( "^the client calls GET \"/math/add/(\\d+)/(\\d+) validate result$" )
    public void the_client_calls_GET_math_add_validate_result( int num1, int num2 ) throws Throwable
    {
        String lv_url = "/math/add/" + num1 + "/" + num2;
        response = null;
        response = restTemplate.getForEntity( lv_url, Long.class );
        logger.info( "Input Provided firstOperand=" + num1 + " , secondOperand=" + num2 + "\nResponse=" + response.getBody( ) );
    }

    @Then( "^the client receives output of addition operation response status code of (\\d+)$" )
    public void the_client_receives_output_of_addition_operation_response_status_code_of( int statusCode ) throws Throwable
    {
        HttpStatus currentStatusCode = response.getStatusCode( );
        logger.info( "Input Provided statusCode=" + statusCode + " , Actual Status Code found=" + currentStatusCode.value( ) );
        assertThat( "status code is incorrect : " + response.getBody( ), currentStatusCode.value( ), is( statusCode ) );
    }

    @Then( "^match \\$ == (\\d+)L$" )
    public void match_$_L( Long result ) throws Throwable
    {
        Long lv_result = response.getBody( );
        logger.info( "Input Provided result of addition of 30 and 20=" + result + " , Actual Status Code found=" + lv_result );
        assertThat( "Result of Addition is incorrect : " + response.getBody( ), lv_result, is( result ) );
    }

    @When( "^the client calls GET \"/math/sub/(\\d+)/(\\d+) validate result$" )
    public void the_client_calls_GET_math_sub_validate_result( int num1, int num2 ) throws Throwable
    {
        String lv_url = "/math/sub/" + num1 + "/" + num2;
        response = null;
        response = restTemplate.getForEntity( lv_url, Long.class );
        logger.info( "Input Provided for Subtraction num1=" + num1 + " , num2=" + num2 + "\nResponse=" + response.getBody( ) );
    }

    @Then( "^the client receives output of subtraction operation response status code of (\\d+)$" )
    public void the_client_receives_output_of_subtraction_operation_response_status_code_of( int statusCode ) throws Throwable
    {
        HttpStatus currentStatusCode = response.getStatusCode( );
        logger.info( "Input Provided statusCode=" + statusCode + " , Actual Status Code found=" + currentStatusCode.value( ) );
        assertThat( "status code is incorrect for Subtraction : " + response.getBody( ), currentStatusCode.value( ), is( statusCode ) );
    }

    @Then( "^the subtraction result match \\$ == (\\d+)L$" )
    public void the_subtraction_result_match_$_L( Long result ) throws Throwable
    {
        Long lv_result = response.getBody( );
        logger.info( "Input Provided result of Subtraction of 45 and 15=" + result + " , Actual Status Code found=" + lv_result );
        assertThat( "Result of Subtraction is incorrect : " + response.getBody( ), lv_result, is( result ) );
    }

    @When( "^the client calls GET \"/math/mul/(\\d+)/(\\d+) validate result$" )
    public void the_client_calls_GET_math_mul_validate_result( int num1, int num2 ) throws Throwable
    {
        String lv_url = "/math/mul/" + num1 + "/" + num2;
        response = null;
        response = restTemplate.getForEntity( lv_url, Long.class );
        logger.info( "Input Provided for Multiplication num1=" + num1 + " , num2=" + num2 + "\nResponse=" + response.getBody( ) );
    }

    @Then( "^the client receives output of multiplication operation response status code of (\\d+)$" )
    public void the_client_receives_output_of_multiplication_operation_response_status_code_of( int statusCode ) throws Throwable
    {
        HttpStatus currentStatusCode = response.getStatusCode( );
        logger.info( "Input Provided statusCode=" + statusCode + " , Actual Status Code found=" + currentStatusCode.value( ) );
        assertThat( "Status code is incorrect for Multiplication of 50 and 12 : " + response.getBody( ), currentStatusCode.value( ), is( statusCode ) );
    }

    @Then( "^the multiplication result match \\$ == (\\d+)L$" )
    public void the_multiplication_result_match_$_L( Long result ) throws Throwable
    {
        Long lv_result = response.getBody( );
        logger.info( "Input Provided result of Multiplication of 50 and 12=" + result + " , Actual Status Code found=" + lv_result );
        assertThat( "Result of Multiplication is incorrect : " + response.getBody( ), lv_result, is( result ) );
    }

    @When( "^the client calls GET \"/math/div/(\\d+)/(\\d+) validate result$" )
    public void the_client_calls_GET_math_div_validate_result( int num1, int num2 ) throws Throwable
    {
        String lv_url = "/math/div/" + num1 + "/" + num2;
        response = null;
        response = restTemplate.getForEntity( lv_url, Long.class );
        logger.info( "Input Provided for Division num1=" + num1 + " , num2=" + num2 + "\nResponse=" + response.getBody( ) );
    }

    @Then( "^the client receives output of division operation response status code of (\\d+)$" )
    public void the_client_receives_output_of_division_operation_response_status_code_of( int statusCode ) throws Throwable
    {
        HttpStatus currentStatusCode = response.getStatusCode( );
        logger.info( "Input Provided statusCode=" + statusCode + " , Actual Status Code found=" + currentStatusCode.value( ) );
        assertThat( "Status code is incorrect for Division of 90 and 30 : " + response.getBody( ), currentStatusCode.value( ), is( statusCode ) );
    }

    @Then( "^the division result match \\$ == (\\d+)L$" )
    public void the_division_result_match_$_L( Long result ) throws Throwable
    {
        Long lv_result = response.getBody( );
        logger.info( "Input Provided result of Division of 90 and 30=" + result + " , Actual Status Code found=" + lv_result );
        assertThat( "Result of Multiplication is incorrect : " + response.getBody( ), lv_result, is( result ) );
    }

    @Test
    public void sampleTest()
    {
        System.out.println( "Sample Test case" );
    }

}// End of class MathAppCucumberTest