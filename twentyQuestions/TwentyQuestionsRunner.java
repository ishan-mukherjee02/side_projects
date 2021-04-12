package twentyQuestions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class TwentyQuestionsRunner implements Serializable {

	private static final long serialVersionUID = 629323042029216321L;
	private static final String FILE_NAME = "20QuestionTrees/savedTree.ser";

	public static void main(String[] args) throws ClassNotFoundException {
		Scanner fromKeyboard = new Scanner(System.in);

		GrowingTree g1 = new GrowingTree();

		g1 = loadGame(g1);
		boolean guessedCorr = false;
		TreeNode<String> temp = g1.root;

		while (!guessedCorr) {
			System.out.println(temp.value);
			String input = fromKeyboard.nextLine();

			if (input.toLowerCase().equals("yes")) {
				if (temp.left.value.equals("Thanks for playing")) {
					temp = temp.left;
					System.out.println(temp.value);
					guessedCorr = true;
				} else
					temp = temp.left;
			} else if (input.toLowerCase().equals("no")) {
				if (temp.right.value.equals("What is it?")) {
					System.out.println(temp.right.value);
					String ans = fromKeyboard.nextLine();

					System.out.println("A " + ans + " is different because it is _____?");
					String message = fromKeyboard.nextLine();

					g1.addNewQuestionNode(temp, message, ans);

					System.out.println("Thanks for playing");
					guessedCorr = true;
				} else
					temp = temp.right;
			}

		}

		fromKeyboard.close();
		saveGame(g1);

	}

	public static void saveGame(GrowingTree g) {
		try {
			FileOutputStream fout = new FileOutputStream(FILE_NAME);
			ObjectOutputStream out = new ObjectOutputStream(fout);

			out.writeObject(g);
			out.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static GrowingTree loadGame(GrowingTree g) throws ClassNotFoundException {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME));
			g = (GrowingTree) in.readObject();
			in.close();
			System.out.println("loaded");
		} catch (IOException e) {
			System.out.println(e);
		}
		return g;
	}
}
