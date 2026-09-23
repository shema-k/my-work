#include <stdio.h>
#include <winsock2.h>   // Windows networking functions
#include <ws2tcpip.h>  // inet_pton()
#include <string.h>    // strlen() and memset()
int main(void) {
    // Step 1: Create a Winsock data structure.
    WSADATA wsa;
    // Step 2: Start Winsock.
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
    SOCKET clientSocket = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP);
    // Check if socket creation failed.
    if (clientSocket == INVALID_SOCKET) {
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
    // Server is listening on port 8080.
    serverAddress.sin_port = htons(8080);
    // Convert server IP address from text to binary.
    //
    // 127.0.0.1 means this same computer.
    if (inet_pton(
            AF_INET,
            "127.0.0.1",
            &serverAddress.sin_addr
        ) != 1) {
        printf("inet_pton() failed\n");
        closesocket(clientSocket);
        WSACleanup();
        return 1;
    }
    // Step 5: Create the message.
    char message[] = "HELLO MR.UDP SERVER! HOW ARE YOU TODAY?";
    // Step 6: Send the message.
    //
    // UDP uses sendto() instead of send()
    //
    // The destination address is included because
    // UDP does not establish a connection first.
    int sent = sendto(
        clientSocket,
        message,
        (int)strlen(message),
        0,
        (struct sockaddr*)&serverAddress,
        sizeof(serverAddress)
    );
    // Check whether sending failed.
    if (sent == SOCKET_ERROR) {
        printf("sendto() failed: %d\n", WSAGetLastError());
        closesocket(clientSocket);
        WSACleanup();
        return 1;
    }
    // Tell the user the message was sent.
    printf("UDP MESSAGE HAS BEEN SENT TO THE SERVER!\n");
    // Step 7: Close the socket.
    closesocket(clientSocket);
    // Step 8: Clean up Winsock.
    WSACleanup();
    // Program finished successfully.
    return 0;
}
/*
UDP CLIENT FLOW
WSAStartup()
      ↓
socket()
      ↓
sendto()
      ↓
closesocket()
      ↓
WSACleanup()
*/