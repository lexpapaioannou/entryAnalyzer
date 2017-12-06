package EntryAnalyzer;

public class table {
	String label;
	int hits;
	
	public table () {
		label = " ";
		hits = 0;
	}	

	public table (String label, int hits) {
		this.label = label;
		this.hits = hits;
	}
	
	public String getLabel() {
		return label;
	}

	public int getHits() {
		return hits;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public void removeEntry(String label) {
		this.label = "";
		this.hits = -1;
	}

}
