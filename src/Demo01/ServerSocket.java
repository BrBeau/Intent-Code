package Demo01;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ServerSocket {

	public static void main(String[] args) {
		InputStream is=null;
		Socket s=null;
		//�����
		try {
			java.net.ServerSocket server=new java.net.ServerSocket(2018);
			System.out.println("���������ѽ���...�ȴ��ͻ��˵�����...");
			s=server.accept();//���տͻ��˵�����
			System.out.println("�Ѿ��пͻ�������..."+server.getInetAddress()+",#"+server.getLocalPort());
			//�������˽�������
			is=s.getInputStream();
			byte[] bs=new byte[100];
			int len=0;
			len =is.read(bs);
			System.out.println("�ͻ���˵��"+new String(bs,0,len));
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
