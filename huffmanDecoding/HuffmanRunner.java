package huffmanDecoding;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HuffmanRunner {

	public static void main(String[] args) throws FileNotFoundException {
		HuffmanTree h1 = new HuffmanTree();

		File schemeFile = new File("huffmanText/newscheme.txt");
		Scanner fromSchemeFile = new Scanner(schemeFile);

		while (fromSchemeFile.hasNextLine()) {
			String line = fromSchemeFile.nextLine();
			h1.addNode(line);
		}

		File messageFile = new File("huffmanText/message.txt");
		Scanner fromMessageFile = new Scanner(messageFile);

		System.out.println(h1.decryptTree(fromMessageFile.nextLine()));

		System.out.println("Eyy");

		fromSchemeFile.close();

	}

}
