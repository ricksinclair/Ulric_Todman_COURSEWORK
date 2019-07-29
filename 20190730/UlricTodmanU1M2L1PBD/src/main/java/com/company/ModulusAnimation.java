package com.company;

public class ModulusAnimation
{
	public static void main( String[] args ) throws Exception
	{
		for ( int i=0; i<80; i++ )
		{
			if ( i%12 == 0 )
				System.out.print("I\r");
			else if (i%12 == 1)
				System.out.print("I am\r");
			else if (i%12 == 2)
				System.out.print("I am the\r");
			else if (i%12 == 3)
				System.out.print("I am the man\r");
			else if (i%12 == 4)
				System.out.print("I am the man with\r");
			else if (i%12 == 5)
				System.out.print("I am the man with the \r");
			else if (i%12 == 6)
				System.out.print("I am the man with the master\r");
			else if (i%12 == 7)
				System.out.print("I am the man with the master plan.\r");

			Thread.sleep(200);
		}
		
	}
}
