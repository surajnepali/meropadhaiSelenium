package TestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//ITestListeners interface which implements Testng listeners
public class Listeners implements ITestListener{
    
    @Override
    public void onTestStart(ITestResult result){
        
    }

    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("I successfully executed listeners pass code");
    }

    @Override
    public void onTestFailure(ITestResult result){
        String error = result.getName();
        System.out.println("The error is in the " + error + " method.");
        
    }

    @Override
    public void onTestSkipped(ITestResult result){
        
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result){
        
    }

    @Override
    public void onStart(ITestContext result){
        
    }

    @Override
    public void onFinish(ITestContext result){
        
    }

}
