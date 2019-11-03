public class Minion {
	private int atk, hlt, maxhlt, atkchance;
	private boolean isdead, enemy = false;
	
	public Minion(int a, int h)
	{
		if (a < 0) a = 0;
		if (h < 1) h = 1;
		atk = a;
		hlt = h;
		maxhlt = h;
		atkchance = 1;
		isdead = false;
	}
	
	public static boolean attack(Minion a, Minion b)
	{
		if (a.getEnemy()||a.getAtkchance()==0||a.getIsdead()||b.getIsdead()) return false;
		a.hurt(b.getAttack());
		b.hurt(a.getAttack());
		a.downAtkchance();
		return true;
	}
	
	public boolean hurt(int dmg)
	{
		if (dmg < 0) return false;
		
		hlt -= dmg;
		if (hlt <= 0) 
		{
			hlt = 0;
			isdead = true;
		}
		
		return true;
	}
	
	public boolean heal(int n)
	{
		if (n < 0) return false;
		
		hlt += n;
		if (maxhlt < hlt) hlt = maxhlt;
		return true;
	}
	
	public boolean getIsdead()
	{
		return isdead;
	}
	
	public int getAttack()
	{
		return atk;
	}
	
	public int getAtkchance()
	{
		return atkchance;
	}
	
	public void downAtkchance()
	{
		atkchance--;
	}
	
	public void isenemy()
	{
		enemy = true;
	}
	
	public boolean getEnemy()
	{
		return enemy;
	}
	
	public String toString()
	{
		if (!isdead) return atk+"/"+hlt;
		else return "---";
	}
}
