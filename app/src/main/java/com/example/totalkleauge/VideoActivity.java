package com.example.totalkleauge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class VideoActivity extends AppCompatActivity {

    private Button startButton;
    private EditText inputMessage,editPeerIP;
    private InetAddress PeerIP2;
    private InetAddress PeerIP1;
    private boolean Callee = false;
    private TextView receive_message;
    private int SEND_PORT = 7777;
    private int RECV_PORT = 8888;
    private String MessageInput;
    private ArrayAdapter<String> mConversationArrayAdapter;
    private ListView mConversationView;
    private DatagramSocket send_socket;
    TextView OwnIP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        OwnIP = (TextView) findViewById(R.id.OwnIP);
        OwnIP.setText(getIpAddress());
        editPeerIP = (EditText)findViewById(R.id.editPeerIP);
        startButton = (Button) findViewById (R.id.start_button);
        inputMessage = (EditText) findViewById (R.id.input_message);
        //receive_message = (TextView) findViewById (R.id.receive_message);
        mConversationArrayAdapter = new ArrayAdapter<String>(this, R.layout.message);
        mConversationView = (ListView) findViewById(R.id.listView1);
        mConversationView.setAdapter(mConversationArrayAdapter);
        startButton.setOnClickListener(startP2PSend);

        Thread startReceiveThread = new Thread(new StartReceiveThread()); // 서버 역할을 하기 위해 실행
        startReceiveThread.start();

        try {
            send_socket = new DatagramSocket(SEND_PORT); // 메세지를 udp로 보낸다
        } catch (SocketException e) {
            Log.e("VR", "Sender SocketException");
        }




    }
    private final View.OnClickListener startP2PSend = new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {          // 클라이언트 시작
            Log.d("VR", "Click OK");
            startP2PSending();
        }
    };
    public void startP2PSending() { // 클라이언트 역할
        Thread startP2PSendingThread = new Thread (new Runnable() {
            @Override
            public void run() {
                try {
                    MessageInput = inputMessage.getText().toString();
                    if(Callee == true)
                        PeerIP1 = PeerIP2;
                    else
                        PeerIP1 =  InetAddress.getByName(editPeerIP.getText().toString());

                    final InetAddress peerIP = InetAddress.getByName(editPeerIP.getText().toString());

                    DatagramPacket send_packet = new DatagramPacket(MessageInput.getBytes(), MessageInput.length(),PeerIP1,RECV_PORT);

                    send_socket.send(send_packet);
                    Log.d("VR", "Packet Send");

                    VideoActivity.this.runOnUiThread(new Runnable() { // 메세지 전송
                        @Override
                        public void run() {
                            mConversationArrayAdapter.add("Sending from " + getIpAddress().trim() + " : " + inputMessage.getText().toString());
                        }
                    });

                    VideoActivity.this.runOnUiThread(new Runnable() { // 보내고 나서 메시지창 blank
                        @Override
                        public void run() {
                            inputMessage.setText("");
                        }
                    });
                } catch (SocketException e) {
                    Log.e("VR", "Sender SocketException");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        startP2PSendingThread.start();
    }
    private String getIpAddress() {
        String ip = "";
        try {
            Enumeration<NetworkInterface> enumNetworkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (enumNetworkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = enumNetworkInterfaces.nextElement();
                Enumeration<InetAddress> enumInetAddress = networkInterface.getInetAddresses();
                while (enumInetAddress.hasMoreElements()) {
                    InetAddress inetAddress = enumInetAddress.nextElement();
                    if (inetAddress.isSiteLocalAddress()) {
                        ip += inetAddress.getHostAddress() + "\n";
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
            ip += "Something Wrong! " + e.toString() + "\n";
        }
        return ip;
    }
    private class StartReceiveThread extends Thread { // 서버를 역할을 하기 위한 내부 클래스

        DatagramSocket recv_socket; // 수신할 UDP 소켓
        byte[] receiveData =new byte[1024];

        public void run() {
            try {
                recv_socket = new DatagramSocket(RECV_PORT);

                Log.d("VR", "Receiver Socket Created");

                while (true) {
                    DatagramPacket recv_packet = new DatagramPacket(receiveData, receiveData.length); // 데이터를 받을 페킷을 만든다
                    recv_socket.receive(recv_packet); // 페킷을 반을때까지 기다린다. 받아서 packet에 넣는다.
                    Log.d("VR", "Packet Received");
                    final String receive_data = new String(recv_packet.getData(), 0 , recv_packet.getLength());

                    InetAddress sourceHost = recv_packet.getAddress() ; // 메세지를 보낸 ip 주소를 지정
                    PeerIP2 = sourceHost;
                    Callee = true; // 호출된 상태이다 -> 응답을 보낼때 메세지를 보낸 ip주소로 다시 보내기 위해서.
                    final String sourceIP = sourceHost.getHostName();

                    VideoActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mConversationArrayAdapter.add("Message from " + sourceIP + " : " + receive_data);
                        }
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}