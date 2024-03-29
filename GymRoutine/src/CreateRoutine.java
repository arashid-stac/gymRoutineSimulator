import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;

public class CreateRoutine {
	// Create the arrays the will handle the CSV file
	private String[] biceps;
	private String[] triceps;
	private String[] chest;
	private String[] back;
	private String[] legs;
	private String[] abs;
	private String[] interval;

	/*
	 * Create the arrays that will aid in reading the columns of the CSV file
	 */
	private String[] bicepsColumn;
	private String[] tricepsColumn;
	private String[] chestColumn;
	private String[] backColumn;
	private String[] legsColumn;
	private String[] absColumn;
	private String[] intervalColumn;

	/*
	 * aop: Create string that stores user input in regards to how many body parts
	 * they would like to exercise
	 */
	/*
	 * amountOfPartsInt: Create int that stores the input after converting aop from
	 * a String to an int
	 */
	private String aop = null;
	private int amountOfParts;
	private int amountOfPartsInt;

	/*
	 * musclePairsString: Create String that will contain the input for what body
	 * parts the user would like to target
	 */
	/*
	 * musclePair: Create string that holds the value of musclePairsString after
	 * it's been converted from String to int
	 */
	private String musclePairsString = null;
	private int musclePair = 0;
	int mp;

	/*
	 * Create the arrays that will hold the resulting exercises for the user
	 */
	private String[] firstMuscle;
	private String[] secondMuscle;
	private String[] thirdMuscle;

	/*
	 * isValid: boolean for error handling
	 */
	private boolean isValid = false;

	// Integers that'll hold randomly generated numbers
	int firstRnd = 0;
	int secondRnd = 0;
	int thirdRnd = 0;

