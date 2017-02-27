package dev.clacrone.interview.trees;

public class TreeQuestions {

	public class Node {
		Node left;
		Node right;
		int data;
	}
	
	public static boolean isBST(Node curr, int max, int min) {
		if (curr == null) {
			return true;
		}

		if (curr.data > max || curr.data < min) {
			return false;
		}

		if (!isBST(curr.left, curr.data, min) || !isBST(curr.right, max, curr.data)) {
			return false;
		}

		return true;
	}
	
	public static void mirrorTree(Node curr) {
		if (curr == null) {
			return;
		}

		mirrorTree(curr.left);
		mirrorTree(curr.right);
		Node temp = curr.left;
		curr.left = curr.right;
		curr.right = temp;
	}
}
