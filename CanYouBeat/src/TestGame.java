
public class TestGame {

	private int enemy, ally;
	private Minion[] field;
	
	public TestGame(int n, int m, int maxhlt, int maxatk)
	{
		if (n < 1) n = 1;
		if (m < 1) m = 1;
		if (maxhlt < 1) maxhlt = 1;
		if (maxatk < 0) maxatk = 0;
		
		ally = n;
		enemy = m;
		field = new Minion[n+m];
		
		for (int i = 0 ; i < n ; i++)
		{
			field[i] = new Minion((int)(Math.random()*maxatk)+1,(int)(Math.random()*maxhlt)+1);
		}
		for (int i = n ; i < n+m ; i++)
		{
			field[i] = new Minion((int)(Math.random()*maxatk)+1,(int)(Math.random()*maxhlt)+1);
			field[i].isenemy();
		}
	}
	
	public	boolean exeAttack(int i, int j)
	{
		if (0 < i && i <= ally && 0 < j && j <= enemy)
		{
			if (Minion.attack(field[i-1],field[ally+j-1])) return true;
			else return false;
		}
		else return false;
	}
	
	public void showField()
	{
		System.out.println("--- 아군 ---");
		for (int i = 0 ; i < ally ; i++)
		{
			System.out.print(i+1 + " : " + field[i] + " | ");
		}
		System.out.println("\n--- 적군 ---");
		for (int i = 0 ; i < enemy ; i++)
		{
			System.out.print(i+1 + " : " + field[i+ally] + " | ");
		}
		System.out.println("");
	}
}
