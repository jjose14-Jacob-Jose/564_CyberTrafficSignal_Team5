package logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//	Start: Line commented because Jacob's laptop couldn't find  ResourceUtils.java.
//import org.springframework.util.ResourceUtils;
//	End: Line commented because Jacob's laptop couldn't find  ResourceUtils.java.

public class ParseData {

	public static List<InputData> parseFile(String filePath) throws IOException {

		List<InputData> list = new ArrayList<>();

//	Start: Line commented because Jacob's laptop couldn't find  ResourceUtils.java.
//		File file = ResourceUtils.getFile("classpath:inputData.txt");
//
//		List<String> content = Files.readAllLines(file.toPath());

//	End: Line commented because Jacob's laptop couldn't find  ResourceUtils.java.

		List<String> content = new ArrayList<>(Arrays.asList(
				"15,0,15,0,20,0,25,0,1000,1250,false,false,false,false",
				"50,4,50,4,20,10,20,10,1000,1250,false,false,true,false",
				"5,0,5,0,5,0,5,0,1000,1250,false,false,false,false"
		));


		for (int i = 0; i < content.size(); i++) {

			String[] data = content.get(i).split(",");

			InputData inputData = new InputData();
			inputData.setNorthIncomingVehicle(Integer.valueOf(data[0]));
			inputData.setNorthOutgoingVehicle(Integer.valueOf(data[1]));
			inputData.setSouthIncomingVehicle(Integer.valueOf(data[2]));
			inputData.setSouthOutgoingVehicle(Integer.valueOf(data[3]));
			inputData.setEastIncomingVehicle(Integer.valueOf(data[4]));
			inputData.setEastOutgoingVehicle(Integer.valueOf(data[5]));
			inputData.setWestIncomingVehicle(Integer.valueOf(data[6]));
			inputData.setWestOutgoingVehicle(Integer.valueOf(data[7]));

			inputData.setSaturationNS(Integer.valueOf(data[8]));
			inputData.setSaturationEW(Integer.valueOf(data[9]));

			inputData.setNorthEmergency(Boolean.valueOf(data[10]));
			inputData.setSouthEmergency(Boolean.valueOf(data[11]));
			inputData.setEastEmergency(Boolean.valueOf(data[12]));
			inputData.setWestEmergency(Boolean.valueOf(data[13]));

			list.add(inputData);
		}
		return list;
	}
}
