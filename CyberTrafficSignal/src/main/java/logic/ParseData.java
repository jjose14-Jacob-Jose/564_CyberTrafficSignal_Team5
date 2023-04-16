package logic;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ResourceUtils;

public class ParseData {

	private InputData inputData;

	public List<InputData> parseFile(String filePath) throws IOException {

		List<InputData> list = new ArrayList<>();
		File file = ResourceUtils.getFile("classpath:inputData.txt");

		List<String> content = Files.readAllLines(file.toPath());

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
