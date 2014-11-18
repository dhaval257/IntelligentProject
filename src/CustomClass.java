import java.util.ArrayList;
import java.util.Comparator;


public class CustomClass implements Comparator<CustomClass>{

	private String name;
	private int value;
	private boolean isConflicted;
	private ArrayList<Integer> availableValues ;
	
	
	public CustomClass(String name, int value) {
		super();
		this.name = name;
		this.value = value;
		this.availableValues = new ArrayList<>(this.value);
		for(Integer i : this.availableValues){
			this.availableValues.add(i, i);
		}
	}
	
	
	
	public CustomClass(String name, int value, boolean isConflicted) {
		super();
		this.name = name;
		this.value = value;
		this.isConflicted = isConflicted;
		availableValues = new ArrayList<>(this.value);
		for(Integer i : availableValues){
			availableValues.add(i, i);
		}
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	
	public boolean isConflicted() {
		return isConflicted;
	}
	public void setConflicted(boolean isConflicted) {
		this.isConflicted = isConflicted;
	}



	public ArrayList<Integer> getAvailableValues() {
		return availableValues;
	}



	public void setAvailableValues(ArrayList<Integer> availableValues) {
		this.availableValues = availableValues;
	}



	@Override
	public String toString() {
		return "[name=" + name + ", value=" + value
				+ ", isConflicted=" + isConflicted + ", availableValues="
				+ availableValues + "]";
	}



	@Override
	public int compare(CustomClass o1, CustomClass o2) {
		// TODO Auto-generated method stub
		
		return (o1.getValue() - o2.getValue());
	}
	
	
	
	
	

	
	
	
	
}
