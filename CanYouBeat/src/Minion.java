public class Minion {
	private int atk, hlt;
	private boolean isdead;
	
	public Minion(int a, int h)
	{
		if (a < 0) a = 0;
		if (h < 1) h = 1;
		atk = a;
		hlt = h;
		isdead = false;
	}
	
	public static boolean attack (Minion a, Minion b)
	{
		if (a.getDead()||b.getDead()) return false;
		a.hurt(b.getAttack());
		b.hurt(a.getAttack());
		return true;
	}
	
	public boolean hurt (int dmg)
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
	
	public boolean getDead()
	{
		return isdead;
	}
	
	public int getAttack()
	{
		return atk;
	}
}
