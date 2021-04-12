package towers;

public class DiskMover
{
	public static void main(String[] args)
	{
		move(5,1,3);
		System.out.println("fin");
	}
	
    public static void move(int disks, int source, int target)
    {
        if(disks <= 0)
        	{
        		return;
        	}
        
        int other = 6 - (target + source);
        
        move(disks - 1, source, other);
        System.out.println("Move disk " + disks + " to peg " + target);
        move(disks - 1, other, target);
        
    }
}