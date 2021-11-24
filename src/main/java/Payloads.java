import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class Payloads {

    public static String requestPayloadWithPet(String filterKeyword, String expectedValue, Boolean removeMatches) throws IOException { //why exceptions here ?
        JSONObject requestPayload = new JSONObject();
        requestPayload.put("searchKeyword", "");
        requestPayload.put("debug", true);
        requestPayload.put("debugParameters", "debugParametersTrue()");
        requestPayload.put("filters", createFilter(filterKeyword, expectedValue, removeMatches));
        return requestPayload.toString();
    }

    private static JSONArray createFilter(String filterKeyword, String expectedValue, Boolean removeMatches) {
        JSONObject filter = new JSONObject();
        filter.put("field", filterKeyword);
        filter.put("value", expectedValue);
        filter.put("remove", removeMatches);
        JSONArray filterArray = new JSONArray();
        filterArray.put(filter);
        return filterArray;
    }
}
