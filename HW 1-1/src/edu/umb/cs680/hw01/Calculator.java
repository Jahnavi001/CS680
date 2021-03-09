package  edu.umb.cs680.hw01;

public class Calculator {
	
    public static float addtional(float x, float y)
    {
    	float result = x + y;
        return result;
    }
    public static float sub(float x, float y)
    {
    	float result = x-y;
        return result;
    }
    public static float mul(float x, float y)
    {
    	float result = x*y;
        return result;
    }
    public static float div(float x, float y)
    {	
    	if(y==0)
    	{ 
    		throw new IllegalArgumentException("Number divided by zero");
    	}
    	float result = x/y;
        return result;
    }

}