//Packer class

package Code;

import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;

			
public class Packer
{
	public FileOutputStream outstream = null;
	static int pack = 0;
	int key = 10;
	
	public Packer(String FolderName,String FileName)
	{
		try
		{
			//System.out.println("\nInside Packer Constructor\n");
			
			File fout = new File(FileName);
			outstream = new FileOutputStream(FileName);
			
			System.setProperty("user.dir",FolderName);
			
			TravelDirectory(FolderName);
		}
		catch(Exception obj)
		{
			System.out.println(obj);
		}
	}
	
	public void TravelDirectory(String path)
	{
		File directoryPath = new File(path);
		
		File arr[] = directoryPath.listFiles();
		
		for(File filename : arr)
		{
			if(filename.getName().endsWith(".txt"))
			{
				PackFile(filename.getAbsolutePath());
			}
		}
	}
	
	public void PackFile(String FilePath)
	{
		boolean fRet;
		
		FileInputStream istream = null;
		
		System.out.println("\nFileName received: "+FilePath);
		
		File fobj = new File(FilePath);
		
		byte Header[] = new byte[100];
		byte Buffer[] = new byte[1024];
		int length = 0;
		
		String temp = FilePath+" "+fobj.length();
		
		for(int i=temp.length(); i<100; i++)
		{
			temp = temp + " ";
		}
		
		Header = temp.getBytes();
		
		try
		{
			istream = new FileInputStream(FilePath);
			
			outstream.write(Header,0,Header.length);
			while((length = istream.read(Buffer))>0)
			{
				for(int i=0; i<Buffer.length; i++)
				{
					Buffer[i] = (byte)(Buffer[i] ^ key);
				}
				
				outstream.write(Buffer,0,length);
				pack++;
			}
			
			istream.close();
		}
		catch(Exception obj)
		{}
		
		System.out.println("\nHeader: "+temp.length());
		
		System.out.println("\nSucessfully Pack Files is: "+pack);
	}
}
