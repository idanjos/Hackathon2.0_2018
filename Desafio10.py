
n = int(input())
string = input().split(" ")
while(1):
	if n == len(string):
		break
	print("introduz novament")
	n = int(input())
	string = input().split(" ")

def main(inputt):
    output = ""
	# Ideia é ordernar os numeros como fossem strings, para uma lista 1,120,30,5. De seguida, concatenar a solucao
    for x in sorted(inputt): 
        output += x
    print(output)


main(string)
