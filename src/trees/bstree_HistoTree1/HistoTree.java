package trees.bstree_HistoTree1;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import trees.bstree_BasicTree.TreeNode;

public class HistoTree
{
   private HistoNode root;

	public HistoTree( )
	{
		root = null;
	}

	public void addData(Comparable data)
	{

		HistoNode location = search(data);
		// if it hasn't been found before
		if (location == null) {
			System.out.println("hi " + data);
			add(data, root);

		}
		// if the location already exists
		else {
			location.setDataCount(location.getDataCount() + 1);
		}
	}


	// thje ome thing im stil confused on
	private HistoNode add(Comparable data, HistoNode tree) {

		if (tree == null){
			tree = new HistoNode(data, 1, null, null);
			if (root == null) {
				root = tree;
			}
	}
		else {
			Comparable treeValue = tree.getData();
			int dirTest = data.compareTo(treeValue);


			if (dirTest <= 0)
				tree.setLeft(add(data, tree.getLeft()));
			else if (dirTest > 0)
				tree.setRight(add(data, tree.getRight()));
		}
		return tree;

	}

	public HistoNode search(Comparable data)
	{
		return search(data, root);
		// if either side are not null return that
	}

	private HistoNode search(Comparable data, HistoNode tree)
	{
		if (tree == null) {
			return null;
		}

		// if the subtree is the right one
		if (data == tree.getData()) {
			return tree;
		}

		else {
			// checks if not left for no errors in compareTo call
			// if the value is greater than the left, checks the right side
			// if there was nothing on the left then we woudl want it to gl elft
			// issue was that we have to incldue = sign bc the next value will eventually be the right value

			if (tree.getLeft() != null && data.compareTo(tree.getLeft().getData()) <= 0)
			{
				return search(data, tree.getLeft());
			}
			else {
				return search(data, tree.getRight());
			}

		}
		// check if the data = the current value
		// if not, check if its greater than the left side
		// call search on approp val
	}

	public String toString()
	{
		return toString(root);
	}

	private String toString(HistoNode tree)
	{
		String leftString = "";
		String thisString = "";
		String rightString = "";
		if (tree != null){
			 leftString = toString(tree.getLeft());
			 thisString =  tree.getData() + ":" + tree.getDataCount();
			 rightString = toString(tree.getRight());
		}
		return leftString + " " + thisString + " " + rightString ;
	}
}