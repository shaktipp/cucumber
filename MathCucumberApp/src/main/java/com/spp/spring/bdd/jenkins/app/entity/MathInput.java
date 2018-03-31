package com.spp.spring.bdd.jenkins.app.entity;

import com.spp.spring.bdd.jenkins.app.exception.InvalidInputException;

public class MathInput
{
    private Long num1 = new Long(0);
    private Long num2 = new Long(0);
    private Long result = new Long(0);
    private String operator = "";
    
    
    
    public MathInput()
    {
        super();
    }
    
    public MathInput(Long num1,Long num2,String operator)
    {
        this.setNum1( num1 );
        this.setNum2( num2 );
        this.setOperator( operator );        
    }
    
    
    public Long getNum1()
    {
        return num1;
    }
    public void setNum1( Long num1 )
    {
        this.num1 = num1;
    }
    
    public Long getNum2()
    {
        return num2;
    }
    public void setNum2( Long num2 )
    {
        this.num2 = num2;
    }
    
    public Long getResult()
    {
        return result;
    }
    public void setResult( Long result )
    {
        this.result = result;
    }
    
    public String getOperator()
    {
        return operator;
    }
    public void setOperator( String operator )
    {
        String lv_validOperators ="add,sub,mul,div";
        
        if(lv_validOperators.indexOf( operator )==-1)
            throw new InvalidInputException(operator + " is invalid, Valid operators are add,sub,mul,div");
        
        this.operator = operator;
    }
    
    public String disp()
    {
        return String.format( "{\"num1\":%d,\"num2\":%d,\"operator\":\"%s\",\"result\":%d}", this.getNum1( ),this.getNum2( ),this.getOperator( ),this.getResult( ) );
    }
    
    
    
    

}//End of class MathInput
