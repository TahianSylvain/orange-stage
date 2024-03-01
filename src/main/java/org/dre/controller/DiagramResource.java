package org.dre.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.inject.Inject;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import org.dre.model.Diagram;
import org.dre.service.DiagramService;

// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.firefox.FirefoxOptions;
// import org.testng.Assert;
// import org.testng.annotations.Test;

import java.util.List;

@Path("/diagram")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DiagramResource {
    @Inject
    DiagramService diagramService;

    @GET
    public List<Diagram> getAllDiagram() {
        return diagramService.getAllDiagram();
    }

    @GET
    @Path("/{id}")
    public Diagram getDiagramById(@PathParam("id") Long id){
        return diagramService.getDiagramById(id);
    }

    @POST
    public Diagram createDiagram(Diagram diagram) {
        return diagramService.createDiagram(diagram);
    }

    @PUT //####################OptimusPrime#########################
    @Path("/optimus/{id}")
    public Diagram updateDiagram(@PathParam("id") Long id, Diagram diagram) {
        diagram.setId(id); 
        
        //public void login() {
        //     try { WebDriver driver = new FirefoxDriver(); }
        //     finally { WebDriver driver = new WebDriver(); }
                
        //     //driver.manage().window().maximize();
        //     driver.get("https://www.taskade.com/login"); 
        //     WebElement email = driver.findElement(By.id("username"));
        //     WebElement password = driver.findElement(By.id("password"));
        //     WebElement login=driver.findElement(By.type("submit"));

        //     email.sendKeys("@gmail.com");
        //     password.sendKeys("your_password");
        //     login.click();
            
        //?     String actualUrl="https://live.browserstack.com/dashboard";
        //?     String expectedUrl= driver.getCurrentUrl();
        //?     Assert.assertEquals(expectedUrl,actualUrl);
        // }

        
        /*-------------get propositions throughout SeleniumScrapping--------------
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.Assert;
        import org.testng.annotations.Test;

            @Test
            public void login() {
                WebDriver driver = new FirefoxDriver(
                    new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), safariOptions);
                    wait = new WebDriverWait(driver, Duration.ofSeconds(10)     );
                //driver.manage().window().maximize();
                driver.navigate.to("https://www.browserstack.com/users/sign_in"); // driver.get()
                WebElement password = driver.findElement(By.id("user_password"));
                WebElement login=driver.findElement(By.name("commit"));
                password.sendKeys("your_password");
                login.click();
                String actualUrl="https://live.browserstack.com/dashboard";
                String expectedUrl= driver.getCurrentUrl();
                Assert.assertEquals(expectedUrl,actualUrl);
            }
         */
        return diagramService.updateDiagram(diagram);
    }

    @DELETE
    @Path("/{id}")
    public void deleteDiagram(@PathParam("id") Long id) {
        diagramService.deleteDiagram(id);
    }
}

