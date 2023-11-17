package kadai_024;

import java.util.HashMap;
import java.util.Scanner;

public class Jyanken_Chapter21 {
	  public String getMyChoice() {
		  Scanner scanner = new Scanner(System.in);
		  
		  String hand= "";
		  
		  while (true) {
			  System.out.println("自分のじゃんけんの手を入力しましょう");
			  System.out.println("グーはrockのrを入力しましょう");
			  System.out.println("チョキはscissoresのsを入力しましょう");
			  System.out.println("パーはpaperのpを入力しましょう");
			  
			  hand= scanner.next();
			  
			  //エラー確認
			  if(hand.equals("r") || hand.equals("s") || hand.equals("p")) {
			   break;
			  }else {
				  System.out.println("エラーです。再度入力してください");
			  }
			  
		  }
		  scanner.close();
		  return hand;
	}
	  
	  //じゃんけんの乱数メソッド
	  public String getRandom() {
		  String[] pcHand = { "r" , "s" , "p"};
		  
		  String randomhand =pcHand[(int)Math.floor(Math.random() * 3)];
		  return randomhand;
	  }
	  
	  //じゃんけんを行う
	  public void playGame() {
		  String cho =getMyChoice();
		  String ran =getRandom();
		  HashMap<String,String> play = new HashMap<String,String>();
		  play.put("r","グー");
		  play.put("s", "チョキ");
		  play.put("p", "パー");
		  
		  System.out.println("自分の手は" + play.get(cho) +",対戦相手の手は" + play.get(ran));
		  
		  if ((cho.equals("r") && ran.equals("r")) || (cho.equals("s") && ran.equals("s")) || (cho.equals("p") && ran.equals("p"))) {
			    System.out.println("あいこです");
			}

			if ((cho.equals("r") && ran.equals("s")) || (cho.equals("s") && ran.equals("p")) || (cho.equals("p") && ran.equals("r"))) {
			    System.out.println("自分の勝ちです");
			}

			if ((cho.equals("r") && ran.equals("p")) || (cho.equals("s") && ran.equals("r")) || (cho.equals("p") && ran.equals("s"))) {
			    System.out.println("自分の負けです");
			}

	  };

}
