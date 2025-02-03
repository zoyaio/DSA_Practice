package trees.bstree_BasicTree;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

public class BinarySearchTree
{
	private TreeNode root;

	public BinarySearchTree()
	{
		root = null;
	}

	public void add(Comparable val)
	{
		root = add(val, root);
	}

	private TreeNode add(Comparable val, TreeNode tree)
	{
	   if(tree == null)
			tree = new TreeNode(val);
		else {
		   Comparable treeValue = tree.getValue();
		   int dirTest = val.compareTo(treeValue);


		   if (dirTest <= 0)
			   tree.setLeft(add(val, tree.getLeft()));
		   else if (dirTest > 0)
			   tree.setRight(add(val, tree.getRight()));
	   }
		return tree;
	}

   public void inOrder()
	{
		inOrder(root);
		System.out.println("\n\n");
	}

	private void inOrder(TreeNode tree)
	{
		if (tree != null){
			inOrder(tree.getLeft());
			System.out.print(tree.getValue() + " ");
			inOrder(tree.getRight());
		}
	}

	//add preOrder, postOrder, and revOrder
	public void revOrder()
	{
		revOrder(root);
		System.out.println("\n\n");
	}

	private void revOrder(TreeNode tree)
	{
		if (tree != null){
			revOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
			revOrder(tree.getLeft());
		}
	}

	public void preOrder() {
		preOrder(root);
		System.out.println("\n\n");
	}

	private void preOrder(TreeNode tree) {
		if (tree != null) {
			System.out.println(tree.getValue() + " ");
			preOrder(tree.getLeft());
			preOrder(tree.getRight());
		}
	}

	public void postOrder() {
		postOrder(root);
		System.out.println("\n\n");
	}
	private void postOrder(TreeNode tree) {
		if (tree != null) {
			postOrder(tree.getLeft());
			postOrder(tree.getRight());
			System.out.println(tree.getValue() + " ");

		}
	}




	public int getNumLevels()
	{
		return getNumLevels(root);
	}

	private int getNumLevels(TreeNode tree)
	{
		if(tree==null)
			return 0;
		else if(getNumLevels(tree.getLeft())>getNumLevels(tree.getRight()))
			return 1+getNumLevels(tree.getLeft());
		else
			return 1+getNumLevels(tree.getRight());
	}



	//add getNumLeaves, getDiameter, getHeight, getNumNodes, and isFull

	public int getDiameter() {
		// subtract 1 because the root is counted twice in these diameters
		return getDiameter(root.getLeft()) + getDiameter(root.getRight()) - 1;
	}
	private int getDiameter(TreeNode tree) {
		if (tree == null) {
			return 1;
		}
		int leftDiameter = getDiameter(tree.getLeft());
		int rightDiameter = getDiameter(tree.getLeft());
		if (leftDiameter >= rightDiameter) {
			return leftDiameter + 1;
		}
		else {
			return rightDiameter + 1;
		}
	}

	public int getNumLeaves() {
		return getNumLeaves(root)/2; // since each node gets double counted
	}
	public int getNumLeaves(TreeNode node) {
		// if the next one is null then +1, return lft + right
		if (node == null) {
			return 1; // these get doubled because each node is counted twice
		}
		return getNumLeaves(node.getLeft()) + getNumLeaves(node.getRight());
	}

	public int getHeight() {
		return getDiameter(root);
	}

	public int getNumNodes() {
		return getNumNodes(root);
	}
	private int getNumNodes(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return getNumNodes(node.getLeft()) + getNumNodes(node.getRight()) + 1;
	}

	public boolean isFull() {
		return isFull(root);
	}

	public boolean isFull(TreeNode node) {
		if (node.getLeft() == null) {
			if (node.getRight() == null) {
				return true;
			}
			return false;
		}
		else if (node.getRight() != null) {
			return isFull(node.getLeft()) && isFull(node.getRight());
		}
		return false;
	}



	//add extra credit options here - 10 points each
	
	//search
	
	//maxNode
	
	//minNode
	
	//level order
	
	//display like a tree
	
	//remove


	public String toString()
	{
		return "";
	}

	private String toString(TreeNode tree)
	{
		return "";
	}
}