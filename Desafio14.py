import sys
n = input()
while(not n.isdigit()):
    print("ERROR: Bad Input!")
    n = input()
o1 = input()


def fun(o1):
    for x in range(0, sys.maxsize):
        if str(x) not in o1: # Uma contagem desde do 0 até N, o menor numero que não está na lista é retornado
            print(x)
            break


fun(o1)
