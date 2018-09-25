package stacks;

public class PalindromeChecker {

  //Data Fields
  private String inputStr;
  private StackLL<Character> charStack;

  //Constructor
  PalindromeChecker(String str) {
    inputStr = str;
    charStack = new StackLL<Character>();
    fillStack(str);
  }

  private void fillStack(String str){
    for (int i = 0; i < str.length(); i++){
      charStack.push(str.charAt(i));
    }
  }

  private String buildReverse() {
    StringBuilder s = new StringBuilder();

    while (!charStack.empty()){
      s.append(charStack.pop());
    }

    return s.toString();
  }

  public boolean isPalindrome() {
    String revStr = buildReverse();
    boolean result = true;
    int i = 0;
    int j = 0;

    while (i<inputStr.length() && result){

      while (i < inputStr.length() && inputStr.charAt(i) == ' '){
        i++;
      }

      while (j < revStr.length() && revStr.charAt(j) == ' '){
        j++;
      }

      if(i < inputStr.length() && j < revStr.length()){
        result = result && Character.toLowerCase(inputStr.charAt(i)) == Character.toLowerCase(revStr.charAt(j));
        i++;
        j++;
      }
    }
    return result;
  }

  public static void main(String[] args){
    PalindromeChecker pc = new PalindromeChecker("kayak");
    PalindromeChecker pc2 = new PalindromeChecker("kayaK");
    PalindromeChecker pc3 = new PalindromeChecker("kaya k");
    PalindromeChecker pc4 = new PalindromeChecker("cayak");

    System.out.println(pc.isPalindrome());
    System.out.println(pc2.isPalindrome());
    System.out.println(pc3.isPalindrome());
    System.out.println(pc4.isPalindrome());
  }
}
