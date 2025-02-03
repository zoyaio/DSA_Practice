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
		if (location == null) {
			add(data, root);

		}
		else {
			location.setDataCount(location.getDataCount() + 1);
		}
	}


	// thje ome thing im stil confused on
	private HistoNode add(Comparable data, HistoNode tree) {

		if (tree == null){
			tree = new HistoNode(data, 1, null, null);
		root = tree;
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

		if (data == tree.getData()) {
			return tree;
		}
		else {

			if (tree.getLeft() != null && (tree.getLeft().getData().compareTo(data) < 0)) {
				return search(data, tree.getRight());
			}
			else {
				return search(data, tree.getLeft());
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
		String retString = "";
		if (tree != null){
			toString(tree.getLeft());
			retString += tree.getData() + " " + tree.getDataCount() + "\n";
			toString(tree.getRight());
		}
		return retString;
	}
}