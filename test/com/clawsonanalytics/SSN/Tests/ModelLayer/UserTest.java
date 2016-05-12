/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.SSN.Tests.ModelLayer;

import com.clawsonanalytics.SSN.DataLayer.MySQL.TestEnvironment;
import com.clawsonanalytics.SSN.DataLayer.MySQL.Interface.SQLModel;
import com.clawsonanalytics.SSN.DataLayer.MySQL.MySQLDataSource;
import com.clawsonanalytics.SSN.ModelLayer.User;

import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andrewclawson
 */
public class UserTest {
    private static User SUT;
    private static TestEnvironment environment;
    private String first = "sutFirst";
    private String last = "sutLast";
    private String email = "sutEmail";
    private String password = "sutPassword";
    
    public UserTest() {
        environment = new TestEnvironment();
        environment.Setup("No Data");
        environment.CreateTestTableForModelByTablename(User.getTablename());
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        //environment.DropTestTableForModelByTablename(User.getTablename());
        //environment.TearDown();
    }
    
    @Before
    public void setUp() {
        SUT = new User();
    }
    
    @After
    public void tearDown() {
        SUT = null;
    }
    
    public void SetupValidUser(){
        SUT.setFirstname(first);
        SUT.setLastname(last);
        SUT.setEmail(email);
        SUT.setPassword(password);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void TablenameIsCorrect(){
        Assert.assertEquals("USERS",User.getTablename());
        
    }
    
    
    
    @Test
    public void CanSetFirstName(){
        SUT.setFirstname(first);
        Assert.assertEquals(SUT.getFirstname(),first);
        
    }
    
    @Test
    public void CanSetLastName(){
        SUT.setLastname(last);
        Assert.assertEquals(SUT.getLastname(),last);
    }
    
    @Test
    public void CanSetEmail(){
        SUT.setEmail(email);
        Assert.assertEquals(SUT.getEmail(), email);
    }
    
    @Test
    public void CanSetPassword(){
        SUT.setPassword(password);
        Assert.assertEquals(SUT.getPassword(),password);
    }
    
    @Test
    public void MissingFirstReturnsMessage(){
        SUT.setLastname(last);
        SUT.setEmail(email);
        SUT.setPassword(password);
        Assert.assertEquals(SUT.GetValidationErrors().contains("User must have a firstname."), true);
        Assert.assertEquals(SUT.IsValid(),false);
    }
    
    @Test
    public void MissingLastReturnsMessage(){
        SUT.setFirstname(first);
        SUT.setEmail(email);
        SUT.setPassword(password);
        Assert.assertEquals(SUT.GetValidationErrors().contains("User must have a lastname."),true);
        Assert.assertEquals(SUT.IsValid(), false);
    }
    
    @Test
    public void MissingEmailReturnsMessage(){
        SUT.setFirstname(first);
        SUT.setLastname(last);
        SUT.setPassword(password);
        Assert.assertEquals(SUT.GetValidationErrors().contains("User must have an email."),true);
        Assert.assertFalse(SUT.IsValid());
    }
    
    @Test
    public void MissingPasswordReturnsMessage(){
        SUT.setFirstname(first);
        SUT.setLastname(last);
        SUT.setEmail(email);
        Assert.assertTrue(SUT.GetValidationErrors().contains("User must have a password."));
        Assert.assertFalse(SUT.IsValid());
    }
    
    
    public void CanInsertIntoDB(){
        int firstCount = User.Count();
        SUT.setFirstname(first);
        SUT.setLastname(last);
        SUT.setEmail(email);
        SUT.setPassword(last);
        SUT.Insert();
        int secondCount = User.Count();
        Assert.assertEquals(secondCount, firstCount + 1);
        
    }
    
    
}
