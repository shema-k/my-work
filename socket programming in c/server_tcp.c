#include <stdio.h>
#include <winsock2.h>   // Windows networking library. It contains socket functions like socket(), bind(), listen(), accept(), recv(), etc.
#include <ws2tcpip.h>  // Extra TCP/IP helpers like inet_pton() and address conversion functions.
#include <string.h>    // For memset() and strlen() functions.

int main(void) {
    // Step 1: Create a Winsock data structure.
    // WSADATA stores details about the Winsock version and startup state in Windows.
    WSADATA wsa;

    // Step 2: Start Winsock on this machine.
    // MAKEWORD(2, 2) asks for Winsock version 2.2.
    // The function returns 0 on success. Any other value means startup failed.
    int result = WSAStartup(MAKEWORD(2, 2), &wsa);

    // If Winsock did not start properly, stop the program.
    if (result != 0) {
        printf("WSAStartup failed: %d\n", result);
        return 1;
    }

    // Step 3: Create the server socket.
    // AF_INET = IPv4
    // SOCK_STREAM = TCP (connection-oriented stream)
    // IPPROTO_TCP = use TCP protocol explicitly
    // socket() returns a SOCKET handle for the new socket.
    SOCKET serverSocket = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);

    // If the socket creation failed, print the error and exit.
    if (serverSocket == INVALID_SOCKET) {
        printf("socket() failed: %d\n", WSAGetLastError());
        WSACleanup();
        return 1;
    }

    // Step 4: Prepare the server address information.
    // sockaddr_in holds an IPv4 address, port, and address family.
    struct sockaddr_in serverAddress;

    // Fill the entire sockaddr_in structure with zeros before using it.
    memset(&serverAddress, 0, sizeof(serverAddress));

    // Tell the structure we are using IPv4.
    serverAddress.sin_family = AF_INET;

    // Set the listening port to 8080.
    // htons() converts the port number from host byte order to network byte order.
    serverAddress.sin_port = htons(8080);

    // Tell the server to listen on all available local IP addresses.
    // INADDR_ANY means accept connections from any interface on this machine.
    // htonl() converts the address to correct network byte order.
    serverAddress.sin_addr.s_addr = htonl(INADDR_ANY);

    // Step 5: Bind the socket to the IP and port.
    // bind() attaches the socket to a particular local address and port.
    // Without this, the socket does not have a fixed address to listen on.
    if (bind(serverSocket, (struct sockaddr*)&serverAddress, sizeof(serverAddress)) == SOCKET_ERROR) {
        printf("bind() failed: %d\n", WSAGetLastError());
        closesocket(serverSocket);
        WSACleanup();
        return 1;
    }

    // Step 6: Put the socket in listening mode.
    // listen() tells the operating system to wait for incoming client connections.
    // 5 means the socket can queue up to 5 connection requests.
    if (listen(serverSocket, 5) == SOCKET_ERROR) {
        printf("listen() failed: %d\n", WSAGetLastError());
        closesocket(serverSocket);
        WSACleanup();
        return 1;
    }

    // Step 7: Print a message so the user knows the server is waiting.
    printf("SERVER IS WAITING FOR ANY CLIENT....\n");

    // Step 8: Accept a client connection.
    // accept() blocks until a client connects.
    // It returns a new socket specifically for communication with that client.
    SOCKET clientSocket = accept(serverSocket, NULL, NULL);

    // If accept() failed, print the error and clean up.
    if (clientSocket == INVALID_SOCKET) {
        printf("accept() failed: %d\n", WSAGetLastError());
        closesocket(serverSocket);
        WSACleanup();
        return 1;
    }

    // The connection is established.
    printf("CLIENT CONNECTED!\n");

    // Step 9: Create a buffer to receive data from the client.
    // 1024 is the maximum size in bytes of the message we can receive.
    char buffer[1024];

    // Step 10: Receive data from the client through the client socket.
    // recv() reads incoming data from the network.
    // sizeof(buffer) - 1 leaves space for the null terminator '\0'.
    int bytesReceived = recv(clientSocket, buffer, sizeof(buffer) - 1, 0);

    // Only process the received data if at least one byte was received.
    if (bytesReceived > 0) {
        // Add a null terminator so we can print it as a string.
        buffer[bytesReceived] = '\0';

        // Print the client's message.
        printf("CLIENT SAYS: %s\n", buffer);
    }

    // Step 11: Close the sockets.
    // closesocket() ends the connection for that socket.
    closesocket(clientSocket);
    closesocket(serverSocket);

    // Step 12: Clean up the Winsock library.
    // WSACleanup() releases resources used by Winsock.
    WSACleanup();

    // End the program successfully.
    return 0;
}

/* FLOW
WSAStartup()
socket()
bind()
listen()
accept()
recv()
closesocket()
WSACleanup()
*/