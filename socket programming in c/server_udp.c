#include <stdio.h>
#include <winsock2.h>   // Windows networking functions
#include <ws2tcpip.h>  // TCP/IP helper functions
#include <string.h>    // memset()
int main(void) {
    // Step 1: Create a Winsock data structure.
    WSADATA wsa;
    // Step 2: Start Winsock.
    // We request Winsock version 2.2.
    int result = WSAStartup(MAKEWORD(2, 2), &wsa);
    // Check if Winsock started successfully.
    if (result != 0) {
        printf("WSAStartup failed: %d\n", result);
        return 1;
    }
    // Step 3: Create a UDP socket.
    //
    // AF_INET      = IPv4
    // SOCK_DGRAM  = UDP
    // IPPROTO_UDP = UDP protocol
    SOCKET serverSocket = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP);
    // Check if socket creation failed.
    if (serverSocket == INVALID_SOCKET) {
        printf("socket() failed: %d\n", WSAGetLastError());
        WSACleanup();
        return 1;
    }
    // Step 4: Prepare the server address.
    struct sockaddr_in serverAddress;
    // Clear the structure.
    memset(&serverAddress, 0, sizeof(serverAddress));
    // Use IPv4.
    serverAddress.sin_family = AF_INET;
    // Server will use port 8080.
    serverAddress.sin_port = htons(8080);
    // Listen on all available network interfaces.
    serverAddress.sin_addr.s_addr = htonl(INADDR_ANY);
    // Step 5: Bind the UDP socket to port 8080.
    //
    // Unlike TCP, UDP does not use listen().
    // The server simply binds to a port and waits for datagrams.
    if (bind(serverSocket,
             (struct sockaddr*)&serverAddress,
             sizeof(serverAddress)) == SOCKET_ERROR) {
        printf("bind() failed: %d\n", WSAGetLastError());
        closesocket(serverSocket);
        WSACleanup();
        return 1;
    }
    // Tell the user that the server is ready.
    printf("UDP SERVER IS WAITING FOR A MESSAGE...\n");
    // Step 6: Create a buffer for incoming data.
    char buffer[1024];
    // We will store information about the client here.
    struct sockaddr_in clientAddress;
    // Size of the client address structure.
    int clientAddressSize = sizeof(clientAddress);
    // Step 7: Receive a UDP message.
    //
    // recvfrom() receives the message AND tells us
    // which client sent it.
    int bytesReceived = recvfrom(
        serverSocket,
        buffer,
        sizeof(buffer) - 1,
        0,
        (struct sockaddr*)&clientAddress,
        &clientAddressSize
    );
    // Check whether receiving failed.
    if (bytesReceived == SOCKET_ERROR) {
        printf("recvfrom() failed: %d\n", WSAGetLastError());
        closesocket(serverSocket);
        WSACleanup();
        return 1;
    }
    // Add the null terminator so buffer becomes a C string.
    buffer[bytesReceived] = '\0';
    // Display the message.
    printf("CLIENT SAYS: %s\n", buffer);
    // Step 8: Close the UDP socket.
    closesocket(serverSocket);
    // Step 9: Clean up Winsock.
    WSACleanup();
    // Program finished successfully.
    return 0;
}
/*
UDP SERVER FLOW
WSAStartup()
      ↓
socket()
      ↓
bind()
      ↓
recvfrom()
      ↓
closesocket()
      ↓
WSACleanup()
*/