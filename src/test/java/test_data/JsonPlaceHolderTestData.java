package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {
    //that method used for POST
    public Map<String, Object> expectedDataWithAllKeys(Integer userId, String title, Boolean completed) {

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", userId);
        expectedData.put("title", title);
        expectedData.put("completed", completed);

        return expectedData;
    }

    //that method will be used for PATCH
    public Map<String, Object> expectedDataWithMissingKeys(Integer userId, String title, Boolean completed) {
        Map<String, Object> expectedData = new HashMap<>();

        if (userId != null) {
            expectedData.put("userId", userId);
        }
        if (title != null) {
            expectedData.put("title", title);
        }
        if (completed != null) {
            expectedData.put("completed", completed);
        }
        return expectedData;
    }

    public String expectedDataInString(Integer userId, String title, Boolean completed){

        String expectedData = "{" + "\"userId\":" + userId + "," + "\"title\":" + "\"" + title + "\"" + "," + "\"completed\":" + completed + "}";

    return expectedData;

    }






}
