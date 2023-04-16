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


		ArrayList<String> listAll = new ArrayList<>(Arrays.asList(
				"10,0,10,0,20,0,20,0,1000,1250,false,false,false,false",
				"5,0,10,0,10,20,15,20,1000,1250,false,false,false,false",
				"0,15,20,30,55,0,65,0,1000,1250,false,false,false,false",
				"20,0,30,0,20,55,20,65,1000,1250,true,false,false,false",
				"0,20,0,30,75,0,65,0,1000,1250,false,false,false,false",
				"0,0,0,0,0,50,0,50,1000,1250,false,false,true,false",
				"0,0,0,0,0,30,0,20,1000,1250,false,false,false,false",
				"0,20,0,30,0,0,0,0,1000,1250,false,false,false,false",
				"0,0,0,0,0,55,0,55,1000,1250,false,false,false,false",
				"0,0,0,0,0,0,0,0,1000,1250,false,false,false,false",
				"1,0,0,0,0,0,0,0,1000,1250,false,false,false,false"
		));

		ArrayList<String> listNormal = new ArrayList<>(Arrays.asList(

//				START: Values added by Jacob.
//				"5,0,10,0,15,0,20,0,1000,1250,false,false,false,false",
//				"10,0,5,0,10,15,10,20,1000,1250,false,false,false,false",
//				"2,15,3,15,7,0,8,0,1000,1250,false,false,false,false",
//				"8,0,9,0,1,22,1,18,1000,1250,false,false,false,false",
//				"5,10,3,12,4,0,2,0,1000,1250,false,false,false,false"
//				END: Values added by Jacob.

				"10,0,10,0,20,0,20,0,1000,1250,false,false,false,false",
				"5,0,10,0,10,20,15,20,1000,1250,false,false,false,false",
				"0,15,20,30,55,0,65,0,1000,1250,false,false,false,false",
				"20,0,30,0,20,55,20,65,1000,1250,false,false,false,false",
				"0,0,0,0,10,20,3,20,1000,1250,false,false,false,false"
		));


		ArrayList<String> listEmergencySouth = new ArrayList<>(Arrays.asList(

				"10,0,10,0,20,0,20,0,1000,1250,false,false,false,false",
				"5,0,10,0,10,20,15,20,1000,1250,false,false,false,false",
				"0,15,20,30,55,0,65,0,1000,1250,false,false,false,false",
				"20,0,30,0,20,55,20,65,1000,1250,false,false,false,false",
				"20,0,30,0,20,30,20,20,1000,1250,false,true,false,false",
				"0,20,0,30,75,0,65,0,1000,1250,false,false,false,false"
		));

		ArrayList<String> listEmergencyEast = new ArrayList<>(Arrays.asList(

				"10,0,10,0,20,0,20,0,1000,1250,false,false,false,false",
				"5,0,10,0,10,20,15,20,1000,1250,false,false,false,false",
				"15,15,20,30,15,0,15,0,1000,1250,false,false,false,false",
				"15,0,20,0,15,30,5,30,1000,1250,false,false,true,false",
				"0,0,0,0,0,10,0,5,1000,1250,false,false,false,false"
				));

		ArrayList<String> listEmptyNorthSouth = new ArrayList<>(Arrays.asList(

				"0,0,0,0,20,0,15,0,1000,1250,false,false,false,false",
				"0,0,0,0,5,20,8,15,1000,1250,false,false,false,false",
				"0,0,0,0,35,5,55,15,1000,1250,false,false,false,false",
				"5,0,10,0,0,35,55,20,1000,1250,false,false,false,false"
		));


		ArrayList<String> content = listEmptyNorthSouth;



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
