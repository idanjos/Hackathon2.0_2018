import math


def calculatePenagonalNumber(n):
    # function that calculates the number of dots in function of n of iteration
    return int((5*math.pow(n, 2)-5*n+2)/2)


def main():
    numberOfIteration = input("Input: ")
    while not numberOfIteration.isdigit():
        print("ERROR: Bad Input!")
        numberOfIteration = input("Input: ")
    numberOfIteration = int(numberOfIteration)
    print("Output:%d" % calculatePenagonalNumber(numberOfIteration))


if __name__ == "__main__":
    # execute only if run as a script
    main()
