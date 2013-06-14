package kz.epam.azimkhan.text.model.number;

public class IntegerNumber extends Number{

	private int value;
	
	public IntegerNumber(){
		value = 0;
	}
	
	public IntegerNumber(int value){
		this.value = value;
	}
	
	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString(){
		return String.valueOf(value);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IntegerNumber other = (IntegerNumber) obj;
		if (value != other.value)
			return false;
		return true;
	}
	
	

}
