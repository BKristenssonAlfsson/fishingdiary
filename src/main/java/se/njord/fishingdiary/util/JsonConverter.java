package se.njord.fishingdiary.util;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

public class JsonConverter {

    public JsonObject jsonObjectFromString(String input) {
        JsonReader jr = Json.createReader(new StringReader(input));
        JsonObject jsonObject = jr.readObject();

        jr.close();
        return jsonObject;
    }

}
