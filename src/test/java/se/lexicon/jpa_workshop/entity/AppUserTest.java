package se.lexicon.jpa_workshop.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppUserTest {

    AppUser testObject;

    @BeforeEach
    public void setup() {
        testObject = new AppUser(1, "Mehrdad", "Javan", "mehrdad.javan@lexicon.se");
    }

    @Test
    @DisplayName("Test1 Created Object")
    public void test_successfully_created() {
        Assertions.assertEquals(1, testObject.getId());
        Assertions.assertEquals("Mehrdad", testObject.getFirstName());
        Assertions.assertEquals("Javan", testObject.getLastName());
        Assertions.assertEquals("mehrdad.javan@lexicon.se", testObject.getEmail());
    }

    @Test
    @DisplayName("Test2 Equal")
    public void test_equal() {
        AppUser expected = new AppUser(1, "Mehrdad", "Javan", "mehrdad.javan@lexicon.se");
        Assertions.assertTrue(testObject.equals(expected));
    }

    @Test
    @DisplayName("Test3 HashCode")
    public void test_hashCode() {
        AppUser expected = new AppUser(1, "Mehrdad", "Javan", "mehrdad.javan@lexicon.se");
        Assertions.assertEquals(expected.hashCode(), testObject.hashCode());
    }


}
