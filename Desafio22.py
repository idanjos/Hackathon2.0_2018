

def main(mapax,mx):
	lines = 0
	flag = 0
	
	m = 0
	
	lines = 0
	flag  = 0
	for y in range (0,mx): # levels

		#print("------")
		for n in range(1,mx):
			m = y + n
			if(m<=mx):
				#print("%d-%d" % (m,n))
				if str(m) in mapax.keys():
					#print(mapax[str(m)])
					if str(n) in mapax[str(m)]:
						flag = 1
						#print("poggers")

		if flag == 1:
			lines +=1
			flag = 0


	for y in range (1,mx):
		#print("------")
		for n in range(1,mx):
			m = y + n
			if(m<=mx):
				#print("%d-%d" % (n,m))
				if str(n) in mapax.keys():
					#print(mapax[str(n)])
					if str(m) in mapax[str(n)]:
						flag = 1
						#print("poggers")
		if flag == 1:
			lines +=1
			flag = 0

	#print(lines)
	return lines
def main2(mapax,mx):
	lines = 0
	flag = 0
	
	m = 0
	
	lines = 0
	flag  = 0
	for y in range (0,mx*2): # levels
		#print("-------")
		for n in range(1,y+3): 
			m = y+2 - n #
			if m > 0:
				#print("%d-%d" % (n,m))
				if str(n) in mapax.keys():
					#print(mapax[str(n)])
					if str(m) in mapax[str(n)]:
						flag = 1
						#print("poggers")
		if flag == 1:
			lines +=1
			flag = 0
	

	#print(lines)
	return lines

T = int(input())

for i in range(0,T):
	string = ""
	for j in range(0,int(input())):
		temp = ""
		while(1):
			temp = input()
			if len(temp.split(" ")) == 2:
				break
			print("introduz novamente")
		string+=temp+"-"
	string=string[0:-1]
	#print(string)
	# Dois dicionarios com eixo principal x e y. Serve para contar linhas horizontais e verticais sem problemas
	mapax = {}
	mapay = {}
	pontos = string.split("-")
	pp = string.replace("-"," ")
	mx = 0
	for i in pp.split(" "):
		if int(i) > mx:
			mx = int(i)  # maior coordenada
	#print(mx)
	points = []
	for x in pontos:
		points += [(int(x.split(" ")[0]),int(x.split(" ")[1]))]
		if x.split(" ")[0] in mapax.keys():
			mapax[x.split(" ")[0]]+=[x.split(" ")[1]]
		else:
			mapax[x.split(" ")[0]]=[x.split(" ")[1]]

		if x.split(" ")[1] in mapay.keys():
			mapay[x.split(" ")[1]]+=[x.split(" ")[0]]
		else:
			mapay[x.split(" ")[1]]=[x.split(" ")[0]]
	#Main serve para contar o numero linhas paralelas da funcao y = x com mx niveis
	#Main2 serve para contar o numero de linhas paralelas diagonais com mx niveis
	# No fim, retorna a maior das 4 maneiras
	print(min([len(mapax.keys()),len(mapay.keys()),main(mapax,mx),main2(mapax,mx)]))


