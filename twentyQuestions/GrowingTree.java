package twentyQuestions;

import java.io.Serializable;

public class GrowingTree implements Serializable {

	private static final long serialVersionUID = -7077509763281774875L;
	public TreeNode<String> root = new TreeNode<String>("null");

	public GrowingTree() {
		root.value = "Is it an animal?";
		root.left = new TreeNode<String>("Is it a dog?");
		root.right = new TreeNode<String>("What is it?");
		root.left.right = new TreeNode<String>("What is it?");
		root.left.left = new TreeNode<String>("Thanks for playing");

	}

	public void addNewQuestionNode(TreeNode<String> t, String message, String newAns) {
		TreeNode<String> newLeft = new TreeNode<String>("Is it a " + newAns + "?");
		TreeNode<String> newRight = new TreeNode<String>(t.value);

		t.value = "Is it " + message + "?";

		newLeft.left = new TreeNode<String>("Thanks for playing");
		newLeft.right = new TreeNode<String>("What is it?");

		newRight.left = new TreeNode<String>("Thanks for playing");
		newRight.right = new TreeNode<String>("What is it?");

		t.left = newLeft;
		t.right = newRight;
	}

}