	public CreateRoutine() {
		do {
			try {
				// Ask user for how many body parts they'd like to exercise
				aop = JOptionPane.showInputDialog("How many body parts would you like to exercise? 2 or 3.\n"
						+ "Input '0' if you want\nto do some interval training.");
				amountOfPartsInt = Integer.parseInt(aop);
				// If the input is either 2 or 3 or 0, then move on to the next part
				if (amountOfPartsInt == 2 || amountOfPartsInt == 3 || amountOfPartsInt == 0) {
					isValid = true;
				}
				// If input is not 2 or 3 or 0, input again.
				else {
					JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			// if user clicks on cancel or the exit button, then exit the program
			catch (NumberFormatException e) {
				if (aop == null) {
					System.exit(0);
				}
				// if user inputs any other incorrect value, input again
				else {
					JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		} while (isValid == false);

		this.amountOfParts = amountOfPartsInt;

		if (amountOfPartsInt == 2) {
			do {
				try {
					// Ask user what body parts they'd like to exercise
					musclePairsString = JOptionPane.showInputDialog(
							"Select which pair:\n1) Biceps and Back\n2) Triceps and Chest\n3) Legs and Abs\n4) Chest and Back\n5) Biceps and Triceps");
					musclePair = Integer.parseInt(musclePairsString);
					// To move on to the next part of the program, user would have to input a number
					// between 0 and 6
					if (musclePair > 0 && musclePair < 6) {
						isValid = true;
					} else {
						JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
						isValid = false;
					}
				}
				// if user clicks on cancel or the exit button, then exit the program
				catch (NumberFormatException e) {
					if (musclePairsString == null) {
						System.exit(0);
					}
					// if user inputs any other invalid input, input again
					else {
						JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
						isValid = false;
					}
				}
			} while (isValid == false);
		} else if (amountOfPartsInt == 3) {
			do {
				try {
					// Ask user what body parts they'd like to exercise
					musclePairsString = JOptionPane.showInputDialog(
							"Select which pair:\n1)Biceps, Triceps, Chest\n2)Biceps, Triceps, and Back\n3) Biceps, Triceps, Legs\n4) Biceps, Triceps, Abs\n"
									+ "5) Chest, Back, Abs\n6) Chest, Back, Legs");
					musclePair = Integer.parseInt(musclePairsString);
					// To move on to the next part of the program, user would have to input a number
					// between 0 and 7
					if (musclePair > 0 && musclePair < 7) {
						isValid = true;
					} else {
						isValid = false;
					}
				} catch (NumberFormatException e) {
					// if user clicks on cancel or the exit button, then exit the program
					if (musclePairsString == null) {
						System.exit(0);
					}
					// if user inputs any other invalid input, input again
					else {
						JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
						isValid = false;
					}
				}
			} while (isValid == false);
		} else {
			JOptionPane.showMessageDialog(null,
					"Do each exercise for 15 seconds one after the other. \nAfter the final "
							+ "exercise, take a 3 to 4 minute \nbreak, then start again from \nthe top. Repeat 4 times. "
							+ "*adjust for difficulty*");
		}
		this.mp = musclePair;
	}

	public int getMusclePair() {
		return mp;
	}

	public int getAmountOfParts() {
		return amountOfParts;
	}

	public void createSets() throws IOException {

		int amountOfPartsResult = getAmountOfParts();

		Methods methods = new Methods();

		int musclePairResult = getMusclePair();

		// If the user picks a 2-body-part workout, execute the following
		if (amountOfPartsResult == 2) {
			/*
			 * Enter all the muscles into the respective arrays, firstMuscle and
			 * secondMuscle, depending on the result of the users choice
			 */
			/* biceps and back */
			if (musclePairResult == 1) {
				methods.createMuscleGroup(biceps, bicepsColumn, 0);
				firstMuscle = methods.getMGroup();

				methods.createMuscleGroup(back, backColumn, 3);
				secondMuscle = methods.getMGroup();
			}
			/* triceps and chest */
			else if (musclePairResult == 2) {
				methods.createMuscleGroup(chest, chestColumn, 2);
				firstMuscle = methods.getMGroup();

				methods.createMuscleGroup(triceps, tricepsColumn, 1);
				secondMuscle = methods.getMGroup();
			}
			/* Legs and abs */
			else if (musclePairResult == 3) {
				methods.createMuscleGroup(legs, legsColumn, 4);
				firstMuscle = methods.getMGroup();

				methods.createMuscleGroup(abs, absColumn, 5);
				secondMuscle = methods.getMGroup();
			}
			/* Chest and Back */
			else if (musclePairResult == 4) {
				methods.createMuscleGroup(chest, chestColumn, 2);
				firstMuscle = methods.getMGroup();

				methods.createMuscleGroup(back, backColumn, 3);
				secondMuscle = methods.getMGroup();
			}
			/* Biceps and Triceps */
			else if (musclePairResult == 5) {
				methods.createMuscleGroup(biceps, bicepsColumn, 0);
				firstMuscle = methods.getMGroup();

				methods.createMuscleGroup(triceps, tricepsColumn, 1);
				secondMuscle = methods.getMGroup();
			}

		}
		// If the user picks a 3-body-part workout, execute the following
		else if (amountOfPartsResult == 3) {
			/*
			 * Enter all the muscles into the respective arrays, firstMuscle, secondMuscle,
			 * and thirdMuscle, depending on the result of the users choice
			 */

			/* Chest, Biceps, Triceps */
			if (musclePairResult == 1) {
				methods.createMuscleGroup(chest, chestColumn, 2);
				firstMuscle = methods.getMGroup();

				methods.createMuscleGroup(biceps, bicepsColumn, 0);
				secondMuscle = methods.getMGroup();

				methods.createMuscleGroup(triceps, tricepsColumn, 1);
				thirdMuscle = methods.getMGroup();
			}
			/* Back, Triceps, Biceps */
			else if (musclePairResult == 2) {
				methods.createMuscleGroup(back, backColumn, 3);
				firstMuscle = methods.getMGroup();

				methods.createMuscleGroup(triceps, tricepsColumn, 1);
				secondMuscle = methods.getMGroup();

				methods.createMuscleGroup(biceps, bicepsColumn, 0);
				thirdMuscle = methods.getMGroup();
			}
			/* Legs, Biceps, Triceps */
			else if (musclePairResult == 3) {
				methods.createMuscleGroup(legs, legsColumn, 4);
				firstMuscle = methods.getMGroup();

				methods.createMuscleGroup(triceps, tricepsColumn, 1);
				secondMuscle = methods.getMGroup();

				methods.createMuscleGroup(biceps, bicepsColumn, 0);
				thirdMuscle = methods.getMGroup();
			}
			/* Biceps, Triceps, Abs */
			else if (musclePairResult == 4) {
				methods.createMuscleGroup(biceps, bicepsColumn, 0);
				firstMuscle = methods.getMGroup();

				methods.createMuscleGroup(triceps, tricepsColumn, 1);
				secondMuscle = methods.getMGroup();

				methods.createMuscleGroup(abs, absColumn, 5);
				thirdMuscle = methods.getMGroup();
			}
			/* Chest, Back, Abs */
			else if (musclePairResult == 5) {
				methods.createMuscleGroup(chest, chestColumn, 2);
				firstMuscle = methods.getMGroup();

				methods.createMuscleGroup(back, backColumn, 3);
				secondMuscle = methods.getMGroup();

				methods.createMuscleGroup(abs, absColumn, 5);
				thirdMuscle = methods.getMGroup();
			}
			/* Chest, Back, Legs */
			else {
				methods.createMuscleGroup(chest, chestColumn, 2);
				firstMuscle = methods.getMGroup();

				methods.createMuscleGroup(back, backColumn, 3);
				secondMuscle = methods.getMGroup();

				methods.createMuscleGroup(legs, legsColumn, 4);
				thirdMuscle = methods.getMGroup();
			}
		} else if (amountOfPartsInt == 0) {
			methods.createMuscleGroup(interval, intervalColumn, 6);
			firstMuscle = methods.getMGroup();
		}

		/*
		 * Printing results for two-body-part workout
		 */

		if (amountOfPartsResult == 2) {
			for (int i = 0; i < 4; i++) {
				// Generate random number to represent an element in the array
				// Keep generating random numbers until you find one that can
				// represent an element in the array that hasn't already been printed out
				do {
					firstRnd = new Random().nextInt(firstMuscle.length);
				} while (firstMuscle[firstRnd] == null);

				// Print out the workout
				System.out.println("4x8    " + firstMuscle[firstRnd]);

				// Set that element in the array to null to indicate that it's been
				// printed out
				firstMuscle[firstRnd] = null;

				// Same instructions as above
				do {
					secondRnd = new Random().nextInt(secondMuscle.length);

				} while (secondMuscle[secondRnd] == null);

				System.out.println("4x8    " + secondMuscle[secondRnd]);

				secondMuscle[secondRnd] = null;

			}
		}
		/*
		 * Printing results for two-body-part workout
		 */
		else if (amountOfPartsResult == 3) {
			for (int i = 0; i < 3; i++) {
				// Same instructions as above
				do {
					firstRnd = new Random().nextInt(firstMuscle.length);
				} while (firstMuscle[firstRnd] == null);

				System.out.println("3x8    " + firstMuscle[firstRnd]);

				firstMuscle[firstRnd] = null;
			}
			for (int i = 0; i < 3; i++) {
				// Same instructions as above
				do {
					secondRnd = new Random().nextInt(secondMuscle.length);
				} while (secondMuscle[secondRnd] == null);

				System.out.println("3x8    " + secondMuscle[secondRnd]);

				secondMuscle[secondRnd] = null;
			}
			for (int i = 0; i < 3; i++) {
				do {
					thirdRnd = new Random().nextInt(thirdMuscle.length);
				} while (thirdMuscle[thirdRnd] == null);

				System.out.println("3x8    " + thirdMuscle[thirdRnd]);

				thirdMuscle[thirdRnd] = null;
			}
		}
		// Printing results for interval training
		else if (amountOfPartsInt == 0) {
			for (int i = 0; i < 10; i++) {
				System.out.println(firstMuscle[i]);
			}
		}

		/* Close the Buffered Reader */

		BufferedReader theBR = methods.br;
		theBR.close();
	}
}
