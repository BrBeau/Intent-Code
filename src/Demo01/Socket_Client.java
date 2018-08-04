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
			System.out.println("�ͻ��˳����Ѿ�����...ͬʱ�������ӷ�����...");
			os=client.getOutputStream();
			os.write("�����Ҵӿͻ���д�������...".getBytes());
			
			//�ر���Դ
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
