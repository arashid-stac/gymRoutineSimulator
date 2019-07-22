import java.io.IOException;
import java.util.Random;

import javax.swing.JOptionPane;

public class CreateRoutine {
	private String[] biceps;
	private String[] bicepsColumn;
	private String[] triceps;
	private String[] tricepsColumn;
	private String[] chest;
	private String[] chestColumn;
	private String[] back;
	private String[] backColumn;
	private String[] legs;
	private String[] legsColumn;
	private String[] abs;
	private String[] absColumn;

	int amountOfParts;
	String aop = null;

	int musclePair = 0;
	int mp;
	String musclePairsString = null;

	private String[] firstMuscle;
	private String[] secondMuscle;
	private String[] thirdMuscle;

	private boolean isValid = false;
	int amountOfPartsInt;

	public CreateRoutine() {
		do {
			try {
				aop = JOptionPane.showInputDialog("How many body parts? 2 or 3.");
				amountOfPartsInt = Integer.parseInt(aop);
				if (amountOfPartsInt == 2 || amountOfPartsInt == 3) {
					isValid = true;
				} else {
					JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException e) {
				if (aop == null) {
					System.exit(0);
				} else {
					JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		} while (isValid == false);

		this.amountOfParts = amountOfPartsInt;

		// CHECK HERE FOR ERROR HANDLING!!!!!
		if (amountOfPartsInt == 2) {
			do {
				try {
					musclePairsString = JOptionPane.showInputDialog(
							"Select which pair:\n1)Biceps and Back\n2) Triceps and Chest\n3) Legs and Abs\n4) Chest and Back\n5) Biceps and Triceps");
					musclePair = Integer.parseInt(musclePairsString);
					if (musclePair > 0 && musclePair < 6) {
						isValid = true;
					} else {
						JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
						isValid = false;
					}
				} catch (NumberFormatException e) {
					if (musclePairsString == null) {
						System.exit(0);
					} else {
						JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
						isValid = false;
					}
				}
			} while (isValid == false);
		} else {
			do {
				try {
					musclePairsString = JOptionPane.showInputDialog(
							"Select which pair:\n1)Biceps, Triceps, Chest\n2)Biceps, Triceps, and Back\n3) Biceps, Triceps, Legs\n4) Biceps, Triceps, Abs\n"
									+ "5) Chest, Back, Abs\n6) Chest, Back, Legs");
					musclePair = Integer.parseInt(musclePairsString);
					if (musclePair > 0 && musclePair < 7) {
						isValid = true;
					} else {
						isValid = false;
					}
				} catch (NumberFormatException e) {
					if (musclePairsString == null) {
						System.exit(0);
					} else {
						JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
						isValid = false;
					}
				}
			} while (isValid == false);
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

		if (amountOfPartsResult == 2) {

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

		} else {
			// CREATE SET OF WORKOUTS FOR 3-BODY-PART ROUTINE
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
		}

		/* FOR TWO BODY PART WORKOUT */
		if (amountOfPartsResult == 2) {
			for (int i = 0; i < 4; i++) {
				int firstRnd = new Random().nextInt(firstMuscle.length);
				System.out.println("4x8    " + firstMuscle[firstRnd]);

				int secondRnd = new Random().nextInt(secondMuscle.length);
				System.out.println("4x8    " + secondMuscle[secondRnd]);
			}
		}
		/* FOR THREE BODY PART WORKOUT */
		else {
			for (int i = 0; i < 3; i++) {
				int firstRnd = new Random().nextInt(firstMuscle.length);
				System.out.println("3x8    " + firstMuscle[firstRnd]);
			}
			for (int i = 0; i < 3; i++) {
				int secondRnd = new Random().nextInt(secondMuscle.length);
				System.out.println("3x8    " + secondMuscle[secondRnd]);
			}
			for (int i = 0; i < 3; i++) {
				int thirdRnd = new Random().nextInt(thirdMuscle.length);
				System.out.println("3x8    " + thirdMuscle[thirdRnd]);
			}
		}
	}
}
