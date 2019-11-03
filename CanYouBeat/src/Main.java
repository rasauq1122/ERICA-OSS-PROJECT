import java.util.Scanner;


public class Main {
	public static void main(String[] args)
	{
		int n, m, maxh, maxa;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("아군 하수인의 수는? ");
		n = scan.nextInt();
		System.out.print("적군 하수인의 수는? ");
		m = scan.nextInt();
		System.out.print("최대 생명력은? ");
		maxh = scan.nextInt();
		System.out.print("최대 공격력은? ");
		maxa = scan.nextInt();
		
		TestGame a = new TestGame(n,m,maxh,maxa);
		
		int atker = 1, atked = 1;
		while(true)
		{
			a.showField();
			System.out.print("공격할 아군 하수인의 번호는? ");
			atker = scan.nextInt();
			if (atker == 0)
			{
				System.out.print("종료를 원하시면 0을 입력해 주세요. ");
				atked = scan.nextInt();
				if (atked == 0) break;
				else continue;
			}
			else
			{
				System.out.print("공격대상이 될 적군 하수인의 번호는? ");
				atked = scan.nextInt();
			}
			if (a.exeAttack(atker,atked)) System.out.println("공격 성공!");
			else System.out.println("정상적인 입력인지 확인해주세요.");
		}
		
		scan.close();
	}
}
