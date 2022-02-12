//Unpacker class

package Code;

import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
		
public class Unpacker
{
	int key = 10;
	
	public Unpacker(String src)
	{
		UnpackFile(src);
	}
	
	public void UnpackFile(String FilePath)
	{
		try
		{
			FileInputStream instream = new FileInputStream(FilePath);
			
			byte Header[] = new byte[100];
			int length = 0;
			int counter = 0;
			
			while((length = instream.read(Header,0,100)) > 0)
			{
				String str = new String(Header);
				
				String ext = str.substring(str.lastIndexOf("\\"));
				
				ext = ext.substring(1);
				
				String words[] = ext.split("\\s");
				String name = words[0];
				int size = Integer.parseInt(words[1]);
				
				byte arr[] = new byte[size];
				
				instream.read(arr,0,size);
				
				for(int i=0; i<arr.length; i++)
				{
					arr[i] = (byte)(arr[i] ^ key);
				}
				
				System.out.println("\nNew File gets created as: "+name);
				
				FileOutputStream fout = new FileOutputStream(name);
				fout.write(arr,0,size);
				
				counter++;
			}
			System.out.println("\nSucessfully Unpack Files is: "+counter);
		}
		catch(Exception obj)
		{}
	}
}
