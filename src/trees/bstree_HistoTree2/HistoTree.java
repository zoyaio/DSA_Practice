package trees.bstree_HistoTree2;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

public class HistoTree {
	private TreeNode root;

	public HistoTree() {
		root = null;
	}

	public void addData(Comparable data) {
		root = add(data, root);
	}

	private TreeNode add(Comparable data, TreeNode tree) {
		if (tree == null) {
			return new TreeNode(new ThingCount(data, 1));
		}
		ThingCount nodeData = (ThingCount) tree.getValue();
		if (nodeData.getThing().equals(data)) {
			nodeData.setCount(nodeData.getCount() + 1);
		} else if (data.compareTo(nodeData.getThing()) < 0) {
			tree.setLeft(add(data, tree.getLeft()));
		} else {
			tree.setRight(add(data, tree.getRight()));
		}
		return tree;
	}

	private TreeNode search(Comparable data) {
		return search(data, root);
	}

	private TreeNode search(Comparable data, TreeNode tree) {
		if (tree == null) return null;
		ThingCount nodeData = (ThingCount) tree.getValue();
		if (nodeData.getThing().equals(data)) return tree;
		if (data.compareTo(nodeData.getThing()) < 0) return search(data, tree.getLeft());
		return search(data, tree.getRight());
	}

	public String toString() {
		return toString(root).trim();
	}

	private String toString(TreeNode tree) {
		if (tree == null) return "";
		return toString(tree.getLeft()) + tree.getValue() + "    " + toString(tree.getRight());
	}
}
