from socket import *
import socket as ss
import time
import threading
s=socket(AF_INET, SOCK_DGRAM)
s.setsockopt(SOL_SOCKET, SO_BROADCAST, 1)
global thread1
ip = "127.0.0.1:5001" #Node's location
file = "img.png" #What node is asking
msg = ip+" I need to doownload "+file


def tcp_server(host,port,file):
	

    s = ss.socket()
    s.bind((host,port))
    print("server Started")
    s.listen(1)
    while True:
        c, addr = s.accept() # Accepts connection
        print("Connection from: " + str(addr))
       	filedata = ""
       	myfile = open('new2'+file, "wb")
        while True:
            data = c.recv(1024)
            if not data:
                break
            myfile.write(data) # write data to file
        
        
        
        myfile.close()
        c.close()
        print("Thank you")
        

def receive():
	s=socket(AF_INET, SOCK_DGRAM)
	s.setsockopt(SOL_SOCKET, SO_BROADCAST, 1)
	s.bind(('',12345)) # binding to port to listen
	while(1):
		m=s.recvfrom(1024)
		file = m[0].decode(encoding='UTF-8').split(" ")[-1]
		dest = m[0].decode(encoding='UTF-8').split(" ")[0].split(":")
		print (m[0].decode(encoding='UTF-8'))
		msg = "Ok "+file
		fh = open(file,"rb")
		msg = fh.read() #reading tcp server
		print(msg)
		
		s1 = ss.socket() # creating socket to connect to TCP
		try:
			s1.connect((dest[0],int(dest[1]))) # TCP destination 
			s1.send(msg) # sending data to TCP server
			s1.close()	
		except Exception as e:
			print(e)
		finally:
			s1.close()

thread1 = threading.Thread(target = tcp_server,args=('127.0.0.1',5001,file)) # Tcp Server to receive file
thread1.start()

broadcast_listener = threading.Thread(target = receive) #Broadcast listener/ handler
broadcast_listener.start()



while(1):
	stopads = 0

	if thread1.isAlive():
		s.sendto(msg.encode(),('255.255.255.255',12346)) # Broadcast request
		time.sleep(5)
		stopads+=1
	else:
		if stopads == 5:
			print("I decided to go download it myself") # Node decides to download instead of searching
			thread1.terminate()
		else:
			print("Mission acomplished")
		exit()




