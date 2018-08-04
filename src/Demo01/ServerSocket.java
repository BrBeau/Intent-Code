package Demo01;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ServerSocket {

	public static void main(String[] args) {
		InputStream is=null;
		Socket s=null;
		//服务端
		try {
			java.net.ServerSocket server=new java.net.ServerSocket(2018);
			System.out.println("服务器端已建立...等待客户端的连接...");
			s=server.accept();//接收客户端的请求
			System.out.println("已经有客户端连接..."+server.getInetAddress()+",#"+server.getLocalPort());
			//服务器端接收数据
			is=s.getInputStream();
			byte[] bs=new byte[100];
			int len=0;
			len =is.read(bs);
			System.out.println("客户端说："+new String(bs,0,len));
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (s!=null) {
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
