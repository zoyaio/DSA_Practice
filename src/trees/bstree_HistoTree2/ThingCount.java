package trees.bstree_HistoTree2;//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

public class ThingCount implements Comparable {
	private int count;
	private Object thing;

	public ThingCount() {
		this.thing = null;
		this.count = 0;
	}

	public ThingCount(Object thang, int cnt) {
		this.thing = thang;
		this.count = cnt;
	}

	public void setThing(Object obj) {
		this.thing = obj;
	}

	public void setCount(int cnt) {
		this.count = cnt;
	}

	public Object getThing() {
		return thing;
	}

	public int getCount() {
		return count;
	}

	public boolean equals(Object obj) {
		if (obj instanceof ThingCount) {
			ThingCount other = (ThingCount) obj;
			return this.thing.equals(other.thing);
		}
		return false;
	}

	public int compareTo(Object obj) {
		ThingCount other = (ThingCount) obj;
		return ((Comparable) this.thing).compareTo(other.thing);
	}

	public String toString() {
		return thing + " - " + count;
	}
}
