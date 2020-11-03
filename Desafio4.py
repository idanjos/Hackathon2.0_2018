def calculateDifference(num1, num2):
    return abs(num1-num2)


def getMaxDifference(listNumbers):
    retval = 0
    for i1 in range(0, len(listNumbers)):
        for i2 in range(i1, len(listNumbers)):
            num1 = int(listNumbers[i1])
            num2 = int(listNumbers[i2])
            dif = calculateDifference(num1, num2)
            if dif > retval:
                retval = dif
    return retval


def main():
    print("Input: ")
    numbersList = input().split(" ")
    while(len(numbersList)!=6):
        print("ERROR: Bad Input!")
        numbersList = input().split(" ")
    maxDifference = getMaxDifference(numbersList)
    print("Output:", maxDifference)


if __name__ == "__main__":
    # execute only if run as a script
    main()
