package trees.bstree_HistoTree2;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

public interface Treeable
{
	public Object getValue();
	public Treeable getLeft();
	public Treeable getRight();
	public void setValue(Comparable value);
	public void setLeft(Treeable left);
	public void setRight(Treeable right);
}