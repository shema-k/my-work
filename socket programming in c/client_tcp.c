#include <stdio.h>
#include <winsock2.h>   // Windows networking library. It gives us socket functions.
#include <ws2tcpip.h>  // Extra TCP/IP helper functions, including inet_pton().
#include <string.h>    // Used for memset() and strlen().

int main(void) {
    // Step 1: Create a Winsock data structure.
    // This stores information about the Winsock implementation.
    WSADATA wsa;

    // Step 2: Initialize Winsock.
    // MAKEWORD(2, 2) asks for Winsock version 2.2.
    // If the value is not 0, initialization failed.
    int result = WSAStartup(MAKEWORD(2, 2), &wsa);

    // If Winsock did not start correctly, stop the program.
    if (result != 0) {
        printf("WSAStartup failed: %d\n", result);
        return 1;
    }

    // Step 3: Create a client socket.
    // AF_INET = IPv4
    // SOCK_STREAM = TCP
    // IPPROTO_TCP = use the TCP protocol
    SOCKET clientSocket = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);

    // If socket creation failed, print the error and exit.
    if (clientSocket == INVALID_SOCKET) {
        printf("socket() failed: %d\n", WSAGetLastError());
        WSACleanup();
        return 1;
    }

    // Step 4: Prepare the server address.
    // sockaddr_in contains the server's IP address, port, and family.
    struct sockaddr_in serverAddress;

    // Clear the structure before using it.
    memset(&serverAddress, 0, sizeof(serverAddress));

    // Tell the system this is an IPv4 address.
    serverAddress.sin_family = AF_INET;

    // Set the server port to 8080.
    // htons() converts the port to network byte order.
    serverAddress.sin_port = htons(8080);

    // Step 5: Convert the IP address string to binary form.
    // "127.0.0.1" means local host, which is this same computer.
    // inet_pton() converts text IP to packed binary data.
    if (inet_pton(AF_INET, "127.0.0.1", &serverAddress.sin_addr) != 1) {
        printf("inet_pton() failed\n");
        closesocket(clientSocket);
        WSACleanup();
        return 1;
    }

    // Step 6: Connect to the server.
    // connect() tries to connect the client socket to the server address.
    // If it succeeds, the socket is ready for sending data.
    if (connect(clientSocket, (struct sockaddr*)&serverAddress, sizeof(serverAddress)) == SOCKET_ERROR) {
        printf("connect() failed: %d\n", WSAGetLastError());
        closesocket(clientSocket);
        WSACleanup();
        return 1;
    }

    // Step 7: Create the message to send.
    // This is a text message that will be sent to the server.
    char message[] = "HELLO SERVER!";

    // Step 8: Send the message to the server.
    // send() sends bytes over the connected socket.
    // strlen(message) gives the length of the string without the null terminator.
    int sent = send(clientSocket, message, (int)strlen(message), 0);

    // If sending failed, print the error and clean up.
    if (sent == SOCKET_ERROR) {
        printf("send() failed: %d\n", WSAGetLastError());
        closesocket(clientSocket);
        WSACleanup();
        return 1;
    }

    // Tell the user the message was successfully sent.
    printf("MESSAGE SENT!\n");

    // Step 9: Close the client socket.
    closesocket(clientSocket);

    // Step 10: Clean up Winsock resources.
    WSACleanup();

    // End the program successfully.
    return 0;
}

/* FLOW
WSAStartup()
socket()
connect()
send()
closesocket()
WSACleanup()
*/