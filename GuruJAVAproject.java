import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
<applet code=GuruJAVAproject" width=1500 height=3000>
<param name = "Image" value = "relaxery.jpg">
</applet>
*/

public class myproject extends Applet implements ActionListener,ItemListener
{
	String[] msg = new String[8];	Button Enter_Id,Previous,Next;	TextField cust_id;	List l;	Image pic;
	String[][] details=new String[52][];	String csvFile = "my_file.csv";	String line = "";	String 	csvsplit=","; 
	Choice myc;
	public void init()
	{
		int choice_no=5001;
		AudioClip clip = getAudioClip( getCodeBase(),"Ali.wav");
		clip.play();
		pic=getImage(getDocumentBase(),getParameter("Image"));
    	setFont(new Font("TimesRoman",Font.PLAIN,18));
        cust_id = new TextField(6);
	    Enter_Id = new Button("Enter");
		Previous = new Button("Previous");
		Next = new Button("Next");
	    l =  new List(10);
		l.setBackground(Color.lightGray);
		myc = new Choice();
		myc.setBackground(Color.lightGray);
		
		while(choice_no<5051)
		{
			String choice_add="";
			choice_add = Integer.toString(choice_no);
			myc.add(choice_add);
			choice_no++;
		}
		add(l);
		add(myc);
		add(cust_id);
		add(Enter_Id);
        add(Previous);
		add(Next);
		try 
		{
			int i=0;
			BufferedReader br = new BufferedReader(new FileReader(csvFile));
		    while ((line = br.readLine()) != null)
			{ 
            	details[i]=line.split(csvsplit);
			    i++;
		 	} 
        } 
		catch (IOException e)
		{ 
			System.out.println("Cannot load, exception!");
        } 
		myc.addItemListener(this);
		cust_id.addActionListener(this);
		Enter_Id.addActionListener(this);
		Previous.addActionListener(this);
		Next.addActionListener(this);
    }
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource()== myc)
		{
			String str8=myc.getSelectedItem();
			cust_id.setText(str8);
		}
		repaint();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
        	l.removeAll();
		String str1 = cust_id.getText();
		int i=0,w=1,d=-1;
		if(ae.getSource() == Enter_Id)
		{
			String str2 = details[i][0];
			while(!(str1.equals(str2)))
			{
				i++;
				str2 = details[i][0];
			}
			for(int u=0;u<10;u++)
			{
				l.add(details[i][u]);
			}
		}
		else if(ae.getSource()==Previous)
		{
			String str4=details[(w-1)][0];
			while(!(str1.equals(str4)))
			{
				w++;
				str4=details[w][0];
			}
			for(int r=0;r<10;r++)
			{
				l.add(details[w-1][r]);
			}
	
		}
		else
		{
			System.out.println("Next");
			String str3=details[(d+1)][0];
			while(!(str1.equals(str3)))
			{
				d++;
				str3=details[d][0];
			}
			for(int b=0;b<10;b++)
			{
				l.add(details[d+1][b]);
			}
		}
		repaint();
	}
	public void paint(Graphics g)
	{
		g.drawImage( pic, 0, 0,1370,750,this );
		g.setFont(new Font("TimesRoman",Font.BOLD,24));
		g.setColor(Color.YELLOW);
		g.drawString("Submitted By-", 1010, 540);
		g.drawString("Gurucharan Kaur Saluja", 1010, 580);
		g.drawString("17MTES08", 1010, 600);
		g.drawString("Submitted To-", 110, 540);
		g.drawString("Ms. Kirti Panwar Bhati", 110, 580);
		g.setFont(new Font("TimesRoman",Font.BOLD,56));
		g.setColor(Color.BLACK);
		g.drawString("Hotel Relaxery", 470, 540);
		g.setFont(new Font("TimesRoman",Font.BOLD | Font.ITALIC,24));
		g.setColor(Color.RED);
		g.drawString("Keep Calm...!!", 570, 600);
		g.drawString("And Pamper Yourself....Relax..!!", 470, 640);
		g.setFont(new Font("TimesRoman",Font.BOLD,20));
		g.setColor(Color.CYAN);
		g.drawString("Customer Id:", 300, 30);
		g.drawString("Customer Name:", 300, 50);
		g.drawString("Customer Age:", 300, 70);
		g.drawString("Booking of Days:", 300, 90);
		g.drawString("Id Proof:", 300, 110);
		g.drawString("Id No.:", 300, 130);
		g.drawString("Required room:", 300, 150);
		g.drawString("Type of Room:", 300, 170);
		g.drawString("Number of person:", 300, 190);
	}		
} 
