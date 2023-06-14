package serialization.basic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class JacksonUserTest {

    @BeforeEach
    void setUp() {
        System.out.println("Started a test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Finished a test");
    }

    //    @Disabled
    @Test
    public void testUserFieldNames() throws JsonProcessingException {
        JacksonUser jacksonUser = new JacksonUser(1, "First");
        String jsonResult = new ObjectMapper().writeValueAsString(jacksonUser);
        Assertions.assertTrue(jsonResult.contains("indentifier"));
            Assertions.assertTrue(jsonResult.contains("name"));
            Assertions.assertTrue(jsonResult.contains("lastName"));
        }

    @Test
    public void testUserFieldValues() throws JsonProcessingException {
        JacksonUser jacksonUserNew = new JacksonUser(2, "Second");
        String jsonResultNew = new ObjectMapper().writeValueAsString(jacksonUserNew);
        System.out.println(jsonResultNew);
        try {
            Assertions.assertTrue(jsonResultNew.equals("\"2, Second\""));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void arrays(){

        // wrong
//        int[] one = new int[];
        int[] one = new int[3];
        int[] five = new int[0];
        five[0] = 5;
        five[0] = 7;
        //wrong
//        int[] four = new int[2]{};
        int[] four = new int[]{};
        four[0] = 4;
        four[0] = 8;
        // wrong
//        int[] two = new int[3]{1,2,3};
        // wrong
//        int[] two = new int[3]{};
        int[] two = new int[]{1,2,3};
        int[] six = {1,2,3,4,5,6};
        Arrays.sort(six);
        String[] asd = {"a","b","d"};
        Arrays.sort(asd);
        StringBuilder sb = new StringBuilder("asdf");
        StringBuilder sb2 = new StringBuilder(10);
        sb.reverse();
        sb2.append("1234567890");


        Boolean collect = Arrays.stream(two).anyMatch(x -> x > 2);
    }




}