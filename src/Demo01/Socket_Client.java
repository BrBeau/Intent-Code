package Demo01;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Socket_Client {

	public static void main(String[] args) {
		
		OutputStream os=null;
		Socket client=null;

		try {
			client=new Socket("192.168.17.1", 2018);
			System.out.println("客户端程序已经建立...同时申请连接服务器...");
			os=client.getOutputStream();
			os.write("这是我从客户端写入的数据...".getBytes());
			
			//关闭资源
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (os!=null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (client!=null) {
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
