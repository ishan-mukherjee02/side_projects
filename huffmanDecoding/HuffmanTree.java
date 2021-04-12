package huffmanDecoding;

import binaryTree.linkBased.TreeNode;

public class HuffmanTree {

	private TreeNode<String> root = constructNewNode("null");

	public void addNode(String line) {
		String character = line.substring(0, 1);
		line = line.substring(1);
		TreeNode temp = root;

		while (line.length() > 1) {
			if (line.substring(0, 1).equals("0")) {
				if (temp.left == null)
					temp.left = constructNewNode("null");
				temp = temp.left;
			} else if (line.substring(0, 1).equals("1")) {
				if (temp.right == null)
					temp.right = constructNewNode("null");
				temp = temp.right;
			}

			line = line.substring(1);
		}

		if (line.substring(0, 1).equals("0")) {
			temp.left = constructNewNode(character);
		} else if (line.substring(0, 1).equals("1")) {
			temp.right = constructNewNode(character);
		}
	}

	protected TreeNode constructNewNode(String string) {
		TreeNode newNode = new TreeNode();
		newNode.value = string;

		return newNode;
	}

	public String decryptTree(String encoded) {
		String message = "";
		TreeNode temp = root;

		for (int i = 0; i < encoded.length(); i++) {
			if (encoded.substring(i, i + 1).equals("0"))
				temp = temp.left;
			else if (encoded.substring(i, i + 1).equals("1"))
				temp = temp.right;

			if (temp.value != null && !temp.value.equals("null")) {
				message += temp.value;
				temp = root;
			}
		}

		return message;
	}
}
