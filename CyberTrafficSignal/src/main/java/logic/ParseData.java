package logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import org.springframework.util.ResourceUtils;

public class ParseData {

	InputData inputData;

	public List<InputData> parseFile(String filePath) throws IOException {

		List<InputData> list = new ArrayList<InputData>();
//		File file = ResourceUtils.getFile("classpath:inputData.txt");

//		List<String> content = Files.readAllLines(file.toPath());


		ArrayList<String> content = new ArrayList<>(Arrays.asList(
				"10,0,10,0,20,0,20,0,1000,1250,false,false,false,false",
				"30,0,30,0,40,20,40,20,1000,1250,false,false,false,false",
				"10,30,20,30,55,0,65,0,1000,1250,false,false,false,false",
				"20,0,30,0,20,55,20,65,1000,1250,true,false,false,false",
				"0,20,0,30,75,0,65,0,1000,1250,false,false,false,false",
				"0,0,0,0,0,50,0,50,1000,1250,false,false,true,false",
				"0,0,0,0,0,30,0,20,1000,1250,false,false,false,false",
				"0,20,0,30,0,0,0,0,1000,1250,false,false,false,false",
				"0,0,0,0,0,55,0,55,1000,1250,false,false,false,false",
				"0,0,0,0,0,0,0,0,1000,1250,false,false,false,false",
				"1,0,0,0,0,0,0,0,1000,1250,false,false,false,false"
		));



		for (int i = 0; i < content.size(); i++) {

			String[] data = content.get(i).split(",");

			inputData = new InputData();
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
