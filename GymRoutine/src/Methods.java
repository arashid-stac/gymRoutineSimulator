import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Methods {
	BufferedReader br;
	private String[] muscle;

	Methods() throws IOException {
		// Input file path
		String csvFile = "Input file path here";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(csvFile));
			/*
			 * Read the first line so that when passing the CSV file it ignores the first
			 * row
			 */
			br.readLine();
			this.br = br;
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,
					"File does not exist.\n Check to see " + "if it's in the correct folder.", "Error",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	/*
	 * Parse the CSV file
	 */
	public void createMuscleGroup(String[] muscle, String[] column, int columnNumber) throws IOException {
		Methods object = new Methods();

		String line = "";
		String cvsSplitBy = ",";
		column = null;
		// The array is size 11 because that's how many rows are in the CSV file
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
