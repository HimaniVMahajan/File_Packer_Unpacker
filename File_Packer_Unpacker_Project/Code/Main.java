import Code.Packer;
import Code.Unpacker;

import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;

class Main
{
	public static void main(String arg[])
	{
		Scanner sobj = new Scanner(System.in);
		System.out.println("\n-------------------------------");
		System.out.println("File Packer-Unpacker Application");
		
		while(true)
		{
			int choice = 0;
			System.out.println("-------------------------------");
			System.out.println("1 : Packing");
			System.out.println("2 : Unpacking");
			System.out.println("3 : Exit");
			System.out.println("\nEnter your choice: ");
			choice = sobj.nextInt();
			System.out.println("-------------------------------");
			
			String Dir,Filename;

			switch(choice)
			{
				case 1:
					System.out.println("\nEnter Directory name:");
					Dir = sobj.next();

					System.out.println("\nEnter the file name for packing:");
					Filename = sobj.next();

					Packer pobj = new Packer(Dir,Filename);

				break;

				case 2:
					System.out.println("Enter packed file name for Unpacking:");
					String name = sobj.next();
					Unpacker obj = new Unpacker(name);

					break;

				case 3:
					System.out.println("\n------------------------------------------------------");
					System.out.println("Thank you for using File Packer-Unpacker Application");
					System.out.println("-------------------------------------------------------");
					System.exit(0);
					break;

				default:
					System.out.println("Wrong choice");
					break;
			}
		}

	}
}