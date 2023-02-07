import java.util.*;
import java.util.regex.*;

public class App {
    @SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {  
    	Regex regex = new Regex(); 
    	System.out.println("종료 : Q\n");
    	while (true) {
        	System.out.println("주소를 입력해주세요.");
        	System.out.print("입력 : ");
        	Scanner sc = new Scanner(System.in);
            String add = sc.nextLine();
            if(add.equals("Q") ||  add.equals("q")) {
            	break;
            }
            System.out.printf("출력 : %s\n\n",  regex.getAddress(add));
    	}
    	System.out.println("\n-종료-");
    	return;
    }
}

class Regex{
     String getAddress(String add){
       String processedAdd = add;
       String gu = "";
       String doro = "";

       final String GU_PATTERN = "(([가-힣A-Za-z·\\d~\\-\\.]{2,}(시|군|구)+))";
       Matcher getGu = Pattern.compile(GU_PATTERN).matcher(add);
       while (getGu.find()) {
    	   if(getGu.group()!=null) {
    		   gu = getGu.group().replaceAll("[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]", "");
    		   break;
    	   }
    	}

       
       if(gu.equals("")) {
    	   processedAdd = processedAdd.replaceAll(" ", "");
       }
       final String DORO_PATTERN = "(([가-힣A-Za-z·\\d~\\-\\.]{2,}(로|길)+))";
       Matcher getDoro = Pattern.compile(DORO_PATTERN).matcher(processedAdd);
       while (getDoro.find()) {
    	   if(getDoro.group(0)!=null) {
    		   doro = getDoro.group(0).replaceAll("[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]", "");
    		   break;
		   }
	   }
       return (gu + ' ' + doro).trim();
    }
     
     
}
