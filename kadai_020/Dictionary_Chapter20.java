package kadai_020;

import java.util.HashMap;

public class Dictionary_Chapter20 {
	public static void main(String[] words) {
		 HashMap<String,String> fruitMap = new HashMap<String,String>();
		 
		 fruitMap.put("apple","りんご");
		 fruitMap.put("peach","桃");
		 fruitMap.put("banana","バナナ");		 
		 fruitMap.put("lemon","レモン");				 
         fruitMap.put("pear","梨");
         fruitMap.put("kiwi","キウィ");
         fruitMap.put("strawberry","いちご");
         fruitMap.put("grape","ぶどう");
         fruitMap.put("muscat","マスカット");
	     fruitMap.put("cherry","さくらんぼ");
	     
	     for (int i = 0; i < words.length; i++) {
	    	    if (fruitMap.containsKey(words[i])) {
	    	        System.out.println(words[i] + "の意味は" + fruitMap.get(words[i]));
	    	    } else {
	    	        System.out.println(words[i] + "は辞書に存在しません");
	    	    }
	     }
	     

	}
 }
