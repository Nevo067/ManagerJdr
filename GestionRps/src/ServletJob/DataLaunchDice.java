package ServletJob;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataLaunchDice implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2592759822320468805L;
	
	private List<Integer>listVal;
	public DataLaunchDice()
	{
		listVal = new ArrayList<Integer>();
	}
	public List<Integer> getListVal() {
		List<Integer>listInteger = new ArrayList<Integer>();
		for (Integer integer : listVal) {
			listInteger.add(integer);
		}
		return listInteger;
	}
	public void setListVal(List<Integer> listVal) {
		this.listVal = listVal;
	}
	public boolean addVal(int newVal)
	{
		try {
			listVal.add(newVal);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	public boolean deleteVal(int nb)
	{
		try {
			listVal.remove(nb);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}	
	}
	public boolean clearList()
	{
		try {
			listVal.clear();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	public boolean clearLastVal()
	{
		try {
			listVal.remove(listVal.size()-1);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	public boolean AddList(List<Integer>values)
	{
		for (Integer integer : values) {
			if(!addVal(integer))
			{
				return false;
			}
		}
		return true;
	}
}
