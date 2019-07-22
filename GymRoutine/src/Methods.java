import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Methods {
	BufferedReader br;
	private String[] muscle;

	Methods() {
		// Input file path
		String csvFile = "[input path here]";
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(csvFile));
			this.br = br;
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,
					"File does not exist.\n Check to see " + "if it's in the correct folder.", "Error",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

	}

	public void createMuscleGroup(String[] muscle, String[] column, int columnNumber) throws IOException {
		Methods object = new Methods();

		String line = "";
		String cvsSplitBy = ",";
		column = null;
		muscle = new String[11];

		int i = 0;
		while ((line = object.br.readLine()) != null) {

			column = line.split(cvsSplitBy);

			muscle[i] = column[columnNumber];

			i++;
		}
		this.muscle = muscle;
	}

	public String[] getMGroup() {
		return muscle;
	}
}
