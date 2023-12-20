
import java.util.*;
public class BullsAndCows 
{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int user_no[]=new int[4];
        int comp_no[]=new int[4];
        String generated_no="";
        System.out.println("How's it hanging Bro!!");
        rules();
        for(int i=0;i<4;i++)comp_no[i]=(int)Math.floor(Math.random()*(9-0+1)-0);
        for(int i=0;i<4;i++)generated_no+=comp_no[i];
        System.out.println("computer no is " +generated_no);
        String user=in.next();
        for(int i=0;i<4;i++)user_no[i]=user.charAt(i)-'0';
        char choice='Y';
        int t=10;
        boolean correct=false;
        while(t-->0&&(choice=='Y'||choice=='y')){ 
            correct=continuethegame(comp_no, user_no);
            if(correct)break;
            System.out.println("Do you want to Continue?[Y/N]");
            choice=in.next().charAt(0);

            if(choice=='N'||choice=='n'){
                System.out.println("You don't want to paly this game.");
                break;
            }
            else{
                System.out.println("Enter your no: ");
                user=in.next();
                for(int i=0;i<4;i++)user_no[i]=user.charAt(i)-'0';
            }    
        }
        in.close();
    }
    public static void intro(){
        Scanner in=new Scanner(System.in);
        System.out.println("Hello user!!!\nHow's it hnaging Bro!!!");
        System.out.println("Menu");
        System.out.println("1.Play Game\n2.Rules\n3.Quit");
        int choice=in.nextInt();
        if(choice==1){

        }
        in.close();
    }
    public static void game_controller(int t,char choice,boolean correct,int[] user_no,int[] comp_no){

        Scanner in=new Scanner(System.in);
        String user;
        while(t-->0&&(choice=='Y'||choice=='y')){ 
            correct=continuethegame(comp_no, user_no);
            if(correct)break;
            System.out.println("Do you want to Continue?[Y/N]");
            choice=in.next().charAt(0);

            if(choice=='N'||choice=='n'){
                System.out.println("You don't want to play this game.");
                break;
            }
            else{
                System.out.println("Enter your no: ");
                user=in.next();
                for(int i=0;i<4;i++)user_no[i]=user.charAt(i)-'0';
            }    
        }
        in.close();
    }
    private static void rules(){
        System.out.println("Let me Introduce you to the Rules.\nGuess any four digit no,if the digit match with the one of the no persent in the computer's no with same indexing then you get +1 bulls.If the index do not match then you get +1 cow");
        System.out.println("Example:\nSecret no:4271\nOppnent's no:1234\nSo you get 1 bull for 2 and two cows for four and one.\n Hope you got it.");
        System.out.println("Computer has decided its no");
    } 
    private static boolean continuethegame(int[] comp_no,int[]user_no){
        
        int ans[]=solution(comp_no,user_no);
        if(ans[0]==4){
            System.out.println("You guessed the correct answer.\n");
            return true;
        }
        else if(ans[0]==1&&ans[1]==0)System.out.println("You suck."); 
        else if(ans[1]==0&&ans[0]==0)System.out.println("Try to next time.\n");
        System.out.println("Bulls: " +ans[0]+" Cows: "+ans[1]);
        return false;
    }
    private static int[] solution(int[] comp_no, int[] user_no) {
        int ans[]=new int[2];
        int bull=0;
        int cow=0;
        Map<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<comp_no.length;i++){
            map.putIfAbsent(comp_no[i], new ArrayList<Integer>());
            map.get(comp_no[i]).add(i);
        }
        for(int i=0;i<user_no.length;i++){
            if(map.containsKey(user_no[i])){
                boolean index_matched = false;
                for(int item:map.get(user_no[i])){
                    if(item==i){
                        bull++;
                        index_matched = true;
                        break;
                    }
                }
                if(!index_matched)cow++;
            }   
        }
        ans[0]=bull;
        ans[1]=cow;
        return ans;
    }
} 
