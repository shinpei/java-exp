import com.google.common.io.Closeables;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class TestFuture {

    @Test
    void testRunnableCallable() throws Exception {

        // Runnable is void
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("hi");
            }
        };
        task.run();

        // Callable returns ret value
        Callable<String> task2 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Executed!";
            }
        };
        System.out.println(task2.call());

    }

    @Test
    void testExecutorService() throws Exception {

        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(() -> System.out.println("hi"));
        es.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 3;
            }
        });
    }

    class Server {
        ExecutorService es;
        ServerSocket ss;
        Server () throws IOException {
            this.es = Executors.newSingleThreadExecutor();
            ss = new ServerSocket();
            ss.bind(new InetSocketAddress(9999));
        }

        class Job implements Callable<Socket>{
            ServerSocket ss;
            Job(ServerSocket ss) {
                this.ss = ss;
            }

            @Override
            public Socket call() throws Exception {
                try {
                    return ss.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }

        void start() {
            InputStream ins = null;
            OutputStream ous = null;
            try{
                Future<Socket> fs = es.submit(new Job(ss));
                System.out.println("Invoked fs");
                Socket s = fs.get();
                System.out.println("Caught future");
                ins = s.getInputStream();
                ous = s.getOutputStream();
                System.out.println(new String(ins.readAllBytes()));
            } catch (InterruptedException | ExecutionException | IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    assert ins != null;
                    ins.close();
                    assert ous != null;
                    ous.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    class ServerHandler implements Callable<Socket> {
        ServerSocket ss;

        ServerHandler(ServerSocket ss) {
            this.ss = ss;
        }

        @Override
        public Socket call() throws Exception {
            do {
                Socket s = ss.accept();
                return s;
            } while (true);

        }
    }

    class SocketHandler implements Callable<Void> {
        Socket sock;
        SocketHandler(Socket sock) {
            this.sock = sock;

        }
        @Override
        public Void call() throws Exception {
            return null;
        }
    }

    @Test
    void testServerSock () throws Exception {
        Server serv = new Server();

        serv.start();
    }
}
