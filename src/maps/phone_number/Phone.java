package maps.phone_number;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Map;
import java.util.TreeMap;

public class Phone
{
	private Map<String, Integer> m;
	
	public Phone()
	{
		//complete the constructor
		m = new TreeMap<>();
		m.put("", 1);
		String[] strs = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
		for (int i = 1; i<= strs.length; i++) {
			for (String c : strs[i -1].split("")) {
				m.put(c, i+1);
			}
		}
		System.out.println(m);
	}
	
	public String getNumber( String s )
	{
		String conv = "";
		conv += s.substring(0,4);
		for (String chunk : s.substring(4).split("-")) {
			for (String c : chunk.split(""))  {
				Integer temp = m.get(c);
				if (temp == null) {
					conv += m.get("");
				}
				else {
					conv += temp;
				}
			}

			conv += "-";
			// treats them both as 4 or both as 3
		}
		return conv.substring(0, conv.length()-1);
	}

}