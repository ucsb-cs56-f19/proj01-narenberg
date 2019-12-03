package earthquakes.osm;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class Place {
	private static Logger logger = LoggerFactory.getLogger(Place.class);
	public long place_id;
	public double lat, lon;
	public String display_name, type;
	 /**
	  *      * Create a List of Places from json representation
	  *           * 
	  *                * @param json String of json returned by API endpoint {@code /locations/search}
	  *                     * @return a new FeatureCollection object
	  *                          * @see <a href="https://stackoverflow.com/questions/6349421/how-to-use-jackson-to-deserialise-an-array-of-objects/6349488#6349488">
	  *                                 https://stackoverflow.com/questions/6349421/how-to-use-jackson-to-deserialise-an-array-of-objects/6349488#6349488
	  *                               </a>
	  *                                    */
	 public static List<Place> listFromJSON(String json) {
	 	try {
	 		ObjectMapper objectMapper = new ObjectMapper();
	 		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	 		List<Place> places = objectMapper.readValue(json, new TypeReference<List<Place>>(){});
	 		return places;
	 	} catch (JsonProcessingException jpe) {
	 		logger.error("JsonProcessingException:" + jpe);
	 		return null;
	 	} catch (Exception e) {
	 		logger.error("Exception:" + e);
	 		return null;
	 	}
	 }

}