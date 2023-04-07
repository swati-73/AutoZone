import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class TestEndtoEndFlow extends BaseSetup {


    @Test()
    public void testEndtoEndScenario()  {
        basePageClass.launchURL("https://www.autozone.com/");
        test.log(LogStatus.PASS, "Navigated to the specified URL");
        basePageClass.addVehicle("2020","Audi", "A3 Premium");
        test.log(LogStatus.PASS,"Vehicle added successfully");
        basePageClass.addToCart("Duralast 24DC-DL Group Size 24 Deep Cycle Marine And RV Battery 550 CCA", "38122");
        test.log(LogStatus.PASS,"Product added successfully");
        basePageClass.enterCartDetails("4811111111111114", "0224","123", "$140.47");
        test.log(LogStatus.PASS,"Card details added successfully");
        basePageClass.enterAddress("Lori","Smith","8888888888","qwer@gmail.com","1 Central Ave","New York","10001","NY");
        test.log(LogStatus.PASS,"Address added successfully");
    }

}
