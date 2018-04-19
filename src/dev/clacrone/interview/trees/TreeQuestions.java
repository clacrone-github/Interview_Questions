package dev.clacrone.interview.trees;

import java.util.TreeMap;

import dev.clacrone.interview.utils.TreeNode;

public class TreeQuestions {

	public static boolean isBST(TreeNode curr, int min, int max) {
		if (curr == null) {
			return true;
		}

		if (curr.getData() > max || curr.getData() <=s min) {
			return false;
		}

		if (!isBST(curr.getLeft(), min, curr.getData()) || !isBST(curr.getRight(), curr.getData(), max)) {
			return false;
		}

		return true;
	}
	
	public static void mirrorTree(TreeNode curr) {
		if (curr == null) {
			return;
		}

		mirrorTree(curr.getLeft());
		mirrorTree(curr.getRight());
		TreeNode temp = curr.getLeft();
		curr.setLeft(curr.getRight());
		curr.setRight(temp);
	}
	
	public static void isBalanced(TreeMap t) {
		
	}
}
