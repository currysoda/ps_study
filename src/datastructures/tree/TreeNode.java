package datastructures.tree;

public class TreeNode {
	
	private TreeNode left;
	private TreeNode right;
	private Integer  value;
	
	public TreeNode(Integer value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	
	public TreeNode getLeft() {
		return left;
	}
	
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	
	public TreeNode getRight() {
		return right;
	}
	
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	public Integer getValue() {
		return value;
	}
	
	public void setValue(Integer value) {
		this.value = value;
	}
}
