package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static test.RuntTimeExceptionWrapper.noException;


public class TCPMultiThreadEchoServer {

    private static final int TELNET_PORT = 8080;

    private static final String[] allowedIps = {"127.0.0.1"};

    final static Collection<InetAddress> allowedAddresses =
            Arrays.stream(allowedIps)
                    .map(noException(InetAddress::getByName))
                    .collect(Collectors.toSet());

    public static void main(String[] args) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(TELNET_PORT);

        final ExecutorService service = Executors.newFixedThreadPool(4);

        while (true) {

            final Socket clientSocket = serverSocket.accept();
            final InetSocketAddress remote = (InetSocketAddress) clientSocket.getRemoteSocketAddress();
            final InetAddress address = remote.getAddress();
            final byte[] ip = address.getAddress();

            System.out.println("connection from port=" + remote.getPort()
                    + " ip=" + Arrays.toString(ip));

            if (isAllowed(ip)) {
                serve(service, clientSocket);
            } else {
                clientSocket.close();
                System.out.println("connection from port=" + remote.getPort()
                        + " ip=" + Arrays.toString(ip) + " is refused");
            }
        }
    }

    /**
     * Check if ip is allowed
     * @param ip
     * @return
     */
    private static boolean isAllowed(byte[] ip) {
        return allowedAddresses
                .stream()
                .map(InetAddress::getAddress)
                .anyMatch(allowed -> Arrays.equals(ip, allowed));
    }


    /**
     *
     * @param service
     * @param clientSocket
     */
    private static void serve(ExecutorService service, Socket clientSocket) {
        service.submit(
                () -> {
                    try (final InputStream in = clientSocket.getInputStream();
                         final OutputStream out = clientSocket.getOutputStream()) {
//                        while (clientSocket.isConnected() && in.transferTo(out) > 0) ;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );
    }
}
