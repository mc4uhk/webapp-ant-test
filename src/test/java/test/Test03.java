package test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import hk.mc4u.SimpleItem;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test03 {

	@Test
	public void test() {
		List<SimpleItem> lolTeams = Arrays.asList(
				new SimpleItem("LPL","S","LPL Session"),
				new SimpleItem("LPL","N","RNG"),
				new SimpleItem("LPL","N","IG"),
				new SimpleItem("LPL","N","FPX"),
				new SimpleItem("LPL","N","WE"),
				new SimpleItem("LPL","N","EDG"),
				new SimpleItem("LCK","S","LCK Session"),
				new SimpleItem("LCK","N","SKT T1"),
				new SimpleItem("LCK","N","Samsung White"),
				new SimpleItem("LCK","N","DWG"),
				new SimpleItem("LEC","S","LEC Session"),
				new SimpleItem("LEC","N","G2"),
				new SimpleItem("LEC","N","Fnatic")
				);

		lolTeams.forEach(item -> log.info(item.toString()));
		Map<String, List<SimpleItem>> lolGroup = lolTeams.stream()
				.filter(item -> item.getType() != "S")
				.collect(Collectors.groupingBy(item -> item.getRegion()));
		
		lolGroup.forEach((k, v) -> log.info("region: {}, teams {}", k, v));

		log.info(findDescription("LPL", lolTeams));
		log.info(findDescription("LCK", lolTeams));
		log.info(findDescription("LEC", lolTeams));
		
		lolGroup.forEach((k, v) -> log.info("region: {}, teams {}", findDescription(k,lolTeams), v));
		
		JSONArray json = createJSON(lolTeams);
		log.info(json.toString());
	}
	
	
	private String findDescription(String region, List<SimpleItem> list) {
		List<SimpleItem> collect = list.stream().filter(
				item -> { 
				return region.equals(item.getRegion()) && 
				       "S".equals(item.getType()); }
				).collect(Collectors.toList());
		
		return collect.get(0).getName();
	}
	
	private JSONArray createJSON(List<SimpleItem> list) {

		Map<String, List<SimpleItem>> group = list.stream()
				.filter(item -> item.getType() != "S")
				.collect(Collectors.groupingBy(item -> item.getRegion()));

		JSONArray result = new JSONArray();

		group.forEach((k, v) -> {
			JSONArray array = new JSONArray(v);
			JSONObject session = new JSONObject();
			session.put("session", findDescription(k, list));
			session.put("rows", array);
			
			result.put(session);
		});

		return result;
	}
}
