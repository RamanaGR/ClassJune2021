package com.edu.frameworktest;

import com.edu.framework.Palindrome;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PalindromeTest {
    Palindrome pl;

    //@BeforeTest //runs before every Test
    @BeforeMethod//run before every test case
    public void setUp() {
        pl = new Palindrome();
    }

    @Test
    public void testPositiveInput() {
        Assert.assertTrue(pl.isPalindrome("dad"));
    }

    @Test
    public void testNegativeInput() {
        Assert.assertFalse(pl.isPalindrome("abcd"));
    }

    @Test
    public void testSpecialChInput() {
        Assert.assertTrue(pl.isPalindrome("@#%#@"));
    }

    @Test
    public void testAlphaNumericInput() {
        Assert.assertTrue(pl.isPalindrome("da232ad"));
    }

    @Test
    public void testEmptyInput() {
        Assert.assertFalse(pl.isPalindrome(""));
    }

    @Test
    public void testNullInput() {
        Assert.assertFalse(pl.isPalindrome(null));
    }

    public boolean isBalanced(String s) {
        return true;
    }
}
