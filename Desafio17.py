
ns = input().split(" ")
x = input().split(" ")
y = input().split(" ")
while(1):
	if int(ns[0]) == len(x):
		if int(ns[1]) == len(y):
			break
		
	print("introduz novament")
	ns = input().split(" ")
	x = input().split(" ")
	y = input().split(" ")
	
output = dict()
output2 = []
for a in x:
	if a in y:
		
		output2 += [a] #adiciono a solucao
		y.remove(a) # tiro, para o caso se houver elements repetidos em na ambas listas


print(len(output2)) 
out = ""
for x in output2:
	out += x+" "
print(out)