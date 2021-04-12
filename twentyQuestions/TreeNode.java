package twentyQuestions;

import java.io.Serializable;

public class TreeNode<E> implements Serializable{
	public E value;
	public TreeNode<E> left, right;

	public TreeNode(E val) {
		this.value = val;
	}

	public String toString() {
		String asString = "value: " + this.value + " left: ";

		asString += this.left == null ? null : left.value;
		asString += " right: ";
		asString += this.right == null ? null : right.value;

		return asString;
	}
}
