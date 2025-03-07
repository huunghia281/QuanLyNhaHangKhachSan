package hotel;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.sql.Statement;

public class Customer {

	int customerID;
	String custName;
	String addr;
	String phone;
	String Type;
	static int j=0;
	
	
	Customer()
	{
		
	}
	
	
	public Customer(int customerID, String custName, String addr, String phone, String Type) {
		super();
		this.customerID = customerID;
		this.custName = custName;
		this.addr = addr;
		this.phone = phone;
		this.Type = Type;
	}

	public void printCustomer()
	{
		System.out.println("Tên khách hàng : "+this.custName);
		System.out.println("Địa chỉ khách hàng : "+this.addr);
		System.out.println("SDT khách hàng : "+this.phone);
	}
	
	
	public void addCustomer(String oper,Customer cust)
	{   PreparedStatement ps = null;
    ResultSet result = null;
		try {
	    	 if(oper=="i")
	         {   
	    		GetConnection connect=new GetConnection();
	    		Connection conn=connect.getConnection();
	        	 ps=conn.prepareStatement("INSERT INTO KhachHang (TenKhachHang, DiaChi, SDT, LoaiKhachHang) VALUES (?,?,?,?)");
                 ps.setString(1,cust.custName);
	             ps.setString(2,cust.addr);
	             ps.setString(3,cust.phone);
	             ps.setString(4,cust.Type);
	             
	             
	             if(ps.executeUpdate()>0)
	             {
	            	 JOptionPane.showMessageDialog(null, "Đã thêm khách hàng mới");
	             }
	         }
	    	}
	    	
	    	catch(Exception ex)
	    	{
	    		ex.printStackTrace();
	    	}
	}
	
	
	public void deleteCustomer(String oper,Customer cust)
	{
		 PreparedStatement ps = null;
		    ResultSet result = null;
				try {
			    	 if(oper=="d")
			         {   
			    		GetConnection connect=new GetConnection();
			    		Connection conn=connect.getConnection();
			        	 ps=conn.prepareStatement("DELETE FROM KhachHang where TenKhachHang=?");
			        	 ps.setString(1,cust.custName);
			        	 
			             ps.executeUpdate();
			                JOptionPane.showMessageDialog(null,"Đã xóa khách hàng");
			           
			         }
			    	}
			    	
			    	catch(Exception ex)
			    	{
			    		ex.printStackTrace();
			    	}
	}
	
	
	
}
