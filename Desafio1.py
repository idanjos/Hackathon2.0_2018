def getEvenNumbersSum5(listNumbers, n):
    retval = 0
    for i1 in range(0, n-1):
        for i2 in range(i1+1, n):
            n1 = int(listNumbers[i1])
            n2 = int(listNumbers[i2])
            resultSum = n1 + n2
            if resultSum % 5 == 0:
                retval += 1
    return retval


def main():
    print("Input:")
    nOfNumbers = input()
    while(not nOfNumbers.isdigit()):
        print("Must be a positive integer")
        nOfNumbers = input()
    nOfNumbers = int(nOfNumbers)
    listNumbers = input().split(" ")
    while (len(listNumbers) != nOfNumbers):
        print("Number of numbers doesn't match")
        listNumbers = input().split(" ")
    for element in listNumbers:
        if(not element.isdigit()):
            print("Must be a positive integer")
            return 1

    nOfNumbersSum5 = getEvenNumbersSum5(listNumbers, nOfNumbers)
    print("Output:", nOfNumbersSum5)


if __name__ == "__main__":
    # execute only if run as a script
    main()
